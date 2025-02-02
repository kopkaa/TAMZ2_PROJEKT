package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hroo078.gxattack.Game.Interfaces.Direction;
import com.hroo078.gxattack.Game.Interfaces.Type;

public class Bullet extends GameObject{


    private Type type;


    public Bullet(float width, float height, Type type) {
        super(width, height);
        if(type == Type.ENEMY) {
            setTexture("laserRed16.png", true);
        } else {
            setTexture("laserBlue16.png", true);
        }
        this.type = type;
    }

    private void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(sheetTexture, getPosX(), getPosY(), width, height);
        batch.end();
    }



    public void update(float dt) {
        if(type == Type.PLAYER) {
            setPosY(getPosY() + 10);
        } else {
            setPosY(getPosY() - 10);
        }
        draw(batch);
    }



}
