package me.whiteship.chapter01.item01;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

//    public static HelloService of(String lang) {
//        // 각기 다른 인스턴스를 만들 수 있다.
//        if (lang.equals("ko")) {
//            return new KoreanHelloService();
//        } else {
//            return new EnglishHelloService();
//        }
//    }

    public static void main(String[] args) {
//        HelloService ko = HelloServiceFactory.of("ko");
//        HelloService ko = HelloService.of("ko");
//        System.out.println(ko.hello());

        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });
    }
}
