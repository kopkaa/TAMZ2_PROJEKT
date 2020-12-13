package com.hroo078.gxattack.Game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.hroo078.gxattack.AndroidLauncher;
import com.hroo078.gxattack.Database.DatabaseHelper;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.ScreenEnum;

public class EndScreen extends MenuScreen {

    private Stage stage;

    public EndScreen() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        GallaxyAttackGame.soundManager.playGameOverSound();

        boolean isHighScore = insertScoreAndCheckRecord();

        VerticalGroup group = new VerticalGroup();
        int groupHeight = 0;

        TextButton endLabel = new TextButton("GAME OVER!", GallaxyAttackGame.gameSkin, "default");
        endLabel.getLabel().setFontScale(3.25f, 3.25f);
        Container<TextButton> container = new Container<TextButton>(endLabel);
        groupHeight += 120;
        group.addActor(container);

        if(isHighScore) {
            TextButton scoreLabel = new TextButton("Congratulations you reach high score! " + GameScreen.score, GallaxyAttackGame.gameSkin, "default");
            endLabel.getLabel().setFontScale(2f, 2f);
            container = new Container<TextButton>(scoreLabel);
            container.padTop(250);
            groupHeight += 120;
            group.addActor(container);
        }

        TextButton scoreLabel = new TextButton("Your Score: " + GameScreen.score, GallaxyAttackGame.gameSkin, "score");
        endLabel.getLabel().setFontScale(2f, 2f);
        container = new Container<TextButton>(scoreLabel);
        container.padTop(250);
        groupHeight += 120;
        group.addActor(container);

        TextButton retryButton = new TextButton("Play again", GallaxyAttackGame.gameSkin, "default");
        retryButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.GAME);
            }
        });
        retryButton.getLabel().setFontScale(2f, 2f);
        container = new Container<TextButton>(retryButton);
        container.padTop(500);
        groupHeight += 120;
        group.addActor(container);



        TextButton backButton = new TextButton("Menu", GallaxyAttackGame.gameSkin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.MAIN_MENU);
            }
        });
        backButton.getLabel().setFontScale(2f, 2f);
        container = new Container<TextButton>(backButton);
        container.padTop(50);
        group.addActor(container);

        group.setPosition(Gdx.graphics.getWidth() / 2 - group.getWidth() / 2, Gdx.graphics.getHeight() / 2 + groupHeight );
        stage.addActor(group);

    }

    public boolean insertScoreAndCheckRecord() {
        int highScore = DatabaseHelper.getInstance(AndroidLauncher.getAppContext()).getHighScore();
        DatabaseHelper.getInstance(AndroidLauncher.getAppContext()).insert(GameScreen.score);
        if(GameScreen.score > highScore ) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
        stage.draw();
    }

}
