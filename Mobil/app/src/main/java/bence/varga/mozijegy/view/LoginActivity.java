package bence.varga.mozijegy.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import bence.varga.mozijegy.R;


/**
 * A LoginActivity felelős a bejelentkezési felület megjelenítéséért és a bejelentkezési logika kezeléséért.
 */
public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private static final String PREF_KEY = Objects.requireNonNull(MainActivity.class.getPackage()).toString();
    private static final int SECRET_KEY=99;
    private EditText emailET;
    private EditText passwordET;
    private Button loginButtonET;
    private Button registerButtonET;
    private Button googleSignInButtonET;

    public Button getGoogleSignInButtonET() {
        return googleSignInButtonET;
    }

    public void setGoogleSignInButtonET(Button googleSignInButtonET) {
        this.googleSignInButtonET = googleSignInButtonET;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    private SharedPreferences preferences;


    public Button getRegisterButtonET() {
        return registerButtonET;
    }
    public void setRegisterButtonET(Button registerButtonET) {
        this.registerButtonET = registerButtonET;
    }
    /** getterek és setterek**/
    public void setEmailET(EditText emailET) {
       this.emailET = emailET;
    }

    public void setPasswordET(EditText passwordET) {
        this.passwordET = passwordET;
    }

    public void setLoginButtonET(Button loginButtonET) {
        this.loginButtonET = loginButtonET;
    }

    public EditText getEmailET() {
        return emailET;
    }

    public EditText getPasswordET() {
        return passwordET;
    }

    public Button getLoginButtonET() {
        return loginButtonET;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences() {
        preferences=getSharedPreferences(PREF_KEY,MODE_PRIVATE);
    }

    /**
     * Inicializálja a változókat az UI elemekkel.
     */
    public void valtozoInit(){
        setEmailET(findViewById(R.id.editTextEmail));
        setPasswordET(findViewById(R.id.editTextPassword));
        setLoginButtonET(findViewById(R.id.LoginButton));
        setRegisterButtonET(findViewById(R.id.RegisterButton));
        setGoogleSignInButtonET(findViewById(R.id.google_sign_in_button));
    }


    /**
     * Az bejelentkezési logikát kezeli.
     */
    public void loginLogic(){
        getLoginButtonET().setOnClickListener(v -> {
            String userNameStr = getEmailET().getText().toString();
            String passwordStr = getPasswordET().getText().toString();

            if (TextUtils.isEmpty(userNameStr) || TextUtils.isEmpty(passwordStr)) {
                // Ha valamelyik mező üres, megjelenítünk egy felugró buborék ablakot
                Snackbar.make(v, "Töltse ki mindkét mezőt!", Snackbar.LENGTH_LONG).show();
            } else {
                // Ha mindkét mező ki van töltve, folytathatjuk a bejelentkezést
                if (validateCredentials(userNameStr, passwordStr)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("isLoggedIn", true);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Hibás felhasználónév vagy jelszó", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void GoogleSignInLogic(){
        getGoogleSignInButtonET().setOnClickListener(v -> {

        });
    }

    /**
     * Ellenőrzi a felhasználói bevitelt.
     *
     * @param email    A felhasználó által megadott e-mail cím
     * @param password A felhasználó által megadott jelszó
     * @return true, ha a bevitel helyes, különben false
     */
    private boolean validateCredentials(String email, String password) {
        // Példa: Egyszerű ellenőrzés, hogy az e-mail cím és jelszó nem üres
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }


    /**
     * Inicializálja a nézetet.
     */
    public void viewInit(){
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void registerLogic(){
        getRegisterButtonET().setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            //intent.putExtra("SECRET_KEY",SECRET_KEY);
            //TODO.
            startActivity(intent);
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setPreferences();

        //Init logic
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        viewInit();
        valtozoInit();
        loginLogic();
        registerLogic();

        Log.i(LOG_TAG,"onCreate");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("email",getEmailET().getText().toString());
        edit.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}