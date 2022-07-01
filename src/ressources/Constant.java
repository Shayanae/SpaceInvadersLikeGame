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
}
