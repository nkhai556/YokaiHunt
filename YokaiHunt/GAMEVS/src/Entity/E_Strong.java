package Entity;

import static Game.Panel.getTilesize;
import static Game.Texture.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import Game.EnemyManager;

public class E_Strong extends Enemy implements Villians{
    
    private int speed = 1;
    private BufferedImage sprite;
    private int width = getTilesize() * 3;
    private int height =  getTilesize() * 3;
    private EnemyManager EM;

    public E_Strong(int x, int y, EnemyManager EM) {
        super.x = x;
        super.y = y;
        super.HP = 15;
        this.sprite = getE_STRONG();
        super.hurtbox = new Rectangle(x,y,width,height);
        this.EM = EM;
    }

    @Override
    public void shoot() {
        if (cooldown >= 150){
            addBullet();
            cooldown = 0;
        }
    }

    @Override
    public void move() {
        y+= speed;
        hurtbox.y += speed;
        cooldown ++;
        shoot();
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(sprite, x, y, width, height, null);
    }

    public void addBullet (){

        EM.addBullet(new EB_Angled(x + width/4, y + getTilesize(), 0));
        EM.addBullet(new EB_Angled(x + width/4, y + getTilesize(), 45));
        EM.addBullet(new EB_Angled(x + width/4, y + getTilesize(), -45));
        EM.addBullet(new EB_Angled(x + width/4, y + getTilesize()*2, 30));
        EM.addBullet(new EB_Angled(x + width/4, y + getTilesize()*2, -30));
    }
}