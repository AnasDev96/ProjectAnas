#include "Board.h"
#include <iostream>


Board::Board(){

    board_.resize(9);
    std::vector<Piece> v1(5);
    board_.at(0) = v1;
    std::vector<Piece> v2(6);
    board_.at(1) = v2;
    std::vector<Piece> v3(7);
    board_.at(2) = v3;
    std::vector<Piece> v4(8);
    board_.at(3) =  v4;
    std::vector<Piece> v5(9);
    board_.at(4) = v5;
    std::vector<Piece> v6(8);
    board_.at(5) = v6;
    std::vector<Piece> v7(7);
    board_.at(6) = v7;
    std::vector<Piece> v8(6);
    board_.at(7) = v8;
    std::vector<Piece> v9(5);
    board_.at(8) = v9;

    signed x = -5;
    signed j = 0;
    signed k = 0;

    int y = 0;
    int z = 0;
    for(signed i =4; i >-5 ; i--)
    {
        j = k;
        while(z < 4){
            while(j > x){
                Position position = Position(j,i);
                if(i == 4 || i == 3 || (i == 2 && (j==0 || j== -1 || j==-2)) ){
                    Piece piece = Piece(RED,position);
                    putPiece(y,z,piece);
                }else
                    if(i == -4 || i == -3 || (i == -2 && (j==2 || j== 1 || j==0))){
                        Piece piece = Piece(BLUE,position);
                        putPiece(y,z,piece);
                    }else{
                        Piece piece = Piece(NONE,position);
                        putPiece(y,z,piece);
                    }
                j--;
                z++;
            }
        }
        y++;
        if(i > 0 ){
            k++;
        }else{
            x++;
        }
        z=0;
        j= k;
    }
}

bool Board::isInside(Position position){
    bool isInside = false;
    for(unsigned long long i = 0; i < board_.size() ; i++){
        for(unsigned long long j = 0; j < board_[i].size() ; j++){
            if(position == board_[i][j].getPosition()){
                isInside = true;
            }
        }
    }
    return isInside ;
}

bool Board::isFreeBoard(unsigned long long x,unsigned long long y){
    if(x> board_.size() || y > board_[x].size()){
        throw invalid_argument("Index endehor");
    }
    return board_[x][y].getPlayerColor() == NONE ;
}

void Board::swap( std::vector<Piece> piece, Direction direction){

    piece = triPiece(piece,direction);

    if(piece.size() == 0 || !canPush(piece,direction)){
        throw invalid_argument("Aucune bille, ou push impossible");
    }


    if(!isInside(piece[0].getPosition().nextPosition(direction))){
        throw invalid_argument("Direction endehor du plateau.");
    }

    if(!isFree(piece[0].getPosition().nextPosition(direction)) && isInside(piece[0].getPosition().nextPosition(direction))){
        piece = push(piece,direction);
        piece = triPiece(piece,direction);
    }

    for(unsigned long long i = 0; i < piece.size(); i++){
        if(isInside(piece[i].getPosition().nextPosition(direction))){
            board_[posBoard(piece[i].getPosition()).getX()][posBoard(piece[i].getPosition()).getY()].setPlayerColor(NONE);
            board_[posBoard(piece[i].getPosition().nextPosition(direction)).getX()]
                    [posBoard(piece[i].getPosition().nextPosition(direction)).getY()].setPlayerColor(piece[i].getPlayerColor());
        }
    }
}


Direction Board::selectDir(vector<Piece> piece){
    Direction direction2;
    Direction direction[] = { HAUT_DROITE, BAS_DROITE, GAUCHE, DROITE,HAUT_GAUCHE,BAS_GAUCHE };
    for(Direction direction : direction){
        if( piece.at(0).getPosition().nextPosition(direction) == piece.at(1).getPosition() ){
            direction2 = direction;
        }
    }
    return direction2;
}

bool Board::canPush(vector<Piece> piece,Direction direction){
    Directions dirs = Directions();
    Position position = piece[0].getPosition();
    unsigned long long cpt = 0;
    bool canMove = false;

    while(!isFree(position.nextPosition(direction)) && isInside(position.nextPosition(direction))){
        cpt++;
        position = position.nextPosition(direction);
    }
    canMove = cpt < piece.size();
    if( direction != dirs.opposite(selectDir(piece)) ||
            ( board_[posBoard(piece[0].getPosition().nextPosition(direction)).getX()]
              [posBoard(piece[0].getPosition().nextPosition(direction)).getY()].getPlayerColor()
              == piece[0].getPlayerColor() ))
    {
        for(unsigned long long i = 0; i < piece.size(); i++){
            if(!isFree(piece[i].getPosition().nextPosition(direction))){
                canMove=false;
            }
        }
    }
    return canMove;
}

vector<Piece> Board::push(vector<Piece> piece,Direction direction){
    Position position = piece[0].getPosition();

    unsigned long long i = 1;
    vector<Piece> piece2 ;
    piece2.resize(piece.size());

    for(unsigned long long j = 0 ; j < piece.size() ; j ++){
        piece2.at(j) = piece.at(j);
    }
    while(  isInside(position.nextPosition(direction)) && !isFree(position.nextPosition(direction))){
        piece2.resize(i+piece.size());
        piece2.at(i+piece.size()-1) = getPieceOnPosition(position.nextPosition(direction));
        position = position.nextPosition(direction);
        i++;
    }
    return piece2;
}

vector<Piece> Board::triPiece(vector<Piece> piece, Direction dir){
    Piece temp;
    for(int i = piece.size()-1 ; i>=1 ; i--)
    {
        for(int j = 0 ; j<i ; j++){
            if(dir == BAS_GAUCHE || dir == GAUCHE
               || (dir == BAS_DROITE && posBoard(piece.at(j).getPosition()).getX() >=4 ))
            {
                if( (posBoard(piece.at(j).getPosition()).getX() - posBoard(piece.at(j).getPosition()).getY())
                        < (posBoard(piece.at(j+1).getPosition()).getX() - posBoard(piece.at(j+1).getPosition()).getY()))
                {
                    temp = piece.at(j+1);
                    piece.at(j+1)=piece.at(j);
                    piece.at(j)=temp;
                }
            } else if( dir == DROITE || dir == HAUT_DROITE){

                if((posBoard(piece.at(j).getPosition()).getX() - posBoard(piece.at(j).getPosition()).getY())
                        > (posBoard(piece.at(j+1).getPosition()).getX() - posBoard(piece.at(j+1).getPosition()).getY())){
                    temp = piece.at(j+1);
                    piece.at(j+1)=piece.at(j);
                    piece.at(j)=temp;

                }

            }else if(dir == BAS_DROITE && posBoard(piece.at(j).getPosition()).getX() <=4 ){

                if((posBoard(piece.at(j).getPosition()).getX() + posBoard(piece.at(j).getPosition()).getY())
                        < (posBoard(piece.at(j+1).getPosition()).getX() + posBoard(piece.at(j+1).getPosition()).getY())){

                    temp = piece.at(j+1);
                    piece.at(j+1)=piece.at(j);
                    piece.at(j)=temp;

                }
            } else if(dir == HAUT_GAUCHE){
                if((posBoard(piece.at(j).getPosition()).getX() + posBoard(piece.at(j).getPosition()).getY())
                        > (posBoard(piece.at(j+1).getPosition()).getX() + posBoard(piece.at(j+1).getPosition()).getY())){

                    temp = piece.at(j+1);
                    piece.at(j+1)=piece.at(j);
                    piece.at(j)=temp;

                }
            }
        }
    }
    return piece;
}

void Board::removePieceOnIndex(unsigned long long i , unsigned long long j){
    if(board_[i][j].getPlayerColor() == RED || board_[i][j].getPlayerColor() == BLUE){
        board_[i][j].setPlayerColor(NONE);
    }

}

Position Board::posBoard(Position position){
    Position positionOnVectorBoard = Position(0,5);
    for(unsigned long long i = 0; i < board_.size() ; i++){
        for(unsigned long long j = 0; j < board_[i].size() ; j++){
            if(position == board_[i][j].getPosition()){
                positionOnVectorBoard = Position(i,j);
            }
        }
    }
    return positionOnVectorBoard;
}
