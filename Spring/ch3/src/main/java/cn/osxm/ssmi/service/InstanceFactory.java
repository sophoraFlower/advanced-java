package cn.osxm.ssmi.service;

// 包含工厂方法的类
public class InstanceFactory {
    public static Foo foo = new Foo();
    public static Foo2 foo2 = new Foo2();
    // 工厂方法
    public Foo getFooInstance() {
        return foo;
    }

    // 工厂方法w
    public Foo2 getFoo2Instance() {
        return foo2;
    }
}
