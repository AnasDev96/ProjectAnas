/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53203.atl.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author -
 */
public class GameTest {

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberRight() {
        System.out.println("moveNumberRight");
        int direction = 3;
        Game instance = new Game();
        instance.getBoardTab()[0][0] = 2;
        instance.getBoardTab()[1][0] = 2;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[0][3] = 2;
        test.getBoardTab()[1][3] = 2;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }

    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberLeft() {
        System.out.println("moveNumberLeft");
        int direction = 1;
        Game instance = new Game();
        instance.getBoardTab()[0][3] = 2;
        instance.getBoardTab()[1][3] = 2;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[0][0] = 2;
        test.getBoardTab()[1][0] = 2;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }
    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberTop() {
        System.out.println("moveNumberTop");
        int direction = 5;
        Game instance = new Game();
        instance.getBoardTab()[3][0] = 2;
        instance.getBoardTab()[3][1] = 2;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[0][0] = 2;
        test.getBoardTab()[0][1] = 2;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }
    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberBottom() {
        System.out.println("moveNumberBottom");
        int direction = 2;
        Game instance = new Game();
        instance.getBoardTab()[0][0] = 2;
        instance.getBoardTab()[1][1] = 2;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[3][0] = 2;
        test.getBoardTab()[3][1] = 2;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }

    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberAddRight() {
        System.out.println("moveNumberAddRight");
        int direction = 3;
        Game instance = new Game();
        instance.getBoardTab()[0][0] = 2;
        instance.getBoardTab()[0][1] = 2;
        instance.getBoardTab()[0][2] = 4;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[0][3] = 4;
        test.getBoardTab()[0][2] = 4;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }
    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberAddLeft() {
        System.out.println("moveNumberAddLeft");
        int direction = 1;
        Game instance = new Game();
        instance.getBoardTab()[0][3] = 2;
        instance.getBoardTab()[0][2] = 2;
        instance.getBoardTab()[0][1] = 4;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[0][0] = 4;
        test.getBoardTab()[0][1] = 4;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }

    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberAddBottom() {
        System.out.println("moveNumberAddBottom");
        int direction = 2;
        Game instance = new Game();
        instance.getBoardTab()[0][0] = 2;
        instance.getBoardTab()[1][0] = 2;
        instance.getBoardTab()[2][0] = 4;
        instance.getBoardTab()[0][1] = 4;
        instance.getBoardTab()[1][1] = 4;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[3][1] = 8;
        test.getBoardTab()[3][0] = 4;
        test.getBoardTab()[2][0] = 4;

        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }

    }

    /**
     * Test of moveNumber method, of class Game.
     */
    @Test
    public void testMoveNumberAddTop() {
        System.out.println("moveNumberAddTop ");
        int direction = 5;
        Game instance = new Game();
        instance.getBoardTab()[3][0] = 2;
        instance.getBoardTab()[2][0] = 2;
        instance.getBoardTab()[1][0] = 4;
        instance.getBoardTab()[3][1] = 2;
        instance.getBoardTab()[2][1] = 2;
        instance.getBoardTab()[1][1] = 8;
        instance.moveNumber(direction);
        Game test = new Game();
        test.getBoardTab()[0][0] = 4;
        test.getBoardTab()[1][0] = 4;
        test.getBoardTab()[0][1] = 8;
        test.getBoardTab()[1][1] = 4;
        for (int i = 0; i < instance.getBoardTab().length; i++) {
            for (int j = 0; j < instance.getBoardTab()[0].length; j++) {
                assertEquals(instance.getBoardTab()[i][j], test.getBoardTab()[i][j]);
            }
        }
    }

    /**
     * Test of finish method, of class Game.
     */
    @Test
    public void testFinish() {
        System.out.println("finish");
        Game instance = new Game();
        instance.getBoardTab()[3][2] = 2048;
        boolean expResult = true;
        boolean result = instance.finish();
        assertEquals(expResult, result);

    }

    /**
     * Test of finish method, of class Game.
     */
    @Test
    public void testFinishLose() {
        System.out.println("finishLose");
        int[][] tab = new int[][]{{2, 4, 8, 2}, {4, 128, 2, 32}, {8, 32, 256, 8}, {2, 4, 8, 2}};
        Game instance = new Game();
        instance.setTab(tab);
        boolean expResult = true;
        boolean result = instance.finish();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of finish method, of class Game.
     */
    @Test
    public void testFinishLoseStuck() {
        System.out.println("finishLoseStuck");
        int[][] tab = new int[][]{{4, 2, 32, 4}, {16, 8, 256, 32}, {8, 2, 64, 4}, {2, 128, 4, 2}};
        Game instance = new Game();
        instance.setTab(tab);
        boolean expResult = true;
        boolean result = instance.finish();
        assertEquals(expResult, result);
    }
    /**
     * Test of finish method, of class Game.
     */
    @Test
    public void testFinishLoseStuck2() {
        System.out.println("finishLoseStuck2");
        int[][] tab = new int[][]{{2, 16, 8, 2}, {128, 8, 16, 32}, {2, 4, 2, 8}, {4, 32, 16, 2}};
        Game instance = new Game();
        instance.setTab(tab);
        boolean expResult = true;
        boolean result = instance.finish();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopFalseRight() {
        System.out.println("moveStopFalse");
        int direction = 3;
        int[][] tab = new int[][]{{0, 0, 0, 2},{0, 0, 2, 32},{0, 0, 0, 8},{0, 0, 0, 2}};
        Game instance = new Game();
        instance.setTab(tab);

        assertFalse(instance.moveStop(direction));

    }
    /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopTrueRight() {
        System.out.println("moveStopTrueRight");
        int direction = 3;
        int[][] tab = new int[][]{{0, 0, 2, 2},{0, 0, 2, 32},{0, 0, 0, 8},{0, 0, 0, 2}};
        Game instance = new Game();
        instance.setTab(tab);
        assertTrue(instance.moveStop(direction));

    }
     /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopTrueUp() {
        System.out.println("moveStopTrueUp");
        int direction = 5;
        int[][] tab = new int[][]{{0, 0, 2, 2},{0, 0, 2, 32},{0, 0, 0, 2},{0, 0, 0, 2}};
        Game instance = new Game();
        instance.setTab(tab);
        assertTrue(instance.moveStop(direction));

    }
    /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopFlaseUp() {
        System.out.println("moveStopFalseUp");
        int direction = 5;
        int[][] tab = new int[][]{{0, 0, 2, 2},{0, 0, 0, 32},{0, 0, 0, 8},{0, 0, 0, 2}};
        Game instance = new Game();
        instance.setTab(tab);
        assertFalse(instance.moveStop(direction));

    }
    /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopFlaseLeft() {
        System.out.println("moveStopFalseLeft");
        int direction = 1;
        int[][] tab = new int[][]{{2, 0, 0, 0},{2, 0, 0, 0},{2, 8, 0, 0},{0, 0, 0, 0}};
        Game instance = new Game();
        instance.setTab(tab);
        assertFalse(instance.moveStop(direction));

    }
    /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopFlaseDown() {
        System.out.println("moveStopFalseDown");
        int direction = 2;
        int[][] tab = new int[][]{{0, 0, 0, 2},{0, 0, 0, 32},{0, 0, 0, 4},{0, 0, 8, 8}};
        Game instance = new Game();
        instance.setTab(tab);
        assertFalse(instance.moveStop(direction));

    }
    /**
     * Test of moveStop method, of class Game.
     */
    @Test
    public void testmoveStopTrueDown() {
        System.out.println("moveStopTrueDown");
        int direction = 2;
        int[][] tab = new int[][]{{0, 0, 0, 2},{0, 0, 0, 32},{0, 0, 0, 8},{0, 0, 8, 8}};
        Game instance = new Game();
        instance.setTab(tab);
        assertTrue(instance.moveStop(direction));
    }
    /**
     * Test of tabWin method, of class Game.
     */
    @Test
    public void testTabWinTrue() {
        System.out.println("TabWinTrue");
        int[][] tab = new int[][]{{0, 0, 2048, 2},{0, 0, 0, 32},{0, 0, 0, 8},{0, 0, 8, 8}};
        Game instance = new Game();
        instance.setTab(tab);
        assertTrue(instance.tabWin(instance.getBoardTab()));
    }
    /**
     * Test of tabWin method, of class Game.
     */
    @Test
    public void testTabWinFalse() {
        System.out.println("TabWinFalse");  
        int[][] tab = new int[][]{{0, 0, 0, 2},{0, 0, 0, 32},{0, 0, 0, 8},{0, 0, 8, 8}};
        Game instance = new Game();
        instance.setTab(tab);
        assertFalse(instance.tabWin(instance.getBoardTab()));
    }
    
}
