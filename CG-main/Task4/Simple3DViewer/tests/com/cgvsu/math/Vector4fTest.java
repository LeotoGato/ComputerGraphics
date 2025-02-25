package com.cgvsu.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector4fTest {

    @Test
    public void add() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        Vector4f v2 = new Vector4f(4, 5, 6, 7);
        Vector4f result = v1.add(v2);
        assertEquals(5, result.getX());
        assertEquals(7, result.getY());
        assertEquals(9, result.getZ());
        assertEquals(11, result.getW());
    }

    @Test
    public void subtract() {
        Vector4f v1 = new Vector4f(5, 6, 7, 8);
        Vector4f v2 = new Vector4f(4, 3, 2, 1);
        Vector4f result = v1.subtract(v2);
        assertEquals(1, result.getX());
        assertEquals(3, result.getY());
        assertEquals(5, result.getZ());
        assertEquals(7, result.getW());
    }

    @Test
    public void multiply() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        float scalar = 3;
        Vector4f result = v1.multiply(scalar);
        assertEquals(3, result.getX());
        assertEquals(6, result.getY());
        assertEquals(9, result.getZ());
        assertEquals(12, result.getW());
    }

    @Test
    public void divide() {
        Vector4f v1 = new Vector4f(4, 8, 12, 16);
        float scalar = 2;
        Vector4f result = v1.divide(scalar);
        assertEquals(2, result.getX());
        assertEquals(4, result.getY());
        assertEquals(6, result.getZ());
        assertEquals(8, result.getW());
    }

    @Test
    public void divideByZero() {
        Vector4f v = new Vector4f(4, 8, 4, 4);
        try {
            v.divide(0);
        } catch (ArithmeticException e) {
            assertEquals("Exception caught", "Exception caught");
        }
    }

    @Test
    public void length() {
        Vector4f v1 = new Vector4f(1, 2, 2, 2);
        assertEquals(Math.sqrt(13), v1.length(), 0.0001);
    }

    @Test
    public void normalize() {
        Vector4f v1 = new Vector4f(1, 2, 2, 2);
        Vector4f result = v1.normalize();
        assertEquals(1.0 / Math.sqrt(13), result.getX(), 0.0001);
        assertEquals(2.0 / Math.sqrt(13), result.getY(), 0.0001);
        assertEquals(2.0 / Math.sqrt(13), result.getZ(), 0.0001);
        assertEquals(2.0 / Math.sqrt(13), result.getW(), 0.0001);
        assertEquals(1, result.length(), 0.0001);
    }

    @Test
    public void scalarMultiply() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        Vector4f v2 = new Vector4f(4, 5, 6, 7);
        float result = v1.dot(v2);
        assertEquals(60, result);
    }

}