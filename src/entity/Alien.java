package entity;

import ressources.Constant;

import javax.swing.*;
import java.util.Objects;

public class Alien extends Entity{

    // VARIABLES

    // CONSTRUCTEUR

    public Alien(int xPos, int yPos, String strImg1, String strImg2){

        // Initialisation des variables de al super classe
        super.xPos = xPos;
        super.yPos = yPos;
        super.weight = Constant.alienWidth;
        super.height = Constant.alienHeight;
        super.dx = 0;
        super.dy = 0;
        super.alive = true;
        // Adresse des images du vaisseau
        super.strImg1 = strImg1;
        super.strImg2 = strImg2;
        super.strImg3 = "/images/alienMeurt.png";
        // Chargement de l'image du vaisseau
        super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg1)));
        super.img = this.ico.getImage();
    }

    // METHODES
    public void imageChoice(boolean pos1){
        // Methode qui charge l'image de l'alien selon sa position (1 ou 2)
        if (this.alive) {
            if (pos1) {super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg1)));
            } else {super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg2)));}
        } else{ super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg3)));}
        super.img = this.ico.getImage(); // recharge l'image
    }
}
