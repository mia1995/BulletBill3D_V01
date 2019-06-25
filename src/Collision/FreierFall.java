package Collision;

public class FreierFall extends Bahn {

    public FreierFall(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_, int xNeg_, int xPos_, int yNeg_, int yPos_, int zNeg_, int zPos_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_, xNeg_, xPos_, yNeg_, yPos_, zNeg_, zPos_);
    }

    public static FreierFall[] createElement(){
        FreierFall[] freierFall = new FreierFall[1];
        freierFall[0] = new FreierFall (730,770,20,100,130,170, 0, 0, 1,1,0,0);
        return freierFall;
    }
}
