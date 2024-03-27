package me.whiteship.chapter01.item3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertTest {

    @Test
    void perform() {
        // 리허설을 한다고 가정하면 계속해서 엘비스를 데려온다
//        Concert concert = new Concert(Elvis.INSTANCE);
        Concert concert = new Concert(new MockElvis());
        concert.perform();

        assertTrue(concert.isLightsOn());
        assertTrue(concert.isMainStateOpen());

    }
}