package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Back Button Logic
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Stats Cards Connectivity
        setupStatsCards();

        // Menu List Connectivity
        setupMenuOptions();

        // Bottom Navigation Logic
        setupBottomNavigation();
    }

    private void setupStatsCards() {
        // Purchases Card
        View cardPurchases = findViewById(R.id.cardPurchases);
        if (cardPurchases != null) {
            cardPurchases.setOnClickListener(v -> {
                startActivity(new Intent(this, MyPurchasesActivity.class));
            });
        }

        // Impact Card
        View cardImpact = findViewById(R.id.cardImpact);
        if (cardImpact != null) {
            cardImpact.setOnClickListener(v -> {
                startActivity(new Intent(this, MyImpactActivity.class));
            });
        }
    }

    private void setupMenuOptions() {
        // Order History
        View menuOrderHistory = findViewById(R.id.menuOrderHistory);
        if (menuOrderHistory != null) {
            menuOrderHistory.setOnClickListener(v -> {
                startActivity(new Intent(this, OrderHistoryActivity.class));
            });
        }

        // Wishlist
        View menuWishlist = findViewById(R.id.menuWishlist);
        if (menuWishlist != null) {
            menuWishlist.setOnClickListener(v -> {
                startActivity(new Intent(this, WishlistActivity.class));
            });
        }

        // Notifications
        View menuNotifications = findViewById(R.id.menuNotifications);
        if (menuNotifications != null) {
            menuNotifications.setOnClickListener(v -> {
                startActivity(new Intent(this, Notification.class));
            });
        }

        // Settings Connectivity
        View menuSettings = findViewById(R.id.menuSettings);
        if (menuSettings != null) {
            menuSettings.setOnClickListener(v -> {
                startActivity(new Intent(this, SettingsActivity.class));
            });
        }
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
                    return true;
                }
                return false;
            });
        }
    }

    // Header: Notification Icon logic (from XML onClick)
    public void openNotifications(View view) {
        startActivity(new Intent(this, Notification.class));
    }
}
