package sample;

import javafx.scene.shape.Line;

public class CurveLeft extends Bahn {
    public CurveLeft(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_);
    }

    public static CurveLeft[] createElement(){
        CurveLeft[] curveLefts = new CurveLeft[4];
        curveLefts[0] = new CurveLeft(770, 800, 100, 120, 0, 0);
        curveLefts[1] = new CurveLeft(740, 800, 120, 140, 0, 0);
        curveLefts[2] = new CurveLeft(720, 800, 140, 160, 0, 0);
        curveLefts[3] = new CurveLeft(700, 720, 160, 180, 0, 0);
        return curveLefts;
    }
}
