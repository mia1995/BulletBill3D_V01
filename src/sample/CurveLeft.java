package sample;

public class CurveLeft extends Bahn {
    public CurveLeft(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_);
    }

    public static CurveLeft[] createElement(){
        CurveLeft[] curveLefts = new CurveLeft[4];
        curveLefts[0] = new CurveLeft(770, 800, 200, 225, 0, 0);
        curveLefts[1] = new CurveLeft(740, 800, 225, 250, 0, 0);
        curveLefts[2] = new CurveLeft(720, 800, 250, 300, 0, 0);
        curveLefts[3] = new CurveLeft(700, 720, 250, 300, 0, 0);
        return curveLefts;
    }
}
