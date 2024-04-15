package me.whiteship.chapter01.item5.dependencyinjection;

import me.whiteship.chapter01.item5.DefaultDictionary;
import me.whiteship.chapter01.item5.Dictionary;
import me.whiteship.chapter01.item5.MockDictionary;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isValid() {
//        Supplier<Dictionary> dictionarySupplier = () -> new DefaultDictionary();
//        SpellChecker spellChecker = new SpellChecker(dictionarySupplier);

//        SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new);
        SpellChecker spellChecker = new SpellChecker(DictionaryFactory::get);
        SpellChecker mockSpellChecker = new SpellChecker(MockDictionary::new);
        spellChecker.isValid("test");
    }
}