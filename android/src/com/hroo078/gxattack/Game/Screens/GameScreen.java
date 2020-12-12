package com.hroo078.gxattack.Game.Screens;

import android.content.res.Resources;
import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.ILevel;
import com.hroo078.gxattack.Game.Levels.Level1;
import com.hroo078.gxattack.Game.Objects.Player;

public class GameScreen extends AbstractScreen {

    // graphics
    private SpriteBatch batch;
    private Texture background;
    private Texture lifeImage;
    private Label scoreLabel;
    private int backgroundOffset;

    private Stage stage;
    private Player player;
    private ILevel currentLevel;
    private boolean finishedLevel;

    public static int score;
    public static int level;


    public GameScreen() {
        GallaxyAttackGame.soundManager.playGameMusic();

        player = new Player(80,70);
        player.setTexture("ship1.png", false);
        player.setSpeed(3.15f);
        score = 0;
        level = 1;
        finishedLevel = true;

        buildStage();
    }


    public void initBackground() {
        background = new Texture("space_black.png");
        backgroundOffset = 0;

    }

    public void initLivesLabel() {
        lifeImage = new Texture("images/life.png");
    }

    public void initScoreLabel() {
        scoreLabel = new Label("Score: " + score, GallaxyAttackGame.gameSkin, "score");
        scoreLabel.setPosition(5,Gdx.graphics.getHeight() - 100);
        stage.addActor(scoreLabel);
    }

    public void drawLivesLabel() {
        batch.begin();
        for(int i = 0; i < player.lives; i++)
        {
            batch.draw(lifeImage,55*i, Gdx.graphics.getHeight() - 70, 40,40);
        }
        batch.end();
    }

    public void drawScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    public void drawBackground() {
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

    public void gameLoop(float dt) {
        player.update(dt);
        if(finishedLevel) {
            updateLevel();
        }
        currentLevel.update(dt);
        finishedLevel = currentLevel.isFinished();
    }

    public void updateLevel() {

        switch(level) {
            case 1:
                currentLevel = new Level1();
                currentLevel.initLevel();
                finishedLevel = false;
                break;
            default: break;
        }
    }
    @Override
    public void buildStage() {
        stage = new Stage();
        batch = new SpriteBatch();
        initBackground();
        initLivesLabel();
        initScoreLabel();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
        drawLivesLabel();
        drawScoreLabel();
        gameLoop(delta);
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
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
