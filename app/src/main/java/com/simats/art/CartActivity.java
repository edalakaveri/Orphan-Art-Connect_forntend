package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    private TextView txtQuantity1, txtQuantity2, txtItemTotal1, txtItemTotal2, txtSubtotal, txtTotal, txtShipping;
    private int quantity1 = 2; // Initial quantity for Sunset Dreams
    private int quantity2 = 1; // Initial quantity for Geometric Harmony
    private final double itemPrice1 = 45.00;
    private final double itemPrice2 = 65.00;
    private final double shippingPrice = 10.00;
    private CardView layoutItem1, layoutItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize Item 1 Views (Sunset Dreams)
        layoutItem1 = findViewById(R.id.layoutItem1);
        txtQuantity1 = findViewById(R.id.txtQuantity1);
        txtItemTotal1 = findViewById(R.id.txtItemTotal1);
        TextView btnMinus1 = findViewById(R.id.btnMinus1);
        TextView btnPlus1 = findViewById(R.id.btnPlus1);
        ImageView btnDelete1 = findViewById(R.id.btnDelete1);

        // Initialize Item 2 Views (Geometric Harmony)
        layoutItem2 = findViewById(R.id.layoutItem2);
        txtQuantity2 = findViewById(R.id.txtQuantity2);
        txtItemTotal2 = findViewById(R.id.txtItemTotal2);
        TextView btnMinus2 = findViewById(R.id.btnMinus2);
        TextView btnPlus2 = findViewById(R.id.btnPlus2);
        ImageView btnDelete2 = findViewById(R.id.btnDelete2);

        // Summary and Navigation Views
        txtSubtotal = findViewById(R.id.txtSubtotal);
        txtShipping = findViewById(R.id.txtShipping);
        txtTotal = findViewById(R.id.txtTotal);
        FrameLayout btnNotifications = findViewById(R.id.btnNotifications);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // --- Item 1 Logic ---
        if (btnMinus1 != null) btnMinus1.setOnClickListener(v -> { if (quantity1 > 1) { quantity1--; updateCartUI(); } });
        if (btnPlus1 != null) btnPlus1.setOnClickListener(v -> { quantity1++; updateCartUI(); });
        if (btnDelete1 != null) {
            btnDelete1.setOnClickListener(v -> {
                quantity1 = 0;
                if (layoutItem1 != null) layoutItem1.setVisibility(View.GONE);
                updateCartUI();
                Toast.makeText(this, "Sunset Dreams removed", Toast.LENGTH_SHORT).show();
            });
        }

        // --- Item 2 Logic ---
        if (btnMinus2 != null) btnMinus2.setOnClickListener(v -> { if (quantity2 > 1) { quantity2--; updateCartUI(); } });
        if (btnPlus2 != null) btnPlus2.setOnClickListener(v -> { quantity2++; updateCartUI(); });
        if (btnDelete2 != null) {
            btnDelete2.setOnClickListener(v -> {
                quantity2 = 0;
                if (layoutItem2 != null) layoutItem2.setVisibility(View.GONE);
                updateCartUI();
                Toast.makeText(this, "Geometric Harmony removed", Toast.LENGTH_SHORT).show();
            });
        }

        // --- Global Summary Delete Logic ---
        ImageView btnDeleteAll = findViewById(R.id.btnDelete);
        if (btnDeleteAll != null) {
            btnDeleteAll.setOnClickListener(this::removeCartItem);
        }

        // Navigation Logic
        if (btnNotifications != null) btnNotifications.setOnClickListener(v -> startActivity(new Intent(this, Notification.class)));
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_cart);
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
        
        updateCartUI();
    }

    public void removeCartItem(View view) {
        quantity1 = 0;
        quantity2 = 0;
        if (layoutItem1 != null) layoutItem1.setVisibility(View.GONE);
        if (layoutItem2 != null) layoutItem2.setVisibility(View.GONE);
        updateCartUI();
        Toast.makeText(this, "All items removed from cart", Toast.LENGTH_SHORT).show();
    }

    private void updateCartUI() {
        double subtotal1 = quantity1 * itemPrice1;
        double subtotal2 = quantity2 * itemPrice2;
        double subtotal = subtotal1 + subtotal2;
        
        double currentShipping = (subtotal > 0) ? shippingPrice : 0;
        double total = subtotal + currentShipping;

        if (txtQuantity1 != null) txtQuantity1.setText(String.valueOf(quantity1));
        if (txtItemTotal1 != null) txtItemTotal1.setText(String.format(Locale.getDefault(), "$%.2f", subtotal1));
        
        if (txtQuantity2 != null) txtQuantity2.setText(String.valueOf(quantity2));
        if (txtItemTotal2 != null) txtItemTotal2.setText(String.format(Locale.getDefault(), "$%.2f", subtotal2));

        if (txtSubtotal != null) txtSubtotal.setText(String.format(Locale.getDefault(), "$%.2f", subtotal));
        if (txtShipping != null) txtShipping.setText(String.format(Locale.getDefault(), "$%.2f", currentShipping));
        if (txtTotal != null) txtTotal.setText(String.format(Locale.getDefault(), "$%.2f", total));
    }

    public void openCheckout(View view) {
        if (quantity1 > 0 || quantity2 > 0) {
            Toast.makeText(this, "Proceeding to checkout...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your cart is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
