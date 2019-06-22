package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.Mover.scene;

public class Main extends Application {

    Mover mover;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mover = new Mover();

        //Reibungskoeffizient
        double c = 2;

        PVector gravity = new PVector(0,0.0981*mover.mass,0);
        PVector friction = mover.velocity;
        friction.mult(-1);
        friction.normalize();
        friction.mult(c);

        primaryStage.setTitle("BulletBill");
        primaryStage.setScene(scene);
        primaryStage.show();

        //setborder muss hier einmal aufgerufen werden

        mover.applyForce(gravity);
        mover.applyForce(friction);
        mover.draw();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
