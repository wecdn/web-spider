package xyz.redpaper.red.msg;

/**
 * 简转繁api接口数据结构
 */
public class S2tApi {
    private String status;
    private String msg;
    private S2tApiData result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public S2tApiData getResult() {
        return result;
    }

    public void setResult(S2tApiData result) {
        this.result = result;
    }
}
