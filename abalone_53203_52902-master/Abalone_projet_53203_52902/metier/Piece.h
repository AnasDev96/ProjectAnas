/**
 * Project ProjetAbalon_53203_52902
 */

#ifndef PIECE_H
#define PIECE_H

#include <iostream>
#include "PlayerColor.h"
#include "Position.h"

/*!
 * @brief The Piece class, the class that creates the ball of the game
 */
class Piece {

private:

    /*!
     * @brief color_ color of the piece
     */
    PlayerColor color_;

    /*!
     * @brief position_ position of the piece
     */
    Position position_;

public:

    /*!
      * @brief Piece constructor of the class Piece
      * @param color of the piece
      * @param position of the piece
      */
    inline Piece( PlayerColor color,  Position position);

    /*!
     * @brief Piece default constructor
     */
    inline Piece();

    /*!
      * @brief setPosition change the position for the piece
      * @param position new position of the piece
      */
    inline void setPosition(Position position);

    /*!
     * @brief setPlayerColor simple setter of color
     * @param color the new color
     */
    inline void setPlayerColor(PlayerColor color);

    /*!
     * Simple getter for PlayerColor
     * @brief getPlayerColor
     * @return PlayerColor the PlayerColor
     */
    inline constexpr PlayerColor getPlayerColor() const;

    /*!
     *
     * @brief getPosition Simple getter of the position
     * @return the position
     */
    inline  Position getPosition() ;

    /*!
     * @brief to_string diplayer the piece (ball color)
     * @return string
     */
    inline std::string to_string() const;

};

/*!
 * @brief operator == compare two piece if there are equals
 * @param p1 the piece to comparer
 * @param p2 the piece to comparer
 * @return true or false
 */
inline bool operator==( Piece & p1,  Piece & p2);

Piece::Piece( PlayerColor color,  Position position):
    color_{color},
    position_{position}
{
}

void Piece::setPlayerColor(PlayerColor color){
    color_ = color;
}

void Piece::setPosition(Position position){
    position_ = position;
}

Position Piece::getPosition() {
    return position_;
}

constexpr PlayerColor Piece::getPlayerColor() const{
    return color_;
}

Piece::Piece(): color_{NONE}{}

bool operator==( Piece & p1,  Piece & p2){
    return  p1.getPosition() == p2.getPosition()  && p1.getPlayerColor() == p2.getPlayerColor();
}

std::string Piece::to_string() const
{
    std::string result ;
    if(color_ == RED){
        result += "R ";
    }else if(color_ == BLUE){
        result += "B ";
    }
    return result;
}


#endif //PIECE_H

