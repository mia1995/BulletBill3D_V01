package Controller;

import Collision.Mover;
import Collision.PVector;
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

    @FXML
    private Button guiMode;

    Timeline timecounter;
    public int seconds = 0;
    private boolean stopMaker = false;
    private boolean change = false;

    Mover mover;
    private double reibunskoeffizent = 2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mover = new Mover();

        PVector gravity = new PVector(0,0.01*mover.mass,0);
        PVector friction = mover.velocity;
        friction.mult(-1);
        friction.normalize();
        friction.mult(reibunskoeffizent);

        mover.applyForce(gravity);
        mover.applyForce(friction);
    }

    public void playGame() {
        if (stopMaker == false) {

            if (change == false) {
                mover.draw(paneTL, paneBL, paneTR);
                change = true;
            }
            mover.playAnimation();
            stopMaker = true;
            doTime();
        }
    }

    public void repeatGame() {
        mover.repeatAnimation(paneTL, paneBL, paneTR);

        seconds = 0;
        timeLabel.setText(String.valueOf(0));
    }

    public void stopGame() {
        if (stopMaker == true) {
            mover.stopAnimation();
            stopMaker = false;

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
                    seconds++;
                    timeLabel.setText(String.valueOf(seconds));

                }
            });
            timecounter.getKeyFrames().add(frame);
            timecounter.play();
        }
}
