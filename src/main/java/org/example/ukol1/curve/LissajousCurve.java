package org.example.ukol1.curve;

public class LissajousCurve implements Curve {
    private static final double PERIOD = 2*Math.PI;
    private final double x;
    private final double y;
    private final double a;
    private final double b;
    private final double width;
    private final double height;

    public LissajousCurve(double x, double y, double a, double b, double width, double height) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getX(double t) {
        t *= PERIOD;
        return a * Math.cos(x*t) + width;
    }

    @Override
    public double getY(double t) {
        t *= PERIOD;
        return b * Math.sin(y*t) + height;
    }
}
