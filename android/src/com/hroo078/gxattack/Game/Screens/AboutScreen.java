package com.hroo078.gxattack.Game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.hroo078.gxattack.Game.GallaxyAttackGame;

public class AboutScreen extends MenuScreen {

    private Stage stage;

    public AboutScreen() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        VerticalGroup group = new VerticalGroup();
        int groupHeight = 0;

        TextButton authorLabel = new TextButton("Author: Jan Hromadka (school project)", GallaxyAttackGame.gameSkin, "default");
        authorLabel.getLabel().setFontScale(1.15f, 2.15f);
        Container<TextButton> container = new Container<TextButton>(authorLabel);
        container.padTop(40);
        groupHeight += 120;
        group.addActor(container);

        TextButton versionlabel = new TextButton("Version: 1.0.0", GallaxyAttackGame.gameSkin, "default");
        versionlabel.getLabel().setFontScale(1.15f, 2.15f);
        container = new Container<TextButton>(versionlabel);
        container.padTop(authorLabel.getHeight() + 10);
        groupHeight += 120;
        group.addActor(container);

        TextButton backButton = new TextButton("Back", GallaxyAttackGame.gameSkin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.MAIN_MENU);
            }
        });
        backButton.getLabel().setFontScale(3.25f, 3.25f);
        container = new Container<TextButton>(backButton);
        container.padTop(500);
        groupHeight += 120;
        group.addActor(container);

        group.setPosition(Gdx.graphics.getWidth() /2 - group.getWidth() / 2,Gdx.graphics.getHeight()/2  + groupHeight / 2);
        stage.addActor(group);

//        TextButton aboutLabel = new TextButton("About", GallaxyAttackGame.gameSkin, "default");
//        aboutLabel.getLabel().setFontScale(4.75f,4.75f);
//        aboutLabel.setPosition(Gdx.graphics.getWidth() /2 - aboutLabel.getWidth() / 2, 750);
//
//        TextButton authorLabel = new TextButton("Author: Jan Hromadka (school project)", GallaxyAttackGame.gameSkin, "default");
//        aboutLabel.getLabel().setFontScale(3.75f, 3.75f);
//        aboutLabel.setPosition(Gdx.graphics.getWidth() /2 - authorLabel.getWidth() / 2, 550);
//
//
//
//        TextButton backButton = new TextButton("Back", GallaxyAttackGame.gameSkin, "default");
//        backButton.getLabel().setFontScale(3.75f,3.75f);
//        backButton.setPosition(Gdx.graphics.getWidth() /2 - backButton.getWidth() / 2, 200);
//        backButton.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.MAIN_MENU);
//
//            }
//        });
//
//        stage.addActor(authorLabel);
//        stage.addActor(aboutLabel);
//        stage.addActor(backButton);
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
