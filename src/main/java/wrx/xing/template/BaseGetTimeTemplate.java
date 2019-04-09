package wrx.xing.template;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-06-16 14:21
 */
public abstract class BaseGetTimeTemplate {

	public Object getTime(CustomerMethod method){
		Long start = System.currentTimeMillis();
		Object obj = abstractMethod(method);
		Long end = System.currentTimeMillis();
		System.out.println("时间：" + (end - start));
		return obj;
	}

	protected abstract Object abstractMethod(CustomerMethod method);


}
