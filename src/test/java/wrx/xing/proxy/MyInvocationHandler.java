package wrx.xing.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2019-01-02 18:26
 */
public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy");
		Object invoke = method.invoke(target, args);
		return invoke;
	}
}
