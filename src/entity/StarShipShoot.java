package entity;

import jeu.Main;
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

    private boolean starShipShootAtCastleHeight(){
        // Renvoie vrai si le tir du vaisseau est à hauteur des châteaux
        if(this.yPos < Constant.yPosCastle + Constant.castleHeight && this.yPos + this.height > Constant.yPosCastle) {return true;}
        else{return false;}
    }

    private int closeCastle(){
        // Renvoie le numéro du château (0,1,2 ou 3) dans la zone de tir du vaisseau
        int castleNumber = -1;
        int column = -1;
        while (castleNumber == -1 && column < 4){
            column++;
            if (this.xPos + this.weight > Constant.windowMargin + Constant.xPosCastle +
                    column * (Constant.castleWidth + Constant.castleGap) &&
                this.xPos < Constant.windowMargin + Constant.xPosCastle + Constant.castleWidth +
                        column * (Constant.castleWidth + Constant.castleGap)){castleNumber = column;}
        }
        return castleNumber;
    }

    private int xHitShootCastle(Castle castle){
        // Renvoie l'abscisse du tir du vaisseau lors du contact avec un château
        int xPosStarShipShoot = -1;
        if (this.xPos + this.weight > castle.getxPos() && this.xPos < castle.getxPos() + Constant.castleWidth){
            xPosStarShipShoot = this.xPos;
        }
        return xPosStarShipShoot;
    }

    public int[] starShipShootHitCastle(){
        // Renvoie numéro château touché et abscisse du tir
        int[] tabRep = {-1, -1};
        if(this.starShipShootAtCastleHeight()){ // Le tir du vaisseau est à hauteur du château
            tabRep[0] = this.closeCastle(); // Enregistre le numéro du château
            if (tabRep[0] != -1) {
                // enregistre l'abscisse du tir du visseau lors du contact avec le château dans tabRep[1]
                tabRep[1] = this.xHitShootCastle(Main.scene.castles[tabRep[0]]);
            }
        }
        return tabRep;
    }

    public void starShipShootDestroyCastle(Castle castles[]){
        int[] tab = this.starShipShootHitCastle(); // Contien (-1,-1) ou le numéro du château touché et l'abscisse du tir
        if(tab[0] != -1) { // Un château est touché
            if (castles[tab[0]].findBrick(castles[tab[0]].findColumnCastle(tab[1])) != -1) {
                castles[tab[0]].breakBrick(tab[1]); // Détruit les briques du château touché
                this.yPos = -1; // On tue le tir et on réactive le canon du vaisseau
            }
        }
    }
}
