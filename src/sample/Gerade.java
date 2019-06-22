package sample;

public class Gerade extends Bahn {

    public Gerade(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Gerade[] createElement1(){
        Gerade[] gerade = new Gerade[2];
        gerade[0] = new Gerade(500,700,100,220,30,70,true,true,false,false,false,false);
        gerade[1] = new Gerade(300,500,200,320,30,70,false,true,false,false,false,false);
        return gerade;
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

}
