package Entity;

import java.awt.*;

public class Enemy {
    int x,y;
    int speed;
    int HP;
    int limit;
    Rectangle hurtbox;
    boolean Alive = true;
    int cooldown = 0;
    
    public void move(){
    }
    public void render(Graphics g){
    }
    public int getY(){
        return y;
    }
    public Rectangle getHurtBox(){
        return hurtbox;
    }
    public void hurt(int dmg){
        HP -= dmg;
        if (HP <= 0){
            Alive = false;
        }
    }
    public boolean getState (){
        return Alive;
    }
}
