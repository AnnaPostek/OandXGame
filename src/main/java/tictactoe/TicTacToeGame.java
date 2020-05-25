package tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("KÓŁKO I KRZYŻYK");
        System.out.println("Naciśnij ENTER, aby rozpocząć");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        Board board;
        Player playerA;
        Player playerB;

        System.out.println("Witamy w grze KÓŁKO I KRZYŻYK");

        if (Math.random() > 0.5) {
            board = new Board(Sign.X);
            playerA = new Player(Sign.X);
            playerB = new Player(Sign.O);
            System.out.println("Grę rozpoczyna gracz X");
        } else {
            board = new Board(Sign.O);
            playerA = new Player(Sign.O);
            playerB = new Player(Sign.X);
            System.out.println("Grę rozpoczyna gracz O");
        }
        board.printBoard();
        System.out.println("Wybierz pozycję:");
        int choose = sc.nextInt();
        if (choose < 0 || choose > 8) {
            System.out.println("Nieprawidłowa pozycja, wybierz ponownie");
            choose = sc.nextInt();
        }
        playerA.placeSign(board, choose);
        boolean isGameWon = false;
        Player currentPlayer;
        do {
            board.printBoard();
            currentPlayer = getCurrentPlayer(board.getCurrentSign(), playerA, playerB);
            System.out.println("Teraz ruch wykonuje gracz: " + currentPlayer);
            System.out.println("Wybierz pozycję:");
            choose = sc.nextInt();
            while (choose < 0 || choose > 8) {
                System.out.println("Nieprawidłowa pozycja, wybierz ponownie");
                choose = sc.nextInt();
            }
            currentPlayer.placeSign(board, choose);
            isGameWon = board.checkWinner(board.getCurrentSign().revers());
            if (isGameWon) {
                System.out.println("ZWYCIĘZCA, WYGRAŁ GRACZ: " + board.currentSign.revers());
            } else if (board.isBoardFull()) {
                System.out.println("REMIS!");
            }
        }
        while (!isGameWon && !board.isBoardFull());
    }

    private static Player getCurrentPlayer(Sign currentSign, Player playerA, Player playerB) {
        if (playerA.sign.equals(currentSign))
            return playerA;
        else
            return playerB;
    }
}
