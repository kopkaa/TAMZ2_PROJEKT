package com.hroo078.gxattack.Game.Screens;

import android.content.res.Resources;
import android.util.Log;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends AbstractScreen {

    private Camera camera;
    private Viewport viewport;

    // graphics
    private SpriteBatch batch;
    private Texture background;

    private int backgroundOffset;

    private final int WORLD_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    private final int WORLD_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;

     public GameScreen() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("space_x.png");
        backgroundOffset = 0;
        batch = new SpriteBatch();
    }

    @Override
    public void buildStage() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        movingBackground();
    }

    public void movingBackground() {
        batch.begin();

        backgroundOffset++;
        if(backgroundOffset >= WORLD_HEIGHT) {
            backgroundOffset = 0;
        }
        batch.draw(background,0,-backgroundOffset,WORLD_WIDTH, WORLD_HEIGHT);
        batch.draw(background,0,-backgroundOffset+WORLD_HEIGHT,WORLD_WIDTH, WORLD_HEIGHT);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
//         viewport.update(width, height, true);
//         batch.setProjectionMatrix(camera.combined);
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
