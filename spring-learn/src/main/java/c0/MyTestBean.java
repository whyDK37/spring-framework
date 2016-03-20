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


}
