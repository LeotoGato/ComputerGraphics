package com.cgvsu.math;

public class Vector2f {
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float x, y;

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

    public Vector2f add(final Vector2f vector2f) {
        return new Vector2f(this.x + vector2f.x, this.y + vector2f.y);
    }

    public Vector2f subtract(final Vector2f vector2f) {
        return new Vector2f(this.x + (-vector2f.x), this.y + (-vector2f.y));
    }

    public Vector2f multiply(final float scalar) {
        return new Vector2f(this.x * scalar, this.y * scalar);
    }

    public Vector2f divide(final float scalar) {
        if(scalar == 0) throw new ArithmeticException();
        return new Vector2f(this.x / scalar, this.y / scalar);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2f normalize() {
        float len = length();
        return new Vector2f(x / len, y / len);
    }

    public double dot(final Vector2f vector2f) {
        return this.x * vector2f.x + this.y * vector2f.y;
    }

}
