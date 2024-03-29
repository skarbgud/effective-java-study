package me.whiteship.chapter01.item3.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 생성자로 여러 인스턴스 만들기
public class ElvisReflection {

    public static void main(String[] args) {
        try {
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
            defaultConstructor.setAccessible(true); // private라서 객체를 만들 수 있게 해준다.
            Elvis.INSTANCE.sing(); //가능
            Elvis elvis1 = defaultConstructor.newInstance(); //불가능
            Elvis elvis2 = defaultConstructor.newInstance(); //불가능
            System.out.println(elvis1 == elvis2);   // false
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
