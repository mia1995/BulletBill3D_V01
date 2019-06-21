package sample;

import javafx.scene.layout.Pane;



public class Bahn extends Pane {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double minZ;
    private double maxZ;

    //private Bahn[] freierFall;

    public Bahn (double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_){
        this.minX = minX_;
        this.maxX = maxX_;
        this.minY = minY_;
        this.maxY = maxY_;
        this.minZ = minZ_;
        this.maxZ = maxZ_;
    }

    public double getMinX() {
        return minX;
    }
    /**
    public void setMinX(double minX) {
        Bahn.minX = minX;
    }
**/
    public double getMaxX() {
        return maxX;
    }
/**
    public void setMaxX(double maxX) {
        Bahn.maxX = maxX;
    }
**/
    public double getMinY() {
        return minY;
    }
/**
    public void setMinY(double minY) {
        Bahn.minY = minY;
    }
**/
    public double getMaxY() {
        return maxY;
    }
/**
    public void setMaxY(double maxY) {
        Bahn.maxY = maxY;
    }
**/
    public double getMinZ() {
        return minZ;
    }
/**
    public void setMinZ(double minZ) {
        Bahn.minZ = minZ;
    }
**/
    public double getMaxZ() {
        return maxZ;
    }
/**
    public void setMaxZ(double maxZ) {
        Bahn.maxZ = maxZ;
    }
 **/
}
