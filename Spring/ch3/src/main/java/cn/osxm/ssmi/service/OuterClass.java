package cn.osxm.ssmi.service;

public class OuterClass {
    public static class InnerClass {
        public void innerMethod() {
            System.out.println("This is InnerClass's InnerMethod");
        }
    }

    public void outerMethod() {
        System.out.println("This is OuterClass's OuterMethod");
    }
}
