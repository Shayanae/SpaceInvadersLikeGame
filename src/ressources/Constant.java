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
    
    // Nombre total d'aliens
    public final static int nbrAliens = 50;

    /********************************** TIR VAISSEAU *********************************/
    // Dimension du tir
    public static final int widthStarShipShoot = 3;
    public static final int heightStarShipShoot = 13;

    // Unité de déplacement du tir
    public final static int dyStarShipShoot = 2;

    /********************************** CHATEAU *************************************/
    // Dimension de la brique
    public static final int brickSize = 2;

    // Dimensions du château (multiples des dimensions de la brique)
    public static final int castleWidth = 72;
    public static final int castleHeight = 54;

    // Paramètres de position des châteaux
    public final static int yPosCastle = 400;
    public final static int xPosCastle = 39;
    public final static int castleGap = 42;
    
    /********************************** TIR ALIEN ***********************************/
    // Dimensions du tir
    public static final int alienShootWidth = 5;
    public static final int alienShootHeight = 15;
    
    // Unité de déplacement du tir
    public final static int dyAlienShoot = 3;
    
    /********************************** UFO *****************************************/
    // Dimensions de la soucoupe
    public static final int uFOWidth = 42;
    public static final int uFOHeight = 22;
    
    // Position initiale de la soucoupe
    public final static int xPosUFO = windowWidth;
    public final static int yPosUFO = 50;
    
    // Unité de déplacement de la soucoupe
    public final static int dxUFO = 1;
    
    /********************************** SCORE **************************************/
    // Points attribués pour la destruction des aliens
    public static final int highAlienValue = 50;
    public static final int middleAlienValue = 40;
    public static final int lowAlienValue = 20;
    public static final int ufoValue = 100;
}
