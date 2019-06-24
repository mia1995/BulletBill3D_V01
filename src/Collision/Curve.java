package Collision;

public class Curve extends Bahn {
    public Curve(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, int xNeg_, int xPos_, int yNeg_, int yPos_, int zNeg_, int zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Curve[] createElement1(){
        Curve[] curves = new Curve[3];
        curves[0] = new Curve(730, 770, 100, 115 ,130, 170 ,0,0,2,1,0,0);
        curves[1] = new Curve(730 ,770, 115, 170, 115, 170, 0,0,2,0,1,0);
        curves[2] = new Curve(730, 770, 130, 170, 100, 115, 0,0,0,0,1,2);
        return curves;
    }

    public static Curve[] createElement2(){
        Curve[] curveKomplex = new Curve[4];
        curveKomplex[0] = new Curve(715,770,130,170,70,100,0,0,0,0, 1,2);
        curveKomplex[1] = new Curve(715,770,130,170,30,70, 0,0,0,1,0,2);
        curveKomplex[2] = new Curve(715,770,170,195,30,80, 1,0,2,0,0,0);
        curveKomplex[3] = new Curve(700,715,155,195,30,70, 1,2,0,0,0,0);
        return curveKomplex;
    }

    public static Curve[] createElement3(){
        Curve[] curveDown = new Curve[3];
        curveDown[0] = new Curve(285,300,200,320,30,70,1,2,0,0,0,0);
        curveDown[1] = new Curve(230,285,200,320,30,85,0,2,0,0,0,1);
        curveDown[2] = new Curve(230,270,200,320,85,100,0,0,0,0,2,1);
        return curveDown;
    }

    public static Curve[] createElement4(){
        Curve[] curveLeft = new Curve[3];
        curveLeft[0] = new Curve(230,270,300,420,200,215,0,0,0,0,1,2);
        curveLeft[1] = new Curve(215,270,300,420,215,270,1,0,0,0,2,0);
        curveLeft[2] = new Curve(200,215,300,420,230,270,1,2,0,0,0,0);
        return curveLeft;
    }

    public static Curve[] createElement5(){
        Curve[] curveDown2 = new Curve[3];
        curveDown2[0] = new Curve(85,100,300,420,230,270,1,2,0,0,0,0);
        curveDown2[1] = new Curve(30,85,300,420,230,285,0,2,0,0,0,1);
        curveDown2[2] = new Curve(30,70,300,420,285,300,0,0,0,0,2,1);
        return curveDown2;
    }

    public static Curve[] createElement6(){
        Curve[] curveRight = new Curve[3];
        curveRight[0] = new Curve(30,70,300,420,300,315,0,0,0,0,1,2);
        curveRight[1] = new Curve(30,85,300,420,315,370,0,1,0,0,2,0);
        curveRight[2] = new Curve(85,100,300,420,330,370,2,1,0,0,0,0);
        return curveRight;
    }
}
