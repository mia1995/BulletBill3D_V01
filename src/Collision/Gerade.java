package Collision;

public class Gerade extends Bahn {

    public Gerade(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Gerade[] createElement1(){
        Gerade[] gerade1 = new Gerade[2];
        gerade1[0] = new Gerade(600,700,100,220,30,70,true,false,false,false,false,false);
        gerade1[1] = new Gerade(500,600,100,220,30,70,true,true,false,false,false,false);
        return gerade1;
    }

    public static Gerade[] createElement2(){
        Gerade[] gerade2 = new Gerade[2];
        gerade2[0] = new Gerade(400,500,200,320,30,70,true,true,false,false,false,false);
        gerade2[1] = new Gerade(300,400,200,320,30,70,true,true,false,false,false,false);
        return gerade2;
    }

    public static Gerade[] createElement3(){
        Gerade[] geradeDown = new Gerade[3];
        geradeDown[0] = new Gerade(230,270,200,320,100,130,false,false,false,false,true,true);
        geradeDown[1] = new Gerade(230,270,320,327,130,170,false,false,true,true,false,false);
        geradeDown[2] = new Gerade(230,270,327,367,130,200,false,false,true,false,false,true);
        return geradeDown;
    }

    public static Gerade[] createElement4(){
        Gerade[] geradeLeft = new Gerade[1];
        geradeLeft[0] = new Gerade(100,200,300,420,230,270,true,true,false,false,false,false);
        return geradeLeft;
    }

    public static Gerade[] createElement5(){
        Gerade[] geradeRight = new Gerade[1];
        geradeRight[0] = new Gerade(100,200,300,420,330,370,true,false,false,false,false,false);
        return geradeRight;
    }

}
