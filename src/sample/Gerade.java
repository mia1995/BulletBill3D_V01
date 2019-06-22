package sample;

public class Gerade extends Bahn {

    public Gerade(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static Gerade[] createElement(){
        Gerade[] gerade = new Gerade[1];
        gerade[0] = new Gerade(500,700,100,220,0,0,true,false,false,false,false,false);
        return gerade;
    }

}
