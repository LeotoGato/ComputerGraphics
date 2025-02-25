package com.cgvsu.math;

public class Vector3f {
    public static final float EPSILON = 1e-7f;
    public float x, y, z;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Vector3f other) {
        return Math.abs(this.x - other.x) < EPSILON &&
                Math.abs(this.y - other.y) < EPSILON && Math.abs(this.z - other.z) < EPSILON;
    }

    public void mul(Vector3f var1, Vector3f var2) {
        this.x = var1.y * var2.z - var1.z * var2.y;
        this.y = -(var1.x * var2.z - var1.z * var2.x);
        this.z = var1.x * var2.y - var1.y * var2.x;
    }

    public void sub(Vector3f var1, Vector3f var2) {
        this.x = var2.x - var1.x;
        this.y = var2.y - var1.y;
        this.z = var2.z - var1.z;
    }

    public void add(Vector3f var1) {
        this.x += var1.x;
        this.y += var1.y;
        this.z += var1.z;
    }

    public void div(float n) {
        if (n != 0) {
            this.x /= n;
            this.y /= n;
            this.z /= n;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public float dot(Vector3f other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public void normalize() {
        float length = length();
        if (length > EPSILON) {
            this.div(length);
        } else {
            throw new ArithmeticException("Cannot normalize a zero vector");
        }
    }

    public Vector3f normalizeReturn() {
        float len = length();
        return new Vector3f(x / len, y / len, z / len);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3f addReturn(final Vector3f vector3f) {
        return new Vector3f(this.x + vector3f.x, this.y + vector3f.y, this.z + vector3f.z);
    }

    public Vector3f subtract(final Vector3f vector3f) {
        return new Vector3f(this.x + (-vector3f.x), this.y + (-vector3f.y), this.z + (-vector3f.z));
    }

    public Vector3f multiply(final float scalar) {
        return new Vector3f(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Vector3f divide(final float scalar) {
        if(scalar == 0) throw new ArithmeticException();
        return new Vector3f(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    public Vector3f cross(final Vector3f vector3f) {
        return new Vector3f(
                this.y * vector3f.z - this.z * vector3f.y,
                - this.z * vector3f.x + this.x * vector3f.z,
                this.x * vector3f.y - this.y * vector3f.x
        );
    }

    @Override
    public String toString() {
        return "Vector3f{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}