package com.zenika.sealed;

import com.zenika.tp.java.sealed.ColoredCircle;
import com.zenika.tp.java.sealed.Point;
import com.zenika.tp.java.sealed.Shape;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapeTest {
    @Test
    public void shouldCreateShape() {
        Shape shape = new Shape();
        Point center = new Point(10, 34.5);
        shape.setCenter(center);
        Assertions.assertThat(shape.getCenter().getX()).isEqualTo(10);
        Assertions.assertThat(shape.getCenter().getY()).isEqualTo(34.5);
    }

    @Test
    public void shouldCreateColoredCircle() {
        final ColoredCircle shape = new ColoredCircle(8.7, "RED");
        Assertions.assertThat(shape.getColor()).isEqualTo("RED");
        Assertions.assertThat(shape.getRadius()).isEqualTo(8.7);

        Point center = new Point(10, 34.5);
        shape.setCenter(center);
        Assertions.assertThat(shape.getCenter().getX()).isEqualTo(10);
        Assertions.assertThat(shape.getCenter().getY()).isEqualTo(34.5);
    }
}
