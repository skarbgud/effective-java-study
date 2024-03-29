package me.whiteship.chapter01.item3;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
public class Elvis implements IElvis, Serializable {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    // 리플렉션을 막는다.
    private Elvis() {
        if (created) {
            throw new UnsupportedOperationException("can't be created by constructor."); // 리플렉션으로 생성 할 수 없게 된다.
        }
        created = true;
    }

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

    // 역직렬화를 막는다.
    private Object readResolve() {
        return INSTANCE;
    }
}
