include(../defaults.pri)

TEMPLATE = app
CONFIG += console

LIBS += -L../lib -llibcore

SOURCES += main.cpp \
    BroadTest.cpp \
    DirectionTest.cpp \
    GameTest.cpp


HEADERS += \
    catch.hpp \
