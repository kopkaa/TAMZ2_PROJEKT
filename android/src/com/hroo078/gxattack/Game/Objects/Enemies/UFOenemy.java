package com.hroo078.gxattack.Game.Objects.Enemies;

public class UFOenemy extends Enemy {

    public UFOenemy(float width, float height) {
        super(width, height);
        speed = 5.15f;
        setTexture("enemyBlack1.png",true);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
    }
}
