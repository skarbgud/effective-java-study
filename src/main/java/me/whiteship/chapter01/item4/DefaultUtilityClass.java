package me.whiteship.chapter01.item4;

import org.springframework.context.annotation.AnnotationConfigUtils;

public class DefaultUtilityClass extends AnnotationConfigUtils {

    public static void main(String[] args) {
        DefaultUtilityClass utilityClass = new DefaultUtilityClass();
        utilityClass.processCommonDefinitionAnnotations(null);
    }

}
