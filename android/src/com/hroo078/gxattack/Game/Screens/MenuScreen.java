package com.hroo078.gxattack.Game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.hroo078.gxattack.Game.GallaxyAttackGame;



import java.util.ArrayList;

public class MenuScreen implements Screen {

    private Game game;
    private Stage stage;

    // Background
    private Texture background;
    private SpriteBatch batch;
    private int backgroundOffset;

    // Buttons
    private ArrayList<TextButton> menuButtons = new ArrayList<>();
    private  float BUTTON_WIDTH = 300f;
    private  float BUTTON_HEIGHT = 65;

    public MenuScreen(Game game) {
        this.game = game;
        stage = new Stage();
        initBackground();
        initButtons();
        Gdx.input.setInputProcessor(stage);
    }

    public void initBackground() {
        background = new Texture("Space_Stars2.png");
        backgroundOffset = 0;
        batch = new SpriteBatch();
    }

    private void initButtons() {

        VerticalGroup group = new VerticalGroup();
        int groupHeight = 0;

        menuButtons.add(new TextButton("Play game", GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("High Score", GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("Options", GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("About", GallaxyAttackGame.gameSkin, "default"));

        for(int i = 0; i <= menuButtons.size()-1; i++) {
            Container<TextButton> container = new Container<TextButton>(menuButtons.get(i));
            container.width(BUTTON_WIDTH);
            container.height(BUTTON_HEIGHT);
            container.padBottom(20);

            groupHeight += BUTTON_HEIGHT + 20;
            group.addActor(container);
        }

        System.out.println("GROUP HEIGHT" + groupHeight);
        group.setPosition(Gdx.graphics.getWidth() /2 - (group.getWidth() / 2),Gdx.graphics.getHeight()/2  + groupHeight / 2);

        stage.addActor(group);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        backgroundOffset++;
        if(backgroundOffset >= Gdx.graphics.getHeight()) {
            backgroundOffset = 0;
        }
        batch.draw(background,0,-backgroundOffset,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(background,0,-backgroundOffset+Gdx.graphics.getHeight(),Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
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
