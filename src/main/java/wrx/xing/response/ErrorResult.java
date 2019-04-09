package wrx.xing.response;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-04-09 18:07
 */
public class ErrorResult extends Result {

    public ErrorResult() {
        super(false, "9999");
    }

    public ErrorResult(String code) {
        super(false, code);
    }

    public ErrorResult(String code, String desc) {
        this(code);
        if (null != code) {
            this.setCode(code);
        }
        this.setDesc(desc);
    }

    public ErrorResult(String code, String desc, Object data) {
        this(code);
        if (null != code) {
            this.setCode(code);
        }
        this.setDesc(desc);
        this.setData(data);
    }
}
