package Collision;

import javafx.scene.shape.Line;

public class Border {
    public javafx.scene.shape.Line[] createLines(){
        Line[] lines = new Line[5];
        // i = 1; j = 2; Seitenansicht Y-Z
        lines[0] = new Line(130,170,150,165);
        lines[1] = new Line(150,165,170,120);
        // i = 2; j = 2,3; Topansicht X-Z
        lines[2] = new Line(770,70,742,40);
        lines[3] = new Line(742,40,715,30);
        // i = 2; j = 2,3,4; Frontansicht X-Y
        lines[4] = new Line(715,195,750,175);
        lines[5] = new Line(750,175,760,165);
        // i = 5; j = 2; Topansicht X-Z
        lines[6] = new Line(270,30,250,50);
        lines[7] = new Line(250,50,230,70);
        // i = 6; j = 3; Seitenansicht Y-Z
        lines[8] = new Line(130,327,150,347);
        lines[9] = new Line(150,347,170,367);
        // i = 7; j = 2; Topansicht X-Z
        lines[10] = new Line(270,215,250,250);
        lines[11] = new Line(250,250,230,270);

        return lines;
    }
}
