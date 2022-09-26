#ifndef DIRECTIONS_H
#define DIRECTIONS_H
#include "Direction.h"
#include <tuple>
#include <string>
using namespace std;

/*!
 * @brief The Directions class, the different directions
 *
 */
class Directions{
public:

    /*!
    * @brief Haut_Gauche_ , top left direction
    */
    constexpr  static tuple<Direction,int,int> Haut_Gauche_ = make_tuple(HAUT_GAUCHE,0,1);

    /*!
    * @brief Haut_Droite_ , top right direction
    */
    constexpr  static tuple<Direction,int,int> Haut_Droite_ = make_tuple(HAUT_DROITE,-1,1);

    /*!
    * @brief Bas_Gauche_ , direction down left
    */
    constexpr  static tuple<Direction,int,int> Bas_Gauche_ = make_tuple(BAS_GAUCHE,1,-1);

    /*!
    * @brief Bas_Droite_ , direction down right
    */
    constexpr static tuple<Direction,int,int> Bas_Droite_ = make_tuple(BAS_DROITE,0,-1);

    /*!
    * @brief Gauche_ , direction left
    */
    constexpr  static tuple<Direction,int,int> Gauche_ = make_tuple(GAUCHE,1,0);

    /*!
    * @brief Droite_ , direction right
    */
    constexpr static tuple<Direction,int,int> Droite_ = make_tuple(DROITE,-1,0);


    /*!
     * @brief opposite give the opposite direction
     * @param direction the opposite of this direction
     * @return opposite direction
     */
    Direction opposite(Direction direction);

    /*!
     * @brief giveDirection give the direction
     * @param direction which direction we want
     * @return tuple
     */
    tuple<Direction,int,int> giveDirection(Direction direction);

};



#endif // DIRECTIONS_H

