package sample;

import javafx.scene.layout.Pane;

public class Bahn extends Pane {
    private static double minX;
    private static double maxX;
    private static double minY;
    private static double maxY;
    private static double minZ;
    private static double maxZ;

    public Bahn(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_){
        this.minX = minX_;
        this.maxX = maxX_;
        this.minY = minY_;
        this.maxY = maxY_;
        this.minZ = minZ_;
        this.maxZ = maxZ_;
    }

    public static double getMinX() {
        return minX;
    }

    public static void setMinX(double minX) {
        Bahn.minX = minX;
    }

    public static double getMaxX() {
        return maxX;
    }

    public static void setMaxX(double maxX) {
        Bahn.maxX = maxX;
    }

    public static double getMinY() {
        return minY;
    }

    public static void setMinY(double minY) {
        Bahn.minY = minY;
    }

    public static double getMaxY() {
        return maxY;
    }

    public static void setMaxY(double maxY) {
        Bahn.maxY = maxY;
    }

    public static double getMinZ() {
        return minZ;
    }

    public static void setMinZ(double minZ) {
        Bahn.minZ = minZ;
    }

    public static double getMaxZ() {
        return maxZ;
    }

    public static void setMaxZ(double maxZ) {
        Bahn.maxZ = maxZ;
    }
}
