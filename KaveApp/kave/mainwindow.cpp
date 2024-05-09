#include "mainwindow.h"
#include "./ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    Db_Conn = QSqlDatabase::addDatabase("QSQLITE");
    Db_Conn.setDatabaseName("kapanyamyaoifdsd.db");

    if (!Db_Conn.open()) {
        qDebug() << "Adatbázis hiba:" << Db_Conn.lastError().text();
    } else {
        qDebug() << "Az adatbázis sikeresen létrejött.";
    }


}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_insertBtn_clicked()
{
    Db_Conn.open();
    QSqlDatabase::database().transaction();

    QSqlDatabase::database().commit();
    Db_Conn.close();

}

