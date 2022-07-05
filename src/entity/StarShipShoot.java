package entity;

import ressources.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StarShipShoot extends Entity{

    // VARIABLES
    private boolean starShipFire = false;

    // CONSTRUCTEUR
    public StarShipShoot(){

        // Initialisation des variables de la super class
        super.xPos = 0;
        super.yPos = Constant.initial_StarShip_Y - Constant.heightStarShipShoot;
        super.weight = Constant.widthStarShipShoot;
        super.height = Constant.heightStarShipShoot;
        super.dx = 0;
        super.dy = Constant.dyStarShipShoot;
        // Adresse des images du tir du vaisseau
        super.strImg1 = "/images/tirVaisseau.png";
        super.strImg2 = "";
        super.strImg3 = "";
        // Chargement de l'image du vaisseau
        super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg1)));
        super.img = this.ico.getImage();
    }

    // GETTERS
    public boolean isStarShipFire() {return starShipFire;}

    // SETTERS
    public void setStarShipFire(boolean starShipFire) {this.starShipFire = starShipFire;}

    public int starShipFireDisplacement(){
        if (this.starShipFire) {
            if (this.yPos > 0){this.yPos = yPos - Constant.dyStarShipShoot;}
            else{this.starShipFire = false;}
        }
        return yPos;
    }

    public void drawStarShipFire(Graphics g){
        if(this.starShipFire){g.drawImage(this.img, this.xPos, this.starShipFireDisplacement(), null);}
    }

    public boolean killAlien(Alien alien){
        // le tir du vaisseau détruit un alien

        if (this.yPos < alien.getyPos() + alien.getHeight()
                && this.yPos + this.height > alien.getyPos()
                && this.xPos + this.weight > alien.getxPos()
                && this.xPos < alien.getxPos() + alien.getWeight()){ return true;}
        else{return false;}
    }
}
