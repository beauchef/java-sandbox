package com.beauchef.annotation;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * @author beauchef 9/11/2016.
 */
public class AnnotationApp {

    public void printNonNullToString(@NonNull final Object object) {
        System.out.println(object.toString());
    }

    public static void main(String[] args) {
        final AnnotationApp app = new AnnotationApp();
        final String nullStr = "Blah";
        app.printNonNullToString(nullStr);
    }
}
