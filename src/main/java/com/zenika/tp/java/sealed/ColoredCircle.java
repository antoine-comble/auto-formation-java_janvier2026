package com.zenika.tp.java.sealed;

public final class ColoredCircle extends Circle {
    public ColoredCircle(double radius, String color) {
        super(radius);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;
}
