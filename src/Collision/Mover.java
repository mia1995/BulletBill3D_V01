package Collision;

import Controller.CollisionController;
import Main.Images;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Mover {

    Timeline timeline;

    public PVector location;
    public PVector velocity;
    public PVector acceleration;
    public PVector veloOutput;

    public double velo;

    int[][] linePosition = {{1,1}, {2,1}, {2,2}, {2,1}, {2,2}, {5,1}, {6,2}, {7,1}, {9,1}, {10,1}};

    Object[][] ablauf;

    Line line1;

    int i = 0;
    int j = 0;

    int k = 0;

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

    Line[] lines = Border.createLines();


    Sphere ballFrontView;
    Sphere ballTopView;
    Sphere ballLeftView;

    //Line line1 = new Line(760,185,30,770,120,70);
    //javafx.scene.shape.Line line;

    double radius = 15;
    public double mass;

    double maxWidth = freierFall[0].getMaxX();
    double maxHeight = freierFall[0].getMaxY();
    double maxDepth = freierFall[0].getMaxZ();
    double minWidth = freierFall[0].getMinX();
    double minHeight = freierFall[0].getMinY();
    double minDepth = freierFall[0].getMinZ();

    boolean spherePosition01;
    boolean spherePosition02;
    boolean spherePosition03;
    boolean spherePosition04;
    boolean spherePosition05;
    boolean spherePosition06;
    boolean spherePosition07;
    boolean spherePosition08;
    boolean spherePosition09;
    boolean spherePosition10;
    boolean spherePosition11;
    boolean spherePosition12;
    boolean spherePosition13;
    boolean spherePosition14;
    boolean spherePosition15;
    boolean spherePosition16;
    boolean spherePosition17;
    boolean spherePosition18;


    Bahn currentElement;

    public Mover(){
        location = new PVector(maxWidth - radius, minHeight + radius, maxDepth);
        velocity = new PVector(0,0, 0);
        acceleration = new PVector(0,0.01, 0);
        mass = 20.0;
    }


    public void drawBahnElementsFrontView(Pane container) {
        for (int i = 0; i <= ablauf.length - 1; i++) {
            for (int j = 0; j <= ablauf[i].length - 1; j++) {
                Bahn drawElement = (Bahn) ablauf[i][j];

                Rectangle rect = new Rectangle(drawElement.getMinX(), drawElement.getMinY(), drawElement.getMaxX() - drawElement.getMinX(), drawElement.getMaxY() - drawElement.getMinY());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);


                container.getChildren().add(rect);
            }
        }
    }

    public void drawBahnElementsTopView(Pane container) {
        for (int i = 0; i <= ablauf.length - 1; i++) {
            for (int j = 0; j <= ablauf[i].length - 1; j++) {
                Bahn drawElement = (Bahn) ablauf[i][j];


                Rectangle rect = new Rectangle(drawElement.getMinX(), drawElement.getMinZ(), drawElement.getMaxX() - drawElement.getMinX(), drawElement.getMaxZ() - drawElement.getMinZ());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);
                container.getChildren().add(rect);
            }
        }
    }

    public void drawBahnElementsSideView(Pane container) {
        for (int i = 0; i <= ablauf.length - 1; i++) {
            for (int j = 0; j <= ablauf[i].length - 1; j++) {
                Bahn drawElement = (Bahn) ablauf[i][j];


                Rectangle rect = new Rectangle(drawElement.getMinZ(), drawElement.getMinY(), drawElement.getMaxZ() - drawElement.getMinZ(), drawElement.getMaxY() - drawElement.getMinY());
                rect.setFill(Color.TRANSPARENT);
                rect.setStroke(Color.BLACK);
                container.getChildren().add(rect);
            }
        }
    }

    public Object[] createAblauf() {

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

    //test

    public void startwithElement(Pane frontView, Pane topView, Pane sideView) {

        createAblauf();
        drawBahnElementsFrontView(frontView);
        drawBahnElementsTopView(topView);
        drawBahnElementsSideView(sideView);
        //System.out.println(ablauf[0][0]);
        //System.out.println("IndexI: " + i + " indexJ: " + j);
        currentElement = (Bahn) ablauf[i][j];
        i++;

        /*line = new javafx.scene.shape.Line(270,85,285,85);

        line.setStroke(Color.BLUE);
        line.setStrokeWidth(1);
        line.toFront();
        topView.getChildren().add(line);*/
    }

    public void changeElement(){

        if (i < ablauf.length) {

            if (j == ablauf[i].length - 1) {

                currentElement = (Bahn) ablauf[i][j];
                i++;
                j = 0;

            } else {
                currentElement = (Bahn) ablauf[i][j];
                j++;
            }
        }

        maxWidth = currentElement.getMaxX();
        maxHeight = currentElement.getMaxY();
        maxDepth = currentElement.getMaxZ();
        minWidth = currentElement.getMinX();
        minHeight = currentElement.getMinY();
        minDepth = currentElement.getMinZ();

    }


    public void applyForce(PVector force) {
        PVector f = force;
        f.div(mass);
        acceleration.add(f);
    }

    public void draw(Pane frontView, Pane topView, Pane sideView, Label label) {

        //System.out.println(linePosition[0][1]);
        //System.out.println(linePosition[2][0]);

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

                veloOutput = new PVector(velocity.x, velocity.y, velocity.z);
                velo = (int) veloOutput.mag();

                label.setText(String.valueOf(velo));

                giveBool();
                /*System.out.println("Location: (" + location.x + "; " + location.y  + "; " + location.z + ")");
                System.out.println("Velocity: (" + velocity.x + "; " + velocity.y + "; " + velocity.z + ")");
                System.out.println("Acceleration: (" + acceleration.x + "; " + acceleration.y + "; " + acceleration.y + ")");*/
                //System.out.println(currentElement);
                //lineCollision();
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

    public void repeatAnimation(Pane frontView, Pane topView, Pane sideView) {

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
        velocity = new PVector(0, 0, 0);
        acceleration = new PVector(-0.001, 0.01, -0.001);
        mass = 80.0;

        timeline.play();

    }


    public void checkEdges() {

        int xNeg = currentElement.getXNeg();
        int xPos = currentElement.getXPos();
        int yNeg = currentElement.getYNeg();
        int yPos = currentElement.getYPos();
        int zNeg = currentElement.getZNeg();
        int zPos = currentElement.getZPos();

        if (k < lines.length) {

            //System.out.println(k);

            if (i == linePosition[k][0] && j == linePosition[k][1]) {

                line1 = lines[k];
                //line1 = new Line(760,185,30,770,120,70);

                lineCollision();

                System.out.println(k);

                k++;
            }
        }

        //System.out.println("xball: " +location.x + " > max: " + (maxWidth - radius) + "xball: " + location.x + " < min: " + (minWidth + radius));

        //line1 = new Line(270,300,85,285,300,70);

        /*if (ballFrontView.getBoundsInParent().intersects(line1.getBoundsInParent())) {
            velocity.x *= -1;
        }*/

        if (location.x > (maxWidth - radius)) {

            if (xPos == 1) {
                changeElement();
            } else if (xPos == 0) {
                velocity.x *= -1;
                location.x = maxWidth - radius;
            } else if (xPos == 2) {
            }

        } else if (location.x < minWidth + radius) {

            if (xNeg == 1) {
                changeElement();
            } else if (xNeg == 0) {
                velocity.x *= -1;
                location.x = minWidth + radius;
            }
        }

        if (location.y > (maxHeight - radius)) {

            if (yPos == 1) {
                changeElement();
            } else if (yPos == 0) {
                velocity.y *= -0.2;
                location.y = maxHeight - radius;
            }

        } else if (location.y < minHeight + radius) {

            if (yNeg == 1) {
                changeElement();
            } else if (yNeg == 0) {
                velocity.y *= -1;
                location.y = minHeight + radius;
            }
        }

        if(location.z > (maxDepth - radius)){

            if (zPos == 1) {
                changeElement();
            } else if (zPos == 0) {
                velocity.z *= -1;
                location.z = maxDepth - radius;
            }

        } else if (location.z < minDepth + radius) {

            if (zNeg == 1) {
                changeElement();
            } else if (zNeg == 0) {
                velocity.z *= -1;
                location.z = minDepth + radius;
            }
        }

    }

    public void lineCollision(){

        System.out.println(line1.getStartX());
        System.out.println(line1.getStartY());
        System.out.println(line1.getEndX());
        System.out.println(line1.getEndY());

        double distX = line1.getStartX() - line1.getEndX();
        double distZ = line1.getStartY() - line1.getEndY();
        double len = Math.sqrt((distX*distX) + (distZ*distZ));

        double dot = ( ((location.x - line1.getStartX())*(line1.getEndX()-line1.getStartX()) + ( (location.z-line1.getStartY())*(line1.getEndY()-line1.getStartY())))) / Math.pow(len,2);

        double closestX = line1.getStartX() + (dot * (line1.getEndX() - line1.getStartX()));
        double closestZ = line1.getStartY() + (dot * (line1.getEndY() - line1.getStartY()));

        distX = closestX - location.x;
        distZ = closestZ - location.z;
        double distance = Math.sqrt((distX*distX) + (distZ*distZ));

        if (distance <= radius){
            velocity.x *= -1;
            velocity.z *= -1;

            System.out.println("ja");
        }
    }

    public boolean getSpherePosition(double smallestX, double biggestX, double smallestY, double biggestY, double smallestZ, double biggestZ) {

        if (location.x > smallestX && location.x < biggestX && location.y > smallestY && location.y < biggestY && location.z > smallestZ && location.z < biggestZ) {
            return true;
        }
        return false;
    }

    public void giveBool() {
        spherePosition01 = getSpherePosition(700, 800, 0, 100, 100, 200);
        spherePosition02 = getSpherePosition(700, 800, 100, 200, 100, 200);
        spherePosition03 = getSpherePosition(700, 800, 100, 200, 0, 100);
        spherePosition04 = getSpherePosition(600, 700, 100, 200, 0, 100);
        spherePosition05 = getSpherePosition(600, 700, 200, 300, 0, 100);
        spherePosition06 = getSpherePosition(500, 600, 200, 300, 0, 100);
        spherePosition07 = getSpherePosition(400, 500, 200, 300, 0, 100);
        spherePosition08 = getSpherePosition(400, 500, 300, 400, 0, 100);
        spherePosition09 = getSpherePosition(300, 400, 300, 400, 0, 100);
        spherePosition10 = getSpherePosition(200, 300, 300, 400, 0, 100);
        spherePosition11 = getSpherePosition(200, 300, 300, 400, 100, 200);
        spherePosition12 = getSpherePosition(200, 300, 300, 400, 200, 300);
        spherePosition13 = getSpherePosition(200, 300, 400, 500, 200, 300);
        spherePosition14 = getSpherePosition(100, 200, 400, 500, 200, 300);
        spherePosition15 = getSpherePosition(0, 100, 400, 500, 200, 300);
        spherePosition16 = getSpherePosition(0, 100, 400, 500, 300, 400);
        spherePosition17 = getSpherePosition(100, 200, 400, 500, 300, 400);
        spherePosition18 = getSpherePosition(200, 300, 400, 500, 300, 400);
    }

    public boolean isSpherePosition01() {
        return spherePosition01;
    }


    public boolean isSpherePosition02() {
        return spherePosition02;
    }

    public boolean isSpherePosition03() {
        return spherePosition03;
    }

    public boolean isSpherePosition04() {
        return spherePosition04;
    }

    public boolean isSpherePosition05() {
        return spherePosition05;
    }

    public boolean isSpherePosition06() {
        return spherePosition06;
    }

    public boolean isSpherePosition07() {
        return spherePosition07;
    }

    public boolean isSpherePosition08() {
        return spherePosition08;
    }

    public boolean isSpherePosition09() {
        return spherePosition09;
    }

    public boolean isSpherePosition10() {
        return spherePosition10;
    }

    public boolean isSpherePosition11() {
        return spherePosition11;
    }

    public boolean isSpherePosition12() {
        return spherePosition12;
    }

    public boolean isSpherePosition13() {
        return spherePosition13;
    }

    public boolean isSpherePosition14() {
        return spherePosition14;
    }

    public boolean isSpherePosition15() {
        return spherePosition15;
    }

    public boolean isSpherePosition16() {
        return spherePosition16;
    }

    public boolean isSpherePosition17() {
        return spherePosition17;
    }

    public boolean isSpherePosition18() {
        return spherePosition18;
    }

}
