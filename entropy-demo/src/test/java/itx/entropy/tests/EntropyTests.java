package itx.entropy.tests;


import itx.entropy.EntropyCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntropyTests {

    public static Stream<Arguments> getEntropyStringData() {
        return Stream.of(
                Arguments.of( null, 0D ),
                Arguments.of( "", 0D ),
                Arguments.of( "A", 0D ),
                Arguments.of( "AA", 0D ),
                Arguments.of( "AAA", 0D ),
                Arguments.of( "AB", 1D ),
                Arguments.of( "ABB", 0.9182958340544894D ),
                Arguments.of( "long data text", 3.1820058147602124D ),
                Arguments.of( "aeSauyaepee7ohsooTee5noquequeezu", 3.3973683589017414D ),
                Arguments.of( "ephai8agh9eiYa5r", 3.327819531114783D ),
                Arguments.of( "abcdefghijklmnopqrstuvwyz", 4.643856189774723D )
        );
    }

    @ParameterizedTest
    @MethodSource("getEntropyStringData")
    void testStringEntropyCalculation(String data, Double expectedEntropy) {
        Double entropy = EntropyCalculator.calculateEntropy(data);
        assertEquals(entropy, expectedEntropy);
    }

    public static Stream<Arguments> getEntropyIntegerData() {
        return Stream.of(
                Arguments.of( null, 0D ),
                Arguments.of( 0, 0D ),
                Arguments.of( 1, 0D ),
                Arguments.of( 11, 0D ),
                Arguments.of( 12, 1D ),
                Arguments.of( 122, 0.9182958340544894D ),
                Arguments.of( 2020, 1D ),
                Arguments.of( 12345, 2.321928094887362D ),
                Arguments.of( 1234567890, 3.321928094887362D )
        );
    }

    @ParameterizedTest
    @MethodSource("getEntropyIntegerData")
    void testIntegerEntropyCalculation(Integer data, Double expectedEntropy) {
        Double entropy = EntropyCalculator.calculateEntropy(data);
        assertEquals(entropy, expectedEntropy);
    }

    public static Stream<Arguments> getEntropyLongData() {
        return Stream.of(
                Arguments.of( null, 0D ),
                Arguments.of( 0L, 0D ),
                Arguments.of( 1L, 0D ),
                Arguments.of( 11L, 0D ),
                Arguments.of( 12L, 1D ),
                Arguments.of( 122L, 0.9182958340544894D ),
                Arguments.of( 2020L, 1D ),
                Arguments.of( 12345L, 2.321928094887362D ),
                Arguments.of( 1234567890L, 3.321928094887362D ),
                Arguments.of( 12345678901L, 3.2776134368191157D ),
                Arguments.of( 123456789012L, 3.2516291673878226D )
        );
    }

    @ParameterizedTest
    @MethodSource("getEntropyLongData")
    void testLongEntropyCalculation(Long data, Double expectedEntropy) {
        Double entropy = EntropyCalculator.calculateEntropy(data);
        assertEquals(entropy, expectedEntropy);
    }

}
