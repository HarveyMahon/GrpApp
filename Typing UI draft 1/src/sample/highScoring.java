package sample;

import java.util.ArrayList;
import java.util.List;

public class highScoring {
    int highScore = -100; //Setting it to be lowest possible
    List<Integer> copyOfScores = new ArrayList<>();

    public static void main(String[] args) {
        int score = calcScore(charactersTyped, accuracy);
    }

    public int Scores(int score) {
        copyOfScores.add(score);
        if (score > highScore) {
            highScore = score; //If the score is higher than the current then it replaces it.}
            return score;
        } else {
            int close = highScore - score; //If they haven't achieved a new high score how close they were to the high score is returned
            return close;
        }
    }
}
