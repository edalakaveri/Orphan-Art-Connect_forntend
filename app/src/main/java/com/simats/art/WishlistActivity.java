package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WishlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whishlist);

        // Back Button Logic
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Add to Cart Buttons
        setupAddToCartButtons();

        // Bottom Navigation Logic
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

    private void setupAddToCartButtons() {
        View btn1 = findViewById(R.id.btnAddToCart1);
        if (btn1 != null) {
            btn1.setOnClickListener(v -> {
                CartManager.getInstance().addItem("Sunset Dreams");
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
            });
        }

        View btn2 = findViewById(R.id.btnAddToCart2);
        if (btn2 != null) {
            btn2.setOnClickListener(v -> {
                CartManager.getInstance().addItem("Urban Stories");
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
            });
        }

        View btn3 = findViewById(R.id.btnAddToCart3);
        if (btn3 != null) {
            btn3.setOnClickListener(v -> {
                CartManager.getInstance().addItem("Handwoven Dreams");
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
            });
        }
    }

    // Header: Notification Icon logic
    public void openNotifications(View view) {
        startActivity(new Intent(this, Notification.class));
    }
}
