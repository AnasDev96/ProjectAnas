#include "hexacell.h"
#include <QGraphicsSceneMouseEvent>
#include <QPen>
#include <QBrush>
#include <QPainter>
#include <iostream>
#include <cmath>
#include "point.hpp"



HexaCell::HexaCell(signed x, signed y ,double rad, double dx, double dy, QGraphicsItem *parent)
    : QGraphicsPolygonItem(parent), x_(x) , y_(y) , rad(rad), dx(dx), dy(dy)
{
    this->setAcceptHoverEvents(true);
    zval = zValue();
    static const double piOver6 = atan(1) * 4 / 6;
    QPolygonF polygon;
    auto&& corners = orbit({dx, dy}, 6, rad, piOver6);
    for(auto& p : corners)
        polygon << QPointF(p.first, p.second);
    setPolygon(polygon);
}


#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wunused-parameter"

void HexaCell::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{

    QPen pen(Qt::black, 1);
    painter->setPen(pen);

    QBrush brush;
    brush.setColor(Qt::white);
    brush.setStyle(Qt::SolidPattern);

    painter->setBrush(brush);
    painter->drawPolygon(polygon());
}


#pragma GCC diagnostic pop

