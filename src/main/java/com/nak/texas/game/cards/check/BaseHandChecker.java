package com.nak.texas.game.cards.check;

import com.nak.texas.game.Cards;

public interface BaseHandChecker {

    /**
     * 役が成立しているかを判定するメソッドのインターフェース。<br>
     * 判定する役ごとに処理クラスを実装する。
     *
     * @param cards
     *            手札
     * @return
     */
    public boolean check(Cards[] cards);
}
