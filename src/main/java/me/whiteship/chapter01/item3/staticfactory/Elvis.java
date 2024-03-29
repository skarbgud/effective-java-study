package me.whiteship.chapter01.item3.staticfactory;

// 코드 3-2 정적 팩터리 방식의 싱글턴 (24쪽)
public class Elvis implements Singer {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public static Elvis getInstance() {
        return INSTANCE;
//        return new Elvis();
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        System.out.println(Elvis.getInstance());
        System.out.println(Elvis.getInstance());
    }

    @Override
    public void sing() {
        System.out.println("my way~~~");
    }
}
