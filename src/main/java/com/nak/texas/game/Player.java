package com.nak.texas.game;

public class Player {
    private Cards ownCards;

    public Player() {
        ownCards = new Cards();
    }

    public Cards getCards(){
        return ownCards;
    }

    public Hand getHand() {
        return new Hand(ownCards);
    }
}
