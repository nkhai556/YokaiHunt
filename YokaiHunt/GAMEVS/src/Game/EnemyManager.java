package Game;

import Entity.*;
import Gamestates.Gamestate;

import static Game.Panel.getTilesize;
import java.awt.Graphics;
import java.util.*;

public class EnemyManager {

    private LinkedList<Enemy> enemies;
    private Enemy tempEnemy;
    private E_Bullet tempBullet;
    private LinkedList<E_Bullet> bulletList;
    private ArrayList<Integer> plan;
    private Panel panel;

    private Random rand;

    private Player player;

    public EnemyManager(Panel panel) {
        enemies = new LinkedList<Enemy>();
        bulletList = new LinkedList<E_Bullet>();
        this.panel = panel;
        this.rand = new Random();
    }

    public void update() {
        if (plan.isEmpty() == true && enemies.isEmpty() == true){
            Gamestate.state = Gamestate.MAP;
        }
        if (rand.nextInt((200 - 0) + 1) + 0 <= 2) {
            addEnemies();
        }
        for (int i = 0; i < enemies.size(); i++) {
            tempEnemy = enemies.get(i);
            if (tempEnemy.getState() != true){
                removeEnemies(tempEnemy);
            }
            if (tempEnemy.getY() > panel.getHeight()) {
                removeEnemies(tempEnemy);
            }
            tempEnemy.move();
        }
        for (int i = 0; i < bulletList.size(); i++){
            tempBullet = bulletList.get(i);
            if(tempBullet.getState() == false){
                removeBullet(tempBullet);
                Player.Damaged();
            }
            if(tempBullet.getY() > panel.getHeight()){
                removeBullet(tempBullet);
            }
            if(tempBullet.getX() <= 0 || tempBullet.getX() > panel.getWidth()){
                removeBullet(tempBullet);
            }
            tempBullet.move();
        }

    }

    public void render(Graphics g) {
        for (int i = 0; i < enemies.size(); i++) {
            tempEnemy = enemies.get(i);
            tempEnemy.render(g);
        }
        for (int i = 0; i < bulletList.size(); i++){
            tempBullet = bulletList.get(i);
            tempBullet.draw(g);
        }
    }

    public void addBullet (E_Bullet bullet){
        bulletList.add(bullet);
    }

    private void addEnemies() {
        if(plan.isEmpty() != true){
        int index = plan.getFirst();
        
        switch (index){
            case (0) -> 
                enemies.add(new E_Basic(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, panel.getHeight(), this));
            case (1) ->
                enemies.add(new E_Strong(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, this));
            case (2) ->
                enemies.add(new E_Sniper(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, panel.getHeight(),player, this));
            case (3) ->
                enemies.add(new E_Summoner(rand.nextInt(((panel.getWidth() - getTilesize()*3) - 0) + 1) + 0, -getTilesize()*2, panel.getHeight(),player, this));
            case (10) -> 
                enemies.add(new E_Boss1(player, this, panel));
            }
        plan.removeFirst();
        }
    }

    private void removeEnemies(Enemy enemy) {
        enemies.remove(enemy);
    }

    private void removeBullet (E_Bullet bullet){
        bulletList.remove(bullet);
    }

    public LinkedList<Enemy> getEnemyList (){
        return enemies;
    }
    public void setPlayerInfo(Player player){
        this.player = player;
    }
    public void resetEnemy(){
        enemies.clear();
        bulletList.clear();
    }

    public void setPlan (ArrayList<Integer> plan){
        this.plan = plan;
    }
}

