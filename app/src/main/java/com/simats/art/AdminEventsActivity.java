package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AdminEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_events);

        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        setupNavigation();
        setupEventActions();
    }

    private void setupNavigation() {
        // Tab: Artworks
        LinearLayout tabArtworks = findViewById(R.id.tabArtworks);
        if (tabArtworks != null) {
            tabArtworks.setOnClickListener(v -> {
                startActivity(new Intent(this, AdminDashboardActivity.class));
                overridePendingTransition(0, 0);
                finish();
            });
        }

        // Tab: Upload
        LinearLayout tabUpload = findViewById(R.id.tabUpload);
        if (tabUpload != null) {
            tabUpload.setOnClickListener(v -> {
                startActivity(new Intent(this, AdminUploadActivity.class));
                overridePendingTransition(0, 0);
                finish();
            });
        }

        // Add New Event Button
        AppCompatButton btnAddEvent = findViewById(R.id.btnAddNewEvent);
        if (btnAddEvent != null) {
            btnAddEvent.setOnClickListener(v -> {
                startActivity(new Intent(this, AdminAddEventActivity.class));
            });
        }
    }

    private void setupEventActions() {
        // Event 1
        if (findViewById(R.id.btnEditEvent1) != null) {
            findViewById(R.id.btnEditEvent1).setOnClickListener(v -> {
                Intent intent = new Intent(this, AdminAddEventActivity.class);
                intent.putExtra("isEdit", true);
                intent.putExtra("eventName", "Hope & Harmony");
                startActivity(intent);
            });
        }
        if (findViewById(R.id.btnDeleteEvent1) != null) {
            findViewById(R.id.btnDeleteEvent1).setOnClickListener(v -> 
                Toast.makeText(this, "Event deleted", Toast.LENGTH_SHORT).show()
            );
        }

        // Event 2
        if (findViewById(R.id.btnEditEvent2) != null) {
            findViewById(R.id.btnEditEvent2).setOnClickListener(v -> {
                Intent intent = new Intent(this, AdminAddEventActivity.class);
                intent.putExtra("isEdit", true);
                intent.putExtra("eventName", "Winter Craft Fair");
                startActivity(intent);
            });
        }
        if (findViewById(R.id.btnDeleteEvent2) != null) {
            findViewById(R.id.btnDeleteEvent2).setOnClickListener(v -> 
                Toast.makeText(this, "Event deleted", Toast.LENGTH_SHORT).show()
            );
        }
    }
}
