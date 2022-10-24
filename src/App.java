import javax.swing.*;
import java.awt.*;
import java.util.Scanner;



public class App {
    public static void main(String[] args){
        //printing test
        Refactor refactor = new Refactor();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            System.out.println(refactor.refactorLetters(input));
        }
    }

