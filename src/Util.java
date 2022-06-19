public class Util {
    static float comparePos(Position a, Position b){
        int sum = 0;
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(a.board[i][j]!=b.board[i][j]){
                    sum++;
                }
            }
        }
        return (float)sum/64;
    }
}
