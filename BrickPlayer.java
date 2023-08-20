package PingPongGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BrickPlayer extends Rectangle {

    int id;
    int xVelocity;
    int speed = 10;

    public BrickPlayer(int x, int y, int PLAYER_WIDTH, int PLAYER_HEIGHT, int id) {
        super(x,y, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.id = id;
    }

    public void KeyPressed(KeyEvent e) {
        switch (id) {
            case 1:
            if(e.getKeyCode()==KeyEvent.VK_A){
                setXDirection(-speed);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_D){
                setXDirection(speed);
            }
        }
    }

    public void KeyReleased(KeyEvent e){
        switch (id) {
            case 1:
            if(e.getKeyCode()==KeyEvent.VK_A){
                setXDirection(-speed);
                move();
            }
            if(e.getKeyCode()==KeyEvent.VK_D){
                setXDirection(speed);
            }
        }
    }

    public void setXDirection(int xDirection){
        xVelocity = xDirection;
    }

    public void move(){
        x = x + xVelocity;
    }

    public void draw(Graphics g){
        if(id==1)
            g.setColor(Color.red);
    }

}
