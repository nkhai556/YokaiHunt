package Gamestates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import Game.Panel;

public class GameWin implements Statemethod, ActionListener {

    private Font titleFont;
    private Font timeFont;
    private Panel panel;
    private int time;
    private JButton button1,button2;
    public GameWin (Panel panel2){
        this.panel = panel2;
        this.titleFont = new Font("Serif", Font.BOLD, 40);
        this.timeFont = new Font("Serif", Font.BOLD, 20);
        button1 = new JButton("Retry");
        button1.setBounds(panel.returnWidth()/2 - panel.returnWidth()/8 ,300,100,50);
        button1.addActionListener(this);
        button2 = new JButton("Quit");
        button2.setBounds(panel.returnWidth()/2 - panel.returnWidth()/8 ,350,100,50);
        button2.addActionListener(this);
            
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        this.time = Panel.getSecond();
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("YOU WON!!", panel.returnWidth()/2 - panel.returnWidth()/5, 70);
        g.setFont(timeFont);
        g.drawString(String.format("You've survived for %d seconds...", time), panel.returnWidth()/4, 150 );
        g.drawString(String.format("Try again?"), panel.returnWidth()/4+100, 100 );
        panel.add(button1);
        panel.add(button2);
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
        if (e.getSource() == button1){
        panel.reset();
        panel.remove(button1);
        panel.remove(button2);
        } 
        else if (e.getSource() == button2){
            System.exit(1);
        }   
    }
    
}
