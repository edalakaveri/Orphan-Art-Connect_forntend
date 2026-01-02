package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Connectivity: Continue to Payment Step
        Button btnContinuePayment = findViewById(R.id.btnContinuePayment);
        if (btnContinuePayment != null) {
            btnContinuePayment.setOnClickListener(v -> {
                Intent intent = new Intent(CheckoutActivity.this, CheckoutPaymentactivity1.class);
                startActivity(intent);
            });
        }
    }
}
