package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Selection {

    public static boolean pressedVHard;
    public static boolean pressedHard;
    public static boolean pressedMedium;
    public static boolean pressedEasy;
    
    //change booleans to methods in the real thing

    public static void main(String[] args) {
        /* 
        Four options:
        - Easy
        - Medium
        - Hard
        - Very Hard
        
        Each level has 3 text files, which gets generated randomly 
        */}
    Random rand = new Random();
    int n = rand.nextInt(3);
    //generates a random number between 0 and 2


    public void textSelection(){
        if (pressedHard) {
            File file = null;
            if (n == 0) {
                file = new File("fileHard1.txt");
            } else if (n == 1) {
                file = new File("fileHard2.txt");
            } else if (n == 2) {
                file = new File("fileHard3.txt");
            }
        }


        else if (pressedVHard) {
            File file = null;
            if (n == 0) {
                file = new File("fileVHard1.txt");
            } else if (n == 1) {
                file = new File("fileVHard2.txt");
            } else if (n == 2) {
                file = new File("fileVHard3.txt");
            }
        }


        else if (pressedMedium) {
            File file = null;
            if (n == 0) {
                file = new File("fileMedium1.txt");
            } else if (n == 1) {
                file = new File("fileMedium2.txt");
            } else if (n == 2) {
                file = new File("fileMedium3.txt");
            }
        }


        else if (pressedEasy) {
            File file = null;
            if (n == 0) {
                file = new File("fileEasy1.txt");
            } else if (n == 1) {
                file = new File("fileEasy2.txt");
            } else if (n == 2) {
                file = new File("fileEasy3.txt");
            }
        }


        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //handle this
        }
        //prints out the whole file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            //return line;
        }
    }
}
