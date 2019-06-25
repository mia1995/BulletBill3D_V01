package Collision;

import javafx.scene.shape.Line;

public class Border {
    public static Line[] createLines(){
        Line[] lines = new Line[10];
        // i = 1; j = 1; Seitenansicht Y-Z
        lines[0] = new Line(130,170,170,120);
        // i = 2; j = 1; Topansicht X-Z
        lines[1] = new Line(770,70,715,30);
        // i = 2; j = 2; Topanschit X-Z
        lines[2] = new Line(770,70,715,30);
        // i = 2; j = 1; Frontansicht X-Y
        lines[3] = new Line(770,165,760,170);
        // i = 2; j = 2; Frontansicht X-Y
        lines[4] = new Line(760,170,715,195);
        // i = 5; j = 1; Topansicht X-Z
        lines[5] = new Line(270,30,230,70);
        // i = 6; j = 2; Seitenansicht Y-Z
        lines[6] = new Line(130,327,170,367);
        // i = 7; j = 1; Topansicht X-Z
        lines[7] = new Line(270,215,230,270);
        // i = 9; j = 1; Topansicht X-Z
        lines[8] = new Line(70,230,30,270);
        // i = 10; j = 1; Topansicht X-Z
        lines[9] = new Line(30,330,70,370);

        return lines;
    }
}
