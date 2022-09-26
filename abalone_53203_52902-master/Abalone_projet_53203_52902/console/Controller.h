/**
 * Project ProjetAbalon_53203_52902
 */
#ifndef _CONTROLLER_H
#define _CONTROLLER_H

#include "View.cpp"
#include "Game.h"


/*!
 *  ajouter les package dans le diagramme
 *  @brief The Controller class,  put all method for run my gun
 */
class Controller {

public:

    /*!
     *
     * @brief Controller is the constructor of the class
     * @param view is the View
     * @param game is the Game
     */
    Controller();

    /*!
     * @brief play allows you to start the game
     * mettre dans le game tres important , une section partie projet une section modelisation
     * une section console et graphique une section problem rencontré
     */
    inline void play();

private:
    /*!
     * @brief view allows user interaction and game display
     */
    View view_;
    /*!
     * @brief game contains the state of the game
     */
    Game game_;
};

Controller::Controller(){
    game_ = Game();
    view_ = View();
}

void Controller::play(){

    view_.messageHelp();

    while(!game_.isOver()){

        view_.displayBoard(game_.getBoard());
        view_.messageTurn(game_.getCurrent().getColor());

        try {
            Direction direction ;
            if(!view_.slectMultiple()){
                Piece piece = game_.select( view_.askPosition(game_.getBoard()) ,game_.getCurrent().getColor());
                direction = view_.askDirection();
                game_.simpleMove(piece, direction);
            }else{
                direction = view_.askDirection();
                game_.getBoard().swap( game_.selectMultiple( game_.select(view_.askPosition(game_.getBoard())
                                                          ,game_.getCurrent().getColor())
                                                             ,game_.select( view_.askPosition(game_.getBoard())
                                                                  ,game_.getCurrent().getColor())),direction);
            }
        }catch (invalid_argument & e) {
            std::cerr << "Erreur : " << e.what() << '\n';
        }
    }
    view_.displayBoard(game_.getBoard());
    view_.displayWinner(game_.getBoard());
}


#endif //_CONTROLLER_H

