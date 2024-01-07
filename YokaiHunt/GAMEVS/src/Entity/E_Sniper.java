package Entity;

import static Game.Panel.getTilesize;
import static Game.Texture.*;
import java.awt.image.BufferedImage;

import Game.EnemyManager;

import java.awt.*;

public class E_Sniper extends Enemy implements Villians {
    
    private int speed = 7;
    private BufferedImage sprite;
    private int width = getTilesize() * 2;
    private int height = getTilesize() * 2;
    private Player player;
    private EnemyManager EM;

    
    
    

    public E_Sniper(int x, int y, int limit, Player player, EnemyManager EM) {
        super.x = x;
        super.y = y;
        super.HP = 10;
        this.sprite = getE_SNIPER();
        super.hurtbox = new Rectangle(x,y,width,height);
        super.limit = limit;
        this.player = player;
        this.EM = EM;
    }
    

    @Override
    public void shoot() {
        if (cooldown >= 120){
            addBullet(player.getPlayerX(), player.getPlayerY());
            cooldown = 0;
        }
    }

    @Override
    public void move() {
        if(y < limit * 0.15){
            y+= speed;
            hurtbox.y += speed;
        }
        else {
            cooldown ++;
            shoot();
        }
       
        
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(sprite, x, y, width, height, null);
    }

    public void addBullet (int Px, int Py){
        EM.addBullet(new EB_Aim(x + width/4, y + getTilesize(), Px, Py));
    }
}
