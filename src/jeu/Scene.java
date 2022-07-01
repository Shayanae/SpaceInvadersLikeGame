package jeu;

import entity.AliensGroup;
import entity.StarShip;
import entity.StarShipShoot;
import ressources.Constant;
import ressources.Keyboard;
import ressources.Timer;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    // VARIABLES
    public StarShip starShip = new StarShip();
    public AliensGroup aliensGroup = new AliensGroup();
    public StarShipShoot starShipShoot = new StarShipShoot();

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
        this.starShip.drawStarShip(g2);

        // Dessin du groupe d'alien
        this.aliensGroup.drawAliens(g2);

        // Dessin du tir du vaisseau
        this.starShipShoot.drawStarShipFire(g2);
    }
}
