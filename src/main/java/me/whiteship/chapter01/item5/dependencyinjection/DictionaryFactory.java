package me.whiteship.chapter01.item5.dependencyinjection;


import me.whiteship.chapter01.item5.DefaultDictionary;

public class DictionaryFactory {
    public static DefaultDictionary get() {
        return new DefaultDictionary();
    }
}