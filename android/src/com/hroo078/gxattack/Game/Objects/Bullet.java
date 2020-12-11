package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hroo078.gxattack.Game.Interfaces.Direction;
import com.hroo078.gxattack.Game.Interfaces.Type;

public class Bullet extends GameObject{

    private Direction direction;
    private float speed;
    private boolean status;
    private Type type;
    private int damage = 1;

    public Bullet(int width, int height, Type type) {
        super(width, height);
        if(type == Type.ENEMY) {
            setTexture("laserBlue16.png");
        } else {
            setTexture("laserBlue16.png");
        }
        this.type = type;
        this.status = false;
    }

    private void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(objectTexture, getPosX(), getPosY(), width, height);
        batch.end();
    }

    public void update(float dt) {
        setPosY(getPosY() + 10);
        draw(batch);
    }


}
