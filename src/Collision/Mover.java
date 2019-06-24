package Collision;

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

    Timeline timeline;
    public boolean change = false;

    public PVector location;
    public PVector velocity;
    public PVector acceleration;

    public PVector tmp;

    Object[][] ablauf;

    int i = 0;
    int j = 0;

    FreierFall[] freierFall = FreierFall.createElement();
    Curve[] curves = Curve.createElement1();
    Curve[] curveKomplex = Curve.createElement2();
    Gerade[] gerade1 = Gerade.createElement1();
    Gerade[] gerade2 = Gerade.createElement2();
    Curve[] curveDown = Curve.createElement3();
    Gerade[] geradeDown = Gerade.createElement3();
    Curve[] curveLeft = Curve.createElement4();
    Gerade[] geradeLeft = Gerade.createElement4();
    Curve[] curveLeft2 = Curve.createElement5();
    Curve[] curveRight = Curve.createElement6();
    Gerade[] geradeRight = Gerade.createElement5();


    Sphere ballFrontView;
    Sphere ballTopView;
    Sphere ballLeftView;

    double radius = 15;
    public double mass;

    double maxWidth = freierFall[0].getMaxX();
    double maxHeight = freierFall[0].getMaxY();
    double maxDepth = freierFall[0].getMaxZ();
    double minWidth = freierFall[0].getMinX();
    double minHeight = freierFall[0].getMinY();
    double minDepth = freierFall[0].getMinZ();

    Bahn currentElement;
/*
    public void setBorder(){
        maxWidth = currentElement.getMaxX();
        maxHeight = currentElement.getMaxY();
        maxDepth = currentElement.getMaxZ();
        minWidth = currentElement.getMinX();
        minHeight = currentElement.getMinY();
        minDepth = currentElement.getMinZ();

        Rectangle rect = new Rectangle(minWidth, minHeight, maxWidth - minWidth, maxHeight - minHeight);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.BLACK);
        container.getChildren().add(rect);

        //System.out.println("Bounds: Bahn = (" + maxWidth + "; " + maxHeight + "; " + maxDepth + ")");
    }*/

    public void drawBahnElementsFrontView(Pane container){
        for (int i = 0; i <= ablauf.length -1; i++){
            for (int j = 0; j <= ablauf[i].length -1; j++){
                Bahn drawElement = (Bahn) ablauf[i][j];

                Rectangle rect = new Rectangle(drawElement.getMinX(), drawElement.getMinY(), drawElement.getMaxX() - drawElement.getMinX(), drawElement.getMaxY() - drawElement.getMinY());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);
                container.getChildren().add(rect);
            }
        }
    }

    public void drawBahnElementsTopView(Pane container){
        for (int i = 0; i <= ablauf.length -1; i++){
            for (int j = 0; j <= ablauf[i].length -1; j++){
                Bahn drawElement = (Bahn) ablauf[i][j];


                Rectangle rect = new Rectangle(drawElement.getMinX(), drawElement.getMinZ(), drawElement.getMaxX() - drawElement.getMinX(), drawElement.getMaxZ() - drawElement.getMinZ());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);
                container.getChildren().add(rect);
            }
        }
    }

    public void drawBahnElementsSideView(Pane container){
        for (int i = 0; i <= ablauf.length -1; i++){
            for (int j = 0; j <= ablauf[i].length -1; j++){
                Bahn drawElement = (Bahn) ablauf[i][j];


                Rectangle rect = new Rectangle(drawElement.getMinZ(), drawElement.getMinY(), drawElement.getMaxZ() - drawElement.getMinZ(), drawElement.getMaxY() - drawElement.getMinY());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);
                container.getChildren().add(rect);
            }
        }
    }

    public Object[] createAblauf(){

        ablauf = new Object[12][];
        ablauf[0] = freierFall;
        ablauf[1] = curves;
        ablauf[2] = curveKomplex;
        ablauf[3] = gerade1;
        ablauf[4] = gerade2;
        ablauf[5] = curveDown;
        ablauf[6] = geradeDown;
        ablauf[7] = curveLeft;
        ablauf[8] = geradeLeft;
        ablauf[9] = curveLeft2;
        ablauf[10] = curveRight;
        ablauf[11] = geradeRight;
        return ablauf;
    }

    public void startwithElement(Pane frontView, Pane topView, Pane sideView){

        createAblauf();
        drawBahnElementsFrontView(frontView);
        drawBahnElementsTopView(topView);
        drawBahnElementsSideView(sideView);
        //System.out.println(ablauf[0][0]);
        //System.out.println("IndexI: " + i + " indexJ: " + j);
        currentElement = (Bahn) ablauf[i][j];
        i++;
    }

    public void changeElement(){

        //System.out.println("Bounds: Bahn = (" + maxWidth + "; " + maxHeight + "; " + maxDepth + ")");

        if(i < ablauf.length){

            if(j == ablauf[i].length - 1 ) { //evtl while schleife besser?

                currentElement = (Bahn) ablauf[i][j];
                //System.out.println("IndexI: " + i + " indexJ: " + j);
                i++;
                j = 0;
                //setBorder();
                //checkEdges();

            } else{
                currentElement = (Bahn) ablauf[i][j];
                //System.out.println("IndexI: " + i + " indexJ: " + j);
                j++;
                //setBorder();
                //checkEdges();
                //System.out.println("Bahn wurde durchlaufen");
            }
        }

        maxWidth = currentElement.getMaxX();
        maxHeight = currentElement.getMaxY();
        maxDepth = currentElement.getMaxZ();
        minWidth = currentElement.getMinX();
        minHeight = currentElement.getMinY();
        minDepth = currentElement.getMinZ();

    }

    public Mover(){
        //location = new PVector(maxWidth - radius, maxHeight, maxDepth);
        location = new PVector(maxWidth - radius, minHeight + radius, maxDepth);
        velocity = new PVector(0,0, 0);
        acceleration = new PVector(-0.001,0.01, -0.001);
        mass = 80.0;
    }

    public void applyForce(PVector force){
        PVector f = force;
        f.div(mass);
        acceleration.add(f);
    }

    public void draw(Pane frontView, Pane topView, Pane sideView){

        startwithElement(frontView, topView, sideView);

        ballFrontView = new Sphere(radius);
        ballFrontView.relocate(location.x, location.y);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLACK);

        ballTopView = new Sphere(radius);
        ballTopView.relocate(location.x, location.z);

        ballLeftView = new Sphere(radius);
        ballLeftView.relocate(location.z, location.y);

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                velocity.add(acceleration);
                location.add(velocity);
                acceleration.mult(1);

                ballFrontView.setLayoutX(location.x);
                ballFrontView.setLayoutY(location.y);

                ballTopView.setLayoutX(location.x);
                ballTopView.setLayoutY(location.z);

                ballLeftView.setLayoutX(location.z);
                ballLeftView.setLayoutY(location.y);

                /*System.out.println("Location: (" + location.x + "; " + location.y  + "; " + location.z + ")");
                System.out.println("Velocity: (" + velocity.x + "; " + velocity.y + "; " + velocity.z + ")");
                System.out.println("Acceleration: (" + acceleration.x + "; " + acceleration.y + "; " + acceleration.y + ")");*/
                //System.out.println(currentElement);

                checkEdges();
            }
        }));



        frontView.getChildren().addAll(ballFrontView);
        topView.getChildren().addAll(ballTopView);
        sideView.getChildren().addAll(ballLeftView);

    }

    public void playAnimation() {
        timeline.play();

    }

    public void stopAnimation() {
        timeline.pause();
    }

    public void repeatAnimation(Pane frontView, Pane topView, Pane sideView){

        i = 0;
        j = 0;
        startwithElement(frontView, topView, sideView);

        maxWidth = currentElement.getMaxX();
        maxHeight = currentElement.getMaxY();
        maxDepth = currentElement.getMaxZ();
        minWidth = currentElement.getMinX();
        minHeight = currentElement.getMinY();
        minDepth = currentElement.getMinZ();

        location = new PVector(maxWidth - radius, minHeight + radius, maxDepth);
        velocity = new PVector(0,0, 0);
        acceleration = new PVector(-0.001,0.01, -0.001);
        mass = 80.0;

        timeline.play();

    }


    public void checkEdges(){

        int xNeg = currentElement.getXNeg();
        int xPos = currentElement.getXPos();
        int yNeg = currentElement.getYNeg();
        int yPos = currentElement.getYPos();
        int zNeg = currentElement.getZNeg();
        int zPos = currentElement.getZPos();

        //System.out.println("xball: " +location.x + " > max: " + (maxWidth - radius) + "xball: " + location.x + " < min: " + (minWidth + radius));

        if(location.x > (maxWidth - radius)){

            if(xPos == 1){
                //hier xPos vom Element gleich 2 setzen.
                changeElement();
                //setBorder();
            }else if (xPos == 0){
                velocity.x *= -1;
                location.x = maxWidth;
                //System.out.println("x1-collision");
            } else if (xPos == 2){
                //hier xPos vom Element gleich 1 setzen.
                //und changeElement 1 zurück. Vielleicht mit neuer Methode.
            }

        } else if(location.x < minWidth + radius){

            if(xNeg == 1){
                changeElement();
                //setBorder();
            }else if (xNeg == 0){
                velocity.x *= -1;
                //System.out.println("x2-collision");
                location.x = minWidth + radius;
            }
        }

        if(location.y > (maxHeight - radius)){

            if(yPos == 1){
                changeElement();
                //setBorder();
            }else if (yPos == 0){
                velocity.y *= -0.2;
                location.y = maxHeight - radius;
                //System.out.println("y1-collision");
            }

        } else if(location.y < minHeight + radius){

            if(yNeg == 1){
                changeElement();
                //setBorder();
            }else if(yNeg == 0){
                velocity.y *= -1;
                location.y = minHeight + radius;
                //System.out.println("y2-collision");
            }
        }


        if(location.z > (maxDepth - radius)){

            if(zPos == 1){
                changeElement();
                //setBorder();
            }else if(zPos == 0){
                velocity.z *= -1;
                location.z = maxDepth - radius;
            }

        } else if(location.z < minDepth + radius){

            if(zNeg == 1){
                changeElement();
                //setBorder();
            }else if(zNeg == 0){
                velocity.z *= -1;
                location.z = minDepth + radius;
            }

        } else {
            //System.out.println("kein ChangeElement");
        }

    }


}
