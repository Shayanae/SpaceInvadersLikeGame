package jeu;

import ressources.Constant;

import javax.swing.*;

public class Main {

    // VARIABLES

	public static Scene scene;
	public static boolean game = true;

    public static void main(String[] args) {
        // Création de la fenêtre de l'application
        JFrame window = new JFrame("Space Invaders");
        window.setSize(Constant.windowWidth, Constant.windowHeight);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setAlwaysOnTop(true);

        // Association du panneau Scene à la fêtre
        scene = new Scene();
        window.setContentPane(scene);

        window.setVisible(true);
    }
}
