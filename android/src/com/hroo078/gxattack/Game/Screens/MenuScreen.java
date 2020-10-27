package com.hroo078.gxattack.Game.Screens;

import android.view.InputEvent;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.hroo078.gxattack.Game.GallaxyAttackGame;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuScreen implements Screen {

    private Game game;
    private Stage stage;
    private ArrayList<TextButton> menuButtons = new ArrayList<TextButton>();

    public MenuScreen(Game game) {
        this.game = game;
        stage = new Stage();
        initButtons();
        Gdx.input.setInputProcessor(stage);
    }

    private void initButtons() {

        menuButtons.add(new TextButton("Play game",GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("High Score",GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("Options",GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("About",GallaxyAttackGame.gameSkin, "default"));





//        for(int i=0; i<=3; i++) {
//            TextButton btn = new TextButton("css",GallaxyAttackGame.gameSkin, "default");
//            btn.setWidth(200f);
//            btn.setHeight(20f);
//            btn.setPosition(Gdx.graphics.getWidth() / 2 - 50*i, Gdx.graphics.getHeight() / 2 - 10*i);
//            stage.addActor(btn);
//        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
