import java.util.*;
import java.util.stream.IntStream;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    private Map<Integer,Result > results;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.results = new HashMap<Integer,Result>();
        this.results.put(1,new Result1());
        this.results.put(-1,new Result2());
        this.results.put(2,new Result3());
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (score1()) return function1();
        if (score2()) return function2();
        return function3();
    }

    private String function1(){
        List<String> valores = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All");
        if(validScore1()) return valores.get(m_score1);
        return "Deuce";
    }

    private String function2(){
        return this.results.getOrDefault(m_score1-m_score2, new Result4()).obtenerResultado();
    }

    private boolean validScore1(){
        return(m_score1 >= 0 && m_score1 <= 2);
    }

    private boolean score1(){
        return (m_score1>=4 || m_score2>=4);
    }

    private boolean score2(){
        return(m_score1>=4 || m_score2>=4);
    }
    private String function3(){
        int tempScore = 0;
        String score = "";
        for (int i=1; i<3; i++){

            tempScore = obtenerTempScore(i);
            if (i!=1) score+="-";
            score += swtich_function3(tempScore);

        }
        return score;
    }

    private String swtich_function3(int tempScore){
        List<String> valores = Arrays.asList("Love", "Fifteen", "Thirty","Forty");
        return valores.get(tempScore);
    }

    private int obtenerTempScore(int i){
        if(i != 1) return m_score1;
        return m_score2;
    }

    public class Result{
        public Result() {
        }
        public String obtenerResultado(){
            return "";
        }
    }

    public class Result1 extends Result{
        public Result1() {}

        public String obtenerResultado(){
            return "Advantage player1";
        }
    }

    public class Result2 extends Result{
        public Result2() {}

        public String obtenerResultado(){
            return "Advantage player2";
        }
    }

    public class Result3 extends Result{
        public Result3() {}

        public String obtenerResultado(){
            return "Win for player1";
        }
    }

    public class Result4 extends Result{
        public Result4() {}

        public String obtenerResultado(){
            return "Win for player2";
        }
    }
}
