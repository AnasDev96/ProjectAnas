/**
 * Project ProjetAbalon_53203_52902
 */
#ifndef BOARD_H
#define BOARD_H

#include "PlayerColor.h"
#include "Piece.h"
#include "Direction.h"
#include <vector>
#include <algorithm>
#include "Position.h"


/*!
 * \brief The Board class represent the board of the game.
 *
 */
class Board {

private:

    /*!
     * @brief board contains the board of the game
     */
    vector<vector<Piece>> board_;

public:

    /*!
    * @brief Board is the contructor of the class
    */
    Board();

    /*!
    * Check if our position is inside the board.
    * @param Position position is the position we test
    * @return true or false
    */
    bool isInside( Position position);

    /*!
    *  Check if the square is free.
    * @param Position position is the position we test
    * @return true or false
    */
    bool isFreeBoard(unsigned long long x,unsigned long long y);

    /*!
    * Change position with position1 and positon2 if they are in the board else
    *  delete the piece
    * @param position1 position of the first piece
    * @param position2 position of the second piece
    */
    void swap( std::vector<Piece> piece, Direction direction);

    /*!
     * Simple getter of board
     * @brief getBoard
     * @return Board
     */
    inline vector<vector<Piece>> getBoard();

    /*!
     * place a piece on the board
     * @param Piece piece the piece in the board
     */
    inline void putPiece( unsigned long long x,unsigned long long y,Piece piece);

    /*!
     * For recover the piece on the position
     * @brief getPieceOnPosition
     * @param position is the position of the square.
     * @return the piece on the position on the board
     */
    inline Piece getPieceOnPosition( Position position);

    /*!
     * Method for push the piece on a direction
     * @param Piece pieces is the array piece for push all the piece
     * @param Direction direction is the direction for push
     */
    void push(std::array<Piece,3> piece,  Direction direction);

    /*!
     * @brief isFree for see if the position is free or not
     * @param position the position to check
     * @return true or false
     */
    inline bool isFree(Position position);

    /*!
     * @brief colorPos give the color on a position
     * @param position the position to check
     * @return Blue, Red or NONE
     */
    inline PlayerColor colorPos(Position position);

    /*!
     * @brief equalsColor Check if the given position has the same color as the ball
     * @param position the position to be checked
     * @param piece color of the piece to be checked
     * @return ture or false
     */
    inline bool equalsColor(Position position, Piece piece);

    /*!
     * @brief removePiece remove a Piece
     * @param piece to remove
     */
    inline void removePiece(Piece piece);

    /*!
     * @brief setPiece change a piece in the board with index
     * @param i index
     * @param j index
     * @param piece the piece to set
     */
    inline void setPiece(unsigned long long i , unsigned long long j,Piece piece);

    /*!
      * @brief posBoard Gives the position in the board of the position of the ball
      * @param position the index of the board
      * @return position
      */
    Position posBoard(Position position);

    /*!
     * @brief triPiece sorts a vector based on direction
     * @param piece the vector of piece
     * @param dir direction give
     * @return a sorted vector of the piece
     */
    vector<Piece> triPiece(vector<Piece> piece, Direction dir);

    /*!
     * @brief canPush for know if is possible to push in the direction
     * @param piece vector of piece
     * @param direction which direction to push
     * @return true or false
     */
    bool canPush(vector<Piece> piece,Direction direction);

    /*!
     * @brief push  allows to push in a given direction
     * @param piece vector of piece
     * @param direction which direction to push
     * @return the vector of piece
     */
    vector<Piece> push(vector<Piece> piece,Direction direction);

    /*!
     * @brief selectDir gives the meaning of the different balls
     * @param piece the vector of piece
     * @return a direction
     */
    Direction selectDir(vector<Piece> piece);

    /*!
     * @brief removePieceOnIndex method remove on index a piece
     * @param i index
     * @param j index
     */
    void removePieceOnIndex(unsigned long long i , unsigned long long j);

};


bool Board::isFree(Position position){
    return board_[posBoard(position).getX()][posBoard(position).getY()].getPlayerColor() == NONE;
}

vector<vector<Piece>> Board::getBoard(){
    return board_;
}

void  Board::putPiece(unsigned long long x,unsigned long long y,Piece piece){
    if(x > board_.size()  || y > board_[x].size()){
        throw invalid_argument("Index endehor");
    }
    board_[x][y] = piece;
}


PlayerColor Board::colorPos(Position position){
    return board_[posBoard(position).getX()][posBoard(position).getY()].getPlayerColor();
}


Piece Board::getPieceOnPosition(Position position){
    return board_[posBoard(position).getX()][posBoard(position).getY()];
}


bool Board::equalsColor(Position position,Piece piece){
    return board_[posBoard(position).getX()][posBoard(position).getY()].getPlayerColor() == piece.getPlayerColor();
}


void Board::removePiece(Piece piece){
    board_[posBoard(piece.getPosition()).getX()][posBoard(piece.getPosition()).getY()].setPlayerColor(NONE);
}


void Board::setPiece(unsigned long long i, unsigned long long j,Piece piece){
    board_[i][j].setPlayerColor(piece.getPlayerColor());
}

#endif //BOARD_H
