package entity;

import ressources.Constant;

import java.awt.*;

public class AlienGroup {

    // VARIABLES
        // Tableau contenant tous les aliens (50)
    private Alien aliens[][] = new Alien[5][10];

    // Constructeur

    public AlienGroup () {this.initAliens();}

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
        // Dessin des aliens contenus dans le tableau tabAlien
        for (int column = 0; column < 10; column++){
            for (int line = 0; line < 5; line ++){
                g.drawImage(this.aliens[line][column].getImg(), this.aliens[line][column].getxPos(),
                        this.aliens[line][column].getyPos(), null);
            }
        }
    }
}
