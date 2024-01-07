package Entity;

import static Game.Panel.getTilesize;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.CollisionChecker;
import Game.EnemyManager;
import Game.Panel;
import Game.Texture;

public class EB_Boss1_Splash extends E_Bullet{
    private int speed;
    private BufferedImage sprite;
    private EnemyManager em;
    private Panel panel;
    int width = getTilesize()*3;
    int height = getTilesize()*3;
    double angle;

    public EB_Boss1_Splash(int x, int y, int Px, int Py, EnemyManager EM, Panel panel) {
        super.x = x;
        super.y = y;
        super.hitbox = new Rectangle (x,y,width,height);
        aiming(Py, Px);
        this.speed = 3;
        this.sprite = Texture.getB_SHADOWBALL();
        this.em = EM;
        this.panel = panel;
    }
    
    @Override
    public void move (){
        super.y += speed * Math.sin(angle);
        super.x += speed * Math.cos(angle);
        super.hitbox.y += speed * Math.sin(angle);
        super.hitbox.x += speed * Math.cos(angle);
        if ((x <= 0 || y > panel.getHeight() || x > panel.getWidth())  == true){
            explode();
        }
        if (CollisionChecker.playerCollisionOnBullets(this)){
            super.stateLive = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }
    private void aiming(int Py, int Px){
        angle = Math.atan2(Py - y, Px - x) - 0.05;
    }
    private void explode(){
        if (x <= 0){
            em.addBullet(new EB_Boss1_Scatter(x+10, y, 180));
            em.addBullet(new EB_Boss1_Scatter(x+10, y, 0));
            em.addBullet(new EB_Boss1_Scatter(x+10, y, -45));
            em.addBullet(new EB_Boss1_Scatter(x+10, y, 45));
            em.addBullet(new EB_Boss1_Scatter(x+10, y,90));
            em.addBullet(new EB_Boss1_Scatter(x+10, y, -90));
            em.addBullet(new EB_Boss1_Scatter(x+10, y, 135));
            em.addBullet(new EB_Boss1_Scatter(x+10, y, -135));
        }
        if (y > panel.getHeight()){
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, 180));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, 0));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, -45));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, 45));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10,90));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, -90));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, 135));
            em.addBullet(new EB_Boss1_Scatter(x+10, y-10, -135));
        }
        if(x > panel.getWidth()){
            em.addBullet(new EB_Boss1_Scatter(x-10, y, 180));
            em.addBullet(new EB_Boss1_Scatter(x-10, y, 0));
            em.addBullet(new EB_Boss1_Scatter(x-10, y, -45));
            em.addBullet(new EB_Boss1_Scatter(x-10, y, 45));
            em.addBullet(new EB_Boss1_Scatter(x-10, y,90));
            em.addBullet(new EB_Boss1_Scatter(x-10, y, -90));
            em.addBullet(new EB_Boss1_Scatter(x-10, y, 135));
            em.addBullet(new EB_Boss1_Scatter(x-10, y, -135));
        }
    }
}
