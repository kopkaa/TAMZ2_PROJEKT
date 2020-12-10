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
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hroo078.gxattack.Game.Objects.Player;

public class GameScreen extends AbstractScreen {

    // graphics
    private SpriteBatch batch;
    private Texture background;
    private int backgroundOffset;

    private Stage stage;

    private Player player;

    public static int level;
    public static int score;


    public GameScreen() {
        player = new Player(100,100);
        player.setTexture("playerShip1_red.png");
        player.setSpeed(3.15f);
        level = 1;
        score = 0;
        buildStage();
    }


    public void initBackground() {
        background = new Texture("space_black.png");
        backgroundOffset = 0;
        batch = new SpriteBatch();
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
    }

    @Override
    public void buildStage() {
        stage = new Stage();
        batch = new SpriteBatch();
        initBackground();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
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
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
