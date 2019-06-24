package Controller;

import Collision.Mover;
import Collision.PVector;
import Main.Images;
import Physics.Time;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CollisionController implements Initializable {

    @FXML
    private AnchorPane aPane;

    @FXML
    private Pane paneTL;

    @FXML
    private Button closebtn;

    @FXML
    private ImageView closebtnImage;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView isoPic;

    @FXML
    private Label veloLabel1;

    @FXML
    private Pane paneTR;

    @FXML
    private Pane paneBL;

    @FXML
    private Button playbtn;

    @FXML
    private ImageView playbtnImage;

    @FXML
    private Button breakbtn;

    @FXML
    private ImageView pausebtnImage;

    @FXML
    private Button repeatbtn;

    @FXML
    private ImageView repeatbtnImage;


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



    Timeline timecounter;
    Timeline timeline;
    public int seconds = 0;
    private boolean stopMaker = false;
    private boolean change = false;

    Mover mover;
    private double reibunskoeffizent = 2;

    Image[] imagesFront;
    Image[] imagesTop;
    Image[] imagesLeft;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mover = new Mover();

        PVector gravity = new PVector(0, 0.981 * mover.mass, 0);
        PVector friction = mover.velocity;
        friction.mult(-1);
        friction.normalize();
        friction.mult(reibunskoeffizent);

        mover.applyForce(gravity);
        mover.applyForce(friction);

        imagesFront = Images.getFrontImages();
        imagesTop = Images.getTopImage();
        imagesLeft = Images.getLeftImage();

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                if (mover.isSpherePosition01() == true) {
                    imageFront01.setImage(imagesFront[0]);
                    imageSide01.setImage(imagesLeft[0]);
                    imageTop01.setImage(imagesTop[0]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso01.png"));

                }

                // 02. Fall-Kurve

                if (mover.isSpherePosition02() == true) {

                    Images.fallCurve(imageFront01, imageSide01, imageTop01,imageFront02, imageSide02, isoPic, imagesFront[1], imagesLeft[1]);
                }

                // 03. Kurve mit Steigung

                if (mover.isSpherePosition03() == true) {
                    imageFront02.setImage(new Image("BulletBillParkour Front/Mario02.png"));
                    imageSide02.setImage(new Image("BulletBillParkour Left/Mario02.png"));

                    imageTop02.setImage(imagesTop[1]);
                    imageSide03.setImage(imagesLeft[2]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso03.png"));

                }

                // 04. Kleiner Fall (weiße Fläche)

                if (mover.isSpherePosition04() == true) {
                    imageTop02.setImage(new Image("BulletBillParkour Top/Mario02.png"));
                    imageSide03.setImage(new Image("BulletBillParkour Left/Mario03.png"));

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso07.png"));
                }

                //05. Gerade Strecke nach kleiner Fall (Kollision noch nicht dabei)

                if (mover.isSpherePosition05() == true) {

                    imageFront03.setImage(imagesFront[2]);
                    imageTop03.setImage(imagesTop[2]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));

                }

                //06. Zweite gerade Strecke

                if (mover.isSpherePosition06() == true) {

                    Images.geradeStrecke(imageSide04, imageFront03, imageTop03, imageFront04, imageSide04, imageTop04, imagesFront[2],imagesLeft[3], imagesTop[2]);

                }

                //07. Großer freier Fall

                if (mover.isSpherePosition07() == true) {
                    imageFront04.setImage(new Image("BulletBillParkour Front/Mario04.png"));
                    imageSide04.setImage(new Image("BulletBillParkour Left/Mario04.png"));
                    imageTop04.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso06.png"));
                }

                //08. Gerade Strecke nach großem Fall

                if (mover.isSpherePosition08() == true) {
                    imageFront05.setImage(imagesFront[3]);
                    imageTop05.setImage(imagesTop[2]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));
                }

                //09. Zweite Gerade Strecke nach dem großen Fall

                if (mover.isSpherePosition09() == true) {
                    imageFront05.setImage(new Image("BulletBillParkour Front/Mario05.png"));
                    imageTop05.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    imageFront06.setImage(imagesFront[3]);
                    imageTop06.setImage(imagesTop[2]);
                }

                //10. Links Kurve nach langer geraden Strecke

                if (mover.isSpherePosition10() == true) {
                    imageFront06.setImage(new Image("BulletBillParkour Front/Mario05.png"));
                    imageTop06.setImage(new Image("BulletBillParkour Top/Mario03ff.png"));

                    imageSide05.setImage(imagesLeft[4]);
                    imageTop07.setImage(imagesTop[3]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //11. Loch in gerader Strecke, Fall mit Kurve

                if (mover.isSpherePosition11() == true) {

                    Images.lochGeradeStrecke(imageSide05, imageTop07, imageSide06, imageFront07, imageTop08, isoPic, imagesLeft[5], imagesFront[4], imagesTop[4]);
                }

                //12. Kleiner Fall in eine Kurve

                if (mover.isSpherePosition12() == true) {

                    imageSide06.setImage(new Image("BulletBillParkour Left/Mario08.png"));
                    imageFront07.setImage(new Image("BulletBillParkour Front/Mario09.png"));
                    imageTop08.setImage(new Image("BulletBillParkour Top/Mario05f.png"));

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso08.png"));
                }

                //13. rechts Kurve nach kleinem Fall

                if (mover.isSpherePosition13() == true) {
                    imageTop09.setImage(imagesTop[5]);
                    imageFront10.setImage(imagesFront[5]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //14. gerade Strecke nach rechts Kurve

                if (mover.isSpherePosition14() == true) {
                    imageTop09.setImage(new Image("BulletBillParkour Top/Mario06f.png"));
                    imageFront10.setImage(new Image("BulletBillParkour Front/Mario08.png"));

                    imageTop10.setImage(imagesTop[6]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso04.png"));
                }

                //15. Links Kurve

                if (mover.isSpherePosition15() == true) {
                    imageTop10.setImage(new Image("BulletBillParkour Top/Mario03f.png"));

                    imageTop11.setImage(imagesTop[3]);
                    imageSide07.setImage(imagesLeft[6]);

                    isoPic.setImage(new Image("BB Front Hervorhebung/Iso05.png"));
                }

                //16. Links Kurve nach links Kurve

                if (mover.isSpherePosition16() == true) {
                    Images.leftCurveAfterleftCurve(imageTop11, imageSide07, imageFront08, imageTop12, imageSide08, isoPic, imagesFront[7], imagesTop[8], imagesLeft[7] );
                }

                //17. gerades Ende

                if (mover.isSpherePosition17() == true) {

                    Images.geradeEnde(imageFront08, imageTop12, imageSide08, imageFront09, imageTop13, isoPic, imagesFront[6], imagesTop[9]);
                }

                if (mover.isSpherePosition18() == true) {

                    imageFront09.setImage(new Image("BulletBillParkour Front/Mario10.png"));
                    imageTop13.setImage(new Image("BulletBillParkour Top/Mario03fff.png"));


                    timecounter.stop();
                }
            }
        }));


    }

    public void playGame() {
        if (stopMaker == false) {

            if (change == false) {
                mover.draw(paneTL, paneBL, paneTR, veloLabel1);
                change = true;
            }
            mover.playAnimation();
            timeline.play();
            stopMaker = true;
            doTime();
        }
    }

    public void repeatGame() {
        mover.repeatAnimation(paneTL, paneBL, paneTR);
        timeline.playFromStart();
        seconds = 0;
        timeLabel.setText(String.valueOf(0));
    }

    public void stopGame() {
        if (stopMaker == true) {
            mover.stopAnimation();
            stopMaker = false;
            timeline.pause();
            timecounter.stop();

        }

    }

    public void quitGame() {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
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
        loadFXML("/fxml/Simulation.fxml");

    }

    public void loadFXML(String fxml) {
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
                    int eins = 0;
                    seconds++;
                    timeLabel.setText(String.valueOf(seconds));
                }
            });
            timecounter.getKeyFrames().add(frame);
            timecounter.play();
    }

}
