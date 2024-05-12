package bence.varga.mozijegy.model;

import com.google.firebase.Timestamp;

public class Vetites {
    private String filmNeve;
    private String id;
    private int szekek_szama;
    private Timestamp vetitesIdeje;

    public Vetites() {
    }

    public Vetites(String filmNeve, String id, int szekek_szama, Timestamp vetitesIdeje) {
        this.filmNeve = filmNeve;
        this.id = id;
        this.szekek_szama = szekek_szama;
        this.vetitesIdeje = vetitesIdeje;
    }

    public String getFilmNeve() {
        return filmNeve;
    }

    public void setFilmNeve(String filmNeve) {
        this.filmNeve = filmNeve;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSzekek_szama() {
        return szekek_szama;
    }

    public void setSzekek_szama(int szekek_szama) {
        this.szekek_szama = szekek_szama;
    }

    public Timestamp getVetitesIdeje() {
        return vetitesIdeje;
    }

    public void setVetitesIdeje(Timestamp vetitesIdeje) {
        this.vetitesIdeje = vetitesIdeje;
    }
}
