package com.cgvsu.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Matrix4dTest {

        @Test
        public void add() {
            Matrix4d m1 = new Matrix4d(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Matrix4d m2 = new Matrix4d(new float[][]{
                    {5.5f, 5.5f, 5.5f, 5.5f},
                    {5.5f, 0, 5.5f, 5.5f},
                    {5.5f, 5.5f, 5.5f, 5.5f},
                    {5.5f, 5.5f, 5.5f, 5.5f}
            });
            Matrix4d result = m1.add(m2);
            float[][] expected = {
                    {6.5f, 7.5f, 8.5f, 9.5f},
                    {10.5f, 6, 12.5f, 13.5f},
                    {14.5f, 15.5f, 16.5f, 17.5f},
                    {18.5f, 19.5f, 20.5f, 21.5f}
            };
            assertArrayEquals(expected, result.getElements());
        }

        @Test
        public void subtract() {
            Matrix4d m1 = new Matrix4d(new float[][]{
                    {10, 10, 10, 10},
                    {10, 10, 10, 10},
                    {10, 10, 10, 10},
                    {10, 10, 10, 10}
            });
            Matrix4d m2 = new Matrix4d(new float[][]{
                    {5, 5, 5, 5},
                    {5, 5, 5, 5},
                    {5, 5, 5, 5},
                    {5, 5, 5, 5}
            });
            Matrix4d result = m1.subtract(m2);
            float[][] expected = {
                    {5, 5, 5, 5},
                    {5, 5, 5, 5},
                    {5, 5, 5, 5},
                    {5, 5, 5, 5}
            };
            assertArrayEquals(expected, result.getElements());
        }

        @Test
        public void multiplyMatrix() {
            Matrix4d m1 = new Matrix4d(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Matrix4d m2 = new Matrix4d(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Matrix4d result = m1.multiply(m2);
            float[][] expected = {
                    {  90,  100,  110,  120},
                    {  202,  228,  254,  280},
                    {  314,  356,  398,  440},
                    {  426,  484, 542, 600}
            };
            assertArrayEquals(expected, result.getElements());
        }

        @Test
        public void multiplyVector() {
            Matrix4d m = new Matrix4d(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Vector4f v = new Vector4f(1, 2, 3, 4);
            Vector4f result = m.multiply(v);
            assertEquals(30, result.getX());
            assertEquals(70, result.getY());
            assertEquals(110, result.getZ());
            assertEquals(150, result.getW());
        }

        @Test
        public void transpose() {
            Matrix4d m = new Matrix4d(new float[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            });
            Matrix4d result = m.transpose();
            float[][] expected = {
                    {1, 5, 9, 13},
                    {2, 6, 10, 14},
                    {3, 7, 11, 15},
                    {4, 8, 12, 16}
            };
            assertArrayEquals(expected, result.getElements());
        }

        @Test
        public void identity() {
            Matrix4d identity = new Matrix4d(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
            });
            assertArrayEquals(identity.getElements(), identity.identity().getElements());
        }

        @Test
        public void zero() {
            Matrix4d zero = new Matrix4d(new float[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            });
            assertArrayEquals(zero.getElements(), zero.zero().getElements());
        }
}