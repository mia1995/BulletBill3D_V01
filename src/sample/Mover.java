package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Mover {
    PVector location;
    PVector velocity;
    PVector acceleration;

    int i = 0 ;

    FreierFall[] freierFall = FreierFall.createElement();


    //Bahn[] freierFall  = Bahn.createElement();
    //Bahn[] freierFall = bahn.getFreierFall();
    Bahn element1 = new Bahn(freierFall[i].getMinX(), freierFall[i].getMaxX(), freierFall[i].getMinY(), freierFall[i].getMaxY(), freierFall[i].getMinZ(), freierFall[i].getMaxZ());

    public static Pane container = new Pane();
    public static Scene scene = new Scene(container, 1000,800);
    Sphere ball;

    double radius = 16;
    double mass;

    double width; // = freierFall[i].getMaxX();
    double height; // = freierFall[i].getMaxY();
    double depth; // = freierFall[i].getMaxZ();


    public void setBorder(){
        width = freierFall[i].getMaxX();
        height = freierFall[i].getMaxY();
        depth = freierFall[i].getMaxZ();
        System.out.println(freierFall[0].getMaxX() + "; " + freierFall[0].getMaxY() + "; "  + freierFall[0].getMaxZ());
        System.out.println("Bounds: Bahn = (" + width + "; " + height + "; " + depth + ")");
        System.out.println("Index: " + i);
    }

    public Mover(){
        location = new PVector(width - radius,height/2 , depth );
        velocity = new PVector(0,0, 0);
        acceleration = new PVector(0.001,0.01, 0);
        mass = 10.0;
    }

    public void applyForce(PVector force){
        PVector f = force;
        f.div(mass);
        acceleration.add(f);
    }

    public void draw(){
        ball = new Sphere(radius);
        ball.relocate(location.x, location.y);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLACK);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                velocity.add(acceleration);
                location.add(velocity);
                acceleration.mult(1);

                ball.setLayoutX(location.x);
                ball.setLayoutY(location.y);

                System.out.println("Location: (" + location.x + "; " + location.y  + "; " + location.z + ")");
                System.out.println("Velocity: (" + velocity.x + "; " + velocity.y + "; " + velocity.z + ")");
                System.out.println("Acceleration: (" + acceleration.x + "; " + acceleration.y + "; " + acceleration.y + ")");
                // System.out.println("Bounds: Bahn = (" + width + "; " + height + "; " + depth + ")")
                // System.out.println("Index: " + i);

                checkEdges();

            }
        }));
        timeline.play();

        element1.getChildren().add(ball);
        container.getChildren().addAll(element1);
    }

    public void checkEdges(){

        if(location.x > (width - radius)){
            velocity.x *= -1;
            location.x = width;

        } else if(location.x < radius){
            velocity.x *= -1;
            location.x = radius;
        }

        if(location.y > height ) {
            setBorder();
            //location.y = freierFall[i].getMinY();
            if (i < freierFall.length -1) {
                i++;
            } else {
                velocity.y *= -1;
                location.y = height - radius;
            }
        }

        if(location.z > (depth - radius)){
            velocity.z *= -1;
            location.z = depth;
        } else if (location.z < radius){
            velocity.z *= -1;
            location.z = radius;
        }
    }


}
