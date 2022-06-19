import java.util.ArrayList;

public class Game implements Comparable<Game>{
    Position position;
    int score;
    Database db;
    public Game(Database db, boolean mode){
        this.db = db;
        score = 0;
        position = new Position();
        start(mode);
    }
    public Game(boolean mode){
        this(new Database(new ArrayList<>()), mode);
    }
    private void start(boolean mode){
        while(true){
            int move = db.choose(position);

            if(mode){
                db.update(new Move(position, move));
            }
            position.board[position.headX][position.headY] = (byte)move;
            int result = position.nextPos();
            if(result==1){
                return;
            } else if (result == 2){
                score++;
            }
        }
    }

    @Override
    public int compareTo(Game o) {
        return o.score-this.score;
    }
}
