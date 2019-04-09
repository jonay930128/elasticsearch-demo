package wrx.xing.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2019-01-02 17:38
 */
public class ProxyTest {

	@Test
	public void staticTest(){
		Bird bird = new Bird();
		LogProxy logProxy = new LogProxy(bird);
		TimeProxy timeProxy = new TimeProxy(logProxy);
		timeProxy.fly();
	}

	@Test
	public void dynamicTest(){
		MyInvocationHandler handler = new MyInvocationHandler(new Butterfly());
		InvocationHandler invocationHandler = Proxy.getInvocationHandler(new Butterfly());
		Flyable flyable = (Flyable)Proxy.newProxyInstance(this.getClass().getClassLoader(), Butterfly.class.getInterfaces(), handler);
		flyable.fly();

		Butterfly butterfly = new Butterfly();
		butterfly.fly();
	}
}
