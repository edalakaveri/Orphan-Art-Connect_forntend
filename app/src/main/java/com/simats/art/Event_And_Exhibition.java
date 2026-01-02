package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Event_And_Exhibition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventandexhibition);

        // Back Button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Open Event 1 Details (Hope & Harmony) when clicking the first card
        CardView cardEvent1 = findViewById(R.id.cardEvent1);
        if (cardEvent1 != null) {
            cardEvent1.setOnClickListener(v -> {
                Intent intent = new Intent(Event_And_Exhibition.this, Event1.class);
                startActivity(intent);
            });
        }

        // Open Event 2 Details (Winter Craft Fair) when clicking the second card
        CardView cardEvent2 = findViewById(R.id.cardEvent2);
        if (cardEvent2 != null) {
            cardEvent2.setOnClickListener(v -> {
                Intent intent = new Intent(Event_And_Exhibition.this, Event2.class);
                startActivity(intent);
            });
        }

        // Open Event 3 Details (Art Workshop) when clicking the third card
        CardView cardEvent3 = findViewById(R.id.cardEvent3);
        if (cardEvent3 != null) {
            cardEvent3.setOnClickListener(v -> {
                Intent intent = new Intent(Event_And_Exhibition.this, Event3.class);
                startActivity(intent);
            });
        }

        // Notifications connectivity
        findViewById(R.id.btnNotifications).setOnClickListener(v -> {
            Intent intent = new Intent(Event_And_Exhibition.this, Notification.class);
            startActivity(intent);
        });

        // Bottom Navigation Logic
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_events); // Highlight the Events tab
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
