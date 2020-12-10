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
        draw(batch);
    }

    public boolean shoot(float startX, float startY, Direction direction) {
        if(!status){
            setBounds(startX, startY, getWidth(), getHeight());
            this.direction = direction;
            status = true;
            return true;
        } else {
            return false;
        }
    }

    public Bullet[] makeBullets(int count, Type type) {
        Bullet[] bullets = new Bullet[count];
        for(int i = 0; i <= count; i++ ) {
            bullets[i] = new Bullet(2,5,type);
        }

        return bullets;
    }


}
