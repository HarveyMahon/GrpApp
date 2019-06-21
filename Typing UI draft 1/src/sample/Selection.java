package sample;

import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Selection {

    public static boolean pressedVHard;
    public static boolean pressedHard;
    public static boolean pressedMedium;
    public static boolean pressedEasy;
    public static Label lblTextOutput;
    //change booleans to methods in the real thing


    private static String readFile(String file) throws IOException {    //Doesn't work - possible error with FileReader
        //BufferedReader reader = new BufferedReader(new FileReader(file));
        //FileReader reader=new FileReader(file);


        FileReader file2 = new FileReader(file);
        System.out.println("Inside readFile");
        BufferedReader buffer = new BufferedReader(file2);



        //String line = null;
        String line="";

        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try {
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();

        }finally{
            buffer.close();//https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
        }
        /*Scanner scanner = null;
        scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringBuilder.append(line);

            System.out.println("line: "+line);
        }
        return stringBuilder.toString();*/

    }

    public void main(String[] args) throws IOException{
        /* 
        Four options:
        - Easy
        - Medium
        - Hard
        - Very Hard
        Each level has 3 text files, which gets generated randomly 
        */
    }

    //generates a random number between 0 and 2

    public static void textSelection(boolean choice){
        File file=null;
        Random rand = new Random();
        int n = rand.nextInt(3);
        if (choice==pressedHard) {
            if (n == 0) {
                file = new File("fileHard1.txt");
            } else if (n == 1) {
                file = new File("fileHard2.txt");
            } else if (n == 2) {
                file = new File("fileHard3.txt");
            }
        }
        else if (pressedVHard) {
            if (n == 0) {
                file = new File("fileVHard1.txt");
            } else if (n == 1) {
                file = new File("fileVHard2.txt");
            } else if (n == 2) {
                file = new File("fileVHard3.txt");
            }
        }
        else if (pressedMedium) {
            if (n == 0) {
                file = new File("fileMedium1.txt");
            } else if (n == 1) {
                file = new File("fileMedium2.txt");
            } else if (n == 2) {
                file = new File("fileMedium3.txt");
            }
        }
        else if (choice==true) {
            if (n == 0) {
                file = new File("fileEasy1.txt");
            } else if (n == 1) {
                file = new File("fileEasy2.txt");
            } else if (n == 2) {
                file = new File("fileEasy3.txt");
            }
        }

        try{
            lblTextOutput.setText(readFile("fileEasy1.txt"));
        } catch (IOException e) {
            System.out.println("can't load file");
        }


        /*try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //handle this
        }
        //prints out the whole file
        Scanner scanner = null;
        scanner=new Scanner("fileEasy1.txt");
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringBuilder.append(line);

            System.out.println(line);
            //return line;*/
        }
    }

