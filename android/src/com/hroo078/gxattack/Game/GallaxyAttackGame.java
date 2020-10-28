package com.hroo078.gxattack.Game;

import android.content.res.Resources;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.hroo078.gxattack.Game.Screens.MenuScreen;
import com.hroo078.gxattack.Game.Screens.ScreenEnum;


public class GallaxyAttackGame extends Game {

	static public Skin gameSkin;

	@Override
	public void create() {
		gameSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		this.setScreen(ScreenEnum.MAIN_MENU.getScreen());
	}


	@Override
	public void render() {
		super.render();
	}


}
