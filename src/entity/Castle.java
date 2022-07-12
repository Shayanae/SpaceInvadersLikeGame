package entity;

import ressources.Audio;
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

    public int findColumnCastle(int xShoot){
        // Trouve la colone du tableau associé au château touché par le tir
        int column = -1;
        column = (xShoot - this.xPos) / Constant.brickSize;
        return column;
    }

    public int findBrick(int column){
        // Trouve la première brique en partant du bas de la colonne du tableau associé au chpate ou renvoie -1
        int line = nbrLines - 1;
        while (line >= 0 && !castles[line][column]){line--;}
        return line;
    }

    private void deleteBrick(int line, int column){
        // Eliminitation des 6 premières briques de la colonne en partant du bas si elles existent
        for(int count = 0; count < 6; count++){
            if (line - count >= 0){
                castles[line - count][column] = false;
                if (column < nbrColumn - 1){castles[line - count][column + 1] = false;}
            }
        }
    }

    public void breakBrick(int xShoot){
        // Récapitule les 3 méthodes qui rpécédent
    	Audio.playSound("/sounds/sonCasseBrique.wav");
        int column = this.findColumnCastle(xShoot);
        this.deleteBrick(findBrick(column), column);
    }
    
    public int findHighBrick(int column) {
    	// Trouve la première brique en partant du haut de la colonne du tableau
    	// Associé au château ou renvoie -1
    	int line = 0;
    	if(column != -1) {
    		while(line < nbrLines && !castles[line][column]) {line++;}}
    	return line;
    	}
    
    private void deleteHighBrick(int line, int column) {
    	// Elimination des 6 premières briques de la colonne en partant du haut si elles existant
    	for(int count = 0; count < 6; count++) {
    		if(line + count < nbrLines && column != -1) {
    			castles[line + count][column] = false;
    			if(column < nbrColumn - 1) {
    				castles[line + count][column +1] = false;
    			}
    		}
    	}
    }
    
    public void breakHighBrick(int xShoot) {
    	// Récapitule les 3 méthodes qui précédent
    	Audio.playSound("/sounds/sonCasseBrique.wav");
    	int column = this.findColumnCastle(xShoot);
    	this.deleteHighBrick(findHighBrick(column), column);
    	
    }
}
