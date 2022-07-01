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
        // Adresse des images du vaisseau
        super.strImg1 = strImg1;
        super.strImg2 = strImg2;
        super.strImg3 = "/images/alienMeurt.png";
        // Chargement de l'image du vaisseau
        super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg1)));
        super.img = this.ico.getImage();
    }
}
