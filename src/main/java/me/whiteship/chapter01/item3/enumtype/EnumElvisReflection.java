package me.whiteship.chapter01.item3.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection {

    public static void main(String[] args) {
        try {
            Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor(); //Enum 이기때문에 생성자가 X => 리플렉션 사용 X
            System.out.println(declaredConstructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
