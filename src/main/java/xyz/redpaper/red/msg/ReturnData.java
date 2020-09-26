package xyz.redpaper.red.msg;

public class ReturnData {

    public static final String STATE_NO = "0";

    /**
     * 0 - 错误
     * 1- 正常
     */
    private String state = "1";

    private Object data = "恭喜您，操作成功";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
