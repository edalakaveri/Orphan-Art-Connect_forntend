package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class RoleSelectionActivity extends AppCompatActivity {

    private CardView cardBuyer, cardAdmin, cardArtist, cardVolunteer;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);

        // Initialize UI components
        initializeViews();

        // 1. Back button: Returns to Create Account screen
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. Connectivity: Selecting a role navigates to the appropriate screen
        cardBuyer.setOnClickListener(v -> completeRegistration("Buyer"));
        
        // Admin Connectivity: Navigate to Admin Login Page
        cardAdmin.setOnClickListener(v -> {
            startActivity(new Intent(RoleSelectionActivity.this, AdminLoginActivity.class));
        });

        cardArtist.setOnClickListener(v -> completeRegistration("Artist Supporter"));
        cardVolunteer.setOnClickListener(v -> completeRegistration("Volunteer"));
    }

    private void initializeViews() {
        btnBack = findViewById(R.id.btnBack);
        cardBuyer = findViewById(R.id.cardBuyer);
        cardAdmin = findViewById(R.id.cardAdmin);
        cardArtist = findViewById(R.id.cardArtist);
        cardVolunteer = findViewById(R.id.cardVolunteer);
    }

    /**
     * Handles the transition from Role Selection to the Main App screen for non-admin roles
     * @param role The role name selected by the user
     */
    private void completeRegistration(String role) {
        Toast.makeText(this, "Welcome! You are now a " + role, Toast.LENGTH_SHORT).show();

        // Navigate to MainActivity
        Intent intent = new Intent(RoleSelectionActivity.this, MainActivity.class);
        
        // IMPORTANT: Clear the activity stack so the user can't "back" into registration
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        
        startActivity(intent);
        finish();
    }
}
