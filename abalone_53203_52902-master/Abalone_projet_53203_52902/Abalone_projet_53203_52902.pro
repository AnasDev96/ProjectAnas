TEMPLATE = subdirs

SUBDIRS += \
    gui \
    metier \
    tests \
    console \

OTHER_FILES += \
      defaults.pri

    # where to find de sub projects - give folders
    metier.subdir = metier
    console.subdir = console
    gui.subdir = gui
    tests.subdir = tests

    # what subproject depends on others
    console.depends = metier
    gui.depends = metier
    tests.depends = metier
