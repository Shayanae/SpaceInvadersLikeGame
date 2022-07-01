package jeu;

import entity.AlienGroup;
import entity.StarShip;
import ressources.Constant;
import ressources.Keyboard;
import ressources.Timer;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    // VARIABLES
    public StarShip starShip = new StarShip();
    public AlienGroup alienGroup = new AlienGroup();

    // CONSTRUCTEURS

    public Scene(){
        super();

        // Instanciation du clavier
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        Thread screenTimer =new Thread(new Timer());
        screenTimer.start();
    }

    // METHODES

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        // Dessin du fond d'écran
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constant.windowWidth, Constant.windowHeight);

        // Dessin ligne verte en bas de l'écran
        g2.setColor(Color.green);
        g2.fillRect(30, 530, 535, 5);

        // Dessin du vaisseau
        g2.drawImage(this.starShip.getImg(), this.starShip.StarShipDisplacement(), this.starShip.getyPos(), null);

        // Dessin du groupe d'alien
        this.alienGroup.drawAliens(g2);
    }
}
