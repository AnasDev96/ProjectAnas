#include "Game.h"
#include <iostream>


Game::Game():current_{Player(BLUE)}
{
    board_ = Board();

};

Piece Game::select( Position position , PlayerColor colorPlayer ){
    if(board_.getBoard()[board_.posBoard(position).getX()][board_.posBoard(position).getY()].getPlayerColor() == NONE ){
        throw invalid_argument("Pas de piece selectionner.");
    }
    Piece piece;
    if(!board_.isFree(position)
            && board_.isInside(position)
            && board_.colorPos(position) == colorPlayer){
        piece = board_.getPieceOnPosition(position);
    }
    return piece;
}

std::vector<Piece> Game::selectMultiple(Piece piece1,Piece piece2){
    if(piece1.getPlayerColor() == NONE || piece2.getPlayerColor() == NONE){
        throw invalid_argument("Aucune piece selectionner.");
    }
    Direction direction[] = { HAUT_DROITE, BAS_DROITE, GAUCHE, DROITE,HAUT_GAUCHE,BAS_GAUCHE };
    vector<Piece> pieces;
    for(Direction direction : direction){
        if (board_.equalsColor(piece1.getPosition(), piece2)){
            if(piece1.getPosition().nextPosition(direction) == piece2.getPosition()){
                pieces.resize(2);
                pieces.at(1) = piece1;
                pieces.at(0) = piece2;
            }else if(piece1.getPosition().nextPosition(direction).nextPosition(direction) == piece2.getPosition()){
                pieces.resize(3);
                pieces.at(2) = piece1;
                pieces.at(1) = board_
                        .getPieceOnPosition(piece1.getPosition()
                                            .nextPosition(direction));
                pieces.at(0) = piece2;
            }
        }
    }
    setCurrent();
    return pieces;
}

bool Game::isOver(){

    int red = 0;
    int blue = 0;
    for(unsigned long long i = 0; i < board_.getBoard().size() ; i++){
        for(unsigned long long j = 0; j < board_.getBoard()[i].size() ; j++){
            if(board_.getBoard()[i][j].getPlayerColor() == RED){
                red++;
            } else if(board_.getBoard()[i][j].getPlayerColor() == BLUE){
                blue++;
            }
        }
    }
    return red < 9 || blue < 9;
}

void Game::simpleMove(Piece piece,Direction direction){
    if(piece.getPlayerColor() == NONE){
        throw invalid_argument("Pas de piece selectionner.");
    }
    if(!board_.isInside(piece.getPosition().nextPosition(direction))){
        throw invalid_argument("Direction endehor du plateau.");
    }
    if(board_.getBoard()[board_.posBoard(piece.getPosition().nextPosition(direction)).getX()]
            [board_.posBoard(piece.getPosition().nextPosition(direction)).getY()].getPlayerColor() == NONE
            && board_.isInside(piece.getPosition()) ){
        board_.removePiece(piece);
        board_.setPiece(board_.posBoard(piece.getPosition().nextPosition(direction)).getX()
                        ,board_.posBoard(piece.getPosition().nextPosition(direction)).getY(),piece);
    }else if(board_.getBoard()[board_.posBoard(piece.getPosition().nextPosition(direction)).getX()]
             [board_.posBoard(piece.getPosition().nextPosition(direction)).getY()].getPlayerColor() != NONE){
        throw invalid_argument("Mouvement impossible, une bille s'y trouve deja.");
    }
    setCurrent();
}

void Game::setCurrent(){
    if(current_.getColor() == BLUE){
        current_ = RED;
    }else{
        current_ = BLUE;
    }
}
