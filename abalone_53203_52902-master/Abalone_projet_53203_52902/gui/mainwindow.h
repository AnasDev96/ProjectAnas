#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include "circle.h"
#include <QFormLayout>
#include <QRadioButton>
#include <QMainWindow>
#include <vector>
#include "hexacell.h"
#include <QLineEdit>
#include "QPushButton"
#include <QGraphicsScene>
#include <QGraphicsView>
#include "Game.h"
#include <QLabel>

class MainWindow : public QMainWindow
{
    Q_OBJECT

private:

    QRadioButton  *simpleSelect = new QRadioButton("Simple select") ;
    QRadioButton  *multiSelect = new QRadioButton("Multi select") ;
    QFormLayout *layout = new QFormLayout;
    QLineEdit *pos1 = new QLineEdit;
    QLineEdit *dir = new QLineEdit;
    QLineEdit *pos2 = new QLineEdit;
    QPushButton *pushButton = new QPushButton("Swap");
    QGraphicsScene  * scene = new QGraphicsScene();
    QGraphicsView * view = new QGraphicsView(scene);
    vector<vector<Circle*>> circle;
    Game game_;

public:

   /*!
     * @brief MainWindow, simple constructor
     * @param game , for play the game
     * @param parent, item of widget
     */
    MainWindow(Game game ,QWidget *parent = nullptr);

    /*!
     * destructor
     */
    ~MainWindow();

    /*!
     * @brief handleButton , for do something after press button
     */
    void handleButton();

    /*!
     * @brief displayBoard , display the Board of game
     */
    void displayBoard();

    /*!
     * @brief positionCell , give the position of the user
     * @param str , character of the position
     * @param nb , number, of the position
     * @return a position
     */
    Position positionCell(char str, int nb );

    /*!
     * @brief convertChar, convert charactere on int
     * @param caractere , character to convert
     * @return
     */
    signed int convertChar(char caractere);

    /*!
     * @brief displayPos , to display the different position and  direction
     */
    void displayPos();

    /*!
     * @brief giveDirection, method for have the direction
     * @param dir , the direction
     * @return direction
     */
    Direction giveDirection(int dir);

    /*!
     * @brief displayWinner , method for display the winner
     */
    void displayWinner();
};
#endif // MAINWINDOW_H
