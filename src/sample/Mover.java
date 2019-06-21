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

    FreierFall freierFall = FreierFall.createElement();

    CurveLeft[] curveLefts = CurveLeft.createElement();

    Bahn element1 = new Bahn(curveLefts[i].getMinX(), curveLefts[i].getMaxX(), curveLefts[i].getMinY(), curveLefts[i].getMaxY(), curveLefts[i].getMinZ(), curveLefts[i].getMaxZ());

    public static Pane container = new Pane();
    public static Scene scene = new Scene(container, 1000,800);
    Sphere ball;

    double radius = 16;
    double mass;

    double width;
    double height;
    double depth;

    public void setBorder(){
        width = curveLefts[i].getMaxX();
        height = curveLefts[i].getMaxY();
        depth = curveLefts[i].getMaxZ();
        System.out.println(curveLefts[0].getMaxX() + "; " + curveLefts[0].getMaxY() + "; "  + curveLefts[0].getMaxZ());
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

                checkEdges();

            }
        }));
        timeline.play();

        freierFall.getChildren().add(ball);
        element1.getChildren().add(freierFall);
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
