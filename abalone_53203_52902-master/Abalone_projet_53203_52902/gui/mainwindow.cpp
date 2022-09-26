#include <iostream>
#include <QGraphicsScene>
#include <QGraphicsView>
#include <QCoreApplication>
#include <cmath>
#include <QVBoxLayout>
#include "circle.h"
#include "hexacell.h"
#include "point.hpp"
#include "QString"
#include "Position.h"
#include "mainwindow.h"
#include "Direction.h"
#include "View.h"
#include <QMessageBox>

MainWindow::MainWindow(Game game,QWidget *parent)
    : QMainWindow(parent),game_(game)
{

    displayBoard();
    displayPos();

    layout->addRow("Position 1 (simple select ou multi select)", pos1);
    layout->addRow("Position 2 (multi select) ", pos2);
    layout->addRow("Direction", dir);
    layout->addWidget(pushButton);

    view->setRenderHint(QPainter::Antialiasing);
    view->setRenderHint(QPainter::TextAntialiasing);
    view->setCacheMode(QGraphicsView::CacheBackground);
    view->setViewportUpdateMode(QGraphicsView::BoundingRectViewportUpdate);
    view->setDragMode(QGraphicsView::ScrollHandDrag);
    view->setLayout(layout);
    view->update();

    resize(1500, 1000);
    this->setCentralWidget(view);

    connect(pushButton, &QPushButton::released, this, &MainWindow::handleButton);
}


void MainWindow::handleButton(){

    scene->clear();

    string test = pos1->text().toStdString();
    try {
        string strDir = dir->text().toStdString();
        size_t j = 0;
        for ( ; j < strDir.length(); j++ ){ if ( isdigit(strDir[j]) ) break; }
        strDir = strDir.substr(j, strDir.length() - j);

        int nbDir = atoi(strDir.c_str());
        Direction  direction = giveDirection(nbDir);

        string strPos1 = pos1->text().toStdString();
        char pos = strPos1[0];
        size_t i = 0;
        for ( ; i < strPos1.length(); i++ ){ if ( isdigit(strPos1[i]) ) break; }
        strPos1 = strPos1.substr(i, strPos1.length() - i);
        int id = atoi(strPos1.c_str());

        string strPos2 = pos2->text().toStdString();

        if(!strPos1.empty() && strPos2.empty()){
            Piece piece = game_.select( positionCell(pos,id) ,game_.getCurrent().getColor());
            game_.simpleMove(piece, direction);

        }
        else if(!strPos1.empty() && !strPos2.empty()){

            char pos2 = strPos2[0];
            size_t y = 0;
            for ( ; y < strPos2.length(); y++ ){ if ( isdigit(strPos2[i]) ) break; }
            strPos2 = strPos2.substr(i, strPos2.length() - i);
            int id2 = atoi(strPos2.c_str());
            game_.getBoard().swap( game_.selectMultiple( game_.select(positionCell(pos,id)
                                                                      ,game_.getCurrent().getColor())
                                                         ,game_.select( positionCell(pos2,id2)
                                                                        ,game_.getCurrent().getColor())),direction);
        }
        if(game_.isOver()){
            displayWinner();
        }

    }catch (invalid_argument & e) {
        std::cerr << "Erreur : " << e.what() << '\n';
        QMessageBox::information(this, tr("Erreur") ,tr("Mauvaise entrer de position ou de direction !"));
    }

    displayBoard();
    displayPos();
}
Position MainWindow::positionCell(char str, int y){
    signed int z ;
    Position position = Position(20,0);
    Position posBoard;
    while(!game_.getBoard().isInside(position)){
        z = convertChar(str);
        position = Position(z,y);
        position =  game_.getBoard().getBoard()[z][y-1].getPosition();
        posBoard = Position(z,y-1);
        if(z == 0 && y > 0){
            position =  game_.getBoard().getBoard()[z][y-5].getPosition();
            posBoard = Position(z,y-5);
        }else if(z == 1 && y > 0){
            position =  game_.getBoard().getBoard()[z][y-4].getPosition();
            posBoard = Position(z,y-4);
        }else if ( z == 2 && y > 0){
            position =  game_.getBoard().getBoard()[z][y-3].getPosition();
            posBoard = Position(z,y-3);
        }else if ( z == 3 && y > 0){
            position =  game_.getBoard().getBoard()[z][y-2].getPosition();
            posBoard = Position(z,y-2);
        }
    }
    if(static_cast<unsigned long long>(posBoard.getX()) > game_.getBoard().getBoard().size()
            || static_cast<unsigned long long>(posBoard.getY()) > game_.getBoard().getBoard()[z].size()){
        throw invalid_argument("Position endehor du Plateaux");
    }
    return position;
}

signed int MainWindow::convertChar(char caractere){
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
void MainWindow::displayBoard(){

    double rad = 50;
    double w = sqrt(3) / 2 * rad;

    vector<pair<signed,signed>> posBoard = {
        make_pair (4,-4),make_pair (3,-4),make_pair (2,-4),make_pair (1,-4),make_pair (0,-4),
        make_pair (4,-3),make_pair (3,-3),make_pair (2,-3),make_pair (1,-3),make_pair (0,-3),make_pair (-1,-3),
        make_pair (4,-2),make_pair (3,-2),make_pair (2,-2),make_pair (1,-2),make_pair (0,-2),make_pair (-1,-2),make_pair (-2,-2),
        make_pair (4,-1),make_pair (3,-1),make_pair (2,-1),make_pair (1,-1),make_pair (0,-1),make_pair (-1,-1),make_pair (-2,-1),make_pair (-3,-1),
        make_pair (4,0) ,make_pair (3,0) ,make_pair (2,0), make_pair (1,0), make_pair (0,0), make_pair (-1,0), make_pair  (-2,0),make_pair (-3,0), make_pair (-4,0),
        make_pair (3,1) ,make_pair (2,1), make_pair (1,1), make_pair (0,1), make_pair (-1,1),make_pair (-2,1), make_pair (-3,1),make_pair (-4,1),
        make_pair (2,2) ,make_pair (1,2), make_pair (0,2), make_pair (-1,2),make_pair (-2,2),make_pair (-3,2), make_pair (-4,2),
        make_pair (1,3), make_pair (0,3), make_pair (-1,3),make_pair (-2,3), make_pair (-3,3),make_pair (-4,3),
        make_pair (0,4), make_pair (-1,4),make_pair (-2,4),make_pair (-3,4), make_pair (-4,4),
    };

    Position position;
    for(unsigned long long i = 0 ; i < posBoard.size() ; i++){
        position = Position(posBoard.at(i).first,posBoard.at(i).second);
        scene->addItem(new HexaCell(posBoard.at(i).first,posBoard.at(i).second,rad,((2*posBoard.at(i).first+posBoard.at(i).second)*w) * -1, ((2*w - 11) * posBoard.at(i).second) * -1, nullptr));
        scene->addItem(new Circle(posBoard.at(i).first,posBoard.at(i).second,game_.getBoard().getPieceOnPosition(position).getPlayerColor(),12.5, ((2*posBoard.at(i).first+posBoard.at(i).second)*w) * -1, ((2*w - 11) * posBoard.at(i).second) * -1, nullptr));
    }
}

Direction MainWindow::giveDirection(int dir){
    Direction direction;
    int rep = dir;
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

void MainWindow::displayPos(){

    QString str = "9";
    QGraphicsTextItem* label9 = scene->addText(str);
    label9->setPos(QPointF(375,50));
    QFont f9 = label9->font();
    f9.setPixelSize(10);
    f9.setPointSize(20);
    label9->setFont(f9);

    QString str8 = "8";
    QGraphicsTextItem* label8 = scene->addText(str8);
    label8->setPos(340,125);
    QFont f8 = label8->font();
    f8.setPixelSize(10);
    f8.setPointSize(20);
    label8->setFont(f8);

    QString str7 = "7";
    QGraphicsTextItem* label7 = scene->addText(str7);
    label7->setPos(305,200);
    QFont f7 = label7->font();
    f7.setPixelSize(10);
    f7.setPointSize(20);
    label7->setFont(f7);

    QString str6 = "6";
    QGraphicsTextItem* label6 = scene->addText(str6);
    label6->setPos(260,275);
    QFont f6 = label6->font();
    f6.setPixelSize(10);
    f6.setPointSize(20);
    label6->setFont(f6);

    QString str5 = "5";
    QGraphicsTextItem* label5 = scene->addText(str5);
    label5->setPos(225,350);
    QFont f5 = label5->font();
    f5.setPixelSize(10);
    f5.setPointSize(20);
    label5->setFont(f5);

    QString str1 = "1";
    QGraphicsTextItem* label1 = scene->addText(str1);
    label1->setPos(-135,350);
    QFont f1 = label1->font();
    f1.setPixelSize(10);
    f1.setPointSize(20);
    label1->setFont(f1);

    QString str2 = "2";
    QGraphicsTextItem* label2 = scene->addText(str2);
    label2->setPos(-50,350);
    QFont f2 = label2->font();
    f2.setPixelSize(10);
    f2.setPointSize(20);
    label2->setFont(f2);

    QString str3 = "3";
    QGraphicsTextItem* label3 = scene->addText(str3);
    label3->setPos(35,350);
    QFont f3 = label3->font();
    f3.setPixelSize(10);
    f3.setPointSize(20);
    label3->setFont(f3);

    QString str4 = "4";
    QGraphicsTextItem* label4 = scene->addText(str4);
    label4->setPos(120,350);
    QFont f4 = label4->font();
    f4.setPixelSize(10);
    f4.setPointSize(20);
    label4->setFont(f4);

    QString str10 = "I";
    QGraphicsTextItem* label10 = scene->addText(str10);
    label10->setPos(-250,-325);
    QFont f10 = label10->font();
    f10.setPixelSize(10);
    f10.setPointSize(20);
    label10->setFont(f10);

    QString str11 = "H";
    QGraphicsTextItem* label11 = scene->addText(str11);
    label11->setPos(-300,-250);
    QFont f11 = label11->font();
    f11.setPixelSize(10);
    f11.setPointSize(20);
    label11->setFont(f11);

    QString str12 = "G";
    QGraphicsTextItem* label12 = scene->addText(str12);
    label12->setPos(-350,-175);
    QFont f12 = label12->font();
    f12.setPixelSize(10);
    f12.setPointSize(20);
    label12->setFont(f12);

    QString str13 = "F";
    QGraphicsTextItem* label13 = scene->addText(str13);
    label13->setPos(-400,-100);
    QFont f13 = label13->font();
    f13.setPixelSize(10);
    f13.setPointSize(20);
    label13->setFont(f13);

    QString str14 = "E";
    QGraphicsTextItem* label14 = scene->addText(str14);
    label14->setPos(-435,-25);
    QFont f14 = label14->font();
    f14.setPixelSize(10);
    f14.setPointSize(20);
    label14->setFont(f14);

    QString str15 = "D";
    QGraphicsTextItem* label15 = scene->addText(str15);
    label15->setPos(-390,50);
    QFont f15 = label15->font();
    f15.setPixelSize(10);
    f15.setPointSize(20);
    label15->setFont(f15);

    QString str16 = "C";
    QGraphicsTextItem* label16 = scene->addText(str16);
    label16->setPos(-345,125);
    QFont f16 = label16->font();
    f16.setPixelSize(10);
    f16.setPointSize(20);
    label16->setFont(f16);

    QString str17 = "B";
    QGraphicsTextItem* label17 = scene->addText(str17);
    label17->setPos(-300,200);
    QFont f17 = label17->font();
    f17.setPixelSize(10);
    f17.setPointSize(20);
    label17->setFont(f17);

    QString str18 = "A";
    QGraphicsTextItem* label18 = scene->addText(str18);
    label18->setPos(-255,275);
    QFont f18 = label18->font();
    f18.setPixelSize(10);
    f18.setPointSize(20);
    label18->setFont(f18);

    QString str19 = "Direction:\n 1 - Haut Gauche\n 2 - Haut Droit\n 3 - Droite\n 4 - Bas Droite\n 5 - Bas Gauche\n 6 - Gauche\n ";
    QGraphicsTextItem* label19 = scene->addText(str19);
    label19->setPos(-700,-325);
    QFont f19 = label19->font();

    QString str20 = "";
    if(game_.getCurrent().getColor() == BLUE){
        str20 = "Au tour du joueur : Bleu";
    }else{
        str20 = "Au tour du joueur : Rouge";
    }
    QGraphicsTextItem* label20 = scene->addText(str20);
    label20->setPos(-800,-25);
    QFont f20 = label20->font();
    f20.setPixelSize(8);
    f20.setPointSize(15);
    label20->setFont(f20);

}

void MainWindow::displayWinner(){
    int red = 0 ;
    for(unsigned long long i = 0; i < game_.getBoard().getBoard().size() ; i++){
        for(unsigned long long j = 0; j < game_.getBoard().getBoard()[i].size() ; j++){
            if(game_.getBoard().getBoard()[i][j].getPlayerColor() == RED){
                red++;
            }
        }
    }
    if(red  < 9){
        QMessageBox::information(this, tr("Le gagnant") ,tr("Le gagnant est le joueur Bleu !"));
    }else{
        QMessageBox::information(this, tr("Le gagnant") ,tr("Le gagnant est le joueur Rouge !"));
    }
}

MainWindow::~MainWindow()
{
}
