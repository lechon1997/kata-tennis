import java.util.HashMap;
import java.util.Map;

public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    private Map<Integer,String> scores;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
        this.scores = new HashMap<Integer,String>();
        this.scores.put(0,"Love");
        this.scores.put(1,"Fifteen");
        this.scores.put(2,"Thirty");
        this.scores.put(3,"Forty");
    }

    private boolean score1(){ return (p1 < 4 && p2 < 4 && !(p1 + p2 == 6));}

    private String function1(){
        String s = scores.get(p1);
        return (p1 == p2) ? s + "-All" : s + "-" + scores.get(p2);
    }

    private String function2(){
        String s = p1 > p2 ? p1N : p2N;
        return ((p1-p2)*(p1-p2) == 1) ? "Advantage " + s : "Win for " + s;
    }

    public String getScore() {
        if (score1()) return function1();
        if (p1 == p2) return "Deuce";
        return function2();
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
