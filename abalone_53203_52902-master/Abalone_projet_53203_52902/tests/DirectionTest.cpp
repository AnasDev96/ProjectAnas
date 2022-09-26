#include "Directions.h"
#include "catch.hpp"

TEST_CASE("Testing methods of Directions class"){

    SECTION("Testing opposite direction left"){
        Directions dir = Directions();
        bool expect = dir.opposite(GAUCHE) == DROITE;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction right"){
        Directions dir = Directions();
        bool expect = dir.opposite(DROITE) == GAUCHE;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Up rigt"){
        Directions dir = Directions();
        bool expect = dir.opposite(HAUT_DROITE) == BAS_GAUCHE;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Up left"){
        Directions dir = Directions();
        bool expect = dir.opposite(HAUT_GAUCHE) == BAS_DROITE;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Down right"){
        Directions dir = Directions();
        bool expect = dir.opposite(BAS_DROITE) == HAUT_GAUCHE;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Down left"){
        Directions dir = Directions();
        bool expect = dir.opposite(BAS_GAUCHE) == HAUT_DROITE;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction left"){
        Directions dir = Directions();
        tuple<Direction,int,int> directionChose =  make_tuple(GAUCHE,1,0);
        bool expect = directionChose == dir.giveDirection(GAUCHE) ;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction rigt"){
        Directions dir = Directions();
        tuple<Direction,int,int> directionChose =   make_tuple(DROITE,-1,0);
        bool expect = directionChose == dir.giveDirection(DROITE) ;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Up rigt"){
        Directions dir = Directions();
        tuple<Direction,int,int> directionChose =  make_tuple(HAUT_DROITE,-1,1);
        bool expect = directionChose == dir.giveDirection(HAUT_DROITE) ;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Up left"){
        Directions dir = Directions();
        tuple<Direction,int,int> directionChose =  make_tuple(HAUT_GAUCHE,0,1);
        bool expect = directionChose == dir.giveDirection(HAUT_GAUCHE) ;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Down left"){
        Directions dir = Directions();
        tuple<Direction,int,int> directionChose =  make_tuple(BAS_GAUCHE,1,-1);
        bool expect = directionChose == dir.giveDirection(BAS_GAUCHE) ;
        REQUIRE(expect);
    }

    SECTION("Testing opposite direction Down right"){
        Directions dir = Directions();
        tuple<Direction,int,int> directionChose =  make_tuple(BAS_DROITE,0,-1);
        bool expect = directionChose == dir.giveDirection(BAS_DROITE) ;
        REQUIRE(expect);
    }

}
