package com.java.bootcamp.projects.mt.testing;

import com.java.bootcamp.projects.mt.DataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.SAME_THREAD)
public class Parametric01Test {

    private static DataService dataService;

    @BeforeAll
    public static void init() {
        dataService = new DataService();
    }

    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 2, 4),
                Arguments.of(3, 2, 5),
                Arguments.of(4, 4, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void parametrized01Test(Integer a, Integer b, Integer expectedResult) throws InterruptedException {
        Integer result = dataService.add(a, b, 5L, TimeUnit.SECONDS);
        assertEquals(expectedResult, result);
    }

}
