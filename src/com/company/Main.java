package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        System.out.println("All set. Get ready to rumble!");
        int minNumber = 1;
        int maxNumber = 5;
        int playerRow = rnd.nextInt((maxNumber - minNumber) + 1) + minNumber;
        int playerColumn = rnd.nextInt((maxNumber - minNumber) + 1) + minNumber;
        System.out.println("Player row: " + playerRow + ";");
        System.out.println("Player column: " + playerColumn + ";");

        int[][] field = new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                field[i][j] = 0;
            }
        }
        while (true) {
            System.out.println("Give me your row");
            int numberOne = getValidNumber(minNumber,maxNumber)-1;
            System.out.println("Give me your column");
            int numberSecond = getValidNumber(minNumber,maxNumber)-1;

            field[numberOne][numberSecond] = numberOne +1 == playerRow && numberSecond +1 == playerColumn ? 2 : 1;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if(i == 0 && j!=0 ){
                        System.out.print("\t" +j  + "\t|");
                    }
                    if (j == 0 ){
                        System.out.print( i  + "\t|");
                    }
                    if (i > 0 && j > 0) {
                        switch (field[i-1][j-1]){
                            case 0:
                                System.out.print("\t-\t|");
                                break;
                            case 1:
                                System.out.print("\t*\t|");
                                break;
                            default:
                                System.out.print("\tx\t|");
                        }
                    }
                }
                System.out.println();
            }
            if (numberOne+1 == playerRow && numberSecond+1 == playerColumn) {
                System.out.println("You have won!");
                break;
            }
        }
    }
    public static int getInt () {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            System.out.println("Please enter correct number");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
    public  static int getValidNumber (int minNumber , int maxNumber){
        int detectedNumber = getInt();
        if(detectedNumber >= minNumber && detectedNumber <= maxNumber){
            return detectedNumber;
        }
        System.out.println("Please enter correct number");
        return getValidNumber(minNumber,maxNumber);
    }
}

