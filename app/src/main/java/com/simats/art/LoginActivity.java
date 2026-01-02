package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    AppCompatButton btnSignIn;
    TextView txtSignUp, txtAdminLogin;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        initializeViews();

        // 1. Back button: Returns to Splash or previous screen
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. Connectivity: Clicking Sign In opens the Create Account screen as requested
        btnSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(intent);
        });

        // 3. Sign Up text: Also navigates to Create Account screen
        txtSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(intent);
        });

        // 4. Admin Login link
        if (txtAdminLogin != null) {
            txtAdminLogin.setOnClickListener(v -> {
                startActivity(new Intent(LoginActivity.this, AdminLoginActivity.class));
            });
        }
    }

    private void initializeViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtSignUp = findViewById(R.id.txtSignUp);
        btnBack = findViewById(R.id.btnBack);
        txtAdminLogin = findViewById(R.id.txtAdminLogin);
    }
}
