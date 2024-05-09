#ifndef KAVE_H
#define KAVE_H

#include <QString>

class Kave
{
public:
    Kave(const QString & nev, const QString & leiras);
    Kave();

    int GetId() const;
    QString GetNev() const;
    QString GetLeiras() const;
    void SetNev(const QString & nev);
    void SetLeiras(const QString & leiras);

private:
    int id;
    QString m_nev;
    QString m_leiras;
};


#endif // KAVE_H
