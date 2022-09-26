include(../defaults.pri)

TEMPLATE = app
CONFIG += qt

QT += widgets

LIBS += -L../lib -llibcore
SOURCES +=  \
    circle.cpp \
    hexacell.cpp \
    main.cpp \
    mainwindow.cpp
    

HEADERS +=  \
    circle.h \
    hexacell.h \
    mainwindow.h \
    point.hpp

