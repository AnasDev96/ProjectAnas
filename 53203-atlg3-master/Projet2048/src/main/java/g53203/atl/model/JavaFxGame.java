package g53203.atl.model;

import javafx.scene.input.KeyCode;

/**
 * Class JavaFxGame for move on board of 2048
 *
 * @author Anas Benallal 53203
 */
public class JavaFxGame {

    private int[][] tab;
    private KeyCode keycode;

    /**
     * Constructor of JavaFxGame
     *
     * @param tab board of 2048
     * @param keycode code of direction
     */
    public JavaFxGame(int[][] tab, KeyCode keycode) {
        this.tab = tab;
        this.keycode = keycode;
    }

    /**
     * Default constructor of JavaFxGame
     */
    public JavaFxGame() {
    }

    /**
     * Simple getter of tab
     *
     * @return tab
     */
    public int[][] getTab() {
        return tab;
    }

    /**
     * Simple getter of keycode
     *
     * @return keycode
     */
    public KeyCode getKeycode() {
        return keycode;
    }

    /**
     * Simple setter of tab
     *
     * @param tab tab
     */
    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    /**
     * Simple setter of keycode
     *
     * @param keycode keycode
     */
    public void setKeycode(KeyCode keycode) {
        this.keycode = keycode;
    }

    /**
     *
     * Methode for move
     */
    public void moveNumber() {
        int z = -2;
        for (int i = tab.length - 1; i >= 0; i--) {
            z = -2;
            for (int j = tab[0].length - 1; j >= 0; j--) {
                if (keycode == KeyCode.RIGHT) {
                    //deplacement vers la droite
                    if (j - 1 >= 0) {
                        if (tab[i][j] == 0 && tab[i][j - 1] != 0) {
                            tab[i][j] = tab[i][j - 1];
                            tab[i][j - 1] = 0;
                            j = tab[0].length;
                        } else if (tab[i][j] != 0 && tab[i][j] == tab[i][j - 1] && j != z) {
                            if (j - 1 != z) {
                                tab[i][j] = tab[i][j] + tab[i][j - 1];
                                tab[i][j - 1] = 0;
                                z = j;
                            }
                        }
                    }
                } else if (keycode == KeyCode.DOWN) {
                    // deplacement vers le bas
                    if (j - 1 >= 0) {
                        if (tab[j][i] == 0 && tab[j - 1][i] != 0) {
                            tab[j][i] = tab[j - 1][i];
                            tab[j - 1][i] = 0;
                            j = tab[0].length;
                        } else if (tab[j][i] != 0 && tab[j][i] == tab[j - 1][i] && j != z) {
                            if (j - 1 != z) {
                                tab[j][i] = tab[j][i] + tab[j - 1][i];
                                tab[j - 1][i] = 0;
                                z = j;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < tab.length; i++) {
            z = -2;
            for (int j = 0; j < tab[0].length; j++) {
                if (keycode == KeyCode.UP) {
                    //   Deplacement vers le haut
                    if (j + 1 < tab.length) {
                        if (tab[j][i] == 0 && tab[j + 1][i] != 0) {
                            tab[j][i] = tab[j + 1][i];
                            tab[j + 1][i] = 0;
                            j = -1;
                        } else if (tab[j][i] != 0 && tab[j][i] == tab[j + 1][i] && j != z) {
                            if (j + 1 != z) {
                                tab[j][i] = tab[j][i] + tab[j + 1][i];
                                tab[j + 1][i] = 0;
                                z = j;
                            }
                        }
                    }
                } else if (keycode == KeyCode.LEFT) {
                    //deplacement vers la gauche
                    if (j + 1 < tab.length) {
                        if (tab[i][j] == 0 && tab[i][j + 1] != 0) {
                            tab[i][j] = tab[i][j + 1];
                            tab[i][j + 1] = 0;
                            j = -1;
                        } else if (tab[i][j] != 0 && tab[i][j] == tab[i][j + 1] && j != z) {
                            if (j + 1 != z) {
                                tab[i][j] = tab[i][j] + tab[i][j + 1];
                                tab[i][j + 1] = 0;
                                z = j;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Method for finish the game
     *
     * @return true or false
     */
    public boolean finish() {
        boolean end = false;
        int cpt = 0;
        int value = 0;
        int stop = 0;
        for (int i = 0; i < tab.length && !end; i++) {
            for (int j = 0; j < tab[0].length && !end; j++) {
                if (tab[i][j] != 0 && cpt != tab.length * tab[0].length) {
                    cpt++;
                }
                if (cpt == tab.length * tab[0].length) {
                    value++;
                    if (value == 1) {
                        i = 0;
                        j = 0;
                    }
                    if (j + 1 < tab[0].length && i + 1 < tab.length) {
                        if (tab[i][j] == tab[i + 1][j]
                                || tab[i][j] == tab[i][j + 1] || tab[i][j] == tab[i + 1][j + 1]) {
                            stop++;
                        }
                    }
                    if (j - 1 >= 0 && i - 1 >= 0) {
                        if (tab[i][j] == tab[i - 1][j]
                                || tab[i][j] == tab[i][j - 1] || tab[i][j] == tab[i - 1][j - 1]) {
                            stop++;
                        }
                    }
                }
                if (tab[i][j] == 2048) {
                    end = true;
                }
            }
        }
        if (stop == 0 && cpt == tab.length * tab[0].length) {
            end = true;
        }
        return end;
    }

    /**
     * Method for stop the movement if all number are stuck
     *
     *
     * @return true or false
     */
    public boolean moveStop() {
        boolean stop = false;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {

                if (keycode == KeyCode.RIGHT) {
                    // droite
                    if (j + 1 < tab[0].length && tab[i][j] != 0) {
                        if (tab[i][j] == tab[i][j + 1] || tab[i][j + 1] == 0) {

                            stop = true;
                            i = tab.length;
                            j = tab[0].length;
                        }
                    }
                } else if (keycode == KeyCode.LEFT) {
                    // gquche
                    if (j - 1 >= 0 && tab[i][j] != 0) {
                        if (tab[i][j] == tab[i][j - 1] || tab[i][j - 1] == 0) {

                            stop = true;
                            i = tab.length;
                            j = tab[0].length;
                        }
                    }
                } else if (keycode == KeyCode.UP) {
                    // haut
                    if (i - 1 >= 0 && tab[i][j] != 0) {
                        if (tab[i][j] == tab[i - 1][j] || tab[i - 1][j] == 0) {
                            stop = true;
                            i = tab.length;
                            j = tab[0].length;
                        }
                    }
                } else if (keycode == KeyCode.DOWN) {
                    // bas
                    if (i + 1 < tab[0].length && tab[i][j] != 0) {
                        if (tab[i][j] == tab[i + 1][j] || tab[i + 1][j] == 0) {
                            stop = true;
                            i = tab.length;
                            j = tab[0].length;
                        }
                    }
                }
            }

        }
        return stop;
    }
}
