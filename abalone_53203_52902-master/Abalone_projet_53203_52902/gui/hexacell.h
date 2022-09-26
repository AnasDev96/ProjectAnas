#ifndef HEXACELL_H
#define HEXACELL_H

#include <QGraphicsPolygonItem>
#include <QPolygonF>
#include <string>
#include <QPointF>

class QPainter;
class QStyleOptionGraphicsItem;
class QWidget;
class QGraphicsSceneHoverEvent;
class QGraphicsSceneMouseEvent;
class QGraphicsSceneWheelEvent;

class HexaCell  : public QGraphicsPolygonItem
{
    double zval;
protected:

    signed x_ , y_ ;
    double rad, dx, dy;

public:

    /*!
     * @brief HexaCell, constructor of hexacell
     * @param x , the x axis of the position in the board
     * @param y , the y axis of the position in the board
     * @param color , color of the hexacell
     * @param rad , the radius of the hexacell
     * @param dx , the x axe of the hexacell
     * @param dy , the y axe of the hexacell
     * @param parent, graphic item
     */
    HexaCell(signed x, signed y ,double rad = 100, double dx = 0, double dy = 0, QGraphicsItem * parent = 0);

    /*!
     * @brief paint ,method to draw the circle
     * @param painter , to perform drawing operation
     * @param option , lets draw
     * @param widget , the widget item
     */
    void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget);

};
#endif // HEXACELL_H
