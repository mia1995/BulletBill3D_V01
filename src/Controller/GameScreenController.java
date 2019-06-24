package Controller;


import Collision.Mover;
import Collision.PVector;
import Physics.Movement;
import Physics.Time;
import Sprite.Sphere;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class GameScreenController implements Initializable {

    @FXML
    private Button closebtn;
    @FXML
    private Button playbtn;
    @FXML
    private Button breakbtn;
    @FXML
    private Button repeatbtn;
    @FXML
    private Pane paneTL;
    @FXML
    private Pane paneTR;
    @FXML
    private Pane paneBL;
    @FXML
    private Pane aPane;

     //Images Front

    @FXML
    private ImageView imageFront01;

    @FXML
    private ImageView imageFront02;

    @FXML
    private ImageView imageFront03;

    @FXML
    private ImageView imageFront04;

    @FXML
    private ImageView imageFront05;

    @FXML
    private ImageView imageFront06;

    @FXML
    private ImageView imageFront07;

    @FXML
    private ImageView imageFront09;

    @FXML
    private ImageView imageFront08;

    @FXML
    private ImageView imageFront10;

    //Images Side

    @FXML
    private ImageView imageSide01;

    @FXML
    private ImageView imageSide03;

    @FXML
    private ImageView imageSide02;

    @FXML
    private ImageView imageSide04;

    @FXML
    private ImageView imageSide05;

    @FXML
    private ImageView imageSide06;

    @FXML
    private ImageView imageSide07;

    @FXML
    private ImageView imageSide08;

    //Images Top

    @FXML
    private ImageView imageTop02;

    @FXML
    private ImageView imageTop01;

    @FXML
    private ImageView imageTop03;

    @FXML
    private ImageView imageTop04;

    @FXML
    private ImageView imageTop05;

    @FXML
    private ImageView imageTop06;

    @FXML
    private ImageView imageTop07;

    @FXML
    private ImageView imageTop08;

    @FXML
    private ImageView imageTop10;

    @FXML
    private ImageView imageTop11;

    @FXML
    private ImageView imageTop13;

    @FXML
    private ImageView imageTop12;

    @FXML
    private ImageView imageTop09;

    @FXML
    private ImageView isoPic;

    @FXML
    private ImageView playbtnImage;

    @FXML
    private ImageView closebtnImage;

    @FXML
    private ImageView pausebtnImage;

    @FXML
    private ImageView repeatbtnImage;

    @FXML
    private Label timeLabel;

    @FXML
    private Label veloLabel1;

    @FXML
    private Button guiMode;

    @FXML
    private Button collisionMode;

    Image[] imagesFront;
    Image[] imagesTop;
    Image[] imagesLeft;


    Timeline loop;
    Timeline timecounter;
    private double frameTime = 0.01;


    private boolean living = true;
    Sphere xySphere;
    Sphere xzSphere;
    Sphere yzSphere;

    boolean change = true;
    boolean stopMaker = false;
    boolean timeswap = false;

    // Zeit Zähler
     private int seconds = 0;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imagesFront = new Image[8];
        imagesFront[0] = new Image("BB Front Hervorhebung/Mario01 C.png");
        imagesFront[1] = new Image("BB Front Hervorhebung/Mario02 C.png");
        imagesFront[2] = new Image("BB Front Hervorhebung/Mario03 C.png");
        imagesFront[3] = new Image("BB Front Hervorhebung/Mario04 C.png");
        imagesFront[4] = new Image("BB Front Hervorhebung/Mario05 C.png");
        imagesFront[5] = new Image("BB Front Hervorhebung/Mario06 C.png");
        imagesFront[6] = new Image("BB Front Hervorhebung/Mario07 C.png");
        imagesFront[7] = new Image("BB Front Hervorhebung/Mario08 C.png");

        imagesTop = new Image[10];
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

        imagesLeft = new Image[8];
        imagesLeft[0] = new Image("BB Left Hervorhebung/Mario01 C.png");
        imagesLeft[1] = new Image("BB Left Hervorhebung/Mario02 C.png");
        imagesLeft[2] = new Image("BB Left Hervorhebung/Mario03 C.png");
        imagesLeft[3] = new Image("BB Left Hervorhebung/Mario04 C.png");
        imagesLeft[4] = new Image("BB Left Hervorhebung/Mario05 C.png");
        imagesLeft[5] = new Image("BB Left Hervorhebung/Mario06 C.png");
        imagesLeft[6] = new Image("BB Left Hervorhebung/Mario07 C.png");
        imagesLeft[7] = new Image("BB Left Hervorhebung/Mario08 C.png");

        xySphere = new Sphere(750, 20,150, 15, Color.BLACK, 0, 20, 0, 1,0, 0, 0);
        paneTL.getChildren().add(xySphere);

        xzSphere = new Sphere(750,20,150,15, Color.BLACK, 0,20,0,2,0,0,0);
        paneBL.getChildren().add(xzSphere);

        yzSphere = new Sphere(750, 20, 150, 15, Color.BLACK, 0, 20, 0, 3,0,0,0);
        paneTR.getChildren().add(yzSphere);



        loop = new Timeline(new KeyFrame(Duration.seconds(frameTime), event -> {
            if (living == true) {

                xySphere.setCenterX(xySphere.getX0());
                xySphere.setCenterY(xySphere.getY0());

                xzSphere.setCenterX(xzSphere.getX0());
                xzSphere.setCenterY(xzSphere.getZ0());

                yzSphere.setCenterX(yzSphere.getZ0());
                yzSphere.setCenterY(yzSphere.getY0());

                if (change == true) {
                    Time.curTime = System.currentTimeMillis();
                    change = false;
                }

                Time.updateTime();
                new Movement(xySphere, xySphere, xzSphere, yzSphere);
                new Movement(xzSphere, xySphere, xzSphere, yzSphere);
                new Movement(yzSphere, xySphere, xzSphere, yzSphere);

                double velocityValue = Movement.getVelocity(xySphere);
                veloLabel1.setText(String.valueOf( (int) velocityValue));




                // 01. FreierFall

                if (getSpherePosition(700, 800, 0, 100, 100, 200, xySphere)) {
                    imageFront01.setImage(imagesFront[0]);
                    imageSide01.setImage(imagesLeft[0]);
                    imageTop01.setImage(imagesTop[0]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso01.png"));

                }

                // 02. Fall-Kurve

                if (getSpherePosition(700, 800, 100, 200, 100, 200, xySphere)) {
                    imageFront01.setImage(new Image("BulletBillParkour Front/Mario01.png"));
                    imageSide01.setImage(new Image("BulletBillParkour Left/Mario01.png"));
                    imageTop01.setImage(new Image("BulletBillParkour Top/Mario01.png"));

                    imageFront02.setImage(imagesFront[1]);
                    imageSide02.setImage(imagesLeft[1]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso02.png"));
                }

                // 03. Kurve mit Steigung

                if (getSpherePosition(700, 800, 100, 200, 0, 100, xySphere)) {
                    imageFront02.setImage(new Image("BulletBillParkour Front/Mario02.png"));
                    imageSide02.setImage(new Image("BulletBillParkour Left/Mario02.png"));

                    imageTop02.setImage(imagesTop[1]);
                    imageSide03.setImage(imagesLeft[2]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso03.png"));

                }

                // 04. Kleiner Fall (weiße Fläche)

                if (getSpherePosition(600, 700, 100, 200, 0, 100, xySphere)) {
                    imageTop02.setImage(new Image("BulletBillParkour Top/Mario02.png"));
                    imageSide03.setImage(new Image("BulletBillParkour Left/Mario03.png"));

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso07.png"));
                }

                //05. Gerade Strecke nach kleiner Fall (Kollision noch nicht dabei)

                if (getSpherePosition(600, 700, 200, 300, 0, 100, xySphere)) {

                    imageFront03.setImage(imagesFront[2]);
                    imageTop03.setImage(imagesTop[2]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));

                }

                //06. Zweite gerade Strecke

                if (getSpherePosition(500, 600, 200, 300, 0, 100, xySphere)) {
                    imageSide04.setImage(new Image("BulletBillParkour Left/Mario04.png"));
                    imageFront03.setImage(new Image("BulletBillParkour Front/Mario04.png"));
                    imageTop03.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    imageFront04.setImage(imagesFront[2]);
                    imageSide04.setImage(imagesLeft[3]);
                    imageTop04.setImage(imagesTop[2]);

                }

                //07. Großer freier Fall

                if (getSpherePosition(400, 500, 200, 300, 0, 100, xySphere)) {
                    imageFront04.setImage(new Image("BulletBillParkour Front/Mario04.png"));
                    imageSide04.setImage(new Image("BulletBillParkour Left/Mario04.png"));
                    imageTop04.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso06.png"));
                }

                //08. Gerade Strecke nach großem Fall

                if (getSpherePosition(400, 500, 300, 400, 0, 100, xySphere)) {
                    imageFront05.setImage(imagesFront[3]);
                    imageTop05.setImage(imagesTop[2]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));
                }

                //09. Zweite Gerade Strecke nach dem großen Fall

                if (getSpherePosition(300, 400, 300, 400, 0, 100, xySphere)) {
                    imageFront05.setImage(new Image("BulletBillParkour Front/Mario05.png"));
                    imageTop05.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    imageFront06.setImage(imagesFront[3]);
                    imageTop06.setImage(imagesTop[2]);
                }

                //10. Links Kurve nach langer geraden Strecke

                if (getSpherePosition(200, 300, 300, 400, 0, 100, xySphere)) {
                    imageFront06.setImage(new Image("BulletBillParkour Front/Mario05.png"));
                    imageTop06.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    imageSide05.setImage(imagesLeft[4]);
                    imageTop07.setImage(imagesTop[3]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //11. Loch in gerader Strecke, Fall mit Kurve

                if (getSpherePosition(200, 300, 300, 400, 100, 200, xySphere)) {
                    imageSide05.setImage(new Image("BulletBillParkour Left/Mario06.png"));
                    imageTop07.setImage(new Image("BulletBillParkour Top/Mario041ff.png"));

                    imageSide06.setImage(imagesLeft[5]);
                    imageFront07.setImage(imagesFront[4]);
                    imageTop08.setImage(imagesTop[4]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso02.png"));
                }

                //12. Kleiner Fall in eine Kurve

                if (getSpherePosition(200, 300, 300, 400, 200, 300, xySphere)) {

                    imageSide06.setImage(new Image("BulletBillParkour Left/Mario08.png"));
                    imageFront07.setImage(new Image("BulletBillParkour Front/Mario09.png"));
                    imageTop08.setImage(new Image("BulletBillParkour Top/Mario05f.png"));

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso08.png"));
                }

                //13. rechts Kurve nach kleinem Fall

                if (getSpherePosition(200, 300, 400, 500, 200, 300, xySphere)) {
                    imageTop09.setImage(imagesTop[5]);
                    imageFront10.setImage(imagesFront[5]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //14. gerade Strecke nach rechts Kurve

                if (getSpherePosition(100, 200, 400, 500, 200, 300, xySphere)) {
                    imageTop09.setImage(new Image("BulletBillParkour Top/Mario06f.png"));
                    imageFront10.setImage(new Image("BulletBillParkour Front/Mario08.png"));

                    imageTop10.setImage(imagesTop[6]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));
                }

                //15. Links Kurve

                if (getSpherePosition(0, 100, 400, 500, 200, 300, xySphere)) {
                    imageTop10.setImage(new Image("BulletBillParkour Top/Mario03f.png"));

                    imageTop11.setImage(imagesTop[3]);
                    imageSide07.setImage(imagesLeft[6]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //16. Links Kurve nach links Kurve

                if (getSpherePosition(0, 100, 400, 500, 300, 400, xySphere)) {
                    imageTop11.setImage(new Image("BulletBillParkour Top/Mario041f.png"));
                    imageSide07.setImage(new Image("BulletBillParkour Left/Mario09.png"));

                    imageFront08.setImage(imagesFront[7]);
                    imageTop12.setImage(imagesTop[8]);
                    imageSide08.setImage(imagesLeft[7]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //17. gerades Ende

                if (getSpherePosition(100, 200, 400, 500, 300, 400, xySphere)) {
                    imageFront08.setImage(new Image("BulletBillParkour Front/Mario11.png"));
                    imageTop12.setImage(new Image("BulletBillParkour Top/Mario08ff.png"));
                    imageSide08.setImage(new Image("BulletBillParkour Left/Mario10.png"));

                    imageFront09.setImage(imagesFront[6]);
                    imageTop13.setImage(imagesTop[9]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));
                }

                if (getSpherePosition(200, 300, 400, 500, 300, 400, xySphere)) {

                    imageFront09.setImage(new Image("BulletBillParkour Front/Mario10.png"));
                    imageTop13.setImage(new Image("BulletBillParkour Top/Mario03fff.png"));

                    loop.stop();
                    timecounter.stop();
                }
            }

        }));
        loop.setCycleCount(Timeline.INDEFINITE);

    }

    public void quitGame() {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }

    public void playGame() {
        if (stopMaker == false) {
            Time.curTime = System.currentTimeMillis();
            loop.play();
            stopMaker = true;
            doTime();
        }

    }

    public void stopGame()  {
        if (stopMaker == true) {
            loop.pause();
            stopMaker = false;
            timecounter.stop();

        }
    }

    public void repeatGame() {
        Time.curTime = System.currentTimeMillis();

        xySphere.updatePos(750, 20, 150);
        xySphere.updateVelocity(0, 20,0);
        xySphere.updateAccel(0,0,0);

        xzSphere.updatePos(750, 20, 150);
        xzSphere.updateVelocity(0, 20,0);
        xzSphere.updateAccel(0,0,0);

        yzSphere.updatePos(750, 20, 150);
        yzSphere.updateVelocity(0, 20,0);
        yzSphere.updateAccel(0,0,0);

        seconds = 0;
        timeLabel.setText(String.valueOf(0));

    }

    private boolean getSpherePosition (double smallestX, double biggestX, double smallestY, double biggestY, double smallestZ, double biggestZ, Sphere sphere) {

        if (sphere.getX0() > smallestX && sphere.getX0() < biggestX && sphere.getY0() > smallestY && sphere.getY0() < biggestY && sphere.getZ0() > smallestZ && sphere.getZ0() < biggestZ) {
            return true;
        }
        return false;
    }

    public void enterPlay() {
        playbtnImage.setImage(new Image("BB Hervorhebung/playbtnByKlick.png"));
    }

    public void leavePlay() {
        playbtnImage.setImage(new Image("BB Hervorhebung/playbtn.png"));
    }

    public void enterPause() {
        pausebtnImage.setImage(new Image("BB Hervorhebung/breakbtnByKlick.png"));
    }

    public void leavePause() {
        pausebtnImage.setImage(new Image("BB Hervorhebung/breakbtn.png"));
    }

    public void enterRepeat() {
        repeatbtnImage.setImage(new Image("BB Hervorhebung/repeatbtnByKlick.png"));
    }

    public void leaveRepeat() {
        repeatbtnImage.setImage(new Image("BB Hervorhebung/repeatbtn.png"));
    }

    public void enterClose() {
        closebtnImage.setImage(new Image("BB Hervorhebung/closebtnByKlick.png"));
    }

    public void leaveClose() {
        closebtnImage.setImage(new Image("BB Hervorhebung/closebtn.png"));
    }


    public void loadCollision() {
        loadFXML("/fxml/Collision.fxml");

    }

    public void loadFXML(String fxml) {
        loop.pause();
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aPane.getChildren().add(pane);
    }

    private void doTime() {

        timecounter = new Timeline();
        timecounter.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                seconds++;
                timeLabel.setText(String.valueOf(seconds));

            }
        });
        timecounter.getKeyFrames().add(frame);
        timecounter.play();
    }
}

