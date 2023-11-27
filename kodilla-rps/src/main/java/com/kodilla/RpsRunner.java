package com.kodilla;

import com.kodilla.rps.RpsGame;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoję imię:");
        String playerName = scanner.nextLine();

        System.out.println("Podaj liczbę rund by wygrać grę:");
        int roundsToWin = scanner.nextInt();

        RpsGame game = new RpsGame(playerName, roundsToWin);
        game.startGame();
    }
}