package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutPaymentActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Using the layout created for the Google Pay selection slide
        setContentView(R.layout.activity_checkout_payment2);

        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Place Order button connectivity
        Button btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        if (btnPlaceOrder != null) {
            btnPlaceOrder.setOnClickListener(v -> {
                Toast.makeText(this, "Redirecting to Google Pay - Total: $145.00", Toast.LENGTH_SHORT).show();
                
                // Connectivity: Open Success Screen
                Intent intent = new Intent(CheckoutPaymentActivity3.this, OrderSuccessActivity.class);
                startActivity(intent);
            });
        }
    }
}
