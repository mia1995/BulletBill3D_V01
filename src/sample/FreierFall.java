package sample;

public class FreierFall extends Bahn {

    public FreierFall(double minX_, double maxX_, double minY_, double maxY_, double minZ_, double maxZ_) {
        super(minX_, maxX_, minY_, maxY_, minZ_, maxZ_);
    }

    public FreierFall[] freeFall;

    public static FreierFall[] createElement(){
        FreierFall[] freierFall = new FreierFall[3];
        freierFall[0] = new FreierFall(760, 800, 0, 25, 0, 0);
        freierFall[1] = new FreierFall(760, 800, 25, 50, 0, 0);
        freierFall[2] = new FreierFall(700, 800, 50, 75, 0, 0);
        return freierFall;
    }

     public FreierFall[] getFreierFall(){
     return freeFall;
     }
    /**
    public void createElement(){
        FreierFall[] freierFall = new FreierFall[3];
        freierFall[0] = new FreierFall(760, 800, 0, 25, 0, 0);
        freierFall[1] = new FreierFall(760, 800, 25, 50, 0, 0);
        freierFall[2] = new FreierFall(700, 800, 50, 75, 0, 0);
        this.freeFall = freierFall;
    }

    public FreierFall[] getFreierFall(){
        return freeFall;
    }
    public void getFreierFall(FreierFall freierFall){

    }
     **/
}
