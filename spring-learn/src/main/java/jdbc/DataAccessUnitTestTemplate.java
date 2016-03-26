package jdbc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DataAccessUnitTestTemplate {
    private SimpleDriverDataSource db;
    private DefaultListableBeanFactory bf;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public static void main(String[] args) throws SQLException {
        DataAccessUnitTestTemplate dataAccessUnitTestTemplate = new DataAccessUnitTestTemplate();
        dataAccessUnitTestTemplate.setUp();
        dataAccessUnitTestTemplate.testSavePoint(true);
        dataAccessUnitTestTemplate.testIUD();
        dataAccessUnitTestTemplate.testDataAccess();
        dataAccessUnitTestTemplate.testOtherOp();
        dataAccessUnitTestTemplate.testNamedParameterJdbcTemplate();
        dataAccessUnitTestTemplate.testSimpleJdbcTemplate();
        dataAccessUnitTestTemplate.testAutogeneratedKeys();
        dataAccessUnitTestTemplate.tearDown();
    }


    public void setUp() {
        // creates a HSQL in-memory db populated from default scripts classpath:schema.sql and classpath:test-data.sql
//        db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();

        bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("jdbc/jdbc.xml"));

        db = bf.getBean("dataSource", SimpleDriverDataSource.class);


        jdbcTemplate = new JdbcTemplate(db);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(db);
        simpleJdbcTemplate = new SimpleJdbcTemplate(db);
    }


    /**
     * This support is part of the JDBC 3.0 standard;
     */
    private void testAutogeneratedKeys() {
        final String INSERT_SQL = "insert into t_actor (first_name, last_name,age,specialty) values (?, ?,?,?)";
        final String first_name = "Leonor";
        final String last_name = "Watling";
        final int age = 16;
        final String specialty = "fight";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setString(1, first_name);
                        ps.setString(2, last_name);
                        ps.setInt(3, age);
                        ps.setString(4, specialty);
                        return ps;
                    }
                },
                keyHolder);

        // keyHolder.getKey() now contains the generated key
        System.out.println("generated key:"+keyHolder.getKey());
    }

    private void testNamedParameterJdbcTemplate() {
        String sql = "select count(*) from T_ACTOR where first_name = :first_name";

        String firstName = "悟空";
        SqlParameterSource namedParameters = new MapSqlParameterSource("first_name", firstName);

        System.out.println(firstName + " count" + namedParameterJdbcTemplate.queryForInt(sql, namedParameters));


        // notice how the named parameters match the properties of the above 'Actor' class
        sql = "select count(*) from T_ACTOR where first_name = :firstName and last_name = :lastName";
        Actor exampleActor = new Actor();
        exampleActor.setId(1);
        exampleActor.setLastName("sun");
        exampleActor.setFirstName("悟空");
        namedParameters = new BeanPropertySqlParameterSource(exampleActor);
        System.out.println(exampleActor + " count " + this.namedParameterJdbcTemplate.queryForInt(sql, namedParameters));
        ;
    }

    private void testSimpleJdbcTemplate() {

        String specialty = "sun";
        int age = 520;
        String sql = "select id, first_name, last_name,specialty,age from T_ACTOR" +
                " where specialty = ? and age = ?";
        RowMapper<Actor> mapper = new RowMapper<Actor>() {
            public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                Actor actor = new Actor();
                actor.setId(rs.getInt("id"));
                actor.setFirstName(rs.getString("first_name"));
                actor.setLastName(rs.getString("last_name"));
                actor.setAge(rs.getInt("age"));
                actor.setSpecialty(rs.getString("specialty"));
                return actor;
            }
        };

        // notice the use of varargs since the parameter values now come
        // after the RowMapper parameter
        System.out.println("simple " + this.simpleJdbcTemplate.queryForObject(sql, mapper, specialty, age));
    }


    private void testOtherOp() {
        this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
        System.out.println("mytable count:" + this.jdbcTemplate.queryForInt("select count(*) from mytable"));


    }

    private void testIUD() {
        this.jdbcTemplate.update("insert into t_actor (id,first_name, last_name) values (?, ?, ?)", 5276L, "Leonor", "Watling");

        this.jdbcTemplate.update(
                "update t_actor set first_name = ? where id = ?",
                "Banjo", 5276L);

        this.jdbcTemplate.update(
                "delete from t_actor where id = ?",
                Long.valueOf(2));
    }

    public void testDataAccess() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from USER ");
        System.out.println(list);
        int rowCount = jdbcTemplate.queryForInt("select count(*) from USER");
        System.out.println("rowCount:" + rowCount);

        int countOfActorsNamedJoe = this.jdbcTemplate.queryForInt(
                "select count(*) from USER where name = ?", "tangseng");
        System.out.println(countOfActorsNamedJoe);

        String lastName = this.jdbcTemplate.queryForObject(
                "select name from USER where id = ?",
                new Object[]{1}, String.class);
        System.out.println(lastName);


        User user = this.jdbcTemplate.queryForObject(
                "select id,name, age from user where id = ?",
                new Object[]{1},
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User actor = new User();
                        actor.setId(rs.getInt("id"));
                        actor.setName(rs.getString("name"));
                        actor.setAge(rs.getInt("age"));
                        return actor;
                    }
                });
        System.out.println(user);


        List<Actor> actors = this.jdbcTemplate.query(
                "select id,first_name,last_name from t_actor",
                new RowMapper<Actor>() {
                    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Actor actor = new Actor();
                        actor.setId(rs.getInt("id"));
                        actor.setFirstName(rs.getString("first_name"));
                        actor.setLastName(rs.getString("last_name"));
                        return actor;
                    }
                });
        System.out.println(actors);

    }

    public void testSavePoint(boolean savepointrollback) throws SQLException {
        Connection conn = db.getConnection();
        conn.setAutoCommit(false);
        // Set a conservative transaction isolation level.
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate("INSERT INTO USER(ID,NAME,AGE) VALUES(999,'bt',460)");
        // Set a named savepoint.
        Savepoint svpt = conn.setSavepoint("NewAuthor");
        // ...
        rows = stmt.executeUpdate("UPDATE USER set name = 'fiction' WHERE id = 999");
        // ...
        if (savepointrollback) conn.rollback(svpt);
        // ...
        // The author has been added, but not updated.
        conn.commit();
    }

    public void tearDown() {

    }
}