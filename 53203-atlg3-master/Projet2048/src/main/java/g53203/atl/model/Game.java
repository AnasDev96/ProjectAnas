package g53203.atl.model;

/**
 * Class Game all method for run my game
 *
 * @author g53203 - Anas Ben Allal
 *
 */
public class Game implements Model {

    private int[][] tab;
    private final Position position;

    /**
     * Constructor of Game
     */
    public Game() {
        
        tab = new int[4][4];
        position = new Position(0, 0);
       
    }

    @Override
    public int[][] getBoardTab() {
        return tab;
    }

    /**
     * Simple setter of tab
     *
     * @param tab tab of board
     */
    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    @Override
    public void giveNumber() {
        int x = position.randomPosition().getI();
        int y = position.randomPosition().getJ();
        int z = (int) (Math.random() * ((1 - 0) + 1)) + 0;
        boolean find = false;
        for (int i = 0; i < tab.length && !find; i++) {
            for (int j = 0; j < tab[0].length && !find; j++) {
                if (tab[x][y] == 0) {
                    if (z == 1) {
                        tab[x][y] = 2;
                    } else {
                        tab[x][y] = 4;
                    }
                    find = true;
                } else {
                    x = position.randomPosition().getI();
                    y = position.randomPosition().getJ();
                }
            }
        }
    }

    @Override
    public void moveNumber(int direction) {
        int z = -2;
        for (int i = tab.length - 1; i >= 0; i--) {
            z = -2;
            for (int j = tab[0].length - 1; j >= 0; j--) {
                switch (direction) {
                    case 3:
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
                        break;
                    case 2:
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
                        break;
                }
            }

        }
        for (int i = 0; i < tab.length; i++) {
            z = -2;
            for (int j = 0; j < tab[0].length; j++) {
                //   Deplacement vers le haut
                switch (direction) {
                    case 5:
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
                        break;
                    case 1:
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
                        break;
                }
            }
        }
    }

    @Override
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
                                || tab[i][j] == tab[i][j + 1] ) {
                            stop++;
                        }
                    }
                    if (j - 1 >= 0 && i - 1 >= 0) {
                        if (tab[i][j] == tab[i - 1][j]
                                || tab[i][j] == tab[i][j - 1]) {
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

    @Override
    public boolean moveStop(int direction) {
        boolean stop = false;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                switch (direction) {
                    case 3:
                        if (j + 1 < tab[0].length && tab[i][j] != 0) {
                            if (tab[i][j] == tab[i][j + 1] || tab[i][j + 1] == 0) {
                                stop = true;
                                i = tab.length;
                                j = tab[0].length;
                            }
                        }
                        break;
                    case 1:
                        if (j - 1 >= 0 && tab[i][j] != 0) {
                            if (tab[i][j] == tab[i][j - 1] || tab[i][j - 1] == 0) {
                                stop = true;
                                i = tab.length;
                                j = tab[0].length;
                            }
                        }
                        break;
                    case 5:
                        if (i - 1 >= 0 && tab[i][j] != 0) {
                            if (tab[i][j] == tab[i - 1][j] || tab[i - 1][j] == 0) {
                                stop = true;
                                i = tab.length;
                                j = tab[0].length;
                            }
                        }
                        break;
                    case 2:
                        if (i + 1 < tab[0].length && tab[i][j] != 0) {
                            if (tab[i][j] == tab[i + 1][j] || tab[i + 1][j] == 0) {
                                stop = true;
                                i = tab.length;
                                j = tab[0].length;
                            }
                        }
                        break;
                }
            }

        }
        return stop;
    }

    @Override
    public boolean tabWin(int[][] tab) {
        boolean win = false;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] == 2048) {
                    win = true;
                }
            }
        }
        return win;
    }
}
