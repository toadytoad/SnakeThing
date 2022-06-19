import java.util.Arrays;
import java.util.Random;

public class Position {
    byte[][] board; //0 - nothing, -1 - apple, 1 - snake pointing up, 2- snake pointing right, 3 - snake pointing down, 4 - snake pointing left
    int headX;
    int headY;
    int tailX;
    int tailY;
    int appleX;
    int appleY;
    public Position(){
        this.board = new byte[8][8];
        board[0][0] = 5;
        headX = 0;
        headY = 0;
        tailX = 0;
        tailY = 0;
        placeApple();
    }
    public Position(Position p){
        this.board = Arrays.stream(p.board).map(byte[]::clone).toArray(byte[][]::new);
        this.headX = p.headX;
        this.headY = p.headY;
        this.tailX = p.tailX;
        this.tailY = p.tailY;
        this.appleX = p.appleX;
        this.appleY = p.appleY;
    }
    public int nextPos(){
        switch(board[headX][headY]){
            case 1 -> {
                if(headX == 0){
                    return 1;
                }
                if(board[headX-1][headY]==-1){
                    board[headX-1][headY] = 5;
                    headX--;
                    placeApple();
                    return 2;
                }
                if(board[headX-1][headY]==0){
                    //move the tail forward
                    moveTailForward();
                    //move the head
                    board[headX-1][headY] = 5;
                    headX--;
                    return 0;
                } else {
                    return 1;
                }
            }
            case 2 -> {
                if(headY == 7){
                    return 1;
                }
                if(board[headX][headY+1]==-1){
                    board[headX][headY+1] = 5;
                    headY++;
                    placeApple();
                    return 2;
                }
                if(board[headX][headY+1]==0){
                    //move the tail forward
                    moveTailForward();
                    //move the head
                    board[headX][headY+1] = 5;
                    headY++;
                    return 0;
                } else {
                    return 1;
                }
            }
            case 3 -> {
                if(headX == 7){
                    return 1;
                }
                if(board[headX+1][headY]==-1){
                    board[headX+1][headY] = 5;
                    headX++;
                    placeApple();
                    return 2;
                }
                if(board[headX+1][headY]==0){
                    //move the tail forward
                    moveTailForward();
                    //move the head
                    board[headX+1][headY] = 5;
                    headX++;
                    return 0;
                } else {
                    return 1;
                }
            }
            case 4 -> {
                if(headY == 0){
                    return 1;
                }
                if(board[headX][headY-1]==-1){
                    board[headX][headY-1] = 5;
                    headY--;
                    placeApple();
                    return 2;
                }
                if(board[headX][headY-1]==0){
                    //move the tail forward
                    moveTailForward();
                    //move the head
                    board[headX][headY-1] = 5;
                    headY--;
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        return 1;
    }
    private void placeApple(){
        while(true){
            int x = new Random().nextInt(8);
            int y = new Random().nextInt(8);
            if(board[x][y] == 0){
                board[x][y] = -1;
                appleX = x;
                appleY = y;
                return;
            }
        }
    }
    private void moveTailForward() {
        byte a = board[tailX][tailY];
        board[tailX][tailY] = 0;
        switch(a){
            case 1 -> tailX--;
            case 2 -> tailY++;
            case 3 -> tailX++;
            case 4 -> tailY--;
        }
    }
}
