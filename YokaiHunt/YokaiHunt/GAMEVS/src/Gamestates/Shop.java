package Gamestates;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import Entity.Player;
import Game.Panel;
import Items.HealthPot;
import Items.Item;
import Items.Sword;
import Items.Talisman;

public class Shop implements Statemethod,ActionListener {

    Panel panel;
    Player player;
    ArrayList<JButton> slots;
    ArrayList<Integer> shoppingList;
    ArrayList<Item> itemList;
    boolean set = false;

    public Shop (Panel panel, Player player){
        this.panel = panel;
        this.player = player;
        this.slots = new ArrayList<>();
        this.shoppingList = new ArrayList<>();
        this.itemList = new ArrayList<>();
    }

    public void setShop (){
        if(set != true){
            for (int i = 0; i < 6 ; i++){
                JButton newButton = new JButton();
                if(i == 5){
                    newButton.addActionListener(this);
                    newButton.setBounds (panel.getWidth()/2-150, 75 * (i+1), 300, 50 );
                    newButton.setText("Quit Shop");
                    slots.add(newButton);
                }
                else {
                newButton.addActionListener(this);
                newButton.setBounds (panel.getWidth()/2-150, 75 * (i+1), 300, 50 );
                newButton.setText(itemList.get(i).getName());
                slots.add(newButton);
                }
            }
            set = true;
        }
        else {
            for (int i = 0; i < itemList.size(); i++){
                slots.get(i).setText(itemList.get(i).getName());
            }
        }
    }

    

    private void getItem (int no){
        switch (no){
            case (0) -> itemList.add(new HealthPot());
            case (1) -> itemList.add(new Sword());
            case (2) -> itemList.add(new Talisman());  
        }
    }

    public void setList (ArrayList<Integer> list){
        this.shoppingList = list;
        for (int i = 0; i < list.size(); i++){
            getItem(shoppingList.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == slots.get(0)){
            player.addItem(itemList.get(0));
            itemList.clear();
            Gamestate.state = Gamestate.MAP;
            for (JButton jButton : slots) {
                panel.remove(jButton);
                }
        }
        if (e.getSource() == slots.get(1)){
            player.addItem(itemList.get(1));
            itemList.clear();
            Gamestate.state = Gamestate.MAP;
            for (JButton jButton : slots) {
                panel.remove(jButton);
                }
        }
        if (e.getSource() == slots.get(2)){
            player.addItem(itemList.get(2));
            itemList.clear();
            Gamestate.state = Gamestate.MAP;
            for (JButton jButton : slots) {
                panel.remove(jButton);
                }
        }
        if (e.getSource() == slots.get(3)){
            player.addItem(itemList.get(3));
            itemList.clear();
            Gamestate.state = Gamestate.MAP;
            for (JButton jButton : slots) {
                panel.remove(jButton);
                }
        }
        if (e.getSource() == slots.get(4)){
            player.addItem(itemList.get(4));
            itemList.clear();
            Gamestate.state = Gamestate.MAP;
            for (JButton jButton : slots) {
                panel.remove(jButton);
                }
        }
        if (e.getSource() == slots.get(5)){
            itemList.clear();
            Gamestate.state = Gamestate.MAP;
            for (JButton jButton : slots) {
                panel.remove(jButton);
                }
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics g) {
        for (int i =0; i < slots.size(); i++){
            panel.add(slots.get(i));
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    
}
