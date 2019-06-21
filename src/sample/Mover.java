package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
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

    double maxWidth = freierFall.getMaxX();
    double maxHeight = freierFall.getMaxY();
    double maxDepth = freierFall.getMaxZ();
    double minWidth = freierFall.getMinX();
    double minHeight = freierFall.getMinY();
    double minDepth = freierFall.getMinZ();

    Bahn currentElement;

    public void setBorder(){
        maxWidth = currentElement.getMaxX();
        maxHeight = currentElement.getMaxY();
        maxDepth = currentElement.getMaxZ();
        minWidth = currentElement.getMinX();
        minHeight = currentElement.getMinY();
        minDepth = currentElement.getMinZ();
        System.out.println("Bounds: Bahn = (" + maxWidth + "; " + maxHeight + "; " + maxDepth + ")");
        System.out.println("Index: " + i);
    }

    public Object[] createAblauf(){
        ablauf = new Object[2];
        ablauf[0] = freierFall;
        ablauf[1] = curveLefts;
        return ablauf;
    }

    public void startwithElement(){
        createAblauf();
        currentElement = (Bahn) ablauf[0];
        j++;
    }

    public void changeElement(){
        //createAblauf();
        currentElement = (Bahn) ablauf[j];
        j++;
    }

    public Mover(){
        location = new PVector(maxWidth - radius, maxHeight /2 , maxDepth);
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

        startwithElement();

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
        container.getChildren().addAll(freierFall, currentElement, ball);
    }

    public void checkEdges(){

        /*if(location.x > (maxWidth - radius)){
            velocity.x *= -1;
            location.x = maxWidth;

        } else if(location.x < minWidth + radius){
            velocity.x *= -1;
            location.x = radius;
        }

        if(location.y > maxHeight) {
            setBorder();
            //location.y = freierFall[i].getMinY();
            if (i < curveLefts.length -1) {
                i++;
            } else {
                velocity.y *= -1;
                location.y = maxHeight - radius;
            }
        }

        if(location.z > (maxDepth - radius)){
            velocity.z *= -1;
            location.z = maxDepth;
        } else if (location.z < minHeight + radius){
            velocity.z *= -1;
            location.z = radius;
        }*/

        boolean xNeg = currentElement.getXNeg();
        boolean xPos = currentElement.getXPos();
        boolean yNeg = currentElement.getYNeg();
        boolean yPos = currentElement.getYPos();
        boolean zNeg = currentElement.getZNeg();
        boolean zPos = currentElement.getZPos();

        if(location.x > (maxWidth - radius)){

            if(xPos == true){
                setBorder();
                i ++;
            }else{
                velocity.x *= -1;
                location.x = maxWidth;
            }

        } else if(location.x < minWidth + radius){

            if(xNeg == true){
                setBorder();
                i ++;
            }else{
                velocity.x *= -1;
                location.x = radius;
            }

        }


        if(location.y > (maxHeight - radius)){

            if(yPos == true){
                setBorder();
                i ++;
            }else{
                velocity.y *= -1;
                location.y = maxHeight;
            }

        } else if(location.y < minHeight + radius){

            if(yNeg == true){
                setBorder();
                i ++;
            }else{
                velocity.y *= -1;
                location.y = maxHeight - radius;
            }

        }


        if(location.z > (maxDepth - radius)){

            if(zPos == true){
                setBorder();
                i ++;
            }else{
                velocity.z *= -1;
                location.z = maxDepth;
            }

        } else if(location.z < minDepth + radius){

            if(zNeg == true){
                setBorder();
                i ++;
            }else{
                velocity.z *= -1;
                location.z = maxDepth - radius;
            }

        }

    }


}
