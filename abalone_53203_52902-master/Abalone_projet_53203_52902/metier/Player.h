#ifndef PLAYER_H
#define PLAYER_H

#include "PlayerColor.h"
#include "iostream"

/*!
 * @brief The Player class , the players of the game red or blue
 */
class Player
{

private:

    /*!
     * @brief color_ of the player
     */
    PlayerColor color_;

public:

    /*!
     * \brief Player construct a player.
     * \param color is the color of a player.
     */
    inline  Player(PlayerColor color);

    /*!
     * \brief getColor gives us the color of a player.
     * \return the color of a player.
     */
    inline  PlayerColor getColor();

    /*!
    * @brief to_string to display the player
    * @return string
    */
    inline std::string to_string() const;
};

Player::Player(PlayerColor color): color_{color}
{

}

PlayerColor Player::getColor(){
    return color_;
}

std::string Player::to_string() const
{
    std::string result ;
    if(color_ == RED){
        result += "Rouge";
    }else if(color_ == BLUE){
        result += "Bleu";
    }

    return result;
}


#endif // PLAYER_H

