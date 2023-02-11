import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Box collider simulator");
        Box box = new Box(100, 100);
        frame.setContentPane(box);
        frame.setSize(200, 200);
        frame.setVisible(true);
        int FPS = 60;
        int neededTimeForUpdateInMilliSec = 1000/FPS;
        int NANO_TO_MILLI = 1000000;


        // Game engine
        while(true) {
            long startTime = System.nanoTime(); // timer start
            System.out.println("Game loop>>>");
            box.update();
            box.checkCollision(frame);

            long endTime = System.nanoTime(); // timer stop
            long passedTime = startTime - endTime;
            long _deltaTime = neededTimeForUpdateInMilliSec - passedTime/NANO_TO_MILLI;

            try {
                Thread.sleep(_deltaTime);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }




}
