package g53203.atl.model;

/**
 * Class position for my game
 *
 * @author Anas Ben Allal 53203
 */
public class Position {

    private final int i;
    private final int j;

    /**
     * Constructor of position
     *
     * @param i data i for axe x
     * @param j data j for axe y
     */
    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Simple getter for I
     *
     * @return i
     */
    public int getI() {
        return i;
    }

    /**
     * Simple getter for J
     *
     * @return j
     */
    public int getJ() {
        return j;
    }

    /**
     * Method for give a random number for position
     *
     * @return my position
     */
    public Position randomPosition() {
        int x = (int) (Math.random() * ((3 - 0) + 1)) + 0;
        int y = (int) (Math.random() * ((3 - 0) + 1)) + 0;
        Position position = new Position(x, y);

        return position;
    }
}
