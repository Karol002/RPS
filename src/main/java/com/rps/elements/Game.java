package com.rps.elements;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Game {
    private final List<Player> playerList = new ArrayList<>();
    private final Judge judge;
    private int actualRound = 1;

    public Game(Player player, Player computer1, Player computer2, Judge judge) {
        this.playerList.add(player);
        this.playerList.add(computer1);
        this.playerList.add(computer2);
        this.judge = judge;
    }

    public String doRoundBattleSequence(int [] playersMoves) {
        Deque<Figure> battleDeque = new ArrayDeque<>();
        StringBuilder winnersLog = new StringBuilder();
        int playerNumber = 0;

        setPlayersMove(playersMoves);

        for (Player thePlayer : playerList) {
            for (Player checkingPlayer : playerList){
                if (!thePlayer.equals(checkingPlayer)) battleDeque.add(checkingPlayer.getActualMove());
            }
            winnersLog.append(doSingleMoveInBattle(thePlayer.getActualMove(),
                    battleDeque.poll(), battleDeque.poll(), playerNumber));
            playerNumber++;
        }

        actualRound++;
        if (winnersLog.toString().equals("")) return "There is no winners in this round";
        else return "Winners: " + winnersLog;
    }

    private String doSingleMoveInBattle(Figure actualPlayerMove, Figure otherPlayerMove1, Figure otherPlayerMove2, int playerNumber) {

        if (actualPlayerMove.equals(Figure.stone) && judge.checkResultForStone(otherPlayerMove1, otherPlayerMove2)) {
            return getBattleWinner(playerNumber);
        }
        else if (actualPlayerMove.equals(Figure.paper) && judge.checkResultForPaper(otherPlayerMove1, otherPlayerMove2)) {
            return getBattleWinner(playerNumber);
        }
        else if (actualPlayerMove.equals(Figure.scissors) && judge.checkResultForScissors(otherPlayerMove1, otherPlayerMove2)) {
            return getBattleWinner(playerNumber);
        }
        else if (actualPlayerMove.equals(Figure.spock) && judge.checkResultForSpock(otherPlayerMove1, otherPlayerMove2)) {
            return getBattleWinner(playerNumber);
        }
        else if (actualPlayerMove.equals(Figure.lizard) && judge.checkResultForLizard(otherPlayerMove1, otherPlayerMove2)) {
            return getBattleWinner(playerNumber);
        }
        else return "";
    }

    private String getBattleWinner(int playerNumber) {
        playerList.get(playerNumber).addPoint();
        return playerList.get(playerNumber).getName() + " ";
    }

    private void setPlayersMove(int [] playersMoves) {
        for (int i=0; i<playerList.size(); i++) {
            playerList.get(i).choseActualMove(playersMoves[i]);
        }
    }

    public String showStatistics() {
        StringBuilder statistics = new StringBuilder("Round " + (actualRound - 1));
        for(Player thePlayer : playerList) {
            statistics.append("\n").append(thePlayer.getName()).append(" points: ").append(thePlayer.getPoints());
        }
        return statistics.toString();
    }

    public String checkMatchWinner() {
        StringBuilder winner = new StringBuilder("Match winners: ");
        int theBiggestPointsQuantity = 0;
        int winnersQuantity = 0;

        for (Player thePlayer : playerList) {
            if (thePlayer.getPoints() > theBiggestPointsQuantity) theBiggestPointsQuantity = thePlayer.getPoints();
        }
        for (Player thePlayer : playerList) {
            if (thePlayer.getPoints() == theBiggestPointsQuantity) {
                winner.append(thePlayer.getName()).append(" ");
                winnersQuantity++;
            }
        }

        if (winnersQuantity >= playerList.size()) return "Draw!";
        else return winner.toString();
    }

    public void setPlayerNames(String [] names) {
        for (int i=0; i<playerList.size(); i++) {
            playerList.get(i).setName(names[i]);
        }
    }

    public void clean() {
        actualRound = 1;
        for (Player thePlayer : playerList) {
            thePlayer.cleanPoints();
        }
    }

    public int getActualRound() {
        return actualRound;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public String gameInfo() {
        return """
                1 key – playing stone
                2 key – playing paper
                3 key – playing scissors
                4 key – playing spock
                5 key – playing lizard
                x key – the end of the game preceded by the question
                Are you sure to end the game?
                n key – starting the game from scratch preceded by the question
                Are you sure to end the current game?""";
    }
}
