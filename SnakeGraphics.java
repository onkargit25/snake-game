import javax.swing.*;
import java.awt.*;

class SnakePanel extends JPanel{

    int tile = 16;
        int scale = 2;
        int tileOnScreen = tile * scale;
        int rowsOnScreen = 20;
        int colsOnScreen = 20;
        int screenWidth = colsOnScreen * tileOnScreen;
        int screenHeight = rowsOnScreen * tileOnScreen;

    int[][] array;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, screenWidth, screenHeight);
        


    }

    SnakePanel(int[][] array){

        this.array = array;
    }
}