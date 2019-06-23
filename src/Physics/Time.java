package Physics;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Time {

    public static long curTime = 0;
    public static long timePassed = 0;
    public static long lastTime = 0;
    public static double timeFraction = 0.0;


    public static void updateTime() {

        lastTime = curTime;
        curTime = System.currentTimeMillis();
        timePassed = (curTime - lastTime);
        timeFraction = (timePassed / 1000.0);

    }

}


