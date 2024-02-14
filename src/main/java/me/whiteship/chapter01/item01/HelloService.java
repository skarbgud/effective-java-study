package me.whiteship.chapter01.item01;

public interface HelloService {

    String hello();

//    static HelloService of(String lang) {
//        // 각기 다른 인스턴스를 만들 수 있다.
//        if (lang.equals("ko")) {
//            return new KoreanHelloService();
//        } else {
//            return new EnglishHelloService();
//        }
//    }
}
