
#include "View.h"
using namespace std;

bool View::slectMultiple(){
    bool stop = false;
    bool select = false;
    int x = 0;
    while(!stop){
        cout<< "Voulez-vous en prendre plusieur? (1) oui ou (2) non " << endl;
        cin >> x;
        if(x == 1){
            stop =true;
            select = stop;
        }else if(x == 2){
            select = false;
            stop = true;
        }else{
            cin.clear();
            cin.ignore(INT_MAX,'\n');
        }
    }
    cin.clear();
    cin.ignore(INT_MAX,'\n');
    return select;
}

Position View::askPosition(Board board){
    char x;
    signed int y;
    signed int z ;
    Position position = Position(20,0);
    Position posBoard;
    while(!board.isInside(position)){
        cout<<"Entrez une position en X et Y " << endl;
        cin >> x >> y;
        z = convertChar(x);
        position = Position(z,y);
        position =  board.getBoard()[z][y-1].getPosition();
        posBoard = Position(z,y-1);
        if(z == 0 && y > 0){
            position =  board.getBoard()[z][y-5].getPosition();
            posBoard = Position(z,y-5);
        }else if(z == 1 && y > 0){
            position =  board.getBoard()[z][y-4].getPosition();
            posBoard = Position(z,y-4);
        }else if ( z == 2 && y > 0){
            position =  board.getBoard()[z][y-3].getPosition();
            posBoard = Position(z,y-3);
        }else if ( z == 3 && y > 0){
            position =  board.getBoard()[z][y-2].getPosition();
            posBoard = Position(z,y-2);
        }
    }
    if(static_cast<unsigned long long>(posBoard.getX()) > board.getBoard().size()
            || static_cast<unsigned long long>(posBoard.getY()) > board.getBoard()[z].size()){
        throw invalid_argument("Position endehor du Plateaux");
    }
    return position;
}

signed int View::convertChar(char caractere){
    bool found = false;
    char cara[] = "IHGFEDCBA";
    char caraMin[] = "ihgfedcba";
    signed int index;
    for(signed int i = 0 ; i < 9 ; i++){
        if(cara[i] == caractere || caraMin[i] == caractere){
            index = i;
            found =true;
        }
    }
    if(!found){
        throw invalid_argument("Mauvaise entrer en X");
    }
    return index;
}

Direction View::askDirection(){
    Direction direction;
    cout << "Dans quel direction voulez-vous vous déplacer?" << endl;
    cout << "1 : HautGauche" << endl;
    cout << "2 : HautDroit" << endl ;
    cout << "3 : Droit" << endl ;
    cout << "4 : BasDroit" << endl;
    cout << "5 : BasGauche" << endl;
    cout << "6 : Gauche" << endl;
    int rep = 0;
    bool stop = false;
    while (!stop) {
        cout << "Un entier entre 1 et 6!" << endl;
        cin >> rep;
        if(rep >= 1 && rep <= 6){
            stop = true;
        }else{
            cin.clear();
            cin.ignore(INT_MAX,'\n');
        }
    }
    cin.clear();
    cin.ignore(INT_MAX,'\n');

    switch (rep) {
    case 1:
        direction = HAUT_GAUCHE;
        break;
    case 2:
        direction =  HAUT_DROITE;
        break;
    case 3:
        direction = DROITE;
        break;
    case 4:
        direction = BAS_DROITE;
        break;
    case 5:
        direction = BAS_GAUCHE;
        break;
    case 6:
        direction = GAUCHE;
        break;
    default:
        throw   invalid_argument("Direction non choisi.");
    }
    return direction;
}

void View::displayBoard(Board board){
    cout<< "        _________ " << endl;
    for (int i = 0; i < 9; i++) {
        for (unsigned long long k = 0; k < 9 - board.getBoard()[i].size(); k++) {
            cout<<" ";
        }
        for (unsigned long long j = 0; j < board.getBoard()[i].size(); j++) {
            if(j == 0){
                if(i<4){
                    switch(i){
                    case 0:
                        cout<< "I ";
                        break;
                    case 1:
                        cout<< "H ";
                        break;
                    case 2:
                        cout << "G ";
                        break;
                    case 3:
                        cout << "F ";
                        break;
                    }
                    cout<< "/ ";
                }else if(i == 4){
                    cout<< "E | ";
                }else {
                    switch (i) {
                    case 5:
                        cout << "D ";
                        break;
                    case 6:
                        cout<<"C ";
                        break;
                    case 7:
                        cout<<"B ";
                        break;
                    case 8:
                        cout<<"A ";
                        break;
                    }
                    cout << "\\ ";
                }
            }
            if (!board.isFreeBoard(i,j)) {
                cout << board.getBoard()[i][j].to_string();
            } else {
                cout<<". ";
            }
        }
        if(i < 4){
            cout<< "\\";
        }else if (i == 4){
            cout <<"|";
        }else{
            cout<< "/ ";
            cout << (9 - i + 5);
        }
        cout<<""<<endl;
    }
    cout<<"        --------- "<<endl;
    cout<<"          1 2 3 4 5"<<endl;
}

void View::displayWinner(Board board){
    int red = 0;
    for(unsigned long long i = 0; i < board.getBoard().size() ; i++){
        for(unsigned long long j = 0; j < board.getBoard()[i].size() ; j++){
            if(board.getBoard()[i][j].getPlayerColor() == RED){
                red++;
            }
        }
    }
    if(red  < 9){
        cout << "Le gagnant est le joueur Bleu !" << endl;
    }else{
        cout << "Le gagnant est le joueur Rouge !" << endl;
    }

}
