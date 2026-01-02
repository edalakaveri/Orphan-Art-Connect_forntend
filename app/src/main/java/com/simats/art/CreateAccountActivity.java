package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etConfirmPassword;
    private AppCompatButton btnCreateAccount;
    private TextView txtSignIn;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Initialize UI components
        initializeViews();

        // 1. Back button: Standard connectivity to return to the previous screen
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. Connectivity: Process data and move to Role Selection
        btnCreateAccount.setOnClickListener(v -> handleCreateAccount());

        // 3. Navigation Connectivity: Jump back to Login if user already has an account
        txtSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            // Using clear top to avoid multiple instances of LoginActivity
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish(); 
        });
    }

    private void initializeViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        txtSignIn = findViewById(R.id.txtSignIn);
        btnBack = findViewById(R.id.btnBack);
    }

    private void handleCreateAccount() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPass = etConfirmPassword.getText().toString().trim();

        // Validation logic for better user experience (connectivity with user data)
        if (email.isEmpty() || password.isEmpty() || confirmPass.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmPass)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
            
            // CONNECTIVITY: Pass user data to the Role Selection screen
            Intent intent = new Intent(CreateAccountActivity.this, RoleSelectionActivity.class);
            intent.putExtra("user_email", email); 
            startActivity(intent);
            
            // finish() ensures they don't come back to signup after creating account
            finish(); 
        }
    }
}
