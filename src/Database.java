import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database implements Serializable {
    List<Move> moves;
    public int choose(Position p){
        if(moves.isEmpty()){
            return new Random().nextInt(4)+1;
        }
        double[] a = new double[4];
        for(Move move : moves){
            a[move.choice-1]+=Util.comparePos(p, move.p);
        }
        double choice = Math.random()*moves.size();
        for(int i = 0; i<4; i++){
            if(choice-a[i]<0) return i+1;
            choice-=a[i];
        }
        return new Random().nextInt(4)+1;
    }
    public int hasPos(Position p){
        for(int i = 0; i<moves.size(); i++){
            if(Util.comparePos(moves.get(i).p, p)==1){
                return i;
            }
        }
        return -1;
    }
    public void update(Move m){
        int result = hasPos(m.p);
        if(result==-1){
            moves.add(m);
        } else {
            moves.set(result, m);
        }
    }
    public Database(Database db){
        this.moves = new ArrayList<>(db.moves);
    }
    public Database(List<Move> moves){
        this.moves=moves;
    }
}
