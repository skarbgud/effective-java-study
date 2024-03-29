package me.whiteship.chapter01.item3.enumtype;

import me.whiteship.chapter01.item3.field.IElvis;

// 열거 타입 방식의 싱글턴 - 바람직한 방법 (25쪽)
public enum Elvis implements IElvis {
    INSTANCE; //new를 통해서 사용할 수 없게 된다.

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    @Override
    public void sing() {
        System.out.println("테스트까지 가능");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
