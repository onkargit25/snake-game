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

    int[][] screen;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.fillRect(0,0, screenWidth, screenHeight);

        
        for(int i = 0; i < screen.length; i++){
            for(int j = 0; j < screen[0].length; j++){

                if(screen[i][j] == 3){
                    g.setColor(Color.RED);
                    g.fillRect((j*tileOnScreen), (i*tileOnScreen), tileOnScreen, tileOnScreen);
                }

                if(screen[i][j] == 1){
                    g.setColor(Color.ORANGE);
                    g.fillRect((j*tileOnScreen), (i*tileOnScreen), tileOnScreen, tileOnScreen);
                }

                if(screen[i][j] == 2){
                    g.setColor(Color.YELLOW);
                    g.fillRect((j*tileOnScreen), (i*tileOnScreen), tileOnScreen, tileOnScreen);
                }

                

                
            }
        }
        


    }

    SnakePanel(int[][] screen){

        this.screen = screen;
    }
}