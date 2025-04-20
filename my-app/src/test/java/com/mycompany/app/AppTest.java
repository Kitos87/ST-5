package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class AppTest {
    private static final double EPS = 1e-8;
    @Test
    public void testAveragePositive() {
        assertEquals(5.0, new Sqrt(0).average(2.0, 8.0), EPS);
    }
    @Test
    public void testAverageNegativeAndPositive() {
        assertEquals(0.0, new Sqrt(0).average(-3.5, 3.5), EPS);
    }
    @Test
    public void testAverageZeroZero() {
        assertEquals(0.0, new Sqrt(0).average(0.0, 0.0), EPS);
    }
    @Test
    public void testGoodAtBoundary() {
        Sqrt s = new Sqrt(10.0);
        double guess = Math.sqrt(10.0) + 1e-9;
        assertTrue(s.good(guess, 10.0));
    }
    @Test
    public void testGoodJustOutside() {
        Sqrt s = new Sqrt(10.0);
        double guess = Math.sqrt(10.0) + 1e-7;
        assertFalse(s.good(guess, 10.0));
    }
    @Test
    public void testGoodNegativeGuess() {
        assertTrue(new Sqrt(9.0).good(-3.0, 9.0));
    }
    @Test
    public void testImproveBringsCloser() {
        Sqrt s = new Sqrt(9.0);
        double initial = 2.0;
        double improved = s.improve(initial, 9.0);
        assertTrue(Math.abs(improved - 3.0) < Math.abs(initial - 3.0));
    }
    @Test
    public void testImprovePerfect() {
        assertEquals(4.0, new Sqrt(16.0).improve(4.0, 16.0), EPS);
    }
    @Test
    public void testImproveNegativeGuess() {
        assertEquals(-3.4, new Sqrt(9.0).improve(-5.0, 9.0), EPS);
    }
    @Test
    public void testIterWhenGuessGood() {
        assertEquals(5.0, new Sqrt(25.0).iter(5.0, 25.0), EPS);
    }
    @Test
    public void testIterWithNegativeGuess() {
        assertEquals(-6.0, new Sqrt(36.0).iter(-10.0, 36.0), EPS);
    }
    @Test
    public void testCalcPerfectSquare() {
        assertEquals(7.0, new Sqrt(49.0).calc(), EPS);
    }
    @Test
    public void testCalcNonPerfectLiteral() {
        assertEquals(1.41421356, new Sqrt(2.0).calc(), 1e-7);
    }
    @Test
    public void testCalcFraction() {
        assertEquals(0.5, new Sqrt(0.25).calc(), EPS);
    }
    @Test
    public void testCalcZeroAndOne() {
        Sqrt s1 = new Sqrt(1.0);
        assertEquals(1.0, s1.calc(), EPS);
        Sqrt s0 = new Sqrt(0.0);
        double result0 = s0.calc();
        assertTrue(s0.good(result0, 0.0));
    }
    @Test
    public void testCalcTinyGood() {
        Sqrt s = new Sqrt(1e-10);
        double result = s.calc();
        assertTrue(s.good(result, 1e-10));
    }
}
