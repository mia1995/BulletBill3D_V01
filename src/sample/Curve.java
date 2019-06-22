package sample;

public class Curve extends Bahn {
    public Curve(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Curve[] createElement1(){
        Curve[] curves = new Curve[4];
        curves[0] = new Curve(730, 770, 100, 115 ,130, 170 ,false,false,true,true,false,false);
        curves[1] = new Curve(730 ,770, 115, 120, 125, 170, false,false,true,true,false,false);
        curves[2] = new Curve(730, 770, 120, 165, 115, 170, false,false,true,false,true,false);
        curves[3] = new Curve(730, 770, 120, 165, 100, 115, false,false,false,false,false,true);
        return curves;
    }

    public static Curve[] createElement2(){
        Curve[] curveKomplex = new Curve[3];
        curveKomplex[0] = new Curve(730,770,120,165,85,100,false,false,false,false, true,true);
        curveKomplex[1] = new Curve(714,770,120,185,30,85, false,false,false,true,false,true);
        curveKomplex[2] = new Curve(700,770,164,185,30,70, true,true,false,false,false,false);
        return curveKomplex;
    }

    public static Curve[] createElement3(){
        Curve[] curveDown = new Curve[3];
        curveDown[0] = new Curve(285,300,200,320,30,70,true,true,false,false,false,false);
        curveDown[1] = new Curve(230,285,200,320,30,85,false,true,false,false,false,true);
        curveDown[2] = new Curve(230,270,200,320,85,100,false,false,false,false,true,true);
        return curveDown;
    }

    public static Curve[] createElement4(){
        Curve[] curveLeft = new Curve[3];
        curveLeft[0] = new Curve(230,270,300,420,200,215,false,false,false,false,false,true);
        curveLeft[1] = new Curve(215,230,300,420,215,270,true,false,false,false,true,false);
        curveLeft[2] = new Curve(200,215,300,420,230,270,true,true,false,false,false,false);
        return curveLeft;
    }
}
