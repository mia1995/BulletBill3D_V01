package sample;

import javafx.scene.shape.Line;

public class CurveLeft extends Bahn {
    public CurveLeft(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static CurveLeft[] createElement(){
        CurveLeft[] curveLefts = new CurveLeft[4];
        curveLefts[0] = new CurveLeft(750, 800, 100, 110, 0, 0, false,false,true,true,false,false);
        curveLefts[1] = new CurveLeft(755, 800, 110, 140, 0, 0, false,false,true,true,false,false);
        curveLefts[2] = new CurveLeft(720, 800, 140, 160, 0, 0, false,false,true,false,false,false);
        curveLefts[3] = new CurveLeft(700, 720, 160, 180, 0, 0, false,true,false,false,false,false);
        return curveLefts;
    }
}
