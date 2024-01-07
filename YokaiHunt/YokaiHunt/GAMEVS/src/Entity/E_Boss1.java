package Entity;

import static Game.Panel.getTilesize;
import static Game.Texture.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import Game.EnemyManager;
import Game.Panel;

public class E_Boss1 extends Enemy {
    private int t = 0;
    private BufferedImage sprite;
    private int width = getTilesize() * 6;
    private int height = getTilesize() * 6;
    private Player player;
    private EnemyManager EM;
    private Random R;
    private int splashCount = 0;
    private int index = 0;
    private int splashtick = 0;
    private int scatterCount = 0;
    private int scattertick = 0;
    private Panel panel;

    public E_Boss1(Player player, EnemyManager EM, Panel panel) {
        super.x = panel.getWidth()/2 ;
        super.y = 0;
        super.HP = 250;
        this.sprite = getBOSS_1();
        super.hurtbox = new Rectangle(x+60, y, width-120, height-20);
        this.player = player;
        this.EM = EM;
        this.R = new Random();
        this.panel = panel;
    }


    @Override
    public void move() {
        x = (int) (10 * Math.cos (t/18) + width -20);
        y = (int) (10 * Math.sin (t/12)/2 -10);
        hurtbox.x = (int) (10 * Math.cos (t/18) + width -20 +60);
        hurtbox.y = (int) (10 * Math.sin (t/12)/2 -10);
        t++;
        if (cooldown >= 250){
        shoot(index);
        }
        cooldown++;
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(sprite, x, y, width, height, null);
    }

    public void shoot(int index) {
        if (index == 0){
            B_Pattern1();
        }
        if (index == 1){
            B_Pattern2();
        }
        
    }
    private void B_Pattern2(){
        if (splashCount < 5){
            if (splashtick >= 40){
                EM.addBullet(new EB_Boss1_Splash(x + 90, height-20, player.getPlayerX(), player.getPlayerY(), EM, panel));
                splashtick = 0;
                splashCount++;
            }
        splashtick++;
            }
        else if (splashCount == 5){
            splashCount = 0;
            cooldown = 0;
            index = R.nextInt(2);
        }
        
    }

    private void B_Pattern1(){
        if (scatterCount < 30){
            if (scattertick >= 5){
              EM.addBullet(new EB_Boss1_Scatter(x + 90, height-20, R.nextInt(90 - (-90)) - 90));
              scattertick = 0;
              scatterCount++;
            }
            scattertick++;
        }
        else if (scatterCount == 30){
            scatterCount = 0;
            cooldown = 0;
            index = R.nextInt(2);
        }
    }
    public void addBullet (int Px, int Py){
    
    }
}
