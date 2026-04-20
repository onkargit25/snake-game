import javax.swing.JFrame;

class SnakeOnScreen{

    void setSnakeOnScreen(Snake[] snake, int[][] screen, int snakeLength){
        for(int i = 0; i < snakeLength ; i++){
            screen[(snake[i]).y][snake[i].x] = 1;
        }
    }
    

    SnakeOnScreen(){
    }
}
class Snake{
    int x;
    int y;

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
                this.y++;
                break;

            case 'E':
                this.x++;
                break;

            case 'S':
                this.y--;
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

class SnakeMain{
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

        SnakeOnScreen ss = new SnakeOnScreen();
        ss.setSnakeOnScreen(snake, screen, snakeLength);

        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                System.out.print(screen[i][j]);
            }

            System.out.println();
        }
        

        JFrame frame = new JFrame("Snake game");
        SnakePanel panel = new SnakePanel(screen);

        

        frame.add(panel);
        frame.setSize(panel.screenWidth, panel.screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centers the window
        frame.setVisible(true);


        

    }//end of main
}//end of class
