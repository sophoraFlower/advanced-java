package cn.osxm.ssmi.service;

public class SimpleTypeConArgsDepService {

    private int iFoo;
    private String sBar;

    public SimpleTypeConArgsDepService(int iFoo,String sBar) {
        this.iFoo = iFoo;
        this.sBar = sBar;
    }

    public void fooBar() {
        System.out.println("iFoo="+iFoo);
        System.out.println("sBar="+sBar);
    }

    public int getiFoo() {
        return iFoo;
    }

    public void setiFoo(int iFoo) {
        this.iFoo = iFoo;
    }

    public String getsBar() {
        return sBar;
    }

    public void setsBar(String sBar) {
        this.sBar = sBar;
    }
}
