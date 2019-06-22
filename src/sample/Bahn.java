package sample;

import javafx.scene.layout.Pane;

abstract class Bahn {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double minZ;
    private double maxZ;

    private boolean xNeg;
    private boolean xPos;
    private boolean yNeg;
    private boolean yPos;
    private boolean zNeg;
    private boolean zPos;

    public Bahn (double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_){
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

    public boolean getXNeg(){return xNeg; }

    public boolean getXPos(){return xPos; }

    public boolean getYNeg(){return yNeg; }

    public boolean getYPos(){return yPos; }

    public boolean getZNeg(){return zNeg; }

    public boolean getZPos(){return zPos; }
}
