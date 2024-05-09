#include "addkaveview.h"
#include "ui_addkaveview.h"

AddKaveView::AddKaveView(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::AddKaveView)
{
    ui->setupUi(this);
}

AddKaveView::~AddKaveView()
{
    delete ui;
}

void AddKaveView::on_insertBtn_clicked()
{
    db.open();
    QSqlDatabase::database().transaction();

    QSqlQuery QueryInsertData(db);

    QueryInsertData.prepare(" INSERT INTO Kave (neve, leiras) VALUES (:nev, :leiras)");
    QueryInsertData.bindValue(":nev", ui->neveInput->text() );
    QueryInsertData.bindValue(":leiras", ui->leiras->text() );

    if (QueryInsertData.exec()) {
        qDebug() << "Az adatfeltöltés sikeres volt.";
    } else {
        qDebug() << "Hiba történt az adatfeltöltés során:" << QueryInsertData.lastError();
    }

    QSqlDatabase::database().commit();
    db.close();
}

