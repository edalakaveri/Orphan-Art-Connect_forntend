package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_home);
            updateCartBadge(); 
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    return true;
                } else if (id == R.id.nav_explore) {
                    startActivity(new Intent(MainActivity.this, ExploreActivity.class));
                    return true;
                } else if (id == R.id.nav_cart) {
                    startActivity(new Intent(MainActivity.this, ShoppingCart.class));
                    return true;
                } else if (id == R.id.nav_events) {
                    startActivity(new Intent(MainActivity.this, Event_And_Exhibition.class));
                    return true;
                } else if (id == R.id.nav_profile) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    return true;
                }
                return false;
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateCartBadge();
    }

    // Connectivity: Header & Notifications
    public void openNotifications(View view) {
        startActivity(new Intent(this, NotificationsActivity.class));
    }

    // Connectivity: Featured Artworks (Slides)
    public void openArtworkDetail(View view) {
        startActivity(new Intent(this, FeaturedArtWork1Activity.class));
    }

    public void openGeometricDetail(View view) {
        startActivity(new Intent(this, FeaturedArtWork2Activity.class));
    }

    public void openUrbanDetail(View view) {
        startActivity(new Intent(this, FeaturedArtWork3Activity.class));
    }

    // Connectivity: Direct Cart Actions
    public void addSunsetToCart(View view) {
        CartManager.getInstance().addItem("Sunset Dreams");
        updateCartBadge();
        Toast.makeText(this, "Sunset Dreams added to cart", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ShoppingCart.class));
    }

    public void addGeometricToCart(View view) {
        CartManager.getInstance().addItem("Geometric Harmony");
        updateCartBadge();
        Toast.makeText(this, "Geometric Harmony added to cart", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ShoppingCart.class));
    }

    public void openCheckout(View view) {
        startActivity(new Intent(this, CheckoutActivity.class));
    }

    // Artist Profile Links
    public void openArtistProfile(View view) {
        startActivity(new Intent(this, MeetOurArtists.class));
    }

    public void openAhmedProfile(View view) {
        startActivity(new Intent(this, MeetOurArtists2.class));
    }

    public void openMariaProfile(View view) {
        startActivity(new Intent(this, MeetOurArtists3.class));
    }

    public void openDavidProfile(View view) {
        startActivity(new Intent(this, MeetOurArtists4.class));
    }

    private void updateCartBadge() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            int count = CartManager.getInstance().getTotalCount();
            if (count > 0) {
                BadgeDrawable badge = bottomNav.getOrCreateBadge(R.id.nav_cart);
                badge.setVisible(true);
                badge.setNumber(count);
            } else {
                bottomNav.removeBadge(R.id.nav_cart);
            }
        }
    }
}
