import javax.swing.JFrame;
import java.time.*;

class SnakeOnScreen{

    void setSnakeOnScreen(Snake[] snake, int[][] screen, int snakeLength){

        for(int i = 0; i < screen.length; i++){
            for(int j = 0; j < screen[0].length; j++){
                if(screen[i][j] == 1){
                    screen[i][j] = 0;
                }
            }
        }


        screen[(snake[0]).y][snake[0].x] = 2;
        for(int i = 1; i < snakeLength ; i++){
            screen[(snake[i]).y][snake[i].x] = 1;
        }


    }
    

    SnakeOnScreen(){
    }
}


class MoveSnake{

    void moveSnake(char direction, Snake[] snake, int snakeLength){

        for(int i = (snakeLength -1); i >= 1; i--){
            snake[i].y = snake[i-1].y;
            snake[i].x = snake[i-1].x;
        }

        snake[0].move(direction);
    }
}
class Snake{
    int x;
    int y;

    void move(char direction){}

    Snake(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class SnakeHead extends Snake{

    //North, South, East, West
    void move(char direction){

        switch(direction){
            case 'N':
                this.y--;
                break;

            case 'E':
                this.x++;
                break;

            case 'S':
                this.y++;
                break;

            case 'W':
                this.x--;
                break;
        }
    }
    
    SnakeHead(int x, int y){
        super(x, y);
    }
}

class Food{
    int x;
    int y;

    Food(){
        this.x = ((int)(Math.random()*20));
        this.y = ((int)(Math.random()*20));
    }
}

public class SnakeMain{
    public static void main(String args[]){


        Snake[] snake = new Snake[400];
        snake[0] = new SnakeHead(10, 10);
        snake[1] = new Snake(9, 10);
        snake[2] = new Snake(8, 10);

        int snakeLength = 3;


        int[][] screen = new int[20][20];

        final int SNAKE_BODY = 1;
        final int SNAKE_HEAD = 2;
        final int GRASS = 0;
        final int FOOD = 3;

        screen[3][3] = FOOD;

        SnakeOnScreen ss = new SnakeOnScreen();
        ss.setSnakeOnScreen(snake, screen, snakeLength);

        MoveSnake ms = new MoveSnake();

        

        JFrame frame = new JFrame("Snake game");
        SnakePanel panel = new SnakePanel(screen);

        

        frame.add(panel);
        frame.setSize(panel.screenWidth, panel.screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centers the window
        frame.setVisible(true);

        char movingTo = 'S';


        ms.moveSnake(movingTo, snake, snakeLength);
        ss.setSnakeOnScreen(snake, screen, snakeLength);

        panel = new SnakePanel(screen);
        frame.add(panel);
        frame.setVisible(true);


        

    }//end of main
}//end of class
