package me.whiteship.chapter01.item01;

public class Character {

    private char value;

    private String color;

//    private String fontFamily;  //주로 잘 안바꿈
//
//    private int fontSize;       //주로 잘 안바꿈

    private Font font;

//    public Character(char value, String color, String fontFamily, int fontSize) {
//        this.value = value;
//        this.color = color;
//        this.fontFamily = fontFamily;
//        this.fontSize = fontSize;
//    }


    public Character(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }
}
