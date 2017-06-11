package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.view.screen.StartView;

public class StartController {
	
	/********** gameView를 생성하고 배경음악을 재생시키는 메소드 **********/
	public void gameStart() {
		new StartView();
		BackgroundMusicSound.loop();
	}
}