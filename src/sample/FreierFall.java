package sample;

public class FreierFall extends Bahn {

    public FreierFall(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, boolean xNeg_, boolean xPos_, boolean yNeg_, boolean yPos_, boolean zNeg_, boolean zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static FreierFall[] createElement(){
        FreierFall[] freierFall = new FreierFall[1];
        freierFall[0] = new FreierFall (730,770,0,100,0,0, false, false, true,true,false,false);
        return freierFall;
    }

    //createElement1(){} für FreierFall an anderer Stelle
}
