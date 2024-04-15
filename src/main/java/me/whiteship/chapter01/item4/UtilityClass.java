package me.whiteship.chapter01.item4;

public class UtilityClass {

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    private UtilityClass() {
        System.out.println("Constructor");
        throw new AssertionError();
    }

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        String hello = UtilityClass.hello();

        UtilityClass utilityClass = new UtilityClass();
//        utilityClass.hello(); //인스턴스를 만들어서 사용하지 않도록 한다.
    }
}
