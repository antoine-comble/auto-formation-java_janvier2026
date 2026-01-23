package com.zenika.tp.java.sealed;

public sealed class Circle extends Shape permits ColoredCircle {
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    private double radius;
}
