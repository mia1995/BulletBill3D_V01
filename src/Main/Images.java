package Main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Images {

    public static Image[] getIsoPics() {
        Image[] isoImages = new Image[8];
        isoImages[0] = new Image("BB Front Hervorhebung/Iso01.png");
        isoImages[1] = new Image("BB Front Hervorhebung/Iso02.png");
        isoImages[2] = new Image("BB Front Hervorhebung/Iso03.png");
        isoImages[3] = new Image("BB Front Hervorhebung/Iso04.png");
        isoImages[4] = new Image("BB Front Hervorhebung/Iso05.png");
        isoImages[5] = new Image("BB Front Hervorhebung/Iso06.png");
        isoImages[6] = new Image("BB Front Hervorhebung/Iso07.png");
        isoImages[7] = new Image("BB Front Hervorhebung/Iso08.png");
        return isoImages;
    }

    public static Image[] getFrontImages() {
        Image[] imagesFront = new Image[8];
        imagesFront[0] = new Image("BB Front Hervorhebung/Mario01 C.png");
        imagesFront[1] = new Image("BB Front Hervorhebung/Mario02 C.png");
        imagesFront[2] = new Image("BB Front Hervorhebung/Mario03 C.png");
        imagesFront[3] = new Image("BB Front Hervorhebung/Mario04 C.png");
        imagesFront[4] = new Image("BB Front Hervorhebung/Mario05 C.png");
        imagesFront[5] = new Image("BB Front Hervorhebung/Mario06 C.png");
        imagesFront[6] = new Image("BB Front Hervorhebung/Mario07 C.png");
        imagesFront[7] = new Image("BB Front Hervorhebung/Mario08 C.png");
        return imagesFront;
    }

    public static Image[] getTopImage() {
        Image[] imagesTop = new Image[10];
        imagesTop[0] = new Image("BB Top Hervorhebung/Mario01 C.png");
        imagesTop[1] = new Image("BB Top Hervorhebung/Mario02 C.png");
        imagesTop[2] = new Image("BB Top Hervorhebung/Mario03 C.png");
        imagesTop[3] = new Image("BB Top Hervorhebung/Mario04 C.png");
        imagesTop[4] = new Image("BB Top Hervorhebung/Mario05 C.png");
        imagesTop[5] = new Image("BB Top Hervorhebung/Mario06 C.png");
        imagesTop[6] = new Image("BB Top Hervorhebung/Mario07 C.png");
        imagesTop[7] = new Image("BB Top Hervorhebung/Mario08 C.png");
        imagesTop[8] = new Image("BB Top Hervorhebung/Mario09 C.png");
        imagesTop[9] = new Image("BB Top Hervorhebung/Mario10 C.png");
        return imagesTop;
    }

    public static Image[] getLeftImage() {
        Image[] imagesLeft = new Image[8];
        imagesLeft[0] = new Image("BB Left Hervorhebung/Mario01 C.png");
        imagesLeft[1] = new Image("BB Left Hervorhebung/Mario02 C.png");
        imagesLeft[2] = new Image("BB Left Hervorhebung/Mario03 C.png");
        imagesLeft[3] = new Image("BB Left Hervorhebung/Mario04 C.png");
        imagesLeft[4] = new Image("BB Left Hervorhebung/Mario05 C.png");
        imagesLeft[5] = new Image("BB Left Hervorhebung/Mario06 C.png");
        imagesLeft[6] = new Image("BB Left Hervorhebung/Mario07 C.png");
        imagesLeft[7] = new Image("BB Left Hervorhebung/Mario08 C.png");
        return imagesLeft;
    }

    public static void fallCurve(ImageView front, ImageView side, ImageView top, ImageView imageFront02, ImageView imageSide02, ImageView iso, Image imageFront, Image imagesLeft) {
        front.setImage(new Image("BulletBillParkour Front/Mario01.png"));
        side.setImage(new Image("BulletBillParkour Left/Mario01.png"));
        top.setImage(new Image("BulletBillParkour Top/Mario01.png"));

        imageFront02.setImage(imageFront);
        imageSide02.setImage(imagesLeft);

        iso.setImage(new Image("BB Front Hervorhebung/Iso02.png"));
    }

    public static void geradeStrecke(ImageView side04, ImageView front03, ImageView top03, ImageView front04, ImageView side041, ImageView top04, Image image01, Image image02, Image image03) {
        side04.setImage(new Image("BulletBillParkour Left/Mario04.png"));
        front03.setImage(new Image("BulletBillParkour Front/Mario04.png"));
        top03.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

        front04.setImage(image01);
        side041.setImage(image02);
        top04.setImage(image03);
    }

    public static void lochGeradeStrecke(ImageView side05, ImageView top07, ImageView side06, ImageView front07, ImageView top08, ImageView iso, Image left, Image front, Image top) {
        side05.setImage(new Image("BulletBillParkour Left/Mario06.png"));
        top07.setImage(new Image("BulletBillParkour Top/Mario041ff.png"));

        side06.setImage(left);
        front07.setImage(front);
        top08.setImage(top);

        iso.setImage(new Image("BB Front Hervorhebung/Iso02.png"));
    }

    public static void leftCurveAfterleftCurve(ImageView top11, ImageView side07, ImageView front08, ImageView top12, ImageView side08, ImageView iso, Image front, Image top, Image left) {
        top11.setImage(new Image("BulletBillParkour Top/Mario041f.png"));
        side07.setImage(new Image("BulletBillParkour Left/Mario09.png"));

        front08.setImage(front);
        top12.setImage(top);
        side08.setImage(left);

        iso.setImage(new Image("BB Front Hervorhebung/Iso05.png"));

    }

    public static void geradeEnde(ImageView front08, ImageView top12, ImageView side08, ImageView front09, ImageView top13, ImageView iso, Image front, Image top) {

        front08.setImage(new Image("BulletBillParkour Front/Mario11.png"));
        top12.setImage(new Image("BulletBillParkour Top/Mario08ff.png"));
        side08.setImage(new Image("BulletBillParkour Left/Mario10.png"));

        front09.setImage(front);
        top13.setImage(top);

        iso.setImage(new Image("BB Front Hervorhebung/Iso04.png"));
    }


}
