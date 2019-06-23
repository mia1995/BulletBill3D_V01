package Collision;

public class Line extends javafx.scene.shape.Line {
    public double startX;
    public double startY;
    public double startZ;
    public double endX;
    public double endY;
    public double endZ;

    public Line (double startX_, double startY_, double startZ_, double endX_, double endY_, double endZ_){
        this.startX = startX_;
        this.startY = startY_;
        this.startZ = startZ_;
        this.endX = endX_;
        this.endY = endY_;
        this.endZ = endZ_;
    }
}
