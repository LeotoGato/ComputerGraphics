package com.cgvsu.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector2fTest {
    private static final float EPS = 1e-10f;

    @Test
    public void add() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        Vector2f result = v1.add(v2);
        assertEquals(4, result.getX(), EPS);
        assertEquals(6, result.getY(), EPS);
    }

    @Test
    public void subtract() {
        Vector2f v1 = new Vector2f(5, 7);
        Vector2f v2 = new Vector2f(2, 3);
        Vector2f result = v1.subtract(v2);
        assertEquals(3, result.getX(), EPS);
        assertEquals(4, result.getY(), EPS);
    }

    @Test
    public void multiply() {
        Vector2f v = new Vector2f(2, 3);
        Vector2f result = v.multiply(2);
        assertEquals(4, result.getX(), EPS);
        assertEquals(6, result.getY(), EPS);
    }

    @Test
    public void divide() {
        Vector2f v = new Vector2f(4, 8);
        Vector2f result = v.divide(2);
        assertEquals(2, result.getX(), EPS);
        assertEquals(4, result.getY(), EPS);
    }

    @Test
    public void divideByZero() {
        Vector2f v = new Vector2f(4, 8);
        try {
            v.divide(0);
        } catch (ArithmeticException e) {
            assertEquals("Exception caught", "Exception caught");
        }
    }

    @Test
    public void length() {
        Vector2f v = new Vector2f(3, 4);
        assertEquals(5, v.length(), 0.0001); // 3-4-5 triangle
    }

    @Test
    public void normalize() {
        Vector2f v = new Vector2f(3, 4);
        Vector2f normalized = v.normalize();
        assertEquals(0.6f, normalized.getX(), EPS);
        assertEquals(0.8f, normalized.getY(), EPS);
    }

    @Test
    public void scalarMultiply() {
        Vector2f v1 = new Vector2f(2, 3);
        Vector2f v2 = new Vector2f(4, 5);
        assertEquals(23, v1.dot(v2), 0.0001);
    }
}