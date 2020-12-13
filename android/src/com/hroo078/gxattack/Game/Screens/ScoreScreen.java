package com.hroo078.gxattack.Game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.ScreenEnum;

public class ScoreScreen extends  MenuScreen{
    private Stage stage;

    public  ScoreScreen() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        VerticalGroup group = new VerticalGroup();
        int groupHeight = 0;


        TextButton backButton = new TextButton("Back", GallaxyAttackGame.gameSkin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GallaxyAttackGame.screenManager.showScreen(ScreenEnum.MAIN_MENU);
            }
        });
        backButton.getLabel().setFontScale(3.25f, 3.25f);
        Container container = new Container<TextButton>(backButton);
        container.padTop(500);
        groupHeight += 120;
        group.addActor(container);

        group.setPosition(Gdx.graphics.getWidth() /2 - group.getWidth() / 2,Gdx.graphics.getHeight()/2  + groupHeight / 2);
        stage.addActor(group);
    }
}
