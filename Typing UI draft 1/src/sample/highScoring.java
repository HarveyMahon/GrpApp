package sample;

public class highScoring {
    int highScore = -100; //Setting it to be lowest possible

    public static void main(String[] args) {
        int score = calcScore(charactersTyped, accuracy);
    }
    public int Scores(int score) {
        if (score > highScore) highScore = score; //If the score is higher than the current then it replaces it.
        return score;

    }
}
