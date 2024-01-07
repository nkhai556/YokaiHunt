package Gamestates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import Game.Panel;

public class GameOver implements Statemethod {

    private Font titleFont;
    private Font timeFont;
    private Panel panel;
    private int time;
    private JButton button;
    public GameOver (Panel panel2){
        this.panel = panel2;
        this.titleFont = new Font("Serif", Font.BOLD, 40);
        this.timeFont = new Font("Serif", Font.BOLD, 20);
        button = new JButton("Retry");
        button.setBounds(panel.returnWidth()/2 - panel.returnWidth()/8 ,150,100,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.reset();
                panel.remove(button);
            }     
        });

    }

    @Override
    public void update() {
        if (Gamestate.state != Gamestate.DEAD){
            button.setVisible(true);
        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Graphics g) {
        this.time = Panel.getSecond();
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("YOU HAD FALLEN", panel.returnWidth()/2 - panel.returnWidth()/3, panel.returnHeight()/2 -20);
        g.setFont(timeFont);
        g.drawString(String.format("You've survived for %d seconds...", time), panel.returnWidth()/4, panel.returnHeight()/2 + 20);
        g.drawString(String.format("Try again?"), panel.returnWidth()/4+100, panel.returnHeight()/2 + 40);
        panel.add(button);
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
    
}
