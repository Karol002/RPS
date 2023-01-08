package com.rps;

import com.rps.elements.DataConverter;
import com.rps.elements.Game;
import com.rps.elements.Judge;
import com.rps.elements.Player;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        DataConverter dataConverter = new DataConverter();
        Player userPlayer = new Player();
        Judge judge = new Judge();
        Game game = new Game(userPlayer, new Player(), new Player(), judge);
        Scanner scan = new Scanner(System.in);

        int playersQuantity = game.getPlayerList().size();
        int roundsQuantity;
        boolean repeat = false;
        boolean end = false;

        while (!repeat) {
            System.out.println("------------THE NEW GAME STARTS------------");

            System.out.println("Enter your name");
            game.setPlayerNames(dataConverter.selectPlayersName(playersQuantity, scan.next()));
            System.out.println("How many rounds should the game have");
            roundsQuantity = scan.nextInt();
            System.out.println(game.gameInfo());

            while (!end) {
                System.out.println("\nSelect your move " + userPlayer.getName());
                System.out.println("Round result: " + game.doRoundBattleSequence(dataConverter.selectMoves
                        (playersQuantity, scan.nextInt())));
                System.out.println(game.showStatistics());
                end = judge.checkRoundsQuantity(game, roundsQuantity);
            }

            System.out.println("\n \n \n" + "---------------" + game.checkMatchWinner() + "---------------");
            System.out.println("Statistics: \n" + game.showStatistics());
            System.out.println();

            System.out.println("Do you want to repeat the game? ");
            System.out.println("If yes press n, if dont press x");
            repeat = judge.checkGameDecision(scan.next());
            end = repeat;
            game.clean();
        }
    }
}