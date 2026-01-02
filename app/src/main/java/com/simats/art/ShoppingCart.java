package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class ShoppingCart extends AppCompatActivity {

    private View layoutItem1, layoutItem2;
    private TextView txtQuantity1, txtItemTotal1, txtQuantity2, txtItemTotal2, txtSubtotal, txtTotal;
    private int quantity1 = 0; // Sunset Dreams
    private int quantity2 = 0; // Geometric Harmony
    private final double price1 = 45.00;
    private final double price2 = 65.00;
    private final double shippingPrice = 10.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cart);

        // Sync with CartManager
        quantity1 = CartManager.getInstance().getQuantity("Sunset Dreams");
        quantity2 = CartManager.getInstance().getQuantity("Geometric Harmony");

        // UI Initialization
        layoutItem1 = findViewById(R.id.layoutItem1); 
        layoutItem2 = findViewById(R.id.layoutItem2); 

        txtQuantity1 = findViewById(R.id.txtQuantity1);
        txtItemTotal1 = findViewById(R.id.txtItemTotal1);
        TextView btnMinus1 = findViewById(R.id.btnMinus1);
        TextView btnPlus1 = findViewById(R.id.btnPlus1);
        ImageView btnDelete1 = findViewById(R.id.btnDelete1);

        txtQuantity2 = findViewById(R.id.txtQuantity2);
        txtItemTotal2 = findViewById(R.id.txtItemTotal2);
        TextView btnMinus2 = findViewById(R.id.btnMinus2);
        TextView btnPlus2 = findViewById(R.id.btnPlus2);
        ImageView btnDelete2 = findViewById(R.id.btnDelete2);

        txtSubtotal = findViewById(R.id.txtSubtotal);
        txtTotal = findViewById(R.id.txtTotal);
        
        updateCartUI();

        // Sunset Dreams Controls
        if (btnMinus1 != null) btnMinus1.setOnClickListener(v -> {
            if (quantity1 > 1) { 
                quantity1--; 
                CartManager.getInstance().setQuantity("Sunset Dreams", quantity1);
                updateCartUI(); 
            }
        });
        if (btnPlus1 != null) btnPlus1.setOnClickListener(v -> {
            quantity1++; 
            CartManager.getInstance().setQuantity("Sunset Dreams", quantity1);
            updateCartUI();
        });
        if (btnDelete1 != null) btnDelete1.setOnClickListener(v -> {
            quantity1 = 0;
            CartManager.getInstance().removeItem("Sunset Dreams");
            updateCartUI();
        });

        // Geometric Harmony Controls
        if (btnMinus2 != null) btnMinus2.setOnClickListener(v -> {
            if (quantity2 > 1) { 
                quantity2--; 
                CartManager.getInstance().setQuantity("Geometric Harmony", quantity2);
                updateCartUI(); 
            }
        });
        if (btnPlus2 != null) btnPlus2.setOnClickListener(v -> {
            quantity2++; 
            CartManager.getInstance().setQuantity("Geometric Harmony", quantity2);
            updateCartUI();
        });
        if (btnDelete2 != null) btnDelete2.setOnClickListener(v -> {
            quantity2 = 0;
            CartManager.getInstance().removeItem("Geometric Harmony");
            updateCartUI();
        });

        // Bottom Navigation logic
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
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
    }

    private void updateCartUI() {
        if (layoutItem1 != null) layoutItem1.setVisibility(quantity1 > 0 ? View.VISIBLE : View.GONE);
        if (layoutItem2 != null) layoutItem2.setVisibility(quantity2 > 0 ? View.VISIBLE : View.GONE);

        double subtotal1 = quantity1 * price1;
        double subtotal2 = quantity2 * price2;
        double totalSubtotal = subtotal1 + subtotal2;
        double finalTotal = (totalSubtotal > 0) ? (totalSubtotal + shippingPrice) : 0;

        if (txtQuantity1 != null) txtQuantity1.setText(String.valueOf(quantity1));
        if (txtItemTotal1 != null) txtItemTotal1.setText(String.format(Locale.getDefault(), "$%.2f", subtotal1));
        
        if (txtQuantity2 != null) txtQuantity2.setText(String.valueOf(quantity2));
        if (txtItemTotal2 != null) txtItemTotal2.setText(String.format(Locale.getDefault(), "$%.2f", subtotal2));

        if (txtSubtotal != null) txtSubtotal.setText(String.format(Locale.getDefault(), "$%.2f", totalSubtotal));
        if (txtTotal != null) txtTotal.setText(String.format(Locale.getDefault(), "$%.2f", finalTotal));
    }

    public void openCheckout(View view) {
        if (quantity1 + quantity2 > 0) {
            Intent intent = new Intent(this, CheckoutActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Your cart is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
