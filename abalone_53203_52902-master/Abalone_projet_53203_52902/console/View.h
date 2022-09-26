/**
 * Project ProjetAbalon_53203_52902
 */
#ifndef _VIEW_H
#define _VIEW_H

#include "Board.h"
#include "Player.h"
#include <string>

/*!
 * @brief The View class, to display the game and command
 */
class View {

public:

    /*!
     * @brief displayBoard display the board of the game
     */
    void displayBoard(Board board);

    /*!
     * @brief askPosition ask position of the players
     */
    Position askPosition(Board board);

    /*!
     * @brief askDirection ask direction of the players
     */
    Direction askDirection();

    /*!
     * @brief convertChar allows to translate the position given by the user
     * @param caractere the character entered by the user
     * @return the number of the position on board
     */
    signed int convertChar(char caractere);

    /*!
     * @brief slectMultiple ask the player if he wants to select several ball or not
     * @return true or false
     */
    bool slectMultiple();

    /*!
     * @brief messageTurn show who to play
     * @param player who's to play
     */
    inline void messageTurn(Player player);

    /*!
     * @brief messageHelp display help for the players
     */
    inline void messageHelp();

    /*!
     * @brief displayWinner display winner of the game
     * @param board the game board for see which players is the winner
     */
    void displayWinner(Board board);

};

void View::messageTurn(Player player){
    cout << "C'est au tour du joueur " << player.to_string() << endl;
}

void View::messageHelp(){
    cout<< "Bienvenue dans Abalone !" << endl;
    cout<< "Pour selectionner 3 billes, veuillez entrer 2 positions des extremes" << endl;
}

#endif //_VIEW_H

