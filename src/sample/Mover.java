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

   Object[] ablauf;

    int i = 0 ;
    int j = 0;

    FreierFall freierFall = FreierFall.createElement();
    CurveLeft[] curveLefts = CurveLeft.createElement();

    public static Pane container = new Pane();
    public static Scene scene = new Scene(container, 1000,800);
    Sphere ball;

    double radius = 16;
    double mass;

    double width = freierFall.getMaxX();
    double height = freierFall.getMaxY();
    double depth = freierFall.getMaxZ();
    Bahn[] currentElement;

    public void setBorder(){
        width = currentElement[i].getMaxX();
        height = currentElement[i].getMaxY();
        depth = currentElement[i].getMaxZ();
        System.out.println("Bounds: Bahn = (" + width + "; " + height + "; " + depth + ")");
        System.out.println("Index: " + i);
    }

    public Object[] createAblauf(){
        ablauf = new Bahn[7];
        ablauf[0] = freierFall;
        ablauf[1] = curveLefts;
        return ablauf;
    }

    public void changeElement(){
        createAblauf();
        currentElement = ablauf[j];
        j++;
    }

    public Mover(){
        location = new PVector(width - radius,height/2 , depth );
        velocity = new PVector(0,0, 0);
        acceleration = new PVector(-0.001,0.01, 0);
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

                checkEdges();
            }
        }));
        timeline.play();

        //freierFall.getChildren().add(ball);
        //element1.getChildren().add(freierFall);
        container.getChildren().addAll(freierFall, ball);
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
            if (i < curveLefts.length -1) {
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
