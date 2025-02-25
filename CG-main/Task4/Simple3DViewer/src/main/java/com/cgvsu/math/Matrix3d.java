package com.cgvsu.math;

public class Matrix3d {
    private float[][] matrix;

    public Matrix3d(final float[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new IllegalArgumentException("Matrix must be 3x3.");
        }
        this.matrix = matrix;
    }

    public Matrix3d add(final Matrix3d matrix3d) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.matrix[i][j] + matrix3d.matrix[i][j];
            }
        }
        return new Matrix3d(result);
    }

    public Matrix3d subtract(final Matrix3d matrix3d) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.matrix[i][j] - matrix3d.matrix[i][j];
            }
        }
        return new Matrix3d(result);
    }

    public Vector3f multiply(final Vector3f vector3f) {
        float x = matrix[0][0] * vector3f.getX() + matrix[0][1] * vector3f.getY() + matrix[0][2] * vector3f.getZ();
        float y = matrix[1][0] * vector3f.getX() + matrix[1][1] * vector3f.getY() + matrix[1][2] * vector3f.getZ();
        float z = matrix[2][0] * vector3f.getX() + matrix[2][1] * vector3f.getY() + matrix[2][2] * vector3f.getZ();
        return new Vector3f(x, y, z);
    }

    public static Matrix3d identity() {
        return new Matrix3d(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
    }

    public static Matrix3d zero() {
        return new Matrix3d(new float[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
    }

    public Matrix3d multiply(final Matrix3d matrix3d) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    result[i][j] += this.matrix[i][k] * matrix3d.matrix[k][j];
                }
            }
        }
        return new Matrix3d(result);
    }

    public Matrix3d transpose() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = this.matrix[i][j];
            }
        }
        return new Matrix3d(result);
    }

    public float get(final int row,final int column) {
        if (row < 3 && column < 3) {
            return matrix[row][column];
        } else {
            return -1f;
        }
    }

    public void set(final int row, final int column, final float value) {
        if (row < 3 && column < 3) {
            this.matrix[row][column] = value;
        }
    }

    public void setMatrix(final float[][] matrix) {
        if (matrix.length == 3 &&
                matrix[0].length == 3 &&
                matrix[1].length == 3 &&
                matrix[2].length == 3) {
            this.matrix = matrix;
        }
    }

    public float[][] getMatrix() {
        return matrix;
    }
}
