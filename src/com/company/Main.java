package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    static String[][] board = new String[10][10];
    private static int x;
    private static int y;
    //enables the program to check for treasure using the entered x and y coordinates later

    public static void main(String[] args) {
        int playerBalence = 0;
        Board();
        Treasure();
        BoardPrint();
        coordinates();
        checkresult();
        //this creates the private static voids to use later on
    }

    private static void Board() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = "[  ]";
                //this creates the board in a 10 x 10 format
            }
        }
    }

    private static void BoardPrint() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
            //uses for loops to print the 10 x 10 board
        }
    }

    private static void Treasure() {
        Random random = new Random();
        int amountOfTreasure = random.nextInt((75 - 25) + 1) + 25;
        for (int i = 0; i < amountOfTreasure; i++) {
            board[random.nextInt(10)][random.nextInt(10)] = "[" + (random.nextInt((99 - 10) + 1) + 10) + "]";
            //generates random amount of treasure and stores it in random positions in the array store
        }
    }

    private static void coordinates() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter a X coordinate between 0 and 10: ");
                int x = scanner.nextInt();
                System.out.println("Please enter a Y coordinate between 0 and 10: ");
                int y = scanner.nextInt();
                //gets user to enter a set of coordinates and guess where the treasure is located
                if (x >= 0 && x <= 10 && y >= 0 && y <= 10) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
                System.out.println("please enter only numbers between 0 and 10");
                //if a number greater than 10 or invalid characters are entered it will loop back because it only accepts valid board values
            }
        }
    }

    private static void checkresult() {
        System.out.println(board[x][y]);
        //the coordinates entered are checked for by the program and the amount of treasure found will be printed out
    }
}

