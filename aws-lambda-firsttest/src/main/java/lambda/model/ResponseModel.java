package lambda.model;

public class ResponseModel {

    String name;
    String test;

    public ResponseModel(String name, String test) {
        this.test = test;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
