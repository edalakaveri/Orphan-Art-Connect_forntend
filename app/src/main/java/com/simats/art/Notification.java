package com.simats.art;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Using the notification layout created earlier
        setContentView(R.layout.notification);

        // Back button functionality
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Initialize Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            // Notifications is likely a sub-screen, so we don't highlight a specific main nav item
            // or you can set it to a default if desired.
            bottomNav.setOnItemSelectedListener(item -> {
                // Handle navigation between Home, Explore, Cart, etc.
                return true;
            });
        }
    }
}
