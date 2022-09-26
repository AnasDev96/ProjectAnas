package g53203.atl.main;

import g53203.atl.controller.Controller;
import g53203.atl.model.Game;
import g53203.atl.view.View;

/**
 * Class Main run the game
 * @author g53203 - Anas Ben Allal
 */
public class Main {
       /**
        * Main methode, for initialise controler and start
        * @param args args 
        */
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();   
      
 
    }
}
