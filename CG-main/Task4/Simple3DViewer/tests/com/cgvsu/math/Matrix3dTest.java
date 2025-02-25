package com.cgvsu.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Matrix3dTest {
    @Test
    public void add() {
        Matrix3d m1 = new Matrix3d(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix3d m2 = new Matrix3d(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix3d result = m1.add(m2);
        float[][] expected = {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        };
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    public void subtract() {
        Matrix3d m1 = new Matrix3d(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix3d m2 = new Matrix3d(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix3d result = m1.subtract(m2);
        float[][] expected = {
                {8, 6, 4},
                {2, 0, -2},
                {-4, -6, -8}
        };
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    public void multiplyMatrix() {
        Matrix3d m1 = new Matrix3d(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix3d m2 = new Matrix3d(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix3d result = m1.multiply(m2);
        float[][] expected = {
                {30, 24, 18},
                {84, 69, 54},
                {138, 114, 90}
        };
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    public void multiplyVector() {
        Matrix3d m = new Matrix3d(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Vector3f v = new Vector3f(1, 2, 3);
        Vector3f result = m.multiply(v);
        assertEquals(14, result.getX());
        assertEquals(32, result.getY());
        assertEquals(50, result.getZ());
    }

    @Test
    public void transpose() {
        Matrix3d m = new Matrix3d(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix3d result = m.transpose();
        float[][] expected = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    public void identity() {
        Matrix3d identity = Matrix3d.identity();
        float[][] expected = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertArrayEquals(expected, identity.getMatrix());
    }

    @Test
    public void zero() {
        Matrix3d zero = Matrix3d.zero();
        float[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertArrayEquals(expected, zero.getMatrix());
    }
}