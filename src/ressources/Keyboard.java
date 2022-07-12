package ressources;

import jeu.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
    	if(Main.scene.starShip.isAlive()){
    		if(e.getKeyCode() == KeyEvent.VK_RIGHT){Main.scene.starShip.setDx(Constant.dxStarShip);}
        	else if(e.getKeyCode() == KeyEvent.VK_LEFT){Main.scene.starShip.setDx(-Constant.dxStarShip);}
        	else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            	if (!Main.scene.starShipShoot.isStarShipFire()){
                	Main.scene.starShipShoot.setyPos(Constant.initial_StarShip_Y - Constant.heightStarShipShoot);
                	Main.scene.starShipShoot.setxPos(Main.scene.starShip.getxPos() + Constant.starShipWidth/2 - 1);
                	Main.scene.starShipShoot.setStarShipFire(true);
            	}
        	}
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {Main.scene.starShip.setDx(0);}

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
