package wrx.xing.response;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-04-09 19:59
 */
public class Result {
    private boolean flag;
    private String code;
    private String desc;
    private Object data;

    public Result(boolean flag, String code) {
        this.flag = flag;
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
