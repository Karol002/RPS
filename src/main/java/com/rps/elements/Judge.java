package com.rps.elements;

public class Judge {

    public boolean checkRoundsQuantity(Game game, int roundsQuantity) {
        return (game.getActualRound() > roundsQuantity);
    }

    public boolean checkGameDecision(String decision) {
        if (decision.equals("x") || decision.equals("X")) {
            return true;
        } else if (decision.equals("n") || decision.equals("N")) {
            return false;
        } else {
            System.out.println("Error!!! You have entered incorrect data. Ending the game");
            return true;
        }
    }

    public boolean checkResultForStone(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return ((otherPlayerMove1.equals(Figure.scissors) || otherPlayerMove2.equals(Figure.scissors)
                || otherPlayerMove1.equals(Figure.lizard) || otherPlayerMove2.equals(Figure.lizard))
                && !otherPlayerMove2.equals(Figure.paper) && !otherPlayerMove1.equals(Figure.paper)
                && !otherPlayerMove2.equals(Figure.spock) && !otherPlayerMove1.equals(Figure.spock));
    }

    public boolean checkResultForPaper(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.stone) || otherPlayerMove2.equals(Figure.stone)
                || otherPlayerMove1.equals(Figure.spock) || otherPlayerMove2.equals(Figure.spock))
                && !otherPlayerMove2.equals(Figure.scissors) && !otherPlayerMove1.equals(Figure.scissors)
                && !otherPlayerMove2.equals(Figure.lizard) && !otherPlayerMove1.equals(Figure.lizard);
    }

    public boolean checkResultForScissors(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.paper) || otherPlayerMove2.equals(Figure.paper)
                || otherPlayerMove1.equals(Figure.lizard) || otherPlayerMove2.equals(Figure.lizard))
                && !otherPlayerMove2.equals(Figure.stone) && !otherPlayerMove1.equals(Figure.stone)
                && !otherPlayerMove2.equals(Figure.spock) && !otherPlayerMove1.equals(Figure.spock);
    }

    public boolean checkResultForSpock(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.scissors) || otherPlayerMove2.equals(Figure.scissors)
                || otherPlayerMove1.equals(Figure.stone) || otherPlayerMove2.equals(Figure.stone))
                && !otherPlayerMove2.equals(Figure.lizard) && !otherPlayerMove1.equals(Figure.lizard)
                && !otherPlayerMove2.equals(Figure.paper) && !otherPlayerMove1.equals(Figure.paper);
    }

    public boolean checkResultForLizard(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.paper) || otherPlayerMove2.equals(Figure.paper)
                || otherPlayerMove1.equals(Figure.spock) || otherPlayerMove2.equals(Figure.spock))
                && !otherPlayerMove2.equals(Figure.stone) && !otherPlayerMove1.equals(Figure.stone)
                && !otherPlayerMove2.equals(Figure.scissors) && !otherPlayerMove1.equals(Figure.scissors);
    }
}