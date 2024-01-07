package Gamestates;


import java.awt.*;
import Game.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Menu implements Statemethod, ActionListener {

    private Panel panel;
    private JButton playButton,quitButton;
    private Font menuFont;
    private Font buttonFont;
    

    public Menu (Panel panel2){
        this.panel = panel2;
        playButton = new JButton("Play");
        quitButton = new JButton("Quit");
        playButton.setBounds(panel.returnWidth()/2 - panel.returnWidth()/8 ,150,100,50);
        quitButton.setBounds(panel.returnWidth()/2 - panel.returnWidth()/8,250,100,50);
        playButton.addActionListener(this);
        quitButton.addActionListener(this);
        menuFont = new Font("Serif", Font.BOLD, 40);
        buttonFont = new Font ("Serif", Font.BOLD, 30);
    }
    
    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Graphics g) {

        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(menuFont);
        g.setColor(Color.WHITE);
        g.drawString("Yokai Hunt", panel.getWidth()/4 + panel.getWidth()/12, 100);
        g.setFont(buttonFont);
        g.drawString("Quit", panel.returnWidth()/2 - panel.returnWidth()/8 +20, 250+30);
        g.drawString("WASD to move, J to shoot projectile", panel.returnWidth()/2 - panel.returnWidth()/8 - 170, 250+100);
        panel.add(playButton);
        panel.add(quitButton);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playButton){
            Gamestate.state = Gamestate.PLAYING;
            panel.remove(playButton);
            panel.remove(quitButton);
        }
        else if (e.getSource()== quitButton){
            System.exit(1);
        }
    }
    
}
