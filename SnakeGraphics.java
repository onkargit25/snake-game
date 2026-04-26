import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SnakePanel extends JPanel{

    int tile = 16;
    int scale = 2;
    int tileOnScreen = tile * scale;
    int rowsOnScreen = 20;
    int colsOnScreen = 20;
    int screenWidth = colsOnScreen * tileOnScreen;
    int screenHeight = rowsOnScreen * tileOnScreen;

    int[][] screen;
    char direction;
    boolean snakeMoved = false;

    public void setDirection(char direction){
        this.direction = direction;
    }

    public char getDirection(){
        return this.direction;
    }
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

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        
        // 3. Bind the action name to actual code
        actionMap.put("moveUp", new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                setDirection('N');
                snakeMoved = true;
                
            }
        });

        actionMap.put("moveDown", new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                setDirection('S');
                snakeMoved = true;
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                setDirection('W');
                snakeMoved = true;
            }
        });

        actionMap.put("moveRight", new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                setDirection('E');
                snakeMoved = true;
            }
        });
    }
}