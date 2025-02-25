package com.cgvsu.math;

public class Matrix4d {
    private float[][] matrix;

    public Matrix4d(final float[][] matrix) {
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new IllegalArgumentException("Matrix must be 4x4.");
        }
        this.matrix = matrix;
    }

    public Matrix4d identity() {
        return new Matrix4d(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }

    public Matrix4d zero() {
        return new Matrix4d(new float[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
    }

    public Matrix4d add(final Matrix4d matrix4d) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.matrix[i][j] + matrix4d.matrix[i][j];
            }
        }
        return new Matrix4d(result);
    }

    public Matrix4d subtract(final Matrix4d matrix4d) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.matrix[i][j] - matrix4d.matrix[i][j];
            }
        }
        return new Matrix4d(result);
    }

    public Vector4f multiply(final Vector4f vector4f) {
        float x = matrix[0][0] * vector4f.getX() + matrix[0][1] * vector4f.getY() + matrix[0][2] * vector4f.getZ() + matrix[0][3] * vector4f.getW();
        float y = matrix[1][0] * vector4f.getX() + matrix[1][1] * vector4f.getY() + matrix[1][2] * vector4f.getZ() + matrix[1][3] * vector4f.getW();
        float z = matrix[2][0] * vector4f.getX() + matrix[2][1] * vector4f.getY() + matrix[2][2] * vector4f.getZ() + matrix[2][3] * vector4f.getW();
        float w = matrix[3][0] * vector4f.getX() + matrix[3][1] * vector4f.getY() + matrix[3][2] * vector4f.getZ() + matrix[3][3] * vector4f.getW();
        return new Vector4f(x, y, z, w);
    }

    public Matrix4d multiply(final Matrix4d matrix4d) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result[i][j] += this.matrix[i][k] * matrix4d.matrix[k][j];
                }
            }
        }
        return new Matrix4d(result);
    }

    public float get(final int row, final int column) {
        if (row < 4 && column < 4) {
            return matrix[row][column];
        } else {
            return -1f;
        }
    }

    public void set(final int row, final int column, final float value) {
        if (row < 4 && column < 4) {
            this.matrix[row][column] = value;
        }
    }

    public void setMatrix(final float[][] matrix) {
        if (matrix.length == 4 &&
                matrix[0].length == 4 &&
                matrix[1].length == 4 &&
                matrix[2].length == 4 &&
                matrix[3].length == 4) {
            this.matrix = matrix;
        }
    }

    public Matrix4d transpose() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[j][i] = this.matrix[i][j];
            }
        }
        return new Matrix4d(result);
    }

    public float[][] getElements() {
        return matrix;
    }
}
