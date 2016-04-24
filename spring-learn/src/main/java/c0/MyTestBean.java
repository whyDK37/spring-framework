package c0;

/**
 * Created by whydk on 2016/3/10.
 */
public class MyTestBean {

    public MyTestBean(){

    }
    public MyTestBean(String teststr){
        this.teststr = teststr;
    }
    private String teststr;

    public String getTeststr() {
        return teststr;
    }

    public void setTeststr(String teststr) {
        this.teststr = teststr;
    }


    public String test(){
        System.out.println(teststr);
        return teststr;
    }

    @LoggingRequired
    public String logging(){
        System.out.println(teststr+" logging");
        return teststr;
    }

}
