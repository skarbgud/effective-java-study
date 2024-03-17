package me.whiteship.chapter01.item01;

public class Client {

    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        // 하나의 인스턴스를 공유해서 쓸 수 있다.
        Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));
    }
}
