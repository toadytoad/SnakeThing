import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Game> games = new ArrayList<>(100);
        Database bestDB = new Database(new ArrayList<>());
        for(int i = 0; i<100; i++){
            games.add(new Game(new Database(bestDB), true));
        }
        Collections.sort(games);
        bestDB = games.get(0).db;
        System.out.println("Finished first generation, highest score was: " + games.get(0).score);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1 - start the next generation with improving the database");
            System.out.println("2 - start a new round without improving the database");
            System.out.println("3 - output the size of the best database");
            System.out.println("4 - output the results of every game");
            System.out.println("5 - exit");
            System.out.println("6 - run 100 generations with improving db");
            int input = Integer.parseInt(br.readLine());
            switch(input){
                case 1 -> {
                    games = new ArrayList<>(100);
                    for(int i = 0; i<100; i++){
                        games.add(new Game(new Database(bestDB),true));
                    }
                    Collections.sort(games);
                    System.out.println("Finished first generation, highest score was: " + games.get(0).score);
                    bestDB = games.get(0).db;
                }
                case 2 -> {
                    games = new ArrayList<>(100);
                    for(int i = 0; i<100; i++){
                        games.add(new Game(new Database(bestDB),true));
                    }
                    Collections.sort(games);
                    System.out.println("Finished first generation, highest score was: " + games.get(0).score);
                }
                case 3 -> System.out.println(bestDB.moves.size());
                case 4 -> {for(Game g : games) System.out.println(g.score);}
                case 5 -> {return;}
                case 6 -> {
                    for(int z = 0; z<100; z++){
                        games = new ArrayList<>(100);
                        for(int i = 0; i<100; i++){
                            games.add(new Game(new Database(bestDB),true));
                        }
                        Collections.sort(games);
                        System.out.println("Finished first generation, highest score was: " + games.get(0).score);
                        bestDB = games.get(0).db;
                    }
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
