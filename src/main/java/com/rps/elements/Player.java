package com.rps.elements;

public class Player {
    private String name;
    private final int userID;
    static private int nextID;
    private int points = 0;
    private Figure actualMove;

    public Player() {
        nextID += 10;
        userID = nextID;
        this.name = "UnNamedPlayer" + nextID;
    }

    public void choseActualMove(int choice) {
        if (choice == 1) actualMove = Figure.stone;
        if (choice == 2) actualMove = Figure.paper;
        if (choice == 3) actualMove = Figure.scissors;
        if (choice == 4) actualMove = Figure.spock;
        if (choice == 5) actualMove = Figure.lizard;
    }

    public Figure getActualMove() {
        return actualMove;
    }

    public void addPoint() {
        points++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cleanPoints() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;

        if (userID != player.userID) return false;
        return getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + userID;
        return result;
    }
}
