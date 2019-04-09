package wrx.xing.response;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-04-09 18:00
 */
public class SuccessResult extends Result {

    public SuccessResult() {
        super(true,"0000");
    }

    public SuccessResult(Object data) {
        this();
        this.setData(data);
    }
}
