package sample;

public class Curve extends Bahn {
    public Curve(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Curve[] createElement(){
        Curve[] curves = new Curve[4];
        curves[0] = new Curve(750, 800, 100, 110, 0, 0, false,false,true,true,false,false);
        curves[1] = new Curve(755, 800, 110, 140, 0, 0, false,false,true,true,false,false);
        curves[2] = new Curve(720, 800, 140, 160, 0, 0, false,false,true,false,false,false);
        curves[3] = new Curve(700, 720, 160, 180, 0, 0, false,true,false,false,false,false);
        return curves;
    }
}
