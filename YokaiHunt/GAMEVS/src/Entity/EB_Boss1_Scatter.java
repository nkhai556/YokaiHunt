package Entity;

import static Game.Panel.getTilesize;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.CollisionChecker;
import Game.Texture;

public class EB_Boss1_Scatter extends E_Bullet  {
    private int speed;
    private BufferedImage sprite;
    int width = getTilesize();
    int height = getTilesize();
    double angle;

    
    public EB_Boss1_Scatter (int x, int y, int angle){
        super.x = x;
        super.y = y;
        super.hitbox = new Rectangle (x,y,width,height);
        this.speed = 3;
        this.sprite = Texture.getB_SHADOWBALL();
        this.angle = (double) Math.toRadians(angle);
    }

    @Override
    public void move (){
        double resultSin = Math.sin(angle);
        double resultCos = Math.cos(angle);
        if (resultSin < 0){
            super.x += Math.ceil(speed * resultSin);
            super.hitbox.x += Math.ceil(speed * resultSin);
        }
        else if (resultSin > 0){
            super.x += Math.floor(speed * resultSin);
            super.hitbox.x += Math.floor(speed * resultSin);
        }
        else {
            super.x += speed * resultSin;
            super.hitbox.x += speed * resultSin;
        }
        if (resultCos < 0){
            super.y += Math.ceil(speed * resultCos);
            super.hitbox.y += Math.ceil(speed * resultCos);
        }
        else if (resultCos > 0){
            super.y += Math.floor(speed * resultCos);
            super.hitbox.y += Math.floor(speed * resultCos);
        }
        else{
            super.y += speed * resultCos;
            super.hitbox.y += speed * resultCos;
        }
        if (CollisionChecker.playerCollisionOnBullets(this)){
            super.stateLive = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }
}
