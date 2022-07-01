package ressources;

import jeu.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){Main.scene.starShip.setDx(Constant.dxStarShip);}
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){Main.scene.starShip.setDx(-Constant.dxStarShip);}
    }

    @Override
    public void keyReleased(KeyEvent e) {Main.scene.starShip.setDx(0);}

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
