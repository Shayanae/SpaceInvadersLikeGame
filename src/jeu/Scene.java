package jeu;

import entity.AlienShoot;
import entity.AliensGroup;
import entity.Castle;
import entity.StarShip;
import entity.StarShipShoot;
import entity.UFO;
import ressources.Constant;
import ressources.Keyboard;
import ressources.Timer;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    // VARIABLES
    public StarShip starShip = new StarShip();
    public AliensGroup aliensGroup = new AliensGroup();
    public StarShipShoot starShipShoot = new StarShipShoot();

    public Castle castles[] = new Castle[4]; // Création d'un tableau contenant les 4 châteaux
    
    public AlienShoot alienShoot1, alienShoot2, alienShoot3;
    
    public UFO ufo;
    
    private Font displayScore = new Font("Arial", Font.PLAIN, 20);
    private Font displayText = new Font("Arial", Font.PLAIN, 80);
    
    public int score = 0;

    // CONSTRUCTEURS

    public Scene(){
        super();

        // Instanciation des châteaux
        for (int column = 0; column < 4; column++){
            this.castles[column] = new Castle(Constant.windowMargin + Constant.xPosCastle + column * (Constant.castleWidth + Constant.castleGap));
        }

        // Instanciation du clavier
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        Thread screenTimer =new Thread(new Timer());
        screenTimer.start();
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
        
        // Affichage du score
        g.setFont(displayScore);
        g.drawString("Score : " + score, 400, 25);

        // Dessin du vaisseau
        this.starShip.drawStarShip(g2);

        // Dessin du groupe d'alien
        this.aliensGroup.drawAliens(g2);

        // Dessin du tir du vaisseau
        this.starShipShoot.drawStarShipFire(g2);

        // Détection contact StarShipShoot avec alien
        this.aliensGroup.starShipShootHitAlien(this.starShipShoot);

        // Détection des chateaux
        for (int column = 0; column < 4; column++){this.castles[column].drawCastle(g2);}
        
        // Message de début du jeu
        if(Timer.roundCount < 500) {
        	g.setFont(displayText);
        	g.drawString("Good luck!", 95, 100);
        }

        //Détection contact starShipShoot avec château
        this.starShipShoot.starShipShootDestroyCastle(castles);
        
        // Dessin des tirs des aliens
        if(Timer.roundCount % 500 == 0) {
        	alienShoot1 = new AlienShoot(this.aliensGroup.alienWhoShoot());}
        if(this.alienShoot1 != null) {
        	this.alienShoot1.drawAlienShoot(g2);
        	this.alienShoot1.alienShootDestroyCastle(castles); // Détection contact alienShoot1 avec château
        	if(this.alienShoot1.hitStarShip(starShip)) {this.starShip.setAlive(false);}
        }
        if(Timer.roundCount % 750 == 0) {
        	alienShoot2 = new AlienShoot(this.aliensGroup.alienWhoShoot());}
        if(this.alienShoot2 != null) {
        	this.alienShoot2.drawAlienShoot(g2);
        	this.alienShoot2.alienShootDestroyCastle(castles); // Détection contact alienShoot2 avec château
        	if(this.alienShoot2.hitStarShip(starShip)) {this.starShip.setAlive(false);}
        }
        if(Timer.roundCount % 900 == 0) {
        	alienShoot3 = new AlienShoot(this.aliensGroup.alienWhoShoot());}
        if(this.alienShoot3 != null) {
        	this.alienShoot3.drawAlienShoot(g2);
        	this.alienShoot3.alienShootDestroyCastle(castles); // Détection contact alienShoot3 avec château
        	if(this.alienShoot3.hitStarShip(starShip)) {this.starShip.setAlive(false);}
        }
       // Dessin de la soucoupe
        if(Timer.roundCount % 2500 == 0) {ufo = new UFO();}
        if(this.ufo != null) {
        	if(this.ufo.getxPos() > 0) {
        		// Détection contact tir vaisseau avec soucoupe
        		if(this.starShipShoot.destroyUFO(this.ufo)) {
        			if(this.starShipShoot.getDx() != 0) {this.score = this.score + Constant.ufoValue;}
        			this.ufo.setDx(0);
        			this.ufo.setAlive(false);
        			this.ufo.uFOSound.stop();
        			this.ufo.uFODestroySound.play();
        		}
        		this.ufo.drawUFO(g2);
        		}
        	else {this.ufo = null;}
        }
        
        // Affichage de la fin du jeu
        if(!this.starShip.isAlive()) {
        	g.setFont(displayText);
        	g.drawString("GAME OVER", 50, 100);
        }
        if(this.aliensGroup.getNbrAliens() == 0) {	aliensGroup = new AliensGroup();}
        if(this.aliensGroup.posLowestAlien() > Constant.initial_StarShip_Y) {this.starShip.starShipExplodes();}
    }
}
