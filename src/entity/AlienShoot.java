package entity;

import java.awt.Graphics;
import java.util.Objects;
import java.util.Random;

import javax.swing.ImageIcon;

import jeu.Main;
import ressources.Constant;
import ressources.Timer;

public class AlienShoot extends Entity{

	/**** VARIABLES ****/
	
	Random hasard = new Random();
	
	/**** CONSTRUCTEUR ****/
	
	public AlienShoot(int[] aliensPos) {
		// Initialisation des variables de la super classe
		super.xPos = aliensPos[0] + Constant.alienWidth / 2 - 1;
		super.yPos = aliensPos[1] + Constant.alienHeight;
		super.weight = Constant.alienShootWidth;
		super.height = Constant.alienShootHeight;
		super.dx = 0;
		super.dy = Constant.dyAlienShoot;
		// Adresse des images du vaisseau
		super.strImg1 = "/images/tirAlien1.png";
		super.strImg2 = "/images/tirAlien2.png";
		super.strImg3 = "";
		// Chargement de l'image du tir de l'alien
		if(hasard.nextInt(2) == 0) {
			super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg1)));}
		else {super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg2)));}
		super.img = this.ico.getImage();
		}
	
	/**** METHODE ****/
	public int alienShootDisplacement() {
		if(Timer.roundCount % 4 == 0) {
			if(this.yPos < 600) {this.yPos = this.yPos + Constant.dyAlienShoot;}
		}
		return yPos;
	}
	
	public void drawAlienShoot(Graphics g) {
		g.drawImage(this.img,  this.xPos,  this.alienShootDisplacement(),  null);
	}
	
	private boolean alienShootisHighCastle() {
		// Renvoie vrai si le tir du vaisseau est à hauteur des châteaux
		if(this.yPos < Constant.yPosCastle + Constant.castleHeight && 
				this.yPos + this.height > Constant.yPosCastle) {return true;}
		else {return false;}
	}
	
	private int closeCastle() {
		// Renvoie le numéro du château (0,1,2 ou 3) dans la zone de tir du vaisseau
		int castleNumber = -1;
		int column = -1;
		while(castleNumber == -1 && column < 4) {
			column++;
			if(this.xPos + this.weight - 1 > Constant.windowMargin + 
					Constant.xPosCastle + column * (Constant.castleWidth +
					Constant.castleGap)
					&& this.xPos + 1 < Constant.windowMargin +
					Constant.xPosCastle + Constant.castleWidth +
					column * (Constant.castleWidth + Constant.castleGap)) {
					castleNumber = column;
			}
		}
		return castleNumber;
	}
	
	private int xAlienShootHitCastle(Castle castle) {
		int xPosAlienShoot = -1;
		if(this.xPos + this.weight > castle.getxPos() && this.xPos < castle.getxPos() + Constant.castleWidth) {
			xPosAlienShoot = this.xPos;}
	return xPosAlienShoot;
	}
	
	public int[] alienShootHitCastle() { // Renvoie numéro château touché et abscisse du tir
		int[] tabRep = {-1, -1};
		if(this.alienShootisHighCastle()) { // Le tir alien est à hauteur du château
			tabRep[0] = this.closeCastle(); // Enregistre le numéro du château touché dans tabRep[0]
			if(tabRep[0] != -1) {
				tabRep[1] = this.xAlienShootHitCastle(Main.scene.castles[tabRep[0]]);
			}
		}
		return tabRep;
	}
	
	public void alienShootDestroyCastle(Castle castles[]) {
		int[] tab = this.alienShootHitCastle(); // Contient (-1, -1) ou le numéro du château touché et l'abscisse du tir
		if(tab[0] != -1) { // Un château est touché
			if(castles[tab[0]].findHighBrick(castles[tab[0]].findColumnCastle(tab[1])) != -1 && 
					castles[tab[0]].findHighBrick(castles[tab[0]].findColumnCastle(tab[1])) != 27) {
				castles[tab[0]].breakHighBrick(tab[1]); // Détruit les briques du château touché
				this.yPos = 700; // On tue le tir de l'alien
			}
		}
	}
	
	public boolean hitStarShip(StarShip starShip) {
		// Renvoie vrai si un tir Alien touche le vaisseau
		if(this.yPos < starShip.getyPos() + starShip.getHeight() && this.yPos + this.height > starShip.getyPos() &&
				this.xPos + this.weight > starShip.getxPos() && this.xPos < starShip.getxPos() + starShip.getWeight()) {
			this.yPos = 700;
			return true;
		}
		else {return false;}
	}
}

