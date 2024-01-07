package Input;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import Game.Panel;


public class KeyManager  {

    public boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed;
    Action LeftActionP;
    Action RightActionP;
    Action UpActionP;
    Action DownActionP;
    Action ShootActionP;
    Action LeftActionR;
    Action RightActionR;
    Action UpActionR;
    Action DownActionR;
    Action ShootActionR;
    Panel panel;
    
    
    public KeyManager(Panel panel) {
        this.panel = panel;
        LeftActionP = new LeftPressed();
        RightActionP = new RightPressed();
        UpActionP = new UpPressed();
        DownActionP = new DownPressed();
        ShootActionP = new ShootPressed();
        ShootActionR = new ShootReleased();
        LeftActionR = new LeftReleased();
        RightActionR = new RightReleased();
        UpActionR = new UpReleased();
        DownActionR = new DownReleased();

        panel.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressA");
        panel.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressD");
        panel.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressW");
        panel.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressS");
        panel.getInputMap().put(KeyStroke.getKeyStroke("J"), "pressJ");
        panel.getActionMap().put("pressA", LeftActionP);
        panel.getActionMap().put("pressD", RightActionP);
        panel.getActionMap().put("pressW", UpActionP);
        panel.getActionMap().put("pressS", DownActionP);
        panel.getActionMap().put("pressJ", ShootActionP);
        


        panel.getInputMap().put(KeyStroke.getKeyStroke("released A"), "releaseA");
        panel.getInputMap().put(KeyStroke.getKeyStroke("released D"), "releaseD");
        panel.getInputMap().put(KeyStroke.getKeyStroke("released W"), "releaseW");
        panel.getInputMap().put(KeyStroke.getKeyStroke("released S"), "releaseS");
        panel.getInputMap().put(KeyStroke.getKeyStroke("released J"), "releaseJ");
        panel.getActionMap().put("releaseA", LeftActionR);
        panel.getActionMap().put("releaseD", RightActionR);
        panel.getActionMap().put("releaseW", UpActionR);
        panel.getActionMap().put("releaseS", DownActionR);
        panel.getActionMap().put("releaseJ", ShootActionR);
        
    }


    private class LeftPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            leftPressed = true;
            System.out.println("pressed");
        }}

    private class RightPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            rightPressed = true;
        }}

    private class UpPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            upPressed = true;
        }}

    private class DownPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            downPressed = true;
        }}

    private class DownReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            downPressed = false;
        }}

    private class UpReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            upPressed = false;
        }}
    
    private class RightReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            rightPressed = false;
        }} 
        
    private class LeftReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            leftPressed = false;
        }}
        
    private class ShootPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            shootPressed = true;
        }}

    private class ShootReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            shootPressed = false;
        }}
    // @Override
    // public void keyTyped(KeyEvent e) {
    // }

    // @Override
    // public void keyPressed(KeyEvent e) {
        
    //         int code = e.getKeyCode();
    //         switch (code) {
    //             case KeyEvent.VK_A -> leftPressed = true;
    //             case KeyEvent.VK_S -> downPressed = true;
    //             case KeyEvent.VK_D -> rightPressed = true;
    //             case KeyEvent.VK_W -> upPressed = true;
    //             case KeyEvent.VK_UP -> upPressed = true;
    //             case KeyEvent.VK_DOWN -> downPressed = true;
    //             case KeyEvent.VK_LEFT -> leftPressed = true;
    //             case KeyEvent.VK_RIGHT -> rightPressed = true;
    //             case KeyEvent.VK_J -> shootPressed = true;
                
    //     }
    
    // }

    // @Override
    // public void keyReleased(KeyEvent e) {
        
    //         int code = e.getKeyCode();
    //         switch (code) {
    //             case KeyEvent.VK_A -> leftPressed = false;
    //             case KeyEvent.VK_S -> downPressed = false;
    //             case KeyEvent.VK_D -> rightPressed = false;
    //             case KeyEvent.VK_W -> upPressed = false;
    //             case KeyEvent.VK_UP -> upPressed = false;
    //             case KeyEvent.VK_DOWN -> downPressed = false;
    //             case KeyEvent.VK_LEFT -> leftPressed = false;
    //             case KeyEvent.VK_RIGHT -> rightPressed = false;
    //             case KeyEvent.VK_J -> shootPressed = false;
                
    //         }
        
    // }

}