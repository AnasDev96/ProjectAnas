#include "Position.h"
#include <iostream>


std::string Position::to_string() const{
    std::string result = "Position( ";
    result += std::to_string(x_);
    result += " , ";
    result += std::to_string(y_);
    result += " )";
    return result;
}

std::ostream & operator<<(std::ostream & out,
                          const Position & position)
{
    return out << position.to_string();
}

Position Position::nextPosition(Direction direction){
    Directions directions = Directions();
    return Position(x_ + std :: get <1> (directions.giveDirection(direction)),y_ + std :: get < 2 > (directions.giveDirection(direction)));

}
