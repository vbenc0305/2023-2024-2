#include "kave.h"

Kave::Kave(){}
// Konstruktor
Kave::Kave(const QString & nev, const QString & leiras)
    : m_nev(nev), m_leiras(leiras) // Inicializáló lista használata
{
    // A konstruktor törzse, ha szükséges további inicializálás
}

// Getter metódusok
int Kave::GetId() const {
    return id;
}

QString Kave::GetNev() const {
    return m_nev;
}

QString Kave::GetLeiras() const {
    return m_leiras;
}

// Setter metódusok
void Kave::SetNev(const QString &nev) {
    m_nev = nev;
}

void Kave::SetLeiras(const QString & leiras) {
    m_leiras = leiras;
}
