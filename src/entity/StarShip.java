package entity;

import ressources.Constant;
import ressources.Timer;

import javax.swing.*;

import jeu.Main;

import java.awt.*;
import java.util.Objects;

public class StarShip extends Entity{

    // VARIABLES
	private int count = 0;

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
        super.strImg3 = "";
        // Chargement de l'image du vaiseeau
        super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg1)));
        super.img = this.ico.getImage();
        super.alive = true;
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
    	if(!this.alive) {this.starShipExplodes();}
        g.drawImage(this.img, this.starShipDisplacement(), this.yPos, null);
    }
    
    public void starShipExplodes() {
    	if(count < 300) {
    		if(Timer.roundCount % 2 == 0) {super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg2)));}
    		else{super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg3)));}
    		count++;
    	}else {Main.game = false;}
    	super.img = this.ico.getImage();
    }
}
