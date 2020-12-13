package com.hroo078.gxattack.Game.Screens;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.ScreenEnum;


import java.util.ArrayList;

public class MenuScreen extends AbstractScreen {

    private Stage stage;
    private boolean paused;

    // Background
    protected Texture background;
    protected Texture logo;
    protected SpriteBatch batch;
    protected SpriteBatch logoBatch;
    protected int backgroundOffset;

    // Buttons
    private ArrayList<TextButton> menuButtons = new ArrayList<>();

    public MenuScreen() {
        Log.i("ZDE", "Construct");
        buildStage();
        Gdx.input.setInputProcessor(stage);
        GallaxyAttackGame.soundManager.playMenuMusic();
    }

    @Override
    public void buildStage() {
        stage = new Stage();
        initBackground();
        initButtons();
    }

    protected void initBackground() {
        background = new Texture("space_black.png");
        backgroundOffset = 0;
        batch = new SpriteBatch();

        logo = new Texture("logo.png");
        logoBatch = new SpriteBatch();
    }

    private void initButtons() {

        VerticalGroup group = new VerticalGroup();
        int groupHeight = 0;
        int pTop;

        TextButton about = new TextButton("ABOUT", GallaxyAttackGame.gameSkin, "default");
        TextButton newGame = new TextButton("PLAY GAME", GallaxyAttackGame.gameSkin, "default");
        TextButton score = new TextButton("HIGH SCORE", GallaxyAttackGame.gameSkin, "default");

        about.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.ABOUT);
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.soundManager.stopMenuMusic();
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.GAME);
            }
        });

        score.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.SCORE);
            }
        });

        menuButtons.add(newGame);
        menuButtons.add(score);
        menuButtons.add(about);

        for(int i = 0; i <= menuButtons.size()-1; i++) {
            menuButtons.get(i).getLabel().setFontScale(2.15f,2.15f);
            Container<TextButton> container = new Container<TextButton>(menuButtons.get(i));

            pTop = i == 0 ? 120 : 80;
            container.padTop(pTop);

            groupHeight += 120;
            group.addActor(container);
        }

        group.setPosition(Gdx.graphics.getWidth() /2 - group.getWidth() / 2,Gdx.graphics.getHeight()/2  + groupHeight / 2);

        stage.addActor(group);
    }

    protected void drawBackground() {
        batch.setProjectionMatrix(getCamera().combined);
        batch.begin();

        backgroundOffset += 3;
        if(backgroundOffset >= Gdx.graphics.getHeight()) {
            backgroundOffset = 0;
        }

        batch.draw(background,0,-backgroundOffset,Gdx.graphics.getHeight(), Gdx.graphics.getHeight());
        batch.draw(background,0,-backgroundOffset+Gdx.graphics.getHeight(),Gdx.graphics.getHeight(),Gdx.graphics.getHeight());
        batch.end();
    }

    protected void drawLogo() {
        int posY = Gdx.graphics.getHeight() - logo.getHeight() - 50;
        logoBatch.begin();
        logoBatch.draw(logo, Gdx.graphics.getWidth() /2 - logo.getWidth() / 2, posY );
        logoBatch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
        drawLogo();
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        getViewport().update(width,height,true);
    }

    @Override
    public void pause() {
        paused = true;
        GallaxyAttackGame.soundManager.stopMenuMusic();
    }

    @Override
    public void resume() {
        paused = false;
        GallaxyAttackGame.soundManager.playMenuMusic();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
