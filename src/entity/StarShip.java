package entity;

import ressources.Constant;

import javax.swing.*;
import java.util.Objects;

public class StarShip extends Entity{

    // VARIABLES

    // CONSTRUCTEUR

    public StarShip(){

        // Initialisation des variables de la super classe
        super.xPos = Constant.initial_StarShip_X;
        super.yPos = Constant.initial_StarShip_Y;
        super.weight = Constant.starShipWidth;
        super.height = Constant.starShipHeight;
        super.dx = Constant.dxStarShip;
        super.dy = 0;
        // Adresse des images du vaisseau
        super.strImg1 = "/images/vaisseau.png";
        super.strImg2 = "/images/vaisseauDetruit1.png";
        // Chargement de l'image du vaiseeau
        super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg1)));
        super.img = this.ico.getImage();
    }

    // METHODES

}
