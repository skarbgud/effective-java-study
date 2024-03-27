package me.whiteship.chapter01.item3;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
public class Elvis implements IElvis {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

}
