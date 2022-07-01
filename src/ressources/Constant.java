package ressources;

public abstract class Constant {

    /************************************* FENETRE **********************************/
    // Dimensions de la fenêtre
    public static final int windowWidth = 600;
    public static final int windowHeight = 600;
    public static final int windowMargin = 50;

    /************************************ VAISSEAU ********************************>*/
    // DImensions du vaiseau
    public static final int starShipWidth = 39;
    public static final int starShipHeight = 24;

    // Position initiale du vaisseau
    public final static int initial_StarShip_X = (windowWidth - starShipWidth) / 2;
    public final static int initial_StarShip_Y = 490;

    // Unité de déplacement du vaisseau
    public final static int dxStarShip = 1;

    // Limite de déplcaement du vaisseau
    public final static int leftLimitStarShip = 60;
    public final static int rightLimitStarShip = 500;

    /************************************ Alien **************************************/
    // Dimensions de l'alien
    public final static int alienWidth = 33;
    public final static int alienHeight = 25;

    // Paramètres de position des aliens
    public final static int initial_Alien_Y = 120;
    public final static int initial_alien_X = 29 + windowMargin;
    public final static int lineGapAlien = 40;
    public final static int columnGapAlien = 10;

    // Unité de déplacement de l'alien
    public final static int dxAlien = 2;
    public final static int dyAlien = 20;
    public final static int alienSpeed = 1;
}
