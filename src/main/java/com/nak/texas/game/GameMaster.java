package com.nak.texas.game;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Formクラスとしても使用。多分あとで分けたほうがいい。
 * ゲーム内の処理を行う。
 * @author tsubasa
 * @update sugar
 *
 */
public class GameMaster {

	//Form変数。
	//TODO クラスを分けたほうがいい
	@Min(2)
	@Max(10)
    private int playerNum = 0;		//とりあえずプレイヤーは2～10人までとした。
    private Player[] players;

    /**
     * 初期作成時の設定
     * @param playerNum
     */
    public GameMaster(int playerNum) {
        this.playerNum = playerNum;
        this.players = new Player[this.playerNum];

        if (playerNum < 2) {
            // TODO: 例外処理
            System.out.println("are you alone?");
        }
    }

    //TODO 未使用
    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players[i] = new Player();
        }
    }

    //TODO 未使用
    public boolean isGameEnd() {
        // TODO: xxx
        return false;
    }

    //TODO 未使用
    public Player getWinner() {
        Player winner = players[0];
        for (int i = 1; i < playerNum; i++) {
            if (players[i].getHand().isStronger(winner.getHand())) {
                winner = players[i];
            }
        }
        return winner;
    }

    //////////////////////////////////////////////////////
    // getter and setter
    //////////////////////////////////////////////////////
	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
}
