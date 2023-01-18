package dev.sarahgreywolf.redsorcery.util;

public class ShapePos {
    private int X;
    private int Z;
    private int LAYER;

    public ShapePos() {

    }

    public ShapePos(int x, int z, int layer) {
        X = x;
        Z = z;
        LAYER = layer;
    }

    public void setX(int x) {
        X = x;
    }

    public void setZ(int z) {
        Z = z;
    }

    public void setLayer(int layer) {
        LAYER = layer;
    }

    public int getX() {
        return X;
    }

    public int getZ() {
        return Z;
    }

    public int getLayer() {
        return LAYER;
    }

    public boolean isZero() {
        return X == 0 && Z == 0 && LAYER == 0;
    }

}
