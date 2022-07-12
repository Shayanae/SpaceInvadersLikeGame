package entity;

import java.awt.Graphics;
import java.util.Objects;

import javax.swing.ImageIcon;

import ressources.Audio;
import ressources.Constant;
import ressources.Timer;

public class UFO extends Entity{
	/**** VARIABLES ****/
	
	public Audio uFOSound = new Audio("/sounds/sonSoucoupePasse.wav");
	public Audio uFODestroySound = new Audio("/sounds/sonDestructionSoucoupe.wav");
	
	private int count = 0;
	
	/**** CONSTRUCTEUR ****/
	
	public UFO() {
		// Initialisation des variables de la classe mère
		super.xPos = Constant.xPosUFO;
		super.yPos = Constant.yPosUFO;
		super.weight = Constant.uFOWidth;
		super.height = Constant.uFOHeight;
		super.dx = Constant.dxUFO;
		super.dy = 0;
		// Adresse des images du vaisseau
		this.strImg1 = "/images/soucoupe.png";
		this.strImg2 = "/images/soucoupe100.png";
		this.strImg3 = "";
		// Chargement de l'image du vaisseau
		super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(strImg1)));
		super.img = this.ico.getImage();
		super.alive = true;
		
		this.uFOSound.play();
		this.uFODestroySound.stop();
		this.count = 0;
	}
	
	/**** METHODES ****/
	public int uFODisplacement() {
		// Renvoie la nouvelle position de la soucoupe après déplacement éventuel
		if(this.alive && Timer.roundCount % 2 == 0) {
			if(this.xPos > 0) {this.xPos = this.xPos - this.dx;}
			else {this.xPos = Constant.xPosUFO;}
		}
		return this.xPos;
	}
	
	public void drawUFO(Graphics g) {
		if(!this.alive) {this.destroyUFO();}
		g.drawImage(this.img,  this.uFODisplacement(), this.yPos, null);
	}
	
	public void destroyUFO() {
		if(count < 300) {
			super.ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.strImg2)));
			super.img = this.ico.getImage();
			count++;
		}else {this.xPos = Constant.xPosUFO;}
	}
}
