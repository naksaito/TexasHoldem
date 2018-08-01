package com.nak.texas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nak.texas.game.GameMaster;

@Controller
@RequestMapping("/game")
public class GameController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startGame(@RequestParam int playerNum) {
        GameMaster gameMaster = new GameMaster(playerNum);
        gameMaster.gameStart();
        return gameMaster.getWinner().toString();
    }
}