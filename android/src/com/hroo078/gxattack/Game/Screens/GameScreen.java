package com.hroo078.gxattack.Game.Screens;

import android.util.Log;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private Camera camera;
    private Viewport viewport;

    // graphics
    private SpriteBatch batch;
    private Texture background;

    private int backgroundOffset;

    private final int WORLD_WIDTH = 220;
    private final int WORLD_HEIGHT = 640;

     public GameScreen() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        background = new Texture("darkPurpleStarscape.png");
        backgroundOffset = 0;
        batch = new SpriteBatch();

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();

        backgroundOffset++;

        Log.i("WTF", String.valueOf(backgroundOffset));
        batch.draw(background,0,-backgroundOffset,WORLD_WIDTH, WORLD_HEIGHT);
        batch.draw(background,0,-backgroundOffset+WORLD_HEIGHT,WORLD_WIDTH, WORLD_HEIGHT);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
         viewport.update(width, height, true);
         batch.setProjectionMatrix(camera.combined);
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
