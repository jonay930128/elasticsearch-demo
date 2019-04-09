package wrx.xing;

/**
 * 请填写类的描述
 * 方法静态分配演示
 * @author wangruxing
 * @date 2018-10-30 13:08
 */
public class StaticDispatch {
    static abstract class Human{}

    static class Man extends Human{}

    static class Woman extends Human{}

    public void sayHello(Human guy){
        System.out.println("hello,guy");
    }
    public void sayHello(Man man){
        System.out.println("hello,man");
    }
    public void sayHello(Woman woman){
        System.out.println("hello,woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }
}
