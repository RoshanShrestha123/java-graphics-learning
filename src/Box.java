import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Box extends JPanel {
    int x = 0;
    int y = 0;
    int _xDirection = 1;
    int _yDirection = 1;
    int acceleration = 1;

    private Rectangle[] boxes= new Rectangle[100];
    private int[] directionX = new int[100];
    private int[] directionY = new int[100];
    private Random random = new Random();

    public Box(int xV, int yV){
        super();
                this.y = yV;
        for (int i = 0; i < 10; i++){
            int x = random.nextInt(200);
            int y = random.nextInt(200);
            directionX[i] = 1;
            directionY[i] = 1;
            boxes[i] = new Rectangle(x, y , 20, 20);
        }
    }

    public void update(){

        for (int i = 0; i < 10; i++){
            boxes[i].x+=directionX[i];
            boxes[i].y+=directionY[i];

        }
        repaint();
    }

    void checkCollision(JFrame frame){
        int _width = frame.getWidth();
        int _height = frame.getHeight();

        for (int i = 0; i < 10; i++){
            if(boxes[i].x + boxes[i].width > _width){
                directionX[i] = -1;
            } else if (boxes[i].x  < 0) {
                directionX[i] = 1;
            }

            if(boxes[i].y  + boxes[i].height > _height - boxes[i].height){
                directionY[i] = -1;
            } else if (boxes[i].y  < 0) {
                directionY[i] = 1;
            }
        }



    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (int i = 0; i < 10; i++){
            g.fillRect(boxes[i].x, boxes[i].y, boxes[i].width, boxes[i].height);
        }

    }

}
