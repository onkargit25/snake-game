class Snake{
    int x;
    int y;

    Snake(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class SnakeHead extends Snake{
    
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

    }//end of main
}//end of class
