package g53203.atl.view;

/**
 * Interface InterfaceView
 *
 * @author Anas Ben Allal 53203
 */
public interface InterfaceView {

    /**
     * Method for ask a direction
     *
     * @return a number
     */
    public int askMove();

    /**
     * Method for display the board
     *
     * @param tab my 2D tab
     */
    public void displayBoard(int[][] tab);

    /**
     * Method for display the touch for movement
     */
    public void displayTouch();

    /**
     * Method for display the error message
     *
     * @param message message
     */
    public void displayError(String message);

    /**
     * Method for display the winner or loser
     *
     * @param player boolean player
     */
    public void displayWinnerOrLoser(boolean player);
}
