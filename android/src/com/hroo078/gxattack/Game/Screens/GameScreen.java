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
    private final float TOUC_MOVEMENT_TRESHOLD = 1.5f;


    public GameScreen() {
        player = new Player(40,40);
        player.setTexture("playerShip1_red.png");
        buildStage();
    }

    @Override
    public void buildStage() {
        stage = new Stage();
        batch = new SpriteBatch();
        initBackground();
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

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
        handleInput(delta);
        player.draw(batch);
        stage.draw();
    }

    public void handleInput(float deltaTime) {
        float rightLimit, leftLimit,upLimit, downLimit;
        leftLimit = -player.getPosX();
        downLimit = - player.getPosY();
        rightLimit = Gdx.graphics.getWidth() - player.getPosX() - player.getWidth();
        upLimit = Gdx.graphics.getHeight() / 2 - player.getPosY() - player.getHeight();

        if(Gdx.input.isTouched()) {
            float xTouchPixels = Gdx.input.getX();
            float yTouchPixels = Gdx.input.getY();

            Vector2 touchPoint = new Vector2(xTouchPixels, yTouchPixels);
            touchPoint = getViewport().unproject(touchPoint);

            Vector2 playerShipCentre = new Vector2(player.getPosX() + player.getWidth(), player.getPosY() + player.getHeight());

            float touchDistance = touchPoint.dst(playerShipCentre);
            if(true) {
                float xTouchDiff = touchPoint.x - playerShipCentre.x;
                float yTouchDiff = touchPoint.y - playerShipCentre.y;

                float xMove = xTouchDiff / touchDistance * 2 * deltaTime;
                float yMove = yTouchDiff / touchDistance * 2* deltaTime;

                if(xMove > 0) {
                    xMove = Math.min(xMove, rightLimit);
                } else {
                    xMove = Math.max(xMove, leftLimit);
                }

                if(yMove > 0) {
                    yMove = Math.min(yMove, upLimit);
                } else {
                    yMove = Math.max(yMove, downLimit);
                }
                player.moveBy(1, 1);
                Log.v("ccc", "handleInput: " + xMove);
                Log.v("ccc", "handleInput: " + yMove);
            }
        }
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
