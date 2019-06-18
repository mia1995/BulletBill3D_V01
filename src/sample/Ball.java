package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    double r;
    Color color;
    double mass;

    public Ball(double radius, double mass, Color fillColor) {

        setFill(fillColor);

        this.r = radius;
        this.mass = mass;
        this.color = fillColor;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
