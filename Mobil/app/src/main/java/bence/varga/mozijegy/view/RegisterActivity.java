package bence.varga.mozijegy.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import bence.varga.mozijegy.R;

public class RegisterActivity extends AppCompatActivity {


    private static final String LOG_TAG = RegisterActivity.class.getName();
    private static final String PREF_KEY = Objects.requireNonNull(MainActivity.class.getPackage()).toString();

    private SharedPreferences preferences;
    private FirebaseAuth mAuth;


    private static final int SECRET_KEY=99;

    private EditText usernameET;
    private EditText emailET;
    private EditText pwd;
    private EditText pwdAgain;
    private Button register;
    private Button cancel;

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences() {
        preferences=getSharedPreferences(PREF_KEY,MODE_PRIVATE);
    }

    public EditText getUsernameET() {
        return usernameET;
    }

    public void setUsernameET(EditText usernameET) {
        this.usernameET = usernameET;
    }

    public EditText getEmailET() {
        return emailET;
    }

    public void setEmailET(EditText emailET) {
        this.emailET = emailET;
    }

    public EditText getPwd() {
        return pwd;
    }

    public void setPwd(EditText pwd) {
        this.pwd = pwd;
    }

    public EditText getPwdAgain() {
        return pwdAgain;
    }

    public void setPwdAgain(EditText pwdAgain) {
        this.pwdAgain = pwdAgain;
    }

    public Button getRegister() {
        return register;
    }

    public void setRegister(Button register) {
        this.register = register;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public void init(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void valtozoInit(){
        setRegister(findViewById(R.id.RegButton));
        setCancel(findViewById(R.id.cancelButton));
        setUsernameET(findViewById(R.id.registerNameEditText));
        setEmailET(findViewById(R.id.registerEmailEditText));
        setPwd(findViewById(R.id.registerPasswordEditText));
        setPwdAgain(findViewById(R.id.registerPasswordAgainEditText));

        setPreferences();
        String username = preferences.getString("email","");

        usernameET.setText(username);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        int secret_key = getIntent().getIntExtra("SECRET_KEY",0);
        if(secret_key!=99){
            Log.e(LOG_TAG, "Baj van főni");
            finish();
        }

        mAuth = FirebaseAuth.getInstance();
        valtozoInit();
        registerLogic();
        cancelLogic();

    }

    private void registerLogic(){
        getRegister().setOnClickListener(v-> {
            String username = usernameET.getText().toString();
            String email = emailET.getText().toString();
            String password = pwd.getText().toString();
            String passwordConfrim = pwdAgain.getText().toString();

            if (!password.equals(passwordConfrim)) {
                Log.e(LOG_TAG, "Nem egyezik a két jelszó");
                return;
            }
            Log.e(LOG_TAG, "Regisztrált" + username + "jelszo:" + password);
            //TODO: A Reg. funkcionalítást megvalósítani

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Log.d(LOG_TAG, "Sikeres regisztráció");
                    }else{
                        Log.d(LOG_TAG, "Sikertelen regisztráció");
                        Toast.makeText(RegisterActivity.this, "Sikertelen regisztráció"+task.getException(),Toast.LENGTH_SHORT).show();
                        goToLogin();
                    }
                }
            });
        });



    }

    private void goToLogin(){
        finish();
    }

    private void cancelLogic(){
        getCancel().setOnClickListener(v-> finish());
    }
}