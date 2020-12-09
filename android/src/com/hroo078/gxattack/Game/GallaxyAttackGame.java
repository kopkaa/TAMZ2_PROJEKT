package com.hroo078.gxattack.Game;

import android.content.res.Resources;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.hroo078.gxattack.Game.Helpers.Sound;
import com.hroo078.gxattack.Game.Screens.ScreenEnum;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.hroo078.gxattack.Game.Helpers.AssetManager;
import com.hroo078.gxattack.Game.Screens.ScreenEnum;
import com.hroo078.gxattack.Game.Screens.ScreenManager;


public class GallaxyAttackGame extends Game {

	public static Skin gameSkin;
	public static Sound sound;
	public static AssetManager assetManager = new AssetManager();
	public static ScreenManager screenManager;

	@Override
	public void create() {
		gameSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		screenManager = new ScreenManager(this);
		screenManager.showScreen(ScreenEnum.MAIN_MENU);;
		sound = new Sound();
	}


	@Override
	public void render() {
		super.render();
	}


}
