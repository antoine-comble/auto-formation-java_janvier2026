package com.zenika.tp.java.sealed;

public sealed class Shape permits Circle, Square {

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    private Point center;

    // Imaginez d'autres attributs et méthodes.

}
