package jeu;

import entity.StarShip;
import ressources.Constant;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    // VARIABLES
    public StarShip starShip = new StarShip();

    // CONSTRUCTEURS

    public Scene(){
        super();
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
        g2.drawImage(this.starShip.getImg(), this.starShip.getxPos(), this.starShip.getyPos(), null);
    }
}