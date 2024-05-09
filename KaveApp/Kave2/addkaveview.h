#ifndef ADDKAVEVIEW_H
#define ADDKAVEVIEW_H

#include <QWidget>
#include <QtSql>


namespace Ui {
class AddKaveView;
}

class AddKaveView : public QWidget
{
    Q_OBJECT

public:
    explicit AddKaveView(QWidget *parent = nullptr);
    ~AddKaveView();

private slots:
    void on_insertBtn_clicked();

private:
    Ui::AddKaveView *ui;
    QSqlDatabase db;

};

#endif // ADDKAVEVIEW_H
