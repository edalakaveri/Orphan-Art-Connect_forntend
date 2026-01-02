package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        // Back Button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Account Section Connectivity
        setupAccountSection();

        // Preferences Section Connectivity
        setupPreferencesSection();

        // Support Section Connectivity
        setupSupportSection();

        // Sign Out Logic: Navigates to the Thank You (Logout) page
        setupSignOut();

        // Bottom Navigation Logic
        setupBottomNavigation();
    }

    private void setupAccountSection() {
        View personalInfo = findViewById(R.id.itemPersonalInfo);
        if (personalInfo != null) {
            personalInfo.setOnClickListener(v -> Toast.makeText(this, "Personal Information Clicked", Toast.LENGTH_SHORT).show());
        }

        View paymentMethods = findViewById(R.id.itemPaymentMethods);
        if (paymentMethods != null) {
            paymentMethods.setOnClickListener(v -> Toast.makeText(this, "Payment Methods Clicked", Toast.LENGTH_SHORT).show());
        }

        View security = findViewById(R.id.itemSecurity);
        if (security != null) {
            security.setOnClickListener(v -> Toast.makeText(this, "Security Clicked", Toast.LENGTH_SHORT).show());
        }
    }

    private void setupPreferencesSection() {
        View notifications = findViewById(R.id.itemNotifications);
        if (notifications != null) {
            notifications.setOnClickListener(v -> startActivity(new Intent(this, Notification.class)));
        }

        View language = findViewById(R.id.itemLanguage);
        if (language != null) {
            language.setOnClickListener(v -> Toast.makeText(this, "Language Clicked", Toast.LENGTH_SHORT).show());
        }
    }

    private void setupSupportSection() {
        View helpCenter = findViewById(R.id.itemHelpCenter);
        if (helpCenter != null) {
            helpCenter.setOnClickListener(v -> Toast.makeText(this, "Help Center Clicked", Toast.LENGTH_SHORT).show());
        }

        View terms = findViewById(R.id.itemTerms);
        if (terms != null) {
            terms.setOnClickListener(v -> Toast.makeText(this, "Terms & Privacy Clicked", Toast.LENGTH_SHORT).show());
        }
    }

    private void setupSignOut() {
        // Correcting the button setup to ensure it captures clicks from both the card and its content
        View btnSignOut = findViewById(R.id.btnSignOut);
        if (btnSignOut != null) {
            btnSignOut.setOnClickListener(v -> openLogoutPage());
        }
    }

    private void openLogoutPage() {
        // Navigate to LogoutActivity (Thank You Page)
        Intent intent = new Intent(this, LogoutActivity.class);
        // Clear the activity stack so the user can't go back after signing out
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_profile);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_explore) {
                    startActivity(new Intent(this, ExploreActivity.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_cart) {
                    startActivity(new Intent(this, ShoppingCart.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_events) {
                    startActivity(new Intent(this, Event_And_Exhibition.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(this, ProfileActivity.class));
                    finish();
                    return true;
                }
                return false;
            });
        }
    }
}
