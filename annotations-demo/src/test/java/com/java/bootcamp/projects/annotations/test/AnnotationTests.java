package com.java.bootcamp.projects.annotations.test;

import com.java.bootcamp.projects.annotations.ClassScanner;
import com.java.bootcamp.projects.annotations.test.dto.MarkedType;
import com.java.bootcamp.projects.annotations.test.dto.StringHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnnotationTests {

    @Test
    public void testCompileTimeAnnotations() {
        assertFalse(ClassScanner.scan(new StringHolder("data")));
        assertTrue(ClassScanner.scan(new MarkedType()));
    }

    @Test
    public void testStringHolder() {
        StringHolder stringHolder = new StringHolder("data");
        stringHolder.addString("zzz");
        assertEquals(stringHolder.getData(), "data");
    }

    @Test
    public void testTypeCasting() {
        Object object = objectProducer(10);
        Integer integerAgain = objectConsumer(object);
        assertTrue(integerAgain.intValue() == 10);
    }

    private Object objectProducer(int value) {
        return Integer.valueOf(value);
    }

    private Integer objectConsumer(Object object) {
        return (Integer) object;
    }

}
