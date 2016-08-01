/**
 * Created by whydk on 2016/3/20.
 * <p>
 * spring 自带的自定义标签
 * <p>
 * beans
 * http\://www.springframework.org/schema/beans/spring-beans-2.0.xsd=org/springframework/beans/factory/xml/spring-beans-2.0.xsd
 * http\://www.springframework.org/schema/beans/spring-beans-2.5.xsd=org/springframework/beans/factory/xml/spring-beans-2.5.xsd
 * http\://www.springframework.org/schema/beans/spring-beans-3.0.xsd=org/springframework/beans/factory/xml/spring-beans-3.0.xsd
 * http\://www.springframework.org/schema/beans/spring-beans-3.1.xsd=org/springframework/beans/factory/xml/spring-beans-3.1.xsd
 * http\://www.springframework.org/schema/beans/spring-beans-3.2.xsd=org/springframework/beans/factory/xml/spring-beans-3.2.xsd
 * http\://www.springframework.org/schema/beans/spring-beans.xsd=org/springframework/beans/factory/xml/spring-beans-3.2.xsd
 * http\://www.springframework.org/schema/tool/spring-tool-2.0.xsd=org/springframework/beans/factory/xml/spring-tool-2.0.xsd
 * http\://www.springframework.org/schema/tool/spring-tool-2.5.xsd=org/springframework/beans/factory/xml/spring-tool-2.5.xsd
 * http\://www.springframework.org/schema/tool/spring-tool-3.0.xsd=org/springframework/beans/factory/xml/spring-tool-3.0.xsd
 * http\://www.springframework.org/schema/tool/spring-tool-3.1.xsd=org/springframework/beans/factory/xml/spring-tool-3.1.xsd
 * http\://www.springframework.org/schema/tool/spring-tool-3.2.xsd=org/springframework/beans/factory/xml/spring-tool-3.2.xsd
 * http\://www.springframework.org/schema/tool/spring-tool.xsd=org/springframework/beans/factory/xml/spring-tool-3.2.xsd
 * http\://www.springframework.org/schema/util/spring-util-2.0.xsd=org/springframework/beans/factory/xml/spring-util-2.0.xsd
 * http\://www.springframework.org/schema/util/spring-util-2.5.xsd=org/springframework/beans/factory/xml/spring-util-2.5.xsd
 * http\://www.springframework.org/schema/util/spring-util-3.0.xsd=org/springframework/beans/factory/xml/spring-util-3.0.xsd
 * http\://www.springframework.org/schema/util/spring-util-3.1.xsd=org/springframework/beans/factory/xml/spring-util-3.1.xsd
 * http\://www.springframework.org/schema/util/spring-util-3.2.xsd=org/springframework/beans/factory/xml/spring-util-3.2.xsd
 * http\://www.springframework.org/schema/util/spring-util.xsd=org/springframework/beans/factory/xml/spring-util-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/c=org.springframework.beans.factory.xml.SimpleConstructorNamespaceHandler
 * http\://www.springframework.org/schema/p=org.springframework.beans.factory.xml.SimplePropertyNamespaceHandler
 * http\://www.springframework.org/schema/util=org.springframework.beans.factory.xml.UtilNamespaceHandler
 * <p>
 * context
 * http\://www.springframework.org/schema/context/spring-context-2.5.xsd=org/springframework/context/config/spring-context-2.5.xsd
 * http\://www.springframework.org/schema/context/spring-context-3.0.xsd=org/springframework/context/config/spring-context-3.0.xsd
 * http\://www.springframework.org/schema/context/spring-context-3.1.xsd=org/springframework/context/config/spring-context-3.1.xsd
 * http\://www.springframework.org/schema/context/spring-context-3.2.xsd=org/springframework/context/config/spring-context-3.2.xsd
 * http\://www.springframework.org/schema/context/spring-context.xsd=org/springframework/context/config/spring-context-3.2.xsd
 * http\://www.springframework.org/schema/jee/spring-jee-2.0.xsd=org/springframework/ejb/config/spring-jee-2.0.xsd
 * http\://www.springframework.org/schema/jee/spring-jee-2.5.xsd=org/springframework/ejb/config/spring-jee-2.5.xsd
 * http\://www.springframework.org/schema/jee/spring-jee-3.0.xsd=org/springframework/ejb/config/spring-jee-3.0.xsd
 * http\://www.springframework.org/schema/jee/spring-jee-3.1.xsd=org/springframework/ejb/config/spring-jee-3.1.xsd
 * http\://www.springframework.org/schema/jee/spring-jee-3.2.xsd=org/springframework/ejb/config/spring-jee-3.2.xsd
 * http\://www.springframework.org/schema/jee/spring-jee.xsd=org/springframework/ejb/config/spring-jee-3.2.xsd
 * http\://www.springframework.org/schema/lang/spring-lang-2.0.xsd=org/springframework/scripting/config/spring-lang-2.0.xsd
 * http\://www.springframework.org/schema/lang/spring-lang-2.5.xsd=org/springframework/scripting/config/spring-lang-2.5.xsd
 * http\://www.springframework.org/schema/lang/spring-lang-3.0.xsd=org/springframework/scripting/config/spring-lang-3.0.xsd
 * http\://www.springframework.org/schema/lang/spring-lang-3.1.xsd=org/springframework/scripting/config/spring-lang-3.1.xsd
 * http\://www.springframework.org/schema/lang/spring-lang-3.2.xsd=org/springframework/scripting/config/spring-lang-3.2.xsd
 * http\://www.springframework.org/schema/lang/spring-lang.xsd=org/springframework/scripting/config/spring-lang-3.2.xsd
 * http\://www.springframework.org/schema/task/spring-task-3.0.xsd=org/springframework/scheduling/config/spring-task-3.0.xsd
 * http\://www.springframework.org/schema/task/spring-task-3.1.xsd=org/springframework/scheduling/config/spring-task-3.1.xsd
 * http\://www.springframework.org/schema/task/spring-task-3.2.xsd=org/springframework/scheduling/config/spring-task-3.2.xsd
 * http\://www.springframework.org/schema/task/spring-task.xsd=org/springframework/scheduling/config/spring-task-3.2.xsd
 * http\://www.springframework.org/schema/cache/spring-cache-3.1.xsd=org/springframework/cache/config/spring-cache-3.1.xsd
 * http\://www.springframework.org/schema/cache/spring-cache-3.2.xsd=org/springframework/cache/config/spring-cache-3.2.xsd
 * http\://www.springframework.org/schema/cache/spring-cache.xsd=org/springframework/cache/config/spring-cache-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/context=org.springframework.context.config.ContextNamespaceHandler
 * http\://www.springframework.org/schema/jee=org.springframework.ejb.config.JeeNamespaceHandler
 * http\://www.springframework.org/schema/lang=org.springframework.scripting.config.LangNamespaceHandler
 * http\://www.springframework.org/schema/task=org.springframework.scheduling.config.TaskNamespaceHandler
 * http\://www.springframework.org/schema/cache=org.springframework.cache.config.CacheNamespaceHandler
 * <p>
 * framework.jdbc
 * http\://www.springframework.org/schema/framework.jdbc/spring-framework.jdbc-3.0.xsd=org/springframework/framework.jdbc/config/spring-framework.jdbc-3.0.xsd
 * http\://www.springframework.org/schema/framework.jdbc/spring-framework.jdbc-3.1.xsd=org/springframework/framework.jdbc/config/spring-framework.jdbc-3.1.xsd
 * http\://www.springframework.org/schema/framework.jdbc/spring-framework.jdbc-3.2.xsd=org/springframework/framework.jdbc/config/spring-framework.jdbc-3.2.xsd
 * http\://www.springframework.org/schema/framework.jdbc/spring-framework.jdbc.xsd=org/springframework/framework.jdbc/config/spring-framework.jdbc-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/framework.jdbc=org.springframework.framework.jdbc.config.JdbcNamespaceHandler
 * <p>
 * <p>
 * tx
 * http\://www.springframework.org/schema/tx/spring-tx-2.0.xsd=org/springframework/transaction/config/spring-tx-2.0.xsd
 * http\://www.springframework.org/schema/tx/spring-tx-2.5.xsd=org/springframework/transaction/config/spring-tx-2.5.xsd
 * http\://www.springframework.org/schema/tx/spring-tx-3.0.xsd=org/springframework/transaction/config/spring-tx-3.0.xsd
 * http\://www.springframework.org/schema/tx/spring-tx-3.1.xsd=org/springframework/transaction/config/spring-tx-3.1.xsd
 * http\://www.springframework.org/schema/tx/spring-tx-3.2.xsd=org/springframework/transaction/config/spring-tx-3.2.xsd
 * http\://www.springframework.org/schema/tx/spring-tx.xsd=org/springframework/transaction/config/spring-tx-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/tx=org.springframework.transaction.config.TxNamespaceHandler
 * <p>
 * aop
 * http\://www.springframework.org/schema/aop/spring-aop-2.0.xsd=org/springframework/aop/config/spring-aop-2.0.xsd
 * http\://www.springframework.org/schema/aop/spring-aop-2.5.xsd=org/springframework/aop/config/spring-aop-2.5.xsd
 * http\://www.springframework.org/schema/aop/spring-aop-3.0.xsd=org/springframework/aop/config/spring-aop-3.0.xsd
 * http\://www.springframework.org/schema/aop/spring-aop-3.1.xsd=org/springframework/aop/config/spring-aop-3.1.xsd
 * http\://www.springframework.org/schema/aop/spring-aop-3.2.xsd=org/springframework/aop/config/spring-aop-3.2.xsd
 * http\://www.springframework.org/schema/aop/spring-aop.xsd=org/springframework/aop/config/spring-aop-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/aop=org.springframework.aop.config.AopNamespaceHandler
 * <p>
 * oxm
 * http\://www.springframework.org/schema/oxm/spring-oxm-3.0.xsd=org/springframework/oxm/config/spring-oxm-3.0.xsd
 * http\://www.springframework.org/schema/oxm/spring-oxm-3.1.xsd=org/springframework/oxm/config/spring-oxm-3.1.xsd
 * http\://www.springframework.org/schema/oxm/spring-oxm-3.2.xsd=org/springframework/oxm/config/spring-oxm-3.2.xsd
 * http\://www.springframework.org/schema/oxm/spring-oxm.xsd=org/springframework/oxm/config/spring-oxm-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/oxm=org.springframework.oxm.config.OxmNamespaceHandler
 * <p>
 * jms
 * http\://www.springframework.org/schema/jms/spring-jms-2.5.xsd=org/springframework/jms/config/spring-jms-2.5.xsd
 * http\://www.springframework.org/schema/jms/spring-jms-3.0.xsd=org/springframework/jms/config/spring-jms-3.0.xsd
 * http\://www.springframework.org/schema/jms/spring-jms-3.1.xsd=org/springframework/jms/config/spring-jms-3.1.xsd
 * http\://www.springframework.org/schema/jms/spring-jms-3.2.xsd=org/springframework/jms/config/spring-jms-3.2.xsd
 * http\://www.springframework.org/schema/jms/spring-jms.xsd=org/springframework/jms/config/spring-jms-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/jms=org.springframework.jms.config.JmsNamespaceHandler
 * <p>
 * webmvc
 * http\://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd=org/springframework/web/servlet/config/spring-mvc-3.0.xsd
 * http\://www.springframework.org/schema/mvc/spring-mvc-3.1.xsd=org/springframework/web/servlet/config/spring-mvc-3.1.xsd
 * http\://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd=org/springframework/web/servlet/config/spring-mvc-3.2.xsd
 * http\://www.springframework.org/schema/mvc/spring-mvc.xsd=org/springframework/web/servlet/config/spring-mvc-3.2.xsd
 * <p>
 * http\://www.springframework.org/schema/mvc=org.springframework.web.servlet.config.MvcNamespaceHandler
 * <p>
 * <p>
 * test
 * http\://www.foo.com/schema/component/component.xsd=com/foo/component.xsd
 * http\://www.foo.com/schema/component=com.foo.ComponentNamespaceHandler
 */
package framework.c4;