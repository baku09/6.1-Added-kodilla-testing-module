package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {
    private final Scanner scanner;
    private final Random random;
    private final String playerName;

    private final int roundsToWin;
    private int playerWins;
    private int computerWins;

    public RpsGame(String playerName, int roundsToWin){
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.playerName = playerName;
        this.roundsToWin = roundsToWin;
        this.playerWins = 0;
        this.computerWins = 0;
    }

    public void startGame(){
        System.out.println("Witaj " + playerName + " w grze papier,kamień i nożyce");

        while (!isGameEnd()) {
            playRound();
        }
        displayGameSummary();
    }
    private void playRound(){
        System.out.println("Wybierz jakie zagranie wybierasz: 1 - kamień, 2 - papier, 3 - nożyce, " +
                "x - zakończ grę, n - zacznij grę od nowa");

        char playerMove = scanner.next().charAt(0);

        if (playerMove == 'x'){
            endGame();
            return;
        } else if (playerMove == 'n'){
            restartGame();
            return;
        }
        char computerMove = generateComputerMove();

        displayRoundResult(playerMove, computerMove);
    }
    private char generateComputerMove(){
        int randoMove = random.nextInt(3) +1;
        return switch (randoMove) {
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            default -> throw  new IllegalStateException("Zła wartość wybrana " + randoMove);
        };
    }
    private void displayRoundResult(char playerMove, char computerMove){
        System.out.println("Ruch komputera: " + computerMove);
        System.out.println("Twój ruch: " + playerMove);

        if (computerMove == playerMove) {
            System.out.println("W tej rundzie jest remis");
        } else if ((playerMove == '1' && computerMove == '3') ||
                   (playerMove == '2' && computerMove == '1') ||
                   (playerMove == '3' && computerMove == '2')) {
            System.out.println("Wygrywasz tą rundę");
            playerWins++;
        } else {
            System.out.println("Przegrywasz rudnę");
            computerWins++;
        }
        displayCurrentScore();
    }
    private void displayCurrentScore(){
        System.out.println("Wynik: " + playerName + " " + playerWins + ", komputer " + computerWins);
    }
    private boolean isGameEnd(){
        return playerWins == roundsToWin || computerWins == roundsToWin;
    }
    private void displayGameSummary(){
        System.out.println("Koniec Gry!");
        if (playerWins == roundsToWin){
            System.out.println("Wygrywasz grę, Gratulacje.");
        } else {
            System.out.println("Przegrałeś grę.");
        }
    }
    private void endGame(){
        System.out.println("Czy na pewno chcesz zakończyć grę? t - tak , n - nie");
        char choice = scanner.next().charAt(0);
        if (choice == 't'){
            System.exit(0);
        }
    }
    private void restartGame(){
        System.out.println("Czy zrestartować aktualną grę? t - tak, n - nie");
        char choice = scanner.next().charAt(0);
        if (choice == 't'){
            playerWins = 0 ;
            computerWins = 0;
        }
    }

}
