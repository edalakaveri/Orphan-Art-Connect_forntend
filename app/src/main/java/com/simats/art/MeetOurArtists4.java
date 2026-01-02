package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MeetOurArtists4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet_our_artists4);

        // Back button functionality
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Custom Bottom Navigation logic (consistent with other profile pages)
        LinearLayout navHome = findViewById(R.id.nav_home_btn);
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            });
        }

        LinearLayout navExplore = findViewById(R.id.nav_explore_btn);
        if (navExplore != null) {
            navExplore.setOnClickListener(v -> {
                startActivity(new Intent(this, ExploreActivity.class));
                finish();
            });
        }

        LinearLayout navCart = findViewById(R.id.nav_cart_btn);
        if (navCart != null) {
            navCart.setOnClickListener(v -> {
                startActivity(new Intent(this, ShoppingCart.class));
                finish();
            });
        }

        LinearLayout navEvents = findViewById(R.id.nav_events_btn);
        if (navEvents != null) {
            navEvents.setOnClickListener(v -> {
                startActivity(new Intent(this, Event_And_Exhibition.class));
                finish();
            });
        }
    }

    public void openCheckout(View view) {
        startActivity(new Intent(this, CheckoutActivity.class));
    }

    public void addToCartTribal(View view) {
        CartManager.getInstance().addItem("Tribal Unity");
        Toast.makeText(this, "Tribal Unity added to cart", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ShoppingCart.class));
    }

    public void addToCartThreaded(View view) {
        CartManager.getInstance().addItem("Threaded Dreams");
        Toast.makeText(this, "Threaded Dreams added to cart", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ShoppingCart.class));
    }

    public void openNotifications(View view) {
        startActivity(new Intent(this, NotificationsActivity.class));
    }
}
