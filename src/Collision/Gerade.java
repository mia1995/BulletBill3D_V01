package Collision;

public class Gerade extends Bahn {

    public Gerade(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, int xNeg_, int xPos_, int yNeg_, int yPos_, int zNeg_, int zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Gerade[] createElement1(){
        Gerade[] gerade = new Gerade[1];
        gerade[0] = new Gerade(500,700,100,220,30,70,1,2,0,0,0,0);
        return gerade;
    }

    public static Gerade[] createElement2(){
        Gerade[] gerade2 = new Gerade[1];
        gerade2[0] = new Gerade(300,500,200,320,30,70,1,2,0,0,0,0);
        return gerade2;
    }

    public static Gerade[] createElement3(){
        Gerade[] geradeDown = new Gerade[4];
        geradeDown[0] = new Gerade(230,270,200,320,100,130,0,0,0,0,1,2);
        geradeDown[1] = new Gerade(230,270,200,320,130,170,0,0,0,1,0,2);
        geradeDown[2] = new Gerade(230,270,320,327,130,180,0,0,2,1,0,0);
        geradeDown[3] = new Gerade(230,270,327,367,130,200,0,0,2,0,0,1);
        return geradeDown;
    }

    public static Gerade[] createElement4(){
        Gerade[] geradeLeft = new Gerade[1];
        geradeLeft[0] = new Gerade(100,200,300,420,230,270,1,2,0,0,0,0);
        return geradeLeft;
    }

    public static Gerade[] createElement5(){
        Gerade[] geradeRight = new Gerade[1];
        geradeRight[0] = new Gerade(100,200,300,420,330,370,0,0,0,0,0,0);
        return geradeRight;
    }

}
