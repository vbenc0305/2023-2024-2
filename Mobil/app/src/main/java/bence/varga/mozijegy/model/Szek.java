package bence.varga.mozijegy.model;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class Szek {
    private int id;
    private int sor;
    private int szam;
    private boolean foglalt;
    private ArrayList<Szek> mSzek = new ArrayList<>(); // Inicializálás
    private final FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    private final CollectionReference mSzekek = mFirestore.collection("seats"); // Javított kollekció név

    public Szek() {
        // Üres konstruktor, ha szükséges
    }

    // További konstruktorok és metódusok...

    public Szek(int sor, int szam, boolean foglalt, ArrayList<Szek> mSzek) {
        getIdhozErtek();
        this.sor = sor;
        this.szam = szam;
        this.foglalt = foglalt;
        this.mSzek = mSzek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public int getSzam() {
        return szam;
    }

    public void setSzam(int szam) {
        this.szam = szam;
    }

    public boolean isFoglalt() {
        return foglalt;
    }

    public void setFoglalt(boolean foglalt) {
        this.foglalt = foglalt;
    }

    private void getIdhozErtek() {
        mSzekek.get().addOnSuccessListener(queryDocumentSnapshots -> {
            mSzek.clear(); // Töröljük a korábbi elemeket
            for (QueryDocumentSnapshot docu : queryDocumentSnapshots) {
                Szek szek = docu.toObject(Szek.class);
                mSzek.add(szek);
            }
            // Itt kezelje az új ID generálását, mivel ez egy aszinkron hívás
            // További logika az új ID használatával...
            id= mSzek.size()+1;
        });

    }

    // További getterek, setterek és metódusok...
}
