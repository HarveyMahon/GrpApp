package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Selection {
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

    public static String textSelection(String pressed) throws IOException {
        File file=null;
        Random rand = new Random();
        int n = rand.nextInt(3);
        if (pressed == "Hard") {
            if (n == 0) {
                file = new File("fileHard1.txt");
            } else if (n == 1) {
                file = new File("fileHard2.txt");
            } else if (n == 2) {
                file = new File("fileHard3.txt");
            }
        }
        else if (pressed == "VHard") {
            if (n == 0) {
                file = new File("fileVHard1.txt");
            } else if (n == 1) {
                file = new File("fileVHard2.txt");
            } else if (n == 2) {
                file = new File("fileVHard3.txt");
            }
        }
        else if (pressed == "Medium") {
            if (n == 0) {
                file = new File("fileMedium1.txt");
            } else if (n == 1) {
                file = new File("fileMedium2.txt");
            } else if (n == 2) {
                file = new File("fileMedium3.txt");
            }
        }
        else if (pressed == "Easy") {
            if (n == 0) {
                file = new File("fileEasy1.txt");
            } else if (n == 1) {
                file = new File("fileEasy2.txt");
            } else if (n == 2) {
                file = new File("fileEasy3.txt");
            }
        }
        else {
            System.out.println(pressed);
            System.out.println("no if hit");
            file = new File("fileEasy3.txt");
        }
        return Files.readAllLines(Paths.get(file.getAbsolutePath())).get(0);
        }
    }

