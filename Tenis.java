package PingPongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tenis extends JFrame implements KeyListener, ActionListener {
    JFrame frame;
    JPanel panel, scorePanel;
    JLabel score, player1, player2, middle;

    int score1, score2;

    final int PANEL_WIDTH = 600;
    final int PANEL_HEIGHT = 400;

    Image ball;
    int xVelocity = 1;
    int yVelocity = 1;

    int x = 0;
    int y = 0;

    Tenis(){

        frame = new JFrame("Ping Pong");
        frame.setSize(600,400);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.addKeyListener(this);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);
        panel.setBounds(0,0,600,600);

        player1 = new JLabel();
        player2 = new JLabel();

        player1.setBackground(Color.red);
        player1.setOpaque(true);
        player1.setBounds(0,0,10,50);

        player2.setBackground(Color.blue);
        player2.setOpaque(true);
        player2.setBounds(575,0,10,50);

        score = new JLabel();
        score.setFont(new Font("Sans Serif", Font.BOLD,25));
        score.setForeground(new Color( 0, 255, 236 ));

        scorePanel = new JPanel();
        scorePanel.setBounds(250,5,100,35);
        scorePanel.setBackground(Color.BLACK);
        scorePanel.setOpaque(true);
        scorePanel.setBorder(null);
        scorePanel.add(score);

        ball = new ImageIcon("C:\\Users\\Laura\\Documents\\Proiecte\\IntelliJ IDEA\\Java\\pr\\src\\ball.png").getImage();

        middle = new JLabel();
        middle.setBounds(300,0,2,400);
        middle.setBackground(Color.white);
        middle.setOpaque(true);

        frame.add(middle);
        frame.add(scorePanel);
        frame.add(player2);
        frame.add(player1);
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':player1.setLocation(player1.getX(),player1.getY()-10);
            break;
            case's':player1.setLocation(player1.getX(), player1.getY()+10);
            break;
            case'd':player1.setLocation(player1.getX(), player1.getY());
            break;
            case'a':player1.setLocation(player1.getX(), player1.getY());
            break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37: player2.setLocation(player2.getX(), player2.getY());
                break;
            case 38: player2.setLocation(player2.getX(), player2.getY()-10);
                break;
            case 39: player2.setLocation(player2.getX(), player2.getY());
                break;
            case 40: player2.setLocation(player2.getX(), player2.getY()+10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public void paint (Graphics g) {

        g.drawImage(ball,0,0,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(x>=PANEL_WIDTH-ball.getWidth(null) || x<0) {
            xVelocity = xVelocity * -1;
        }

        x = x + xVelocity;
        repaint();
    }

}

