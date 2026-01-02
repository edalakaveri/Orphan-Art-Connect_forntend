package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        // Check if this was an event registration
        boolean isEvent = getIntent().getBooleanExtra("isEventRegistration", false);

        if (isEvent) {
            // Redirect immediately to the event completion page
            Intent intent = new Intent(OrderSuccessActivity.this, CompleteEventRegistrationActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Button btnBackHome = findViewById(R.id.btnBackHome);
        if (btnBackHome != null) {
            btnBackHome.setOnClickListener(v -> {
                Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            });
        }
    }
}
