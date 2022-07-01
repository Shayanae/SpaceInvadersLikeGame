package ressources;

import jeu.Main;

public class Timer implements Runnable{

    // VARIABLES

    private final int pause = 5;
    public static int roundCount = 0;


    // METHODES

    @Override
    public void run() {
        while (true){
            roundCount++;
            Main.scene.repaint(); // Appel de la méthode PaintComponent de l'objet scene
            try{Thread.sleep(pause);} // temps de pause (5ms)
            catch (InterruptedException e){}
        }
    }
}
