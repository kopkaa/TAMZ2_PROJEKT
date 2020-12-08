package com.hroo078.gxattack.Game;

import android.content.res.Resources;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.hroo078.gxattack.Game.Screens.MenuScreen;
import com.hroo078.gxattack.Game.Screens.ScreenEnum;


public class GallaxyAttackGame extends Game {

	public static Skin gameSkin;
	public static Sound sound;

	@Override
	public void create() {
		gameSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		this.setScreen(ScreenEnum.MAIN_MENU.getScreen());
		sound = new Sound();
	}


	@Override
	public void render() {
		super.render();
	}


}
