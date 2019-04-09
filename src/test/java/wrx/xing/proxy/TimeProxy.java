package wrx.xing.proxy;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2019-01-02 17:34
 */
public class TimeProxy implements Flyable{
	private Flyable flyable;

	public TimeProxy(Flyable flyable) {
		this.flyable = flyable;
	}

	@Override
	public void fly() {
		System.out.println("time start ...");
		flyable.fly();
		System.out.println("time end ...");
	}
}
