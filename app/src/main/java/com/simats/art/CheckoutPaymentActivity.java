package com.simats.art;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CheckoutPaymentActivity extends AppCompatActivity {

    private LinearLayout layoutCard, layoutPaypal;
    private LinearLayout cardDetailsSection, paypalInfoSection;
    private ImageView imgCard, imgPaypal;
    private TextView txtCard, txtPaypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize Views
        layoutCard = findViewById(R.id.layoutCard);
        layoutPaypal = findViewById(R.id.layoutPaypal);
        cardDetailsSection = findViewById(R.id.cardDetailsSection);
        paypalInfoSection = findViewById(R.id.paypalInfoSection);

        imgCard = findViewById(R.id.imgCard);
        imgPaypal = findViewById(R.id.imgPaypal);
        txtCard = findViewById(R.id.txtCard);
        txtPaypal = findViewById(R.id.txtPaypal);

        View btnBack = findViewById(R.id.btnBack);
        View btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Back Button
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Default Selection: Card
        selectCard();

        // Payment Method Toggles
        if (layoutCard != null) {
            layoutCard.setOnClickListener(v -> selectCard());
        }

        if (layoutPaypal != null) {
            layoutPaypal.setOnClickListener(v -> selectPaypal());
        }

        // Place Order Button
        if (btnPlaceOrder != null) {
            btnPlaceOrder.setOnClickListener(v -> {
                String method = (cardDetailsSection != null && cardDetailsSection.getVisibility() == View.VISIBLE) ? "Card" : "PayPal";
                Toast.makeText(this, "Order placed successfully via " + method, Toast.LENGTH_LONG).show();
            });
        }

        // Bottom Navigation
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_cart);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_cart) {
                    return true;
                }
                // Handle other items if needed
                return true;
            });
        }
    }

    private void selectCard() {
        if (cardDetailsSection != null) cardDetailsSection.setVisibility(View.VISIBLE);
        if (paypalInfoSection != null) paypalInfoSection.setVisibility(View.GONE);

        if (layoutCard != null) layoutCard.setBackgroundResource(R.drawable.bg_payment_selected);
        if (layoutPaypal != null) layoutPaypal.setBackgroundResource(R.drawable.bg_payment_normal);

        if (txtCard != null) txtCard.setTextColor(Color.parseColor("#1A202C"));
        if (txtPaypal != null) txtPaypal.setTextColor(Color.parseColor("#4A5568"));

        if (imgCard != null) {
            ImageViewCompat.setImageTintList(imgCard, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        }
        if (imgPaypal != null) {
            ImageViewCompat.setImageTintList(imgPaypal, ColorStateList.valueOf(Color.parseColor("#718096")));
        }
    }

    private void selectPaypal() {
        if (cardDetailsSection != null) cardDetailsSection.setVisibility(View.GONE);
        if (paypalInfoSection != null) paypalInfoSection.setVisibility(View.VISIBLE);

        if (layoutPaypal != null) layoutPaypal.setBackgroundResource(R.drawable.bg_payment_selected);
        if (layoutCard != null) layoutCard.setBackgroundResource(R.drawable.bg_payment_normal);

        if (txtPaypal != null) txtPaypal.setTextColor(Color.parseColor("#1A202C"));
        if (txtCard != null) txtCard.setTextColor(Color.parseColor("#4A5568"));

        if (imgPaypal != null) {
            ImageViewCompat.setImageTintList(imgPaypal, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        }
        if (imgCard != null) {
            ImageViewCompat.setImageTintList(imgCard, ColorStateList.valueOf(Color.parseColor("#718096")));
        }
    }
}
