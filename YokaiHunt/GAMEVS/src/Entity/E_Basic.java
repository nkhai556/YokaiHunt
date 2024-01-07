package Entity;


import static Game.Panel.getTilesize;
import static Game.Texture.*;
import java.awt.image.BufferedImage;


import Game.EnemyManager;

import java.awt.*;

public class E_Basic extends Enemy implements Villians {

    private int speed = 2;
    private BufferedImage sprite;
    private int width = getTilesize() * 3/2;
    private int height = getTilesize() * 3/2;
    private EnemyManager EM;
    
    
    

    public E_Basic(int x, int y, int limit,EnemyManager EM) {
        super.x = x;
        super.y = y;
        super.HP = 6;
        this.sprite = getE_BASIC();
        super.hurtbox = new Rectangle(x,y, width, height);
        super.limit = limit;
        this.EM = EM;
    }
    

    @Override
    public void shoot() {
        if (cooldown >= 120){
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
        EM.addBullet(new EB_Straight(x + getTilesize()/4, y + getTilesize()));
    }
}