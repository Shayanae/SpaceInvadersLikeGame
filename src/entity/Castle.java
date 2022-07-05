package entity;

import ressources.Constant;

import java.awt.*;

public class Castle extends Entity{

    /**** VARIABLES ****/

    private final int nbrLines = Constant.castleHeight/Constant.brickSize;
    private final int nbrColumn = Constant.castleWidth/Constant.brickSize;

    // Tableau contenant les briques du château (la case contient true pour une brique et false pour vide)
    boolean castles[][] = new boolean[nbrLines][nbrColumn];

    /**** Constructeur ****/

    public Castle(int xPos) {
        super.xPos = xPos; // Abscisse du point le plus à gauche du château
        super.yPos = Constant.yPosCastle; // Ordonnée du sommet du château

        this.initCastles();
    }

    /**** Methodes ****/

    // Création du tableau initial associé au château sans dégât
    public void initCastles(){
        // On remplit toutes les cases du tableau avec true
        for (int line = 0; line < nbrLines; line++){
            for (int column = 0; column< nbrColumn; column++){
                castles[line][column] = true;
            }
        }
        // On remplit toutes les cases sans brique du tableau avec false
        // Biseautage du haut du château
        for (int column = 0; column < 6; column++){
            for (int line = 0; line < 2; line++){
                castles[line][column] = false;
                castles[line][nbrColumn-column-1] = false;
            }
        }
        for (int column = 0; column < 4; column++){
            for (int line = 2; line < 4; line++) {
                castles[line][column] = false;
                castles[line][nbrColumn-column-1] = false;
            }
        }
        for (int column = 0; column < 2; column++){
            for (int line = 4; line < 6; line++) {
                castles[line][column] = false;
                castles[line][nbrColumn-column-1] = false;
            }
        }
        // Entrée du château
        for (int line = 18; line < nbrLines; line++){
            for (int column = 10 ; column < nbrColumn - 10; column++){
                castles[line][column] = false;
            }
        }
        // Biseautage entrée du château
        for (int column = 12; column < nbrColumn-12; column++){
            for (int line = 16; line < 18; line++) {
                castles[line][column] = false;
                castles[line][nbrColumn-column-1] = false;
            }
        }
        for (int column = 14; column < nbrColumn -14; column++){
            for (int line = 14; line < 16; line++) {
                castles[line][column] = false;
                castles[line][nbrColumn-column-1] = false;
            }
        }
        for (int column = 0; column < 2; column++){
            for (int line = 4; line < 6; line++) {
                castles[line][column] = false;
                castles[line][nbrColumn-column-1] = false;
            }
        }
    }

    // Dessin du château
    public void drawCastle(Graphics g2){
        for (int line = 0; line < nbrLines; line++){
            for (int column = 0; column < nbrColumn; column++){
                if (castles[line][column]){g2.setColor(Color.GREEN);
                }else {g2.setColor(Color.BLACK);}
                g2.fillRect(this.xPos + Constant.brickSize*column, this.yPos + Constant.brickSize*line, Constant.brickSize, Constant.brickSize);
            }
        }
    }
}
