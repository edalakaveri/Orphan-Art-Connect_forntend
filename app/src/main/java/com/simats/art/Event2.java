package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Event2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event2);

        // Initialize Views
        CardView btnBack = findViewById(R.id.btnBack);
        View btnRegister = findViewById(R.id.btnRegister);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Back Button Logic
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Register Button Logic: Connects to the Registration Form
        if (btnRegister != null) {
            btnRegister.setOnClickListener(v -> {
                Intent intent = new Intent(Event2.this, RegisterForEventActivity.class);
                startActivity(intent);
            });
        }

        // Bottom Navigation Logic
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_events);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    return true;
                } else if (id == R.id.nav_cart) {
                    startActivity(new Intent(this, CartActivity.class));
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
