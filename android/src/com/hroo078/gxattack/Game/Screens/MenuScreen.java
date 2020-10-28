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

public class MenuScreen extends AbstractScreen {

    private Stage stage;

    // Background
    private Texture background;
    private Texture logo;
    private SpriteBatch batch;
    private SpriteBatch logoBatch;
    private int backgroundOffset;

    // Buttons
    private ArrayList<TextButton> menuButtons = new ArrayList<>();
    private  float BUTTON_HEIGHT = 100f;

    public MenuScreen() {
        buildStage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void buildStage() {
        stage = new Stage();
        initBackground();
        initButtons();
    }

    public void initBackground() {
        background = new Texture("Space_Stars2.png");
        backgroundOffset = 0;
        batch = new SpriteBatch();

        logo = new Texture("logo.png");
        logoBatch = new SpriteBatch();
    }

    private void initButtons() {

        VerticalGroup group = new VerticalGroup();
        int groupHeight = 0;
        int pTop;

        menuButtons.add(new TextButton("PLAY GAME", GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("SETTINGS", GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("HIGH SCORE", GallaxyAttackGame.gameSkin, "default"));
        menuButtons.add(new TextButton("ABOUT", GallaxyAttackGame.gameSkin, "default"));

        for(int i = 0; i <= menuButtons.size()-1; i++) {
            menuButtons.get(i).getLabel().setFontScale(2.15f,2.15f);
            Container<TextButton> container = new Container<TextButton>(menuButtons.get(i));

            pTop = i == 0 ? 120 : 80;
            container.padTop(pTop);

            groupHeight += BUTTON_HEIGHT + 20;
            group.addActor(container);
        }

        group.setPosition(Gdx.graphics.getWidth() /2 - group.getWidth() / 2,Gdx.graphics.getHeight()/2  + groupHeight / 2);

        stage.addActor(group);
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

    public void drawLogo() {
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
