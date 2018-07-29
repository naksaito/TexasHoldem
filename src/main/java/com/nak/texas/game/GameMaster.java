package com.nak.texas.game;

public class GameMaster {

    private int playerNum;
    private Player[] players;

    public GameMaster(int playerNum) {
        this.playerNum = playerNum;
        this.players = new Player[this.playerNum];

        if (playerNum < 2) {
            // TODO: 例外処理
            System.out.println("are you alone?");
        }
    }

    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players[i] = new Player();
        }
    }

    public boolean isGameEnd() {
        // TODO: xxx
        return false;
    }

    public Player getWinner() {
        Player winner = players[0];
        for (int i = 1; i < playerNum; i++) {
            if (players[i].getHand().isStronger(winner.getHand())) {
                winner = players[i];
            }
        }
        return winner;
    }
}
