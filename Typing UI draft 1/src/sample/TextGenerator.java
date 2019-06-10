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
        */

        if (pressedHard) {
            //generates a random number between 1 and 3
            Random rand = new Random();
            int n = rand.nextInt(3);
            n += 1;

            if (n==1) {
                File file1 = new File("fileHard1.txt");
                Scanner scanner = null;

                try {
                    scanner = new Scanner(file1);
                } catch (FileNotFoundException e) {
                    //handle this
                }
                //prints out the whole file
                while (scanner.hasNextLine()) {         
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==2){
                File file2 = new File("fileHard2.txt");
                Scanner scanner2 = null;

                try {
                    scanner2 = new Scanner(file2);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==3){
                File file = new File("fileHard3.txt");
                Scanner scanner3 = null;

                try {
                    scanner3 = new Scanner(file);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner3.hasNextLine()) {
                    String line = scanner3.nextLine();
                    System.out.println(line);
                }
            }
        }
        else if (pressedVHard) {          //Same is repeated for Very Hard
            Random rand = new Random();
            int n = rand.nextInt(3);
            n += 1;

            if (n==1) {
                File file1 = new File("fileVHard1.txt");
                Scanner scanner = null;

                try {
                    scanner = new Scanner(file1);
                } catch (FileNotFoundException e) {
                    //handle this
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==2){
                File file2 = new File("fileVHard2.txt");
                Scanner scanner2 = null;

                try {
                    scanner2 = new Scanner(file2);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==3){
                File file = new File("fileVHard3.txt");
                Scanner scanner3 = null;

                try {
                    scanner3 = new Scanner(file);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner3.hasNextLine()) {
                    String line = scanner3.nextLine();
                    System.out.println(line);
                }
            }
        }
        else if (pressedMedium) {          //Same is repeated for Medium
            Random rand = new Random();
            int n = rand.nextInt(3);
            n += 1;

            if (n==1) {
                File file1 = new File("fileMedium1.txt");
                Scanner scanner = null;

                try {
                    scanner = new Scanner(file1);
                } catch (FileNotFoundException e) {
                    //handle this
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==2){
                File file2 = new File("fileMedium2.txt");
                Scanner scanner2 = null;

                try {
                    scanner2 = new Scanner(file2);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==3){              
                File file = new File("fileMedium3.txt");
                Scanner scanner3 = null;

                try {
                    scanner3 = new Scanner(file);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner3.hasNextLine()) {
                    String line = scanner3.nextLine();
                    System.out.println(line);
                }
            }
        }
        else if (pressedEasy) {           //Same is repeated for Easy
            Random rand = new Random();
            int n = rand.nextInt(3);
            n += 1;

            if (n==1) {
                File file1 = new File("fileEasy1.txt");
                Scanner scanner = null;

                try {
                    scanner = new Scanner(file1);
                } catch (FileNotFoundException e) {
                    //handle this
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==2){
                File file2 = new File("fileEasy2.txt");
                Scanner scanner2 = null;

                try {
                    scanner2 = new Scanner(file2);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    System.out.println(line);
                }
            }
            else if (n==3){
                File file = new File("fileEasy3.txt");
                Scanner scanner3 = null;

                try {
                    scanner3 = new Scanner(file);
                } catch(FileNotFoundException e) {
                    //handle this
                }
                while (scanner3.hasNextLine()) {
                    String line = scanner3.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
}
