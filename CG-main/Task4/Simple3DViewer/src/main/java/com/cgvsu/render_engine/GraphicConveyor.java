package com.cgvsu.render_engine;

import javax.vecmath.Matrix4f;
import javax.vecmath.Point2f;
import javax.vecmath.Vector3f;

public class GraphicConveyor {
    public static Matrix4f rotateScaleTranslate() {
        float[] matrix = new float[]{
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };
        return new Matrix4f(matrix);
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target) {
        return lookAt(eye, target, new Vector3f(0F, 1.0F, 0F));
    }


    public static Matrix4f lookAt(Vector3f eye, Vector3f target, Vector3f up) {
        Vector3f resultX = new Vector3f();
        Vector3f resultY = new Vector3f();
        Vector3f resultZ = new Vector3f();

        resultZ.sub(target, eye);
        resultX.cross(up, resultZ);
        resultY.cross(resultZ, resultX);

        resultX.normalize();
        resultY.normalize();
        resultZ.normalize();

        float[] matrix = new float[]{
                resultX.x, resultY.x, resultZ.x, 0,
                resultX.y, resultY.y, resultZ.y, 0,
                resultX.z, resultY.z, resultZ.z, 0,
                -resultX.dot(eye), -resultY.dot(eye), -resultZ.dot(eye), 1
        };
        return new Matrix4f(matrix);
    }

    public static Matrix4f perspective(
            final float fov,
            final float aspectRatio,
            final float nearPlane,
            final float farPlane
    ) {
        Matrix4f result = new Matrix4f();

        // f = 1 / tan(fov / 2)
        float tangentMinusOnDegree = (float) (1.0F / (Math.tan(fov * 0.5F)));

        result.m00 = tangentMinusOnDegree / aspectRatio;
        result.m11 = tangentMinusOnDegree;
        result.m22 = (farPlane + nearPlane) / (farPlane - nearPlane);
        result.m23 = 1.0F;
        result.m32 = 2 * (nearPlane * farPlane) / (nearPlane - farPlane);

        return result;
    }

    public static Vector3f multiplyMatrix4ByVector3(final Matrix4f matrix, final Vector3f vertex) {
        final float x = (vertex.x * matrix.m00) + (vertex.y * matrix.m10) + (vertex.z * matrix.m20) + matrix.m30;
        final float y = (vertex.x * matrix.m01) + (vertex.y * matrix.m11) + (vertex.z * matrix.m21) + matrix.m31;
        final float z = (vertex.x * matrix.m02) + (vertex.y * matrix.m12) + (vertex.z * matrix.m22) + matrix.m32;
        final float w = (vertex.x * matrix.m03) + (vertex.y * matrix.m13) + (vertex.z * matrix.m23) + matrix.m33;

        return new Vector3f(x / w, y / w, z / w);
    }

    public static void multiplyMatrix4ByVector(final Matrix4f matrix, final com.cgvsu.math.Vector3f vertex) {
        final float w = (vertex.x * matrix.m30) + (vertex.y * matrix.m31) + (vertex.z * matrix.m32) + matrix.m33;

        vertex.x = ((vertex.x * matrix.m00) + (vertex.y * matrix.m01) + (vertex.z * matrix.m02) + matrix.m03) / w;
        vertex.y = ((vertex.x * matrix.m10) + (vertex.y * matrix.m11) + (vertex.z * matrix.m12) + matrix.m13) / w;
        vertex.z = ((vertex.x * matrix.m20) + (vertex.y * matrix.m21) + (vertex.z * matrix.m22) + matrix.m32) / w;
    }

    public static Point2f vertexToPoint(final Vector3f vertex, final int width, final int height) {
        return new Point2f(
                vertex.x * width + width / 2.0F,
                -vertex.y * height + height / 2.0F
        );
    }
}
