package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeaturedArtWork1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.featuredartwork1);

        // Back Button Logic
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Add to Cart Logic
        if (findViewById(R.id.btnAddToCart) != null) {
            findViewById(R.id.btnAddToCart).setOnClickListener(v -> {
                CartManager.getInstance().addItem("Sunset Dreams");
                Toast.makeText(this, "Sunset Dreams added to cart", Toast.LENGTH_SHORT).show();
                // Open Shopping Cart Page
                startActivity(new Intent(this, ShoppingCart.class));
            });
        }

        // Buy Now Logic
        if (findViewById(R.id.btnBuyNow) != null) {
            findViewById(R.id.btnBuyNow).setOnClickListener(v -> {
                startActivity(new Intent(this, CheckoutActivity.class));
            });
        }

        // Bottom Navigation Logic
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
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
