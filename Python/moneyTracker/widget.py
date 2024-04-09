# This Python file uses the following encoding: utf-8
import sys

from PySide6.QtWidgets import QApplication, QWidget, QMainWindow

# Important:
# You need to run the following command to generate the ui_form.py file
#     pyside6-uic form.ui -o ui_form.py, or
#     pyside2-uic form.ui -o ui_form.py
from ui_form import Ui_Widget
from ui_mainScene import Ui_MainWindow

class NewScene(QMainWindow):
    def __init__(self):
        super().__init__()
        self.ui= Ui_MainWindow()
        self.ui.setupUi(self)

        # Itt állíthatja be az új jelenet tulajdonságait
        self.setWindowTitle("Új Jelenet")

class Widget(QWidget):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_Widget()
        self.ui.setupUi(self)

        self.ui.LoginButton.clicked.connect(self.on_login_clicked)

    def on_login_clicked(self):
        # Új jelenet létrehozása és megjelenítése
        self.new_scene = NewScene()
        self.new_scene.show()

        # Az aktuális bejelentkező felület elrejtése
        self.hide()




if __name__ == "__main__":
    app = QApplication(sys.argv)
    widget = Widget()
    widget.setWindowTitle("HUHUHU")
    widget.show()
    sys.exit(app.exec())
