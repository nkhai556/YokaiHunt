package Entity;


import Game.CollisionChecker;
import Game.EnemyManager;
import Game.Game;
import Game.Panel;
import Gamestates.Gamestate;

import static Game.Panel.getTilesize;
import static Game.Texture.*;
import Input.KeyManager;
import Items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

public class Player {

    private KeyManager Key;
    private Panel panel;
    private static int HP = 5;
    private int x = 200;
    private int y = 300;
    private int speed = 5;
    private int dmg = 1;
    private int cd = 7;
    private static Rectangle hurtbox;
    private BufferedImage sprite;
    private LinkedList<P_Bullet> b;
    private P_Bullet TempBullet;
    private EnemyManager enemyM;
    private LinkedList<Enemy> enemies;
    private ArrayList<Item> bag;
    private Enemy tempEnemy;
    private int width;
    private int height;
    private int tick = 0;
    private int invtick = 0;
    private static boolean isInvin = false;

    public Player(Panel panel, KeyManager Key, EnemyManager EnemyM) {
        this.b          = new LinkedList<>();
        this.panel      = panel;
        this.Key        = Key;
        this.sprite     = getPlayer();
        this.enemyM     = EnemyM;
        this.enemies    = EnemyM.getEnemyList();
        this.bag        = new ArrayList<>();
        this.width      = getTilesize() * 2;
        this.height     = getTilesize() * 2;
        hurtbox         = new Rectangle (x + width/4 + width/8, y + width/3, width/4,height/4);
    }

    public void update() {
        //Bullet collision check
        for (int i = 0; i < b.size(); i++) {
            TempBullet = b.get(i);

            for (int j = 0; j<enemyM.getEnemyList().size(); j++){
                if(CollisionChecker.CollisionOn(enemies.get(j), TempBullet)){
                    System.out.println("Collision Detected");
                    enemies.get(j).hurt(TempBullet.getDamage());
                    removeBullet(TempBullet);
                }
            }
            
            if (TempBullet.getY() < 0) {
                removeBullet(TempBullet);
            }
            TempBullet.move();
        }
        //Collision check
        for (int i = 0; i<enemyM.getEnemyList().size(); i++){
            tempEnemy = enemies.get(i);
            if(CollisionChecker.playerCollisionOnEnemies(tempEnemy)){
                if(isInvin == false){
                System.out.println("Collision Detected");
                Damaged();
                isInvin = true;
                }
            }
        }
        if (isInvin == true){
            invtick++;
            if (invtick >= 120){
                isInvin = false;
                invtick = 0;
            }
        }
        //Keypress check
        if (Key.downPressed) {
            moveDown();
        } else if (Key.upPressed) {
            moveUp();
        } else if (Key.leftPressed) {
            moveLeft();
        } else if (Key.rightPressed) {
            moveRight();
        }
        if (Key.shootPressed) {
            tick ++;
            if (tick == 1 || tick >= cd){
                shoot();
                tick = 1;
            }
        }
    }
    //rendering method
    public void render(Graphics g) { 
        g.drawImage(sprite, x, y, width, height, null);
        for (int i = 0; i < b.size(); i++) {
            TempBullet = b.get(i);
            TempBullet.draw(g);
        }
        
    }


    //adding bullet to the list so it can move and render
    private void shoot() {
        b.add(new P_Bullet(x + width/4, y - width/2, dmg));
    }

    //control
    private void moveRight() {
        if (x + getTilesize() < panel.getWidth()) {
            this.x += speed;
            hurtbox.x += speed;
        }
    }
    private void moveLeft() {
        if (x > 0) {
            this.x -= speed;
            hurtbox.x -= speed;
        }
    }
    private void moveUp() {
        if (y > 0) {
            this.y -= speed;
            hurtbox.y -= speed;
        }
    }
    private void moveDown() {
        if (y + getTilesize() < panel.getHeight()) {
            this.y += speed;
            hurtbox.y += speed;
        }
    }

    //Reduce HP when hit
    public static void Damaged() {
        if (isInvin == false){
            HP--;
            isInvin = true;
            if(HP>=0){
                System.out.println(HP + " HP left");
            }

            if(HP==0){
                System.out.println("You are dead!");
                System.out.print("You've survived for: "+ Panel.getSecond()+" seconds!\n");
                Gamestate.state = Gamestate.DEAD;
            //Game.stopGameLoop();   
            }
        }
    }

    public void addItem (Item item){
        bag.add(item);
        useItem();
    }
    private void useItem (){
        for (int i = 0; i< bag.size(); i++){
            bag.get(i).FX(this);
        }
        bag.clear();
    }

    //remove bullet out of list to make it disappear
    private void removeBullet(P_Bullet bill) {
        this.b.remove(bill);
    }

    //get methods (only these are pulic)
    public int getPlayerX (){
        return x;
    }
    public int getPlayerY (){
        return y;
    }

    public void setX(int x) {
        this.x = x;
        hurtbox.x = x + width/4 + width/8;
    }
    public void setY(int y) {
        this.y = y;
        hurtbox.y = y + width/4 + width/8;
    }
    
    public static Rectangle getHurtBox (){
        return hurtbox;
    }

    public static int getHP() {
        return HP;
    }
    public void setHP(int hP) {
        HP = hP;
    }
    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    public int getCD() {
        return cd;
    }
    public void setCD(int cd) {
        this.cd = cd;
    }
}