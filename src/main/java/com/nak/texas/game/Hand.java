package com.nak.texas.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    protected enum HandEnum{
        RoyalStraightFlash,
        OnePair
    };

    private static final List<HandEnum> handOrder = Collections.unmodifiableList( new ArrayList<HandEnum>() {
        {
            add(HandEnum.RoyalStraightFlash);
            add(HandEnum.OnePair);
        }
    });

    private HandEnum hand;

    public Hand(HandEnum handEnum){
        this.hand = handEnum;
    }

    public Hand(Cards cards){
        // TODO: 役判定
        this.hand = HandEnum.RoyalStraightFlash;
    }

    public HandEnum getHand() {
        return hand;
    }

    public boolean isStronger(Hand hand){
        return handOrder.indexOf(this.hand) < handOrder.indexOf(hand.getHand());
    }
}
