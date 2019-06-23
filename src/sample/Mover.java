package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Mover {
    PVector location;
    PVector velocity;
    PVector acceleration;

   //Object[] ablauf;
    Object[][] ablauf;

    int i = 0;
    int j = 0;

    FreierFall[] freierFall = FreierFall.createElement();
    Curve[] curves = Curve.createElement1();
    Curve[] curveKomplex = Curve.createElement2();
    Gerade[] gerade1 = Gerade.createElement1();
    Curve[] curveDown = Curve.createElement3();
    Gerade[] geradeDown = Gerade.createElement3();
    Curve[] curveLeft = Curve.createElement4();
    Gerade[] geradeLeft = Gerade.createElement4();
    Curve[] curveLeft2 = Curve.createElement5();
    Curve[] curveRight = Curve.createElement6();
    Gerade[] geradeRight = Gerade.createElement5();

    public static Pane container = new Pane();
    public static Scene scene = new Scene(container, 1000,800);
    Sphere ball;

    double radius = 15;
    double mass;

    double maxWidth = freierFall[0].getMaxX();
    double maxHeight = freierFall[0].getMaxY();
    double maxDepth = freierFall[0].getMaxZ();
    double minWidth = freierFall[0].getMinX();
    double minHeight = freierFall[0].getMinY();
    double minDepth = freierFall[0].getMinZ();

    Bahn currentElement;

    public void setBorder(){
        maxWidth = currentElement.getMaxX();
        maxHeight = currentElement.getMaxY();
        maxDepth = currentElement.getMaxZ();
        minWidth = currentElement.getMinX();
        minHeight = currentElement.getMinY();
        minDepth = currentElement.getMinZ();

        /*Rectangle rect = new Rectangle(minWidth, minHeight, maxWidth - minWidth, maxHeight - minHeight);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.BLACK);
        container.getChildren().add(rect);*/

        System.out.println("Bounds: Bahn = (" + maxWidth + "; " + maxHeight + "; " + maxDepth + ")");
    }

    public void drawBahnElements(){
        for (int ii = 0; ii <= ablauf.length -1; ii++){
            for (int jj = 0; jj <= ablauf[ii].length -1; jj++){
                Bahn drawElement = (Bahn) ablauf[ii][jj];

                System.out.println("test2");

                Rectangle rect = new Rectangle(drawElement.getMinX(), drawElement.getMinY(), drawElement.getMaxX() - drawElement.getMinX(), drawElement.getMaxY() - drawElement.getMinY());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);
                container.getChildren().add(rect);
            }
        }
    }

    public Object[] createAblauf(){

        ablauf = new Object[11][];
        ablauf[0] = freierFall;
        ablauf[1] = curves;
        ablauf[2] = curveKomplex;
        ablauf[3] = gerade1;
        ablauf[4] = curveDown;
        ablauf[5] = geradeDown;
        ablauf[6] = curveLeft;
        ablauf[7] = geradeLeft;
        ablauf[8] = curveLeft2;
        ablauf[9] = curveRight;
        ablauf[10] = geradeRight;
        return ablauf;
    }

    public void startwithElement(){

        createAblauf();
        drawBahnElements();
        //System.out.println(ablauf[0][0]);
        currentElement = (Bahn) ablauf[0][0];
        i++;
    }

    public void changeElement(){
        //createAblauf();

        if(j == ablauf[i].length - 1 ) {

            currentElement = (Bahn) ablauf[i][j];
            System.out.println("Index: " + j);
            i++;
            j = 0;

        } else{
            currentElement = (Bahn) ablauf[i][j];
            j++;
            //System.out.println("Bahn wurde durchlaufen");
        }

    }

    public Mover(){
        //location = new PVector(maxWidth - radius, maxHeight, maxDepth);
        location = new PVector(maxWidth - radius, minHeight + radius, maxDepth);
        velocity = new PVector(0,0, 0);
        acceleration = new PVector(-0.001,0.01, -0.0001);
        mass = 80.0;
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

                /*System.out.println("Location: (" + location.x + "; " + location.y  + "; " + location.z + ")");
                System.out.println("Velocity: (" + velocity.x + "; " + velocity.y + "; " + velocity.z + ")");
                System.out.println("Acceleration: (" + acceleration.x + "; " + acceleration.y + "; " + acceleration.y + ")");*/

                checkEdges();
            }
        }));
        timeline.play();

        //freierFall.getChildren().add(ball);
        //element1.getChildren().add(freierFall);
        container.getChildren().addAll(ball);
    }

    public void checkEdges(){

        boolean xNeg = currentElement.getXNeg();
        boolean xPos = currentElement.getXPos();
        boolean yNeg = currentElement.getYNeg();
        boolean yPos = currentElement.getYPos();
        boolean zNeg = currentElement.getZNeg();
        boolean zPos = currentElement.getZPos();

        if(location.x > (maxWidth - radius)){

            if(xPos == true){
                changeElement();
                setBorder();
            }else{
                velocity.x *= -1;
                location.x = maxWidth;
                System.out.println("x1-collision");
            }

        } else if(location.x < minWidth + radius){

            if(xNeg == true){
                changeElement();
                setBorder();
            }else{
                velocity.x *= -1;
                System.out.println("x2-collision");
                location.x = minWidth + radius;
            }
        }

        if(location.y > (maxHeight - radius)){

            if(yPos == true){
                changeElement();
                setBorder();
            }else{
                velocity.y *= -0.2;
                location.y = maxHeight - radius;
                System.out.println("y1-collision");
            }

        } else if(location.y < minHeight + radius){

            if(yNeg == true){
                changeElement();
                setBorder();
            }else{
                velocity.y *= -1;
                location.y = minHeight + radius;
                System.out.println("y2-collision");
            }
        }


        if(location.z > (maxDepth - radius)){

            if(zPos == true){
                changeElement();
                setBorder();
            }else{
                velocity.z *= -1;
                location.z = maxDepth - radius;
            }

        } else if(location.z < minDepth + radius){

            if(zNeg == true){
                changeElement();
                setBorder();
            }else{
                velocity.z *= -1;
                location.z = minDepth + radius;
            }

        }

    }


}
