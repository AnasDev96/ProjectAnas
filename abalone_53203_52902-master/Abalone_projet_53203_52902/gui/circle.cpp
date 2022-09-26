#include <QGraphicsSceneMouseEvent>
#include <QPen>
#include <QBrush>
#include <QPainter>
#include <iostream>
#include <cmath>
#include "circle.h"

Circle::Circle(signed x,signed y, PlayerColor color,double rad, double dx, double dy, QGraphicsItem *parent)
    : QGraphicsPolygonItem(parent), color_(color), x_(x) , y_(y) ,  rad(rad), dx(dx), dy(dy)
{

    this->setAcceptHoverEvents(true);
    zval = zValue();
    static const double piOver6 = atan(1) * 4 / 6;
    QPolygonF polygon;
    auto&& corners = orbit({dx, dy}, 100, rad, piOver6);
    for(auto& p : corners)
        polygon << QPointF(p.first, p.second);


    setPolygon(polygon);
}

#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wunused-parameter"
void Circle::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
    if(color_ == RED){
        QBrush brush;
        brush.setColor(Qt::red);
        brush.setStyle(Qt::SolidPattern);
        painter->setBrush(brush);

    }else if(color_ == BLUE){
        QBrush brush;
        brush.setColor(Qt::blue);
        brush.setStyle(Qt::SolidPattern);
        painter->setBrush(brush);
    }
    painter->drawPolygon(polygon());
}
#pragma GCC diagnostic pop
