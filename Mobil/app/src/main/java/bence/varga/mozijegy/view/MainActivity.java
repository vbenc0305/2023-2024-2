package bence.varga.mozijegy.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import bence.varga.mozijegy.R;

public class MainActivity extends AppCompatActivity {


    private Button LoginButton;
    private Button logoutButton;
    private FirebaseUser user;




    private static final String PREF_KEY = Objects.requireNonNull(MainActivity.class.getPackage()).toString();



    public Button getLoginButton() {
        return LoginButton;
    }

    public void setLoginButton() {
        LoginButton = findViewById(R.id.buttonLogin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_logged_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLogged), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Kijelentkezés gomb inicializálása
        logoutButton = findViewById(R.id.buttonLogout);

        boolean isLoggedIn = getIntent().getBooleanExtra("isLoggedIn", false);
        user= FirebaseAuth.getInstance().getCurrentUser();
        if (user!= null) {
            // Ha bejelentkezett, akkor megváltoztatjuk a főoldal tartalmát
            String userName = getSharedPreferences(PREF_KEY, MODE_PRIVATE).getString("email", "");
            Toast.makeText(this, "Üdvözöllek, " + user.getDisplayName() + "!", Toast.LENGTH_SHORT).show();

            // A kijelentkezés gomb logikájának beállítása
            setupLogoutButton();
        } else {
            // Ha még nem jelentkezett be, akkor a normál főoldalt jelenítjük meg
            setContentView(R.layout.activity_main);

            setLoginButton();

            getLoginButton().setOnClickListener(v -> {
                // Intent létrehozása a LoginActivity-re való átvitelhez
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            });
        }
    }


    private void setupLogoutButton() {
        logoutButton.setOnClickListener(v -> {
            // Kijelentkezés logika: visszairányítás a főoldalra (Home-ra) és beállítás, hogy nincs bejelentkezve
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("isLoggedIn", false); // Bejelentkezési állapot megváltoztatása
            startActivity(intent);
            finish(); // Finish() hívása azért, hogy ne legyen visszalépési lehetőség a főoldalra
        });
    }
}