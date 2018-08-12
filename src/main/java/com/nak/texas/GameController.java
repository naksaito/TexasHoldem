package com.nak.texas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nak.texas.constants.CommonConstants;
import com.nak.texas.game.GameMaster;

/**
 * 各view(画面)のControllerクラス。実行時やボタン押下時に呼び出される。
 * 画面ごとに分けてもいいが、今は一つにしている。
 * @author tsubasa
 * @update sugar
 *
 */
@Controller
@RequestMapping("/")
public class GameController {

	/**
	 * 実行時に自動で呼ばれる。Formを作成し初期値を代入。
	 * 「@ModelAttribute」のある関数は実行時に自動で呼ばれる。
	 * @return new GameMaster(2)
	 */
	@ModelAttribute
	GameMaster setUpForm() {
		return new GameMaster(2);
	}

	/**
	 * 「/game」をリクエストする際に呼ばれる。URL「～/game」をたたいた時など
	 * modelはspringbootの機能。画面に渡したい変数があるとき、model.addAttributeすればよい。
	 * 本クラスで作成したgameMasterフォームを受け取って、画面内に対応させている。
up	 * @param model
	 * @param gameMaster
	 * @return "/game"
	 */
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	String game(Model model, GameMaster gameMaster) {
		//"gameMaster"アトリビュートを追加し、中身に変数gameMasterを代入。
		//game画面内で"gameMaster"アトリビュートを指定(${gameMaster})することで画面からアクセスできる。
		model.addAttribute(CommonConstants.ParameterGameMaster, gameMaster);
		return CommonConstants.PathGame;
	}

	/**
	 * 「/result」をリクエストする際に呼ばれる。送信ボタン押下時など
	 * modelはspringbootの機能。画面に渡したい変数があるとき、model.addAttributeすればよい。
	 * 本クラスで作成したgameMasterフォームを受け取って、画面内に対応させている。
	 * バリデーションの結果がBindingResultに設定されるが、その結果を受け取っている
	 * @param model
	 * @param gameMaster
	 * @param result
	 * @return "/result"
	 */
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	String result(Model model, @Validated GameMaster gameMaster, BindingResult result) {
		//「バリデーションチェックでエラーがあったら」
		if (result.hasErrors()) {
			//game画面に戻る
			return game(model,gameMaster);
		}
		//"gameMaster"アトリビュートを追加し、中身にgameMasterフォームの変数playerNumにセットした値(入力値)を代入。
		//result画面内で"playerNum"アトリビュートを指定(${playerNum})することで画面からアクセスできる。
		model.addAttribute(CommonConstants.ParameterPlayerNum, gameMaster.getPlayerNum());
		return CommonConstants.PathResult;
	}
}