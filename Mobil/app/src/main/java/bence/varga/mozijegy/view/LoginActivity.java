package bence.varga.mozijegy.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import bence.varga.mozijegy.R;


/**
 * A LoginActivity felelős a bejelentkezési felület megjelenítéséért és a bejelentkezési logika kezeléséért.
 */
public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private static final int SECRET_KEY=99;

    private EditText emailET;
    private EditText passwordET;

    private Button loginButtonET;

    private Button registerButtonET;

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


    /**
     * Inicializálja a változókat az UI elemekkel.
     */
    public void valtozoInit(){
        setEmailET(findViewById(R.id.editTextEmail));
        setPasswordET(findViewById(R.id.editTextPassword));
        setLoginButtonET(findViewById(R.id.LoginButton));
        setRegisterButtonET(findViewById(R.id.RegisterButton));
    }


    /**
     * Az bejelentkezési logikát kezeli.
     */
    public void loginLogic(){
        //Bejelentkezés logika
        getLoginButtonET().setOnClickListener(v -> {
            String userNameStr = getEmailET().getText().toString();
            String passwordStr = getPasswordET().getText().toString();

            Log.i(LOG_TAG, "Bejelentkezett: " + userNameStr + ", jelszó:" + passwordStr);
        });
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
            intent.putExtra("SECRET_KEY",SECRET_KEY);
            //TODO.
            startActivity(intent);
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Init logic
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        viewInit();
        valtozoInit();
        loginLogic();
        registerLogic();

    }


}