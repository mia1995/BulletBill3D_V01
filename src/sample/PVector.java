package sample;

import static java.lang.Math.sqrt;

public class PVector {
    double x;
    double y;
    double z;

    PVector(double x_, double y_, double z_){
        x = x_;
        y = y_;
        z = z_;
    }

    public void add(PVector v){
        x = x + v.x;
        y = y + v.y;
        z = z + v.z;
    }

    public void sub(PVector v){
        x = x - v.x;
        y = y - v.y;
        z = z - v.z;
    }

    public void mult (double n){
        x = x * n;
        y = y * n;
        z = z * n;
    }

    public void div (double n){
        x = x / n;
        y = y / n;
        z = z / n;
    }
    // Länge des Vektors (Magnitude)
    public double mag(){
        return sqrt(x*x + y*y + z*z);
    }

    public void normalize(){
        double m = mag();
        if (m != 0){
            div(m);
        }
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() { return z; }
}
