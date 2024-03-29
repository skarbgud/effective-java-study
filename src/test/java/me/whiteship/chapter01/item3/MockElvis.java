package me.whiteship.chapter01.item3;

import me.whiteship.chapter01.item3.field.IElvis;

public class MockElvis implements IElvis {

    @Override
    public void leaveTheBuilding() {

    }

    @Override
    public void sing() {
        System.out.println("you ain't nothin' but a hound dog.");
    }
}
