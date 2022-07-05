package jeu;

import entity.AliensGroup;
import entity.Castle;
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

    private Castle castles[] = new Castle[4]; // Création d'un tableau contenant les 4 châteaux

    // CONSTRUCTEURS

    public Scene(){
        super();

        // Instanciation des châteaux
        for (int column = 0; column < 4; column++){
            this.castles[column] = new Castle(Constant.windowMargin + Constant.xPosCastle + column * (Constant.castleWidth + Constant.castleGap));
        }

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

        // Détection contact StarShipShoot avec alien
        this.aliensGroup.starShipShootHitAlien(this.starShipShoot);

        // Détection des chateaux
        for (int column = 0; column < 4; column++){this.castles[column].drawCastle(g2);}
    }
}
