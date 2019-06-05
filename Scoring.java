package sample;

public class Scoring {

    public static void main(String[] args) {
        // test data is my typing speed at 100% accuracy
        // this data will not be here in the real program
        System.out.println(calcScore(320, 100.0));
    }

    //this func assumes that the length of the task is 1 min and that accuracy is given as a percentage
    //returns the value of score

    public static int calcScore(int charactersTyped, double accuracy) {
        /*
        - typing world record is 216WPM ~ 972CPM
        - score to be in range of 0-1000
        - want to favour speed over accuracy
        - average accuracy of a typist is 92%
        - average stenotypist is 110WPM ~ 495CPM
        - professional typist is approx 70WPM ~ 315CPM
        - mid of these is 248CPM
        - average person is approx 40WPM ~ 180CPM
        - Morse code is about 90CPM
        - writing speed is 68CPM
        - max scoring CPM will be 500CPM
        */

        //ensuring charactersTyped is in valid range

        if (charactersTyped > 500) charactersTyped = 500;

        //converting accuracy to a decimal

        accuracy /= 100;

        //rounding the result in order to display the score

        int score = (int)Math.round((charactersTyped * 2) * accuracy);
        return score;
    }
}
