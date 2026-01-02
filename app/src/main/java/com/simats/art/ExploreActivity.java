package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        // Back Button Logic
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Notification Icon Logic
        View btnNotifications = findViewById(R.id.btnNotifications);
        if (btnNotifications != null) {
            btnNotifications.setOnClickListener(v -> {
                startActivity(new Intent(ExploreActivity.this, NotificationsActivity.class));
            });
        }

        // Artwork Click Connectivity (Open Detail Slides)
        setupArtworkClicks();

        // Buy and Add to Cart Buttons Connectivity
        setupProductButtons();

        // Bottom Navigation Logic
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_explore);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_explore) {
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

    private void setupArtworkClicks() {
        // Link to detail slides for each artwork in the grid using direct IDs
        View art1 = findViewById(R.id.cardArtwork1);
        if (art1 != null) art1.setOnClickListener(v -> startActivity(new Intent(this, FeaturedArtWork1Activity.class)));

        View art2 = findViewById(R.id.cardArtwork2);
        if (art2 != null) art2.setOnClickListener(v -> startActivity(new Intent(this, FeaturedArtWork2Activity.class)));

        View art3 = findViewById(R.id.cardArtwork3);
        if (art3 != null) art3.setOnClickListener(v -> startActivity(new Intent(this, FeaturedArtWork3Activity.class)));
        
        View art4 = findViewById(R.id.cardArtwork4);
        if (art4 != null) art4.setOnClickListener(v -> startActivity(new Intent(this, FeaturedArtWork1Activity.class)));
    }

    private void setupProductButtons() {
        // Buy Buttons -> Open Checkout Page
        View.OnClickListener buyListener = v -> {
            startActivity(new Intent(this, CheckoutActivity.class));
        };

        if (findViewById(R.id.btnBuy1) != null) findViewById(R.id.btnBuy1).setOnClickListener(buyListener);
        if (findViewById(R.id.btnBuy2) != null) findViewById(R.id.btnBuy2).setOnClickListener(buyListener);
        if (findViewById(R.id.btnBuy3) != null) findViewById(R.id.btnBuy3).setOnClickListener(buyListener);
        if (findViewById(R.id.btnBuy4) != null) findViewById(R.id.btnBuy4).setOnClickListener(buyListener);

        // Add to Cart Buttons -> Logic
        setupAddToCart(R.id.btnAddToCart1, "Sunset Dreams");
        setupAddToCart(R.id.btnAddToCart2, "Geometric Harmony");
        setupAddToCart(R.id.btnAddToCart3, "Handwoven Dreams");
        setupAddToCart(R.id.btnAddToCart4, "Floral Whispers");
    }

    private void setupAddToCart(int resId, String itemName) {
        View btn = findViewById(resId);
        if (btn != null) {
            btn.setOnClickListener(v -> {
                CartManager.getInstance().addItem(itemName);
                Toast.makeText(this, itemName + " added to cart", Toast.LENGTH_SHORT).show();
                // Connectivity: Open Shopping Cart page after adding item
                startActivity(new Intent(this, ShoppingCart.class));
            });
        }
    }
}
