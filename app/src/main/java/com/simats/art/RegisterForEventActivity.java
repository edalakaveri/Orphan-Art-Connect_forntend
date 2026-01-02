package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RegisterForEventActivity extends AppCompatActivity {

    private EditText etPaymentAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerforevent);

        etPaymentAmount = findViewById(R.id.etPaymentAmount);

        // Close Button
        ImageView btnClose = findViewById(R.id.btnClose);
        if (btnClose != null) {
            btnClose.setOnClickListener(v -> finish());
        }

        // Setup Spinner for Guests
        Spinner spinnerGuests = findViewById(R.id.spinnerGuests);
        if (spinnerGuests != null) {
            String[] guestOptions = {"Just me", "1 Guest", "2 Guests", "3 Guests", "4+ Guests"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, guestOptions);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGuests.setAdapter(adapter);
        }

        // Submit Button Logic: Connects to Checkout Page
        findViewById(R.id.btnSubmitRegistration).setOnClickListener(v -> {
            String amount = etPaymentAmount.getText().toString().trim();
            if (amount.isEmpty() || amount.equals("0.00")) {
                // If free event, go to success page
                Intent intent = new Intent(RegisterForEventActivity.this, CompleteEventRegistrationActivity.class);
                startActivity(intent);
            } else {
                // If payment required, go to Checkout
                Intent intent = new Intent(RegisterForEventActivity.this, CheckoutActivity.class);
                intent.putExtra("paymentAmount", amount);
                intent.putExtra("isEventRegistration", true);
                startActivity(intent);
            }
            finish(); 
        });

        // Bottom Navigation Logic
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_events);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_cart) {
                    startActivity(new Intent(this, ShoppingCart.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_events) {
                    return true;
                }
                return false;
            });
        }
    }
}
