import javax.swing.JFrame;

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

    Food(Snake[] snake,int snakeLength){

        int xcoord = 0;
        int ycoord = 0;

        boolean validSpawn = false;

        while(!validSpawn){
            xcoord = ((int)(Math.random()*20));
            ycoord = ((int)(Math.random()*20));

            validSpawn = true;

            for(int i = 0; i < snakeLength; i++){

                if((xcoord== (snake[i]).x) && (ycoord == (snake[i]).y)){
                    validSpawn = false;
                    break;
                }
            }
        }

        this.x = xcoord;
        this.y = ycoord;
        


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

        Food food = new Food(snake, snakeLength);
        screen[food.y][food.x] = FOOD;

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

        
        char input = 'E';

        //the food needs to spawn on grass. Not where the snake exists already.


        int downCountForExpansion = 1;
        Snake tailSave = new Snake(0,0);
        
        while(true){

            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 20; j++){
                    panel.screen[i][j] = screen[i][j];
                }
            }
            panel.repaint();
            

            try {
                Thread.sleep(250);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            if(panel.snakeMoved){
                input = panel.getDirection();
            }
            

            ms.moveSnake(input, snake, snakeLength);

            
            //food eating logic
            if(snake[0].x == food.x && snake[0].y == food.y){
                    tailSave.x = snake[snakeLength - 1].x;
                    tailSave.y = snake[snakeLength - 1].y;
                    downCountForExpansion--;
            }

            if(downCountForExpansion == 0){
                snake[snakeLength] = new Snake(tailSave.x, tailSave.y);
                snakeLength++;
                downCountForExpansion = 1;
                food = new Food(snake, snakeLength);
                screen[food.y][food.x] = FOOD;

            }


            boolean collision = false;

            //self collision logic
            for(int i = 1; i < snakeLength; i++){

                if(snake[0].x == (snake[i].x) && (snake[0].y == snake[i].y)){
                    collision = true;
                    break;
                }
            }



            ss.setSnakeOnScreen(snake, screen, snakeLength);

            if(collision){
                break;
            }

        }
        

    }//end of main
}//end of class
