package Gamestates;

import java.awt.*;
import java.util.*;

import javax.swing.JButton;

import Game.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import Map.*;

public class MapPick implements Statemethod,ActionListener {
    private Panel panel;
    private GameMap map;
    private ArrayList<MapPaths> pathList;
    private ArrayList<JButton> buttons;
    private boolean set = false;


    public MapPick (Panel panel, GameMap map){
        this.panel = panel;
        this.map = map;
        this.buttons = new ArrayList<>();
    }
    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        for (int i =0; i < pathList.size(); i++){
            panel.add(buttons.get(i));
            
        }
    }

    public void setButtons(){
        this.pathList = map.getPathList(map.getCurrentNode());
        if(set != true){
            for (int i = 0; i < pathList.size(); i++){
                JButton newButton = new JButton();
                newButton.addActionListener(this);
                newButton.setBounds (panel.getWidth()/2-100, 50 * (i+1), 100, 50 );
                newButton.setText(pathList.get(i).getEnd().getType().name());
                buttons.add(newButton);
            }
            set = true;
        }
        else {
            for (int i = 0; i < pathList.size(); i++){
                buttons.get(i).setText(pathList.get(i).getEnd().getType().name());
            }
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons.get(0)){
            map.setCurrentNode(pathList.get(0).getEnd());
            pathList = map.getPathList(map.getCurrentNode());
            map.getCurrentNode().function();
            for (JButton jButton : buttons) {
                panel.remove(jButton);
                }
            
        }
        else if (e.getSource() == buttons.get(1)){
            map.setCurrentNode(pathList.get(1).getEnd());
            pathList = map.getPathList(map.getCurrentNode());
            map.getCurrentNode().function();
            for (JButton jButton : buttons) {
                
                panel.remove(jButton);
                }
            
        }
        else if (e.getSource() == buttons.get(2)){
            map.setCurrentNode(pathList.get(2).getEnd());
            pathList = map.getPathList(map.getCurrentNode());
            map.getCurrentNode().function();
            for (JButton jButton : buttons) {
                
                panel.remove(jButton);
                }
            
        }
    }
    
}
