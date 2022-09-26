
/**
 * Project ProjetAbalon_53203_52902
 */

#ifndef GAME_H
#define GAME_H

#include "Board.h"
#include "Piece.h"
#include "Player.h"
#include "PlayerColor.h"



/*!
 * \brief The Game class controls the game.
 */
class Game {
private:

    /*!
     * @brief board_ is the board of the game.
     */
    Board board_;

    /*!
      * \brief current_ is the current player.
      */
    Player current_;


private:

    /*!
     * @brief setCurrent  simple setter of current
     * @param player the new color
     */
    void setCurrent();

public:
    /*!
     * @brief Game construct the game
     */
    Game();

    /*!
     * @brief getBoard simple getter for board
     * @return board
     */
    inline Board& getBoard();

    /*!
     * @brief select the piece on the position
     * @param position is the position of the piece
     * @param colorPlayer is the color of the piece
     * @return the piece
     */
    Piece select( Position position , PlayerColor colorPlayer );

    /*!
     * @brief selectMultiple method for select different piece
     * @param piece1 the first piece selected
     * @param piece2 the second piece selected
     * @return the array Piece
     */
    std::vector<Piece> selectMultiple(Piece piece1,Piece piece2);

    /*!
     * @brief isOver method for knows if the game is finish
     * @return true or false
     */
    bool isOver();

    /*!
     * @brief simpleMove can move one single ball
     * @param piece the ball to move
     * @param direction the direction to move
     */
    void simpleMove(Piece piece , Direction direction);

    /*!
     * @brief getCurrent simple getter for current
     * @return player current
     */
    inline Player getCurrent();

};


Player Game::getCurrent(){
    return current_;
}

Board& Game::getBoard(){
    return board_;
}

#endif //GAME_H
