# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'form.ui'
##
## Created by: Qt User Interface Compiler version 6.7.0
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QGridLayout, QLabel, QLineEdit,
    QPushButton, QSizePolicy, QVBoxLayout, QWidget)

class Ui_Widget(object):
    def setupUi(self, Widget):
        if not Widget.objectName():
            Widget.setObjectName(u"Widget")
        Widget.resize(800, 600)
        self.gridLayoutWidget = QWidget(Widget)
        self.gridLayoutWidget.setObjectName(u"gridLayoutWidget")
        self.gridLayoutWidget.setGeometry(QRect(230, 30, 349, 151))
        self.gridLayout = QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setObjectName(u"gridLayout")
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.LabelLoginPlease = QLabel(self.gridLayoutWidget)
        self.LabelLoginPlease.setObjectName(u"LabelLoginPlease")
        self.LabelLoginPlease.setAlignment(Qt.AlignCenter)

        self.gridLayout.addWidget(self.LabelLoginPlease, 2, 1, 1, 1)

        self.LabelHello = QLabel(self.gridLayoutWidget)
        self.LabelHello.setObjectName(u"LabelHello")
        self.LabelHello.setAlignment(Qt.AlignCenter)

        self.gridLayout.addWidget(self.LabelHello, 1, 1, 1, 1)

        self.gridLayoutWidget_2 = QWidget(Widget)
        self.gridLayoutWidget_2.setObjectName(u"gridLayoutWidget_2")
        self.gridLayoutWidget_2.setGeometry(QRect(240, 280, 301, 171))
        self.gridLayout_2 = QGridLayout(self.gridLayoutWidget_2)
        self.gridLayout_2.setObjectName(u"gridLayout_2")
        self.gridLayout_2.setContentsMargins(0, 0, 0, 0)
        self.PasswordInput = QLineEdit(self.gridLayoutWidget_2)
        self.PasswordInput.setObjectName(u"PasswordInput")
        sizePolicy = QSizePolicy(QSizePolicy.Policy.Fixed, QSizePolicy.Policy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.PasswordInput.sizePolicy().hasHeightForWidth())
        self.PasswordInput.setSizePolicy(sizePolicy)

        self.gridLayout_2.addWidget(self.PasswordInput, 2, 1, 1, 1)

        self.UserNameTextInput = QLineEdit(self.gridLayoutWidget_2)
        self.UserNameTextInput.setObjectName(u"UserNameTextInput")
        sizePolicy.setHeightForWidth(self.UserNameTextInput.sizePolicy().hasHeightForWidth())
        self.UserNameTextInput.setSizePolicy(sizePolicy)

        self.gridLayout_2.addWidget(self.UserNameTextInput, 0, 1, 1, 1)

        self.LabelPwd = QLabel(self.gridLayoutWidget_2)
        self.LabelPwd.setObjectName(u"LabelPwd")

        self.gridLayout_2.addWidget(self.LabelPwd, 2, 0, 1, 1)

        self.LabelUserName = QLabel(self.gridLayoutWidget_2)
        self.LabelUserName.setObjectName(u"LabelUserName")

        self.gridLayout_2.addWidget(self.LabelUserName, 0, 0, 1, 1)

        self.verticalLayoutWidget = QWidget(Widget)
        self.verticalLayoutWidget.setObjectName(u"verticalLayoutWidget")
        self.verticalLayoutWidget.setGeometry(QRect(310, 480, 160, 94))
        self.verticalLayout = QVBoxLayout(self.verticalLayoutWidget)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.LoginButton = QPushButton(self.verticalLayoutWidget)
        self.LoginButton.setObjectName(u"LoginButton")
        self.LoginButton.setAutoDefault(False)

        self.verticalLayout.addWidget(self.LoginButton)

        self.NoFiokLabel = QLabel(self.verticalLayoutWidget)
        self.NoFiokLabel.setObjectName(u"NoFiokLabel")

        self.verticalLayout.addWidget(self.NoFiokLabel)

        self.RegisterButton = QPushButton(self.verticalLayoutWidget)
        self.RegisterButton.setObjectName(u"RegisterButton")

        self.verticalLayout.addWidget(self.RegisterButton)


        self.retranslateUi(Widget)

        QMetaObject.connectSlotsByName(Widget)
    # setupUi

    def retranslateUi(self, Widget):
        Widget.setWindowTitle(QCoreApplication.translate("Widget", u"Widget", None))
        self.LabelLoginPlease.setText(QCoreApplication.translate("Widget", u"K\u00e9rem jelentkezzen be!", None))
        self.LabelHello.setText(QCoreApplication.translate("Widget", u"\u00dcdv\u00f6zl\u00f6m a kiad\u00e1sk\u00f6vet\u0151 alkalmaz\u00e1sban!", None))
        self.LabelPwd.setText(QCoreApplication.translate("Widget", u"Jelsz\u00f3", None))
        self.LabelUserName.setText(QCoreApplication.translate("Widget", u"Felhaszn\u00e1l\u00f3n\u00e9v", None))
        self.LoginButton.setText(QCoreApplication.translate("Widget", u"Bejelentkez\u00e9s", None))
        self.NoFiokLabel.setText(QCoreApplication.translate("Widget", u"Nincs fi\u00f3kja?", None))
        self.RegisterButton.setText(QCoreApplication.translate("Widget", u"Regisztr\u00e1ci\u00f3", None))
    # retranslateUi

