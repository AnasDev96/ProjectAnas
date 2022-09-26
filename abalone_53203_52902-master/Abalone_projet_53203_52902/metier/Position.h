/**
 * Project ProjetAbalon_53203_52902
 */
#ifndef POSITION_H
#define POSITION_H

#include "Direction.h"
#include "Directions.h"
#include <ostream>
#include <string>

/*!
 * @brief The Position class, create a position of the piece
 */
class Position {

private:

    /*!
     * @brief x_ represent the axis X of the baord
     */
    signed int x_;

    /*!
     * @brief y_ represent the axis Y of the baord
     */
    signed int y_;


public:

    /*!
     * @brief Position constructor of the class
     * @param x the axis X
     * @param y the axis Y
     */
    inline Position(signed int x,  signed int y);

    /*!
     * @brief Position default constructor of position
     */
    inline Position();

    /*!
     * @brief getX simple getter of the X
     * @return the axis X
     */
    inline constexpr signed int getX() const;

    /*!
     * @brief getY simple getter of the Y
     * @return the axis Y
     */
    inline constexpr signed int getY() const;

    /*!
     *
     * @brief nextPosition give the position of the direction
     * @param direction is the direction give
     * @return the position
     *
     */
    Position nextPosition(Direction direction);

    /*!
     * @brief to_string display a position
     * @param position position to display
     * @return string
     */
    inline std::string to_string(const Position & position);

    /*!
     * @brief to_string display a position
     * @return string
     */
    std::string to_string() const;


};
/*!
 * @brief operator << Operator for injecting a Position into an output stream.
 * @param out the stream in which the position is injected.
 * @param position the inject position
 * @return the stream in which the position was injected.
 */
std::ostream & operator<<(std::ostream & out,
                          const Position & position);
/*!
 * @brief operator == to compare two position if there are equals
 * @param p1 the position to compare
 * @param p2 the position to compare
 * @return true or false
 */
constexpr bool operator==(const Position & p1, const Position & p2);


Position::Position(signed int x,  signed int y):
    x_{x}, y_{y}
{}

signed constexpr int Position::getX() const {
    return x_;

}signed constexpr int Position::getY() const{
    return y_;
}

Position::Position(): x_{0}, y_{0}
{}

constexpr bool operator==( const Position  & p1, const Position & p2){
    return p1.getX() == p2.getX() && p1.getY() == p2.getY();
}

inline std::string to_string(const Position & position){
    return position.to_string();
}

#endif //POSITION_H
