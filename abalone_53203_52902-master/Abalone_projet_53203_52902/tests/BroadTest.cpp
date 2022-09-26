#include "catch.hpp"
#include "Board.h"

TEST_CASE("Testing methods of Board class"){

    SECTION("Testing isInside True"){
        Board board = Board();
        Position position = Position(-1,4);
        REQUIRE(board.isInside(position));
    }

    SECTION("Testing isInside False"){
        Board board = Board();
        Position position = Position(7,4);
        REQUIRE_FALSE(board.isInside(position));
    }

    SECTION("Testing isFree True"){
        Board board = Board();
        Position position = Position(4,0);
        REQUIRE(board.isFree(position));
    }

    SECTION("Testing isFree false"){
        Board board = Board();
        Position position = Position(0,4);
        REQUIRE_FALSE(board.isFree(position));
    }

    SECTION("Testing isFreeBoard false"){
        Board board = Board();
        REQUIRE_FALSE(board.isFreeBoard(0,0));
    }

    SECTION("Testing isFreeBoard true"){
        Board board = Board();
        REQUIRE(board.isFreeBoard(4,0));
    }
    SECTION("Testing puPiece"){
        Board board = Board();
        Position position = Position(3,1);
        Piece piece = Piece(RED, position);
        board.putPiece(4,0,piece);
        REQUIRE(board.getBoard()[4][0] == piece);
    }
    SECTION("Testing Swap Up left"){
        Board board = Board();
        Piece piece = board.getBoard()[8][2];
        Piece piece1 = board.getBoard()[7][2];
        Piece piece2 = board.getBoard()[6][2];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,HAUT_GAUCHE);
        bool expect = board.getBoard()[7][2].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][2].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[5][2].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[8][2].getPlayerColor() == NONE;
        REQUIRE(expect);
    }

    SECTION("Testing Swap Up rigt"){
        Board board = Board();
        Piece piece = board.getBoard()[8][0];
        Piece piece1 = board.getBoard()[7][1];
        Piece piece2 = board.getBoard()[6][2];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,HAUT_DROITE);
        bool expect = board.getBoard()[7][1].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][2].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[5][3].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[8][0].getPlayerColor() == NONE;
        REQUIRE(expect);
    }

    SECTION("Testing Swap left"){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,GAUCHE);
        bool expect = board.getBoard()[6][1].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][2].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[6][3].getPlayerColor() == piece2.getPlayerColor()
                &&  board.getBoard()[6][4].getPlayerColor() == NONE ;
        REQUIRE(expect);
    }
    SECTION("Testing Swap right"){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,DROITE);
        bool expect = board.getBoard()[6][3].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][4].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[6][5].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[6][2].getPlayerColor() == NONE;
        REQUIRE(expect);
    }

    SECTION("Testing Swap Down Right"){
        Board board = Board();
        Piece piece = board.getBoard()[0][0];
        Piece piece1 = board.getBoard()[1][1];
        Piece piece2 = board.getBoard()[2][2];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,BAS_DROITE);
        bool expect = board.getBoard()[1][1].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[2][2].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[3][3].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[0][0].getPlayerColor() == NONE;
        REQUIRE(expect);
    }

    SECTION("Testing Swap Down left"){
        Board board = Board();
        Piece piece = board.getBoard()[0][2];
        Piece piece1 = board.getBoard()[1][2];
        Piece piece2 = board.getBoard()[2][2];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,BAS_GAUCHE);
        bool expect = board.getBoard()[1][2].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[2][2].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[3][2].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[0][2].getPlayerColor() == NONE;
        REQUIRE(expect);
    }

    SECTION("Testing Swap Throws Empty Piece"){
        Board board = Board();
        vector<Piece> piece;
        REQUIRE_THROWS(board.swap(piece,HAUT_DROITE));
    }

    SECTION("Testing Swap Throws Up right "){
        Board board = Board();
        Piece piece = board.getBoard()[0][2];
        Piece piece1 = board.getBoard()[1][2];
        Piece piece2 = board.getBoard()[2][2];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,HAUT_DROITE));
    }

    SECTION("Testing Swap Throws Up left"){
        Board board = Board();
        Piece piece = board.getBoard()[0][2];
        Piece piece1 = board.getBoard()[1][2];
        Piece piece2 = board.getBoard()[2][2];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,HAUT_GAUCHE));
    }

    SECTION("Testing Swap Throws Down right "){
        Board board = Board();
        Piece piece = board.getBoard()[6][3];
        Piece piece1 = board.getBoard()[7][2];
        Piece piece2 = board.getBoard()[8][1];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,BAS_DROITE));
    }


    SECTION("Testing Swap Throws Down left "){
        Board board = Board();
        Piece piece = board.getBoard()[8][1];
        Piece piece1 = board.getBoard()[7][2];
        Piece piece2 = board.getBoard()[6][3];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,BAS_GAUCHE));
    }


    SECTION("Testing Swap Throws  right "){
        Board board = Board();
        Piece piece = board.getBoard()[8][2];
        Piece piece1 = board.getBoard()[8][3];
        Piece piece2 = board.getBoard()[8][4];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,DROITE));
    }

    SECTION("Testing Swap Throws left "){
        Board board = Board();
        Piece piece = board.getBoard()[8][0];
        Piece piece1 = board.getBoard()[8][1];
        Piece piece2 = board.getBoard()[8][2];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,GAUCHE));
    }

    SECTION("Testing Push 3 piece"){
        Board board = Board();
        Piece piece = Piece(BLUE,Position(1,2));
        Piece piece1 = Piece(BLUE,Position(1,1));
        Piece piece2 = Piece(BLUE,Position(1,0));
        Piece rouge = Piece(RED,Position(1,3));
        board.putPiece(2,1,piece);
        board.putPiece(3,2,piece1);
        board.putPiece(4,3,piece2);
        vector<Piece> v = {piece,piece1,piece2};
        board.push(v,HAUT_GAUCHE);
        bool expect = board.push(v,HAUT_GAUCHE).size() == 4
                && board.push(v,HAUT_GAUCHE).at(3) == rouge;
        REQUIRE(expect);
    }

    SECTION("Testing Push 2 piece"){
        Board board = Board();
        Piece piece = Piece(BLUE,Position(0,2));
        Piece piece1 = Piece(BLUE,Position(-1,2));

        Piece blue = Piece(RED,Position(1,2));
        board.putPiece(2,1,blue);

        vector<Piece> v = {piece,piece1};
        board.push(v,GAUCHE);
        bool expect = board.push(v,GAUCHE).size() == 3
                && board.push(v,GAUCHE).at(2) == blue;
        REQUIRE(expect);
    }

    SECTION("Testing canPush 2 piece RED and 2 piece BLUE"){
        Board board = Board();
        Piece piece = Piece(BLUE,Position(1,1));
        Piece piece1 = Piece(BLUE,Position(1,0));
        Piece red = Piece(RED,Position(1,2));
        board.putPiece(3,2,piece);
        board.putPiece(4,3,piece1);
        board.putPiece(2,1,red);
        vector<Piece> v = {piece,piece1};
        REQUIRE_FALSE(board.canPush(v,HAUT_GAUCHE));
    }

    SECTION("Testing TriePiece Up left"){
        Board board = Board();
        Piece piece = Piece(BLUE,Position(2,-2));
        Piece piece1 = Piece(BLUE,Position(2,-2));
        Piece piece2 = Piece(RED,Position(2,-4));
        vector<Piece> v = {piece,piece1,piece2};
        v = board.triPiece(v,HAUT_GAUCHE);
        bool expect = v.at(0) == piece
                && v.at(1) == piece1
                && v.at(2) == piece2 ;
        REQUIRE(expect);
    }

    SECTION("Testing TriePiece Up Right"){
        Board board = Board();
        Piece piece = Piece(BLUE,Position(1,-2));
        Piece piece1 = Piece(BLUE,Position(2,-3));
        Piece piece2 = Piece(RED,Position(3,-4));
        vector<Piece> v = {piece,piece1,piece2};
        v = board.triPiece(v,HAUT_DROITE);
        bool expect = v.at(0) == piece
                && v.at(1) == piece1
                && v.at(2) == piece2 ;
        REQUIRE(expect);
    }

    SECTION("Testing TriePiece Down Right"){
        Board board = Board();
        Piece piece = Piece(BLUE,Position(-1,4));
        Piece piece1 = Piece(BLUE,Position(-1,3));
        Piece piece2 = Piece(RED,Position(-1,2));
        vector<Piece> v = {piece,piece1,piece2};
        v = board.triPiece(v,BAS_DROITE);
        bool expect = v.at(0) == piece2
                && v.at(1) == piece1
                && v.at(2) == piece ;
        REQUIRE(expect);
    }

    SECTION("Testing TriePiece Down right"){
        Board board = Board();
        Piece piece = board.getBoard()[6][4];
        Piece piece1 = board.getBoard()[7][3];
        Piece piece2 = board.getBoard()[8][2];
        vector<Piece> v = {piece,piece1,piece2};
        v = board.triPiece(v,BAS_DROITE);

        bool expect = v.at(0) == piece2
                && v.at(1) == piece1
                && v.at(2) == piece ;
        REQUIRE(expect);
    }


    SECTION("Testing canPush  2 piece Move left"){
        Board board = Board();
        Piece piece = board.getBoard()[6][3];
        Piece piece1 = board.getBoard()[5][3];
        piece1.setPlayerColor(BLUE);
        vector<Piece> v = {piece,piece1};
        REQUIRE_FALSE(board.canPush(v,GAUCHE));
    }

    SECTION("Testing canPush 2 piece RED and 3 piece BLUE"){
        Board board = Board();
        Piece piece = Piece(RED,Position(1,0));
        Piece piece1 = Piece(RED,Position(1,-1));
        board.putPiece(4,3,piece);
        board.putPiece(5,3,piece1);
        vector<Piece> v = {piece,piece1};
        v = board.triPiece(v,BAS_DROITE);
        REQUIRE_FALSE(board.canPush(v,BAS_DROITE));
    }

    SECTION("Testing canPush 2 piece RED and 1 piece BLUE right"){
        Board board = Board();
        Piece piece = Piece(RED,Position(1,0));
        Piece piece1 = Piece(RED,Position(1,-1));
        Piece piece2 = Piece(BLUE,Position(0,0));
        board.putPiece(4,3,piece);
        board.putPiece(5,3,piece1);
        board.putPiece(4,4,piece2);
        vector<Piece> v = {piece,piece1};
        v = board.triPiece(v,DROITE);
        REQUIRE_FALSE(board.canPush(v,DROITE));
    }

    SECTION("Testing canPush 2 piece RED and 1 piece BLUE Up right"){
        Board board = Board();
        Piece piece = Piece(RED,Position(1,0));
        Piece piece1 = Piece(RED,Position(1,-1));
        Piece piece2 = Piece(BLUE,Position(2,-1));
        board.putPiece(4,3,piece);
        board.putPiece(5,3,piece1);
        board.putPiece(5,2,piece2);
        vector<Piece> v = {piece1,piece2};
        v = board.triPiece(v,HAUT_DROITE);
        REQUIRE_FALSE(board.canPush(v,HAUT_DROITE));
    }

    SECTION("Testing canPush 2 piece RED  Up right"){
        Board board = Board();
        Piece piece1 = Piece(RED,Position(1,-1));
        Piece piece2 = Piece(BLUE,Position(2,-1));
        board.putPiece(5,3,piece1);
        board.putPiece(5,2,piece2);
        vector<Piece> v = {piece1,piece2};
        v = board.triPiece(v,HAUT_DROITE);
        REQUIRE(board.canPush(v,HAUT_DROITE));
    }

    SECTION("Testing canPush 2 piece RED  Up right"){
        Board board = Board();
        Piece piece1 = Piece(BLUE,Position(1,0));
        Piece piece2 = Piece(BLUE,Position(1,-1));
        Piece piece3 = Piece(BLUE,Position(1,1));
        Piece piece4 = Piece(RED,Position(1,2));
        board.putPiece(4,3,piece1);
        board.putPiece(5,3,piece2);
        board.putPiece(2,1,piece3);
        board.putPiece(3,2,piece4);
        vector<Piece> v = {piece1,piece2};
        v = board.triPiece(v,HAUT_GAUCHE);
        REQUIRE_FALSE(board.canPush(v,HAUT_GAUCHE));
    }

    SECTION("Testing selectDir top left"){
        Board board = Board();
        Direction direction = BAS_DROITE;
        Piece piece1 = board.getBoard()[8][3];
        Piece piece2 = board.getBoard()[7][3];
        Piece piece3 = board.getBoard()[6][3];
        vector<Piece> v = {piece1,piece2,piece3};
        v = board.triPiece(v,HAUT_GAUCHE);

        REQUIRE(board.selectDir(v)==direction);
    }

    SECTION("Testing selectDir top right"){
        Board board = Board();
        Direction direction = BAS_DROITE;
        Piece piece1 = board.getBoard()[8][3];
        Piece piece2 = board.getBoard()[7][3];
        Piece piece3 = board.getBoard()[6][3];
        vector<Piece> v = {piece1,piece2,piece3};
        v = board.triPiece(v,HAUT_DROITE);
        REQUIRE(board.selectDir(v)==direction);
    }

    SECTION("Testing selectDir down left"){
        Board board = Board();
        Direction direction = HAUT_GAUCHE;
        Piece piece1 = board.getBoard()[8][3];
        Piece piece2 = board.getBoard()[7][3];
        Piece piece3 = board.getBoard()[6][3];
        vector<Piece> v = {piece1,piece2,piece3};
        v = board.triPiece(v,BAS_GAUCHE);
        REQUIRE(board.selectDir(v)==direction);
    }

    SECTION("Testing removePieceOnBIndex"){
        Board board = Board();
        board.removePieceOnIndex(8,3);
        board.removePieceOnIndex(7,3);
        board.removePieceOnIndex(6,3);
        bool expect = board.getBoard()[8][3].getPlayerColor() == NONE
                && board.getBoard()[7][3].getPlayerColor() == NONE
                && board.getBoard()[6][3].getPlayerColor() == NONE ;
        REQUIRE(expect);
    }

    SECTION("Testing posBoard"){
        Board board = Board();
        Position position = Position(0,-2);
        Position positionBoard = Position(6,4);
        board.posBoard(position);
        bool expect = board.posBoard(position) == positionBoard ;
        REQUIRE(expect);
    }

    SECTION("Testing removePiece"){
        Board board = Board();
        Piece piece =  Piece(BLUE,Position(0,-2));
        board.removePiece(piece);
        bool expect = board.getBoard()[board.posBoard(piece.getPosition()).getX()][board.posBoard(piece.getPosition()).getY()].getPlayerColor()
                == NONE;
        REQUIRE(expect);
    }

    SECTION("Testing swap Top left horizontal"){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,HAUT_GAUCHE);
        bool expect = board.getBoard()[5][2].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[5][3].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[5][4].getPlayerColor() == piece.getPlayerColor() ;
        REQUIRE(expect);
    }

    SECTION("Testing swap Top right horizontal"){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,HAUT_DROITE);
        bool expect = board.getBoard()[5][3].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[5][4].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[5][5].getPlayerColor() == piece.getPlayerColor() ;
        REQUIRE(expect);
    }

    SECTION("Testing swap Top right horizontal with one red push"){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        Piece piece3 = Piece(RED,Position(-1,-1));
        board.putPiece(5,5,piece3);
        REQUIRE_THROWS(board.swap(v,HAUT_DROITE));
    }

    SECTION("Testing swap Top Left vertical one ball bloc"){
        Board board = Board();
        Piece piece = board.getBoard()[8][0];
        Piece piece1 = board.getBoard()[7][1];
        Piece piece2 = board.getBoard()[6][2];
        vector<Piece> v = {piece,piece1,piece2};

        REQUIRE_THROWS(board.swap(v,HAUT_GAUCHE));
    }

    SECTION("Testing swap Down left vertical one ball bloc"){
        Board board = Board();
        Piece piece = board.getBoard()[0][0];
        Piece piece1 = board.getBoard()[1][1];
        Piece piece2 = board.getBoard()[2][2];
        vector<Piece> v = {piece,piece1,piece2};

        REQUIRE_THROWS(board.swap(v,BAS_GAUCHE));
    }

    SECTION("Testing swap Down rigt vertical one ball bloc"){
        Board board = Board();
        Piece piece = board.getBoard()[0][4];
        Piece piece1 = board.getBoard()[1][4];
        Piece piece2 = board.getBoard()[2][4];
        vector<Piece> v = {piece,piece1,piece2};

        REQUIRE_THROWS(board.swap(v,BAS_DROITE));
    }

    SECTION("Testing swap Down left horizontal "){
        Board board = Board();
        Piece piece = board.getBoard()[2][2];
        Piece piece1 = board.getBoard()[2][3];
        Piece piece2 = board.getBoard()[2][4];
        vector<Piece> v = {piece,piece1,piece2};
        board.swap(v,BAS_DROITE);
        bool expect = board.getBoard()[3][3].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[3][4].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[3][5].getPlayerColor() == piece.getPlayerColor() ;
        REQUIRE(expect);
    }

    SECTION("Testing swap Top rigt vertical ball bloc"){
        Board board = Board();
        Piece piece = board.getBoard()[0][4];
        Piece piece1 = board.getBoard()[1][4];
        Piece piece2 = board.getBoard()[2][4];
        vector<Piece> v = {piece,piece1,piece2};

        REQUIRE_THROWS(board.swap(v,HAUT_DROITE));
    }

    SECTION("Testing swap right vertical ball bloc"){
        Board board = Board();
        Piece piece = board.getBoard()[7][1];
        Piece piece1 = board.getBoard()[7][2];
        Piece piece2 = board.getBoard()[7][3];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,DROITE));
    }

    SECTION("Testing swap left vertical ball bloc"){
        Board board = Board();
        Piece piece = board.getBoard()[7][1];
        Piece piece1 = board.getBoard()[7][2];
        Piece piece2 = board.getBoard()[7][3];
        vector<Piece> v = {piece,piece1,piece2};
        REQUIRE_THROWS(board.swap(v,GAUCHE));
    }

    SECTION("Testing swap push left horizontal one piece on left RED "){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        Piece piece3 = Piece(RED,Position(3,-2));
        board.putPiece(6,1,piece3);
        board.swap(v,GAUCHE);
        bool expect = board.getBoard()[6][1].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][2].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[6][3].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[6][0].getPlayerColor() == piece3.getPlayerColor();
        REQUIRE(expect);
    }
    SECTION("Testing swap push right horizontal one piece on right RED "){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        Piece piece3 = Piece(RED,Position(-1,-2));
        board.putPiece(6,5,piece3);
        board.swap(v,DROITE);
        bool expect = board.getBoard()[6][3].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][4].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[6][5].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[6][6].getPlayerColor() == piece3.getPlayerColor();
        REQUIRE(expect);
    }
    SECTION("Testing swap push right horizontal twoo piece on rigt RED "){
        Board board = Board();
        Piece piece = board.getBoard()[6][2];
        Piece piece1 = board.getBoard()[6][3];
        Piece piece2 = board.getBoard()[6][4];
        vector<Piece> v = {piece,piece1,piece2};
        Piece piece3 = Piece(RED,Position(-1,-2));
        board.putPiece(6,5,piece3);
        Piece piece4 = Piece(RED,Position(-2,-2));
        board.putPiece(6,6,piece4);
        board.swap(v,DROITE);
        bool expect = board.getBoard()[6][3].getPlayerColor() == piece.getPlayerColor()
                && board.getBoard()[6][4].getPlayerColor() == piece1.getPlayerColor()
                && board.getBoard()[6][5].getPlayerColor() == piece2.getPlayerColor()
                && board.getBoard()[6][6].getPlayerColor() == piece3.getPlayerColor();
        REQUIRE(expect);
    }
}
