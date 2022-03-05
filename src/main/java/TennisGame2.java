import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    private Map<Integer,Score> scores;
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.scores = new HashMap<>();
        this.scores.put(0, new ScoreLove());
        this.scores.put(1, new ScoreFifteen());
        this.scores.put(2, new ScoreThirty());
        this.scores.put(3, new ScoreForty());
    }

    private boolean score1(){
        return (P1point == P2point && P1point < 4);
    }

    private boolean score2(){
        return (P1point==P2point && P1point>=3);
    }

    private boolean score3(){
        return(P1point > 0 && P2point==0);
    }

    private boolean score4(){ return (P2point > 0 && P1point==0); }

    private boolean score5(){ return (P1point>P2point && P1point < 4); }

    private boolean score6(){ return(P2point>P1point && P2point < 4); }

    private boolean score7(){ return(P1point > P2point && P2point >= 3); }

    private boolean score8(){ return(P2point > P1point && P1point >= 3); }

    private boolean score9(){ return(P1point>=4 && P2point>=0 && (P1point-P2point)>=2); }

    private boolean score10(){ return(P2point>=4 && P1point>=0 && (P2point-P1point)>=2); }

    private String function1(){
        return scores.get(P1point).obtenerSocre() + "-All";
    }

    private String function2(){
        return "Deuce";
    }

    private String function3(){
        P2res = "Love";
        P1res = scores.get(P1point).obtenerSocre();
        return P1res + "-" + P2res;
    }

    private String function4(){
        P2res = scores.get(P2point).obtenerSocre();
        P1res = "Love";
        return P1res + "-" + P2res;
    }

    private String function5(){
        P1res = scores.get(P1point).obtenerSocre();
        P2res = scores.get(P2point).obtenerSocre();
        return P1res + "-" + P2res;
    }

    private String function6(){
        P1res = scores.get(P1point).obtenerSocre();
        P2res = scores.get(P2point).obtenerSocre();
        return P1res + "-" + P2res;
    }

    private String function7(){
        return "Advantage player1";
    }

    private String function8(){
        return "Advantage player2";
    }

    private String function9(){
        return "Win for player1";
    }

    private String function10(){
        return "Win for player2";
    }

    public String getScore(){
        String score = "";

        if (score1()) score = function1();
        if (score2()) score = function2();
        if (score3()) score = function3();
        if (score4()) score = function4();
        if (score5()) score = function5();
        if (score6()) score = function6();
        if (score7()) score = function7();
        if (score8()) score = function8();
        if (score9()) score = function9();
        if(score10()) score = function10();

        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

    public class Score{

        public String obtenerSocre(){
            return "";
        }
    }

    public class ScoreFifteen extends Score{
        public String obtenerSocre(){
            return "Fifteen";
        }
    }

    public class ScoreThirty extends Score{
        public String obtenerSocre(){
            return "Thirty";
        }
    }

    public class ScoreForty extends Score{
        public String obtenerSocre(){
            return "Forty";
        }
    }

    public class ScoreLove extends Score{
        public String obtenerSocre(){
            return "Love";
        }
    }
}