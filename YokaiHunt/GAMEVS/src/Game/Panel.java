package Game;

import Entity.*;

import java.awt.*;
import javax.swing.*;

import Input.KeyManager;
import Input.MouseManager;
import Map.*;
import Gamestates.Gamestate;
import Gamestates.MapPick;
import Gamestates.GameOver;
import Gamestates.Menu;
import Gamestates.Shop;


public class Panel extends JPanel {

    private int height = 640;
    private int width = 524;
    private static int tilesize = 32;
    KeyManager Key;
    int xdel = 0;
    int ydel = 0;

    private GameOver over;
    private Menu menu;
    private Shop shop;
    private Player player;
    private BG bg;
    private UI ui;
    private MapPick mappick;
    private EnemyManager spawn;
    private GameMap map;
    private int tick = 0;
    static int second=0;
    
    public Panel() {
        Key = new KeyManager(this);
        //this.addKeyListener(Key);
        this.addMouseListener(new MouseManager(this));
        setPanelSize();
        this.setFocusable(true);
        
        new Texture();

        this.over = new GameOver(this);
        this.menu = new Menu(this);
        
        this.bg = new BG(this);
        this.spawn = new EnemyManager(this);
        this.player = new Player(this, Key, spawn);
        this.shop = new Shop(this, player);
        this.map = new GameMap(spawn, shop);
        this.ui = new UI(this);
        this.mappick = new MapPick(this, map);
        spawn.setPlayerInfo(player);
        map.getCurrentNode().function();
        
    }

    

    private void setPanelSize() {
        Dimension size = new Dimension(width, height);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
        this.setBackground(new Color(48, 97, 181));

    }

    public void update() {

        if(Gamestate.state == Gamestate.PLAYING){
            this.requestFocus();
            tick ++;
            bg.update();
            spawn.update();
            player.update();
            if (tick >= 60){
                second ++;
                tick =0;
            }
        }
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if(Gamestate.state == Gamestate.PLAYING){
            bg.render(g);
            spawn.render(g);
            player.render(g);
            ui.render(g);
        }
        else if (Gamestate.state == Gamestate.MENU ){
            menu.draw(g);
        }
        else if (Gamestate.state == Gamestate.DEAD){
            over.draw(g);
        }
        else if (Gamestate.state == Gamestate.MAP){
            mappick.setButtons();
            mappick.draw(g);
        }
        else if (Gamestate.state == Gamestate.SHOP){
            shop.setShop();
            shop.draw(g);
        }
    }

    
    
    public static int getTilesize() {
        return tilesize;
    }

    public int returnWidth(){
        return this.width;
    }

    public int returnHeight(){
        return this.height;
    }

 
    
    public static int getSecond() {
        return second;
    }
    public static void setSecond(int second) {
        Panel.second = second;
    }

    public void reset(){
        setSecond(0);
        player.setHP(5);
        player.setX(this.getWidth()/2-tilesize);
        player.setY(this.getHeight()/2-tilesize);
        spawn.resetEnemy();
        map.mapReset();

        Gamestate.state = Gamestate.PLAYING;
    }
}

