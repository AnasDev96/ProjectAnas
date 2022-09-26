#ifndef CIRCLE_HPP
#define CIRCLE_HPP

#include <QGraphicsPolygonItem>
#include <QPolygonF>
#include <string>
#include <QPointF>
#include "Position.h"
#include "point.hpp"
#include "PlayerColor.h"

class QPainter;
class QStyleOptionGraphicsItem;
class QWidget;
class QGraphicsSceneHoverEvent;
class QGraphicsSceneMouseEvent;
class QGraphicsSceneWheelEvent;

class Circle : public QGraphicsPolygonItem
{

    double zval;

protected:

    PlayerColor color_;
    signed x_,y_;
    double rad, dx, dy;

public:

    /*!
     * @brief Circle, simple Constructor of Circle
     * @param x , the x axis of the position in the board
     * @param y , the y axis of the position in the board
     * @param color , color of the circle
     * @param rad , the radius of the circle
     * @param dx , the x axe of the circle
     * @param dy , the y axe of the circle
     * @param parent, graphic item
     */
    Circle(signed x , signed y , PlayerColor color , double rad = 50, double dx = 0, double dy = 0, QGraphicsItem * parent = 0);

    /*!
     * @brief paint ,method to draw the circle
     * @param painter , to perform drawing operation
     * @param option , lets draw
     * @param widget , the widget item
     */
    void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget);

};



#endif // CIRCLE_HPP

