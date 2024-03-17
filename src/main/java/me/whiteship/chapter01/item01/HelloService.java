package me.whiteship.chapter01.item01;

public interface HelloService {

    String hello();

    // default 또는 static 으로 메서드 정의
    static public String hi() {
        prepareMessage();
        return "hi";
    }

    static private void prepareMessage() {
    }

    static public String hi1() {
        prepareMessage();
        return "hi";
    }

    static public String hi2() {
        prepareMessage();
        return "hi";
    }

    default String bye() {
        return "hi";
    }

//    static HelloService of(String lang) {
//        // 각기 다른 인스턴스를 만들 수 있다.
//        if (lang.equals("ko")) {
//            return new KoreanHelloService();
//        } else {
//            return new EnglishHelloService();
//        }
//    }
}
