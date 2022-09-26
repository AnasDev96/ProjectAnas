package g53203.atl.model;

/**
 * Interface model for Game
 *
 * @author Anas Ben Allal 53203
 */
public interface Model {

    /**
     * Method for give a number on my table
     */
    public void giveNumber();

    /**
     * Simple getter for my board
     *
     * @return tab
     */
    public int[][] getBoardTab();

    /**
     * Can move all number in one direction
     *
     * @param direction my direction
     */
    public void moveNumber(int direction);

    /**
     * Method for finish the game
     *
     * @return true or false
     */
    public boolean finish();

    /**
     * Method for stop the movement if all number are stuck
     *
     * @param direction my direction
     * @return true or false
     */
    public boolean moveStop(int direction);

    /**
     * Method for find if the player won
     *
     * @param tab my board tab
     * @return true or false
     */
    public boolean tabWin(int[][] tab);
}
