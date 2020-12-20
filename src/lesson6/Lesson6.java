package lesson6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lesson6 {
    public static void main(String[] args) throws IOException {
        CreateFiles("First.txt", "Second.txt");
        CreateNewMergeFiles("First.txt", "Second.txt", "Finish.txt");
       // System.out.println(WordInFile("Finish.txt"));
        System.out.println(fileContainsWord("Finish.txt"));

    }

    public static boolean fileContainsWord(String finish) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        return new String(Files.readAllBytes(Paths.get(finish))).contains(word); //покапался в интернете, посмотрел какие еще методы существуют
    }

    public static void CreateFiles (String file1, String file2) {
        try {
            FileOutputStream fos = new FileOutputStream(file1);
            FileOutputStream fos1 = new FileOutputStream(file2);

            PrintStream ps = new PrintStream(fos);
            ps.println("Я помню чудное мгновенье:\n" +
                    "Передо мной явилась ты,\n" +
                    "Как мимолетное виденье,\n" +
                    "Как гений чистой красоты.");
            ps.close();
            fos.flush();
            fos.close();

            PrintStream ps1 = new PrintStream(fos1);

            ps1.println("В томленьях грусти безнадежной,\n" +
                    "В тревогах шумной суеты,\n" +
                    "Звучал мне долго голос нежный\n" +
                    "И снились милые черты.");
            ps1.close();
            fos1.flush();
            fos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CreateNewMergeFiles (String file1, String file2, String finishFile) {
        try {
            FileOutputStream fos = new FileOutputStream(finishFile);
            int ch;
            FileInputStream fis = new FileInputStream(file1);
            while ((ch = fis.read()) != -1)
                fos.write(ch);
            fis.close();

            fis = new FileInputStream(file2);
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            fis.close();

            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*   private static boolean WordInFile(String finish) throws IOException {
        FileInputStream fis = new FileInputStream(finish);
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        byte[] arr = word.getBytes();
        int ch;
        byte i = 0;
        byte memory = 0;
        while ((ch = fis.read()) != -1) {  //попытался как на уроке считать побайтово, но все равно
            if (ch == arr[i]) {            //результатом выдает false, почему не могу понять ;((
                i++;
            } else {
                memory = i;
                i = 0;
            }
            if (memory == arr.length) {
                fis.close();
                return true;
            }
        }
        fis.close();
        return false;
    }

  */
}
