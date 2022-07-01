package entity;

import ressources.Constant;

import javax.swing.*;
import java.awt.*;
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
        super.dx = 0;
        super.dy = 0;
        // Adresse des images du vaisseau
        super.strImg1 = "/images/vaisseau.png";
        super.strImg2 = "/images/vaisseauDetruit1.png";
        // Chargement de l'image du vaiseeau
        super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg1)));
        super.img = this.ico.getImage();
    }

    // METHODES
    public int starShipDisplacement(){
        // Renvoie la nouvelle position du vaisseau après déplacement éventuel
        if(this.dx < 0){
            if(this.xPos > Constant.leftLimitStarShip){this.xPos = this.xPos + this.dx;}
        } else if (dx > 0) {
            if(this.xPos + this.dx < Constant.rightLimitStarShip){this.xPos = this.xPos + this.dx;}
        }
        return xPos;
    }

    public void drawStarShip(Graphics g){
        g.drawImage(this.img, this.starShipDisplacement(), this.yPos, null);
    }
}
