public class MyData {
    private boolean myBoolean;
    private String myString;

    public MyData(boolean myBoolean, String myString) {
        this.myBoolean = myBoolean;
        this.myString = myString;
    }

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}