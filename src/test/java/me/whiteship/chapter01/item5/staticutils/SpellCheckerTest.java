package me.whiteship.chapter01.item5.staticutils;

import me.whiteship.chapter01.item5.DefaultDictionary;
import me.whiteship.chapter01.item5.dependencyinjection.SpellChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isValid() {
        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
    }
}