package com.hroo078.gxattack.Game.Objects;

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
        this.type = type;
        this.status = false;
    }

    public boolean shoot(float startX, float startY, Direction direction) {
        if(!status){
            setBounds(startX, startY, getWidth(), getHeight());
            this.direction = direction;
            status = true;
            return true;
        }

        return false;
    }


}
