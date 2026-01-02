package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private AppCompatButton btnLogin;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);

        // Initialize views
        etUsername = findViewById(R.id.etAdminUsername);
        etPassword = findViewById(R.id.etAdminPassword);
        btnLogin = findViewById(R.id.btnAdminLogin);
        btnBack = findViewById(R.id.btnBack);

        // Back button connectivity
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Login button connectivity
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Check for Admin Credentials
            if (username.equals("admin") && password.equals("1234")) {
                Toast.makeText(this, "Admin Login Successful", Toast.LENGTH_SHORT).show();
                
                // Navigate to Admin Dashboard
                Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
                startActivity(intent);
                
                // Clear this activity from stack
                finish();
            } else if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
