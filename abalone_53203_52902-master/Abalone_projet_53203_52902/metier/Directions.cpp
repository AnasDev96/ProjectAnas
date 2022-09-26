#include "Directions.h"
#include <iostream>


Direction Directions::opposite(Direction direction){

    Direction opposite;
    switch (direction) {
    case GAUCHE :
        opposite = std :: get < 0 > ( Droite_ );
        break;
    case DROITE:
        opposite = std :: get < 0 > ( Gauche_ );
        break;
    case HAUT_DROITE:
        opposite = std :: get < 0 > ( Bas_Gauche_ );
        break;
    case HAUT_GAUCHE:
        opposite = std :: get < 0 > ( Bas_Droite_ );
        break;
    case BAS_DROITE:
        opposite = std :: get < 0 > ( Haut_Gauche_ );
        break;
    case BAS_GAUCHE:
        opposite = std :: get < 0 > ( Haut_Droite_ );
        break;
    }
    return opposite;
}

tuple<Direction,int,int> Directions::giveDirection(Direction direction){
    tuple<Direction,int,int> directionChose;
    switch (direction) {
    case DROITE :
        directionChose = Droite_;
        break;
    case GAUCHE:
        directionChose = Gauche_;
        break;
    case BAS_GAUCHE:
        directionChose = Bas_Gauche_;
        break;
    case BAS_DROITE:
        directionChose = Bas_Droite_;
        break;
    case HAUT_DROITE:
        directionChose = Haut_Droite_;
        break;
    case HAUT_GAUCHE:
        directionChose = Haut_Gauche_;
        break;
    }
    return directionChose;
}
