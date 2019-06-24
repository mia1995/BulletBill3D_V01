package Collision;

import javafx.scene.layout.Pane;

abstract class Bahn extends Pane {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double minZ;
    private double maxZ;

    private int xNeg;
    private int xPos;
    private int yNeg;
    private int yPos;
    private int zNeg;
    private int zPos;

    public Bahn (double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, int xNeg_, int xPos_, int yNeg_, int yPos_, int zNeg_, int zPos_){
        this.minX = minX_;
        this.maxX = maxX_;
        this.minY = minY_;
        this.maxY = maxY_;
        this.minZ = minZ_;
        this.maxZ = maxZ_;

        this.xNeg = xNeg_;
        this.xPos = xPos_;
        this.yNeg = yNeg_;
        this.yPos = yPos_;
        this.zNeg = zNeg_;
        this.zPos = zPos_;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinZ() {
        return minZ;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public int getXNeg(){return xNeg; }

    public int getXPos(){return xPos; }

    public int getYNeg(){return yNeg; }

    public int getYPos(){return yPos; }

    public int getZNeg(){return zNeg; }

    public int getZPos(){return zPos; }
}
