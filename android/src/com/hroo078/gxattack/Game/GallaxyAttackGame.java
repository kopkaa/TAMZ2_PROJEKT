package com.hroo078.gxattack.Game;

import com.badlogic.gdx.Game;
import com.hroo078.gxattack.AndroidLauncher;
import com.hroo078.gxattack.Database.DatabaseHelper;
import com.hroo078.gxattack.Game.Screens.GameScreen;


public class GallaxyAttackGame extends Game {

	GameScreen gameScreen;

	@Override
	public void create() {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		gameScreen.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}
}
