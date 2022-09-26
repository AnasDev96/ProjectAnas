#include "catch.hpp"
#include "Game.h"

TEST_CASE("Testing methods of Game class"){

    SECTION("Testing isOver True"){
        Game game = Game();
        game.getBoard().removePieceOnIndex(0,0);
        game.getBoard().removePieceOnIndex(0,1);
        game.getBoard().removePieceOnIndex(0,2);
        game.getBoard().removePieceOnIndex(0,3);
        game.getBoard().removePieceOnIndex(0,4);
        game.getBoard().removePieceOnIndex(0,5);
        game.getBoard().removePieceOnIndex(1,0);
        REQUIRE(game.isOver());
    }

    SECTION("Testing isOver False"){
        Game game = Game();
        REQUIRE_FALSE(game.isOver());
    }

    SECTION("Testing selectMultiple Two Piece"){
        Game game = Game();
        Piece piece = game.getBoard().getBoard()[6][2];
        Piece piece2 = game.getBoard().getBoard()[6][3];
        game.selectMultiple(piece,piece2);
        vector<Piece> vector(2);

        vector.at(0) = piece2;
        vector.at(1) = piece;
        bool expect = vector.at(0) == game.selectMultiple(piece,piece2).at(0)
                && vector.at(1) == game.selectMultiple(piece,piece2).at(1);
        REQUIRE(expect);
    }

    SECTION("Testing selectMultiple Three Piece"){
        Game game = Game();
        Piece piece = game.getBoard().getBoard()[6][2];
        Piece piece2 = game.getBoard().getBoard()[6][3];
        Piece piece3 = game.getBoard().getBoard()[6][4];
        game.selectMultiple(piece,piece3);
        vector<Piece> vector(3);
        vector.at(2) = piece;
        vector.at(0) = piece3;
        vector.at(1) = piece2;
        bool expect = vector.at(0) == game.selectMultiple(piece,piece3
                                                          ).at(0)
                && vector.at(1) == game.selectMultiple(piece,piece3).at(1)
                && vector.at(2) == game.selectMultiple(piece,piece3).at(2) ;
        REQUIRE(expect);
    }
    SECTION("Testing simpleMove Up left"){
        Game game = Game();
        game.simpleMove(game.getBoard().getBoard()[6][2], HAUT_GAUCHE);
        bool expect = game.getBoard().getBoard()[5][2].getPlayerColor() == BLUE;
        REQUIRE(expect);
    }

    SECTION("Testing simpleMove Up right"){
        Game game = Game();
        game.simpleMove(game.getBoard().getBoard()[6][2], HAUT_DROITE);
        bool expect = game.getBoard().getBoard()[5][3].getPlayerColor() == BLUE;
        REQUIRE(expect);
    }

    SECTION("Testing simpleMove Left"){
        Game game = Game();
        game.simpleMove(game.getBoard().getBoard()[6][2], GAUCHE);
        bool expect = game.getBoard().getBoard()[6][1].getPlayerColor() == BLUE;
        REQUIRE(expect);
    }

    SECTION("Testing simpleMove Right"){
        Game game = Game();
        game.simpleMove(game.getBoard().getBoard()[6][4], DROITE);
        bool expect = game.getBoard().getBoard()[6][5].getPlayerColor() == BLUE;
        REQUIRE(expect);
    }

    SECTION("Testing simpleMove with Throw"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[6][4], GAUCHE));
    }

    SECTION("Testing simpleMove Null with Throw"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[5][4], GAUCHE));
    }

    SECTION("Testing selectMultiple Null with Throw"){
        Game game = Game();
        REQUIRE_THROWS(game.selectMultiple(game.getBoard().getBoard()[4][0],game.getBoard().getBoard()[4][1]));
    }
    SECTION("Testing select Null with Throw"){
        Game game = Game();
        REQUIRE_THROWS(game.select(game.getBoard().getBoard()[5][2].getPosition(), RED));
    }

    SECTION("Testing select ball Blue with Throw"){
        Game game = Game();
        Piece piece = Piece(BLUE,Position(2,-2));
        bool expect = game.select(game.getBoard().getBoard()[6][2].getPosition(), BLUE).getPlayerColor()
                == piece.getPlayerColor() && game.select(game.getBoard().getBoard()[6][2].getPosition(), BLUE).getPosition()
                == piece.getPosition();
        REQUIRE(expect);
    }

    SECTION("Testing select ball Red with Throw"){
        Game game = Game();
        Piece piece = Piece(RED,Position(-1,3));
        bool expect = game.select(game.getBoard().getBoard()[1][2].getPosition(), RED).getPlayerColor()
                == piece.getPlayerColor() && game.select(game.getBoard().getBoard()[1][2].getPosition(), RED).getPosition()
                == piece.getPosition();
        REQUIRE(expect);
    }

    SECTION("Testing simpleMove left outside"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[7][0], GAUCHE));
    }

    SECTION("Testing simpleMove bottom left outside"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[7][0], BAS_GAUCHE));
    }

    SECTION("Testing simpleMove bottom right outside"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[8][0], BAS_DROITE));
    }

    SECTION("Testing simpleMove top left outside"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[8][0], HAUT_GAUCHE));
    }

    SECTION("Testing simpleMove top rigt outside"){
        Game game = Game();
        REQUIRE_THROWS(game.simpleMove(game.getBoard().getBoard()[8][4], HAUT_DROITE));
    }


}
