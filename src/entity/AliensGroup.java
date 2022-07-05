package entity;

import ressources.Constant;
import ressources.Timer;

import java.awt.*;

public class AliensGroup {

    // VARIABLES
        // Tableau contenant tous les aliens (50)
    private Alien aliens[][] = new Alien[5][10];
    private boolean goToRight, pos1;
    private int speed;

    private int[] aliensDeath = {-1, -1}; // Emplacement alien mort dans le tableau aliens


    // Constructeur

    public AliensGroup() {
        this.initAliens();
        this.goToRight = true;
        this.pos1 = true;
        this.speed = Constant.alienSpeed;
    }

    // METHODES

    private void initAliens(){
        // Méthode qui remplit le tableau complet des aliens
        for (int column = 0; column < 10; column++){
            this.aliens[0][column] = new Alien(Constant.initial_alien_X + (Constant.alienWidth
                    + Constant.columnGapAlien) * column, Constant.initial_Alien_Y,
                    "/images/alienHaut1.png", "/images/alienHaut2.png");
            for (int line = 1; line < 3; line++){
                this.aliens[line][column] = new Alien(Constant.initial_alien_X + (Constant.alienWidth
                        + Constant.columnGapAlien) * column, Constant.initial_Alien_Y + Constant.lineGapAlien
                        * line, "/images/alienMilieu1.png", "/images/alienMilieu2.png");
            }
            for (int line = 3; line < 5; line ++){
                this.aliens[line][column] = new Alien(Constant.initial_alien_X + (Constant.alienWidth
                        + Constant.columnGapAlien) * column, Constant.initial_Alien_Y + Constant.lineGapAlien
                        * line, "/images/alienBas1.png", "/images/alienBas2.png");
            }
        }
    }

    public void drawAliens(Graphics g){
        if (Timer.roundCount % (100 - 10 * this.speed) == 0){this.alienDisplacement();}
        // Dessin des aliens contenus dans le tableau tabAlien
        for (int column = 0; column < 10; column++){
            for (int line = 0; line < 5; line ++){
                if(this.aliens[line][column] != null) {
                    this.aliens[line][column].imageChoice(pos1);
                    g.drawImage(this.aliens[line][column].getImg(), this.aliens[line][column].getxPos(),
                            this.aliens[line][column].getyPos(), null);
                }
            }
        }
    }

    private boolean hitLeftEdge(){
        // Méthode qui détecte le bord gauche de la fenêtre
        boolean hit = false;
        for (int column = 0; column < 10; column++){
            for (int line = 0; line < 5; line ++){
                if(this.aliens[line][column] != null) {
                    if (this.aliens[line][column].getxPos() < Constant.windowMargin) {
                        hit = true;
                        break;
                    }
                }
            }
        }
        return hit;
    }

    private boolean hitRightEdge(){
        // Méthode qui détecte le bord droit de la fenêtre
        boolean hit = false;
        for (int column = 0; column < 10; column++){
            for (int line = 0; line < 5; line ++) {
                if (this.aliens[line][column] != null){
                    if (this.aliens[line][column].getxPos() > Constant.windowWidth - Constant.alienWidth
                            - Constant.dxAlien - Constant.windowMargin) {
                        hit = true;
                        break;
                    }
                }
            }
        }
        return hit;
    }

    private void alienDisplacementChange(){
        // Méthode qui change le sens de déplacement de l'alien et le descend d'un cran
        if (this.hitRightEdge()){
            for (int column = 0; column < 10; column++){
                for (int line = 0; line < 5; line ++){
                    if(this.aliens[line][column] != null) {
                        this.aliens[line][column].setyPos(this.aliens[line][column].getyPos() + Constant.dyAlien);
                    }
                }
            }
            this.goToRight = false;
            if (this.speed < 9){this.speed++;}
        }else{
            if (this.hitLeftEdge()){
                for (int column = 0; column < 10; column++){
                    for (int line = 0; line < 5; line ++){
                        if(this.aliens[line][column] != null) {
                            this.aliens[line][column].setyPos(this.aliens[line][column].getyPos() + Constant.dyAlien);
                        }
                    }
                }
                this.goToRight = true;
                if (this.speed < 9){this.speed++;}
            }
        }
    }

    public void alienDisplacement(){
        // Méthode qui gère le déplacement des aliens
        if(this.aliensDeath[0] != -1) { // Elimination de l'alien mort si nécessaire
            deleteDeathAlien(aliensDeath);
            aliensDeath[0] = -1; // Réinitialisation de aliensDeath
        }
        if (this.goToRight){ // Déplacement vers la droite
            for (int column = 0; column < 10; column++){
                for (int line = 0; line < 5; line ++){
                    if(this.aliens[line][column] != null) {
                        this.aliens[line][column].setxPos(this.aliens[line][column].getxPos() + Constant.dxAlien);
                    }
                }
            }
        }else { // Déplacement vers la gauche
            for (int column = 0; column < 10; column++) {
                for (int line = 0; line < 5; line++) {
                    if(this.aliens[line][column] != null) {
                        this.aliens[line][column].setxPos(this.aliens[line][column].getxPos() - Constant.dxAlien);
                    }
                }
            }
        }
        // Changement de l'image de l'alien
        this.pos1 = !this.pos1;
        // Màj du sens de déplacement si un alien atteint le bord de la fenêtre
        this.alienDisplacementChange();
    }

    public void starShipShootHitAlien(StarShipShoot starShipShoot){
        // Détection contact tirVaisseau avec alien
        for(int column = 0; column < 10; column++){
            for (int line = 0; line < 5; line ++){
                if(this.aliens[line][column] != null) {
                    if (starShipShoot.killAlien(this.aliens[line][column])) {
                        this.aliens[line][column].alive = false; // On tue l'alien
                        starShipShoot.yPos = -1; // On tue le tir
                        // On enregistre la position de l'alien mort dans el tableau
                        this.aliensDeath[0] = line;
                        this.aliensDeath[1] = column;
                        break;
                    }
                }
            }
        }
    }

    private void deleteDeathAlien(int[] aliensDeath){
        // Méthode qui enlève l'alien mort du tableau (case à null)
        this.aliens[aliensDeath[0]][aliensDeath[1]] = null;
    }
}
