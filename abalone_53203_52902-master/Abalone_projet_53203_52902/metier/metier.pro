include(../defaults.pri)

TEMPLATE = lib
TARGET = libcore
DESTDIR = ../lib

HEADERS += \
    Board.h \
    Direction.h \
    Directions.h \
    Game.h \
    Piece.h \
    Player.h \
    PlayerColor.h \
    Position.h \
    array.hpp

SOURCES += \
    Board.cpp \
    Directions.cpp \
    Game.cpp \
    Position.cpp

