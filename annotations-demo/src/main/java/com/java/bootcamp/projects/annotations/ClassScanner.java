package com.java.bootcamp.projects.annotations;

import java.lang.annotation.Annotation;

public class ClassScanner {

    public static final boolean scan(Object object) {
        Annotation[] annotations = object.getClass().getAnnotations();
        for(Annotation annotation : annotations) {
            if(annotation instanceof TypeMarker) {
                return true;
            }
        }
        return false;
    }

}
