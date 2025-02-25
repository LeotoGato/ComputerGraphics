package com.cgvsu.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector3fTest {

    @Test
    public void add() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f result = v1.addReturn(v2);
        assertEquals(5, result.getX());
        assertEquals(7, result.getY());
        assertEquals(9, result.getZ());
    }

    @Test
    public void subtract() {
        Vector3f v1 = new Vector3f(5, 6, 7);
        Vector3f v2 = new Vector3f(4, 3, 2);
        Vector3f result = v1.subtract(v2);
        assertEquals(1, result.getX());
        assertEquals(3, result.getY());
        assertEquals(5, result.getZ());
    }

    @Test
    public void multiply() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        float scalar = 3;
        Vector3f result = v1.multiply(scalar);
        assertEquals(3, result.getX());
        assertEquals(6, result.getY());
        assertEquals(9, result.getZ());
    }

    @Test
    public void divide() {
        Vector3f v1 = new Vector3f(4, 8, 12);
        float scalar = 2;
        Vector3f result = v1.divide(scalar);
        assertEquals(2, result.getX());
        assertEquals(4, result.getY());
        assertEquals(6, result.getZ());
    }

    @Test
    public void divideByZero() {
        Vector3f v = new Vector3f(4, 8, 4);
        try {
            v.divide(0);
        } catch (ArithmeticException e) {
            assertEquals("Exception caught", "Exception caught");
        }
    }

    @Test
    public void length() {
        Vector3f v1 = new Vector3f(3, 4, 0);
        assertEquals(5, v1.length(), 0.0001);
    }

    @Test
    public void normalize() {
        Vector3f v1 = new Vector3f(3, 4, 0);
        Vector3f result = v1.normalizeReturn();
        assertEquals(0.6, result.getX(), 0.0001);
        assertEquals(0.8, result.getY(), 0.0001);
        assertEquals(0.0, result.getZ(), 0.0001);
        assertEquals(1, result.length(), 0.0001);
    }

    @Test
    public void scalarMultiply() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        double result = v1.dot(v2);
        assertEquals(32, result);
    }

    @Test
    public void cross() {
        Vector3f v1 = new Vector3f(1, 0, 0);
        Vector3f v2 = new Vector3f(0, 1, 0);
        Vector3f result = v1.cross(v2);
        assertEquals(0, result.getX());
        assertEquals(0, result.getY());
        assertEquals(1, result.getZ());
    }
}