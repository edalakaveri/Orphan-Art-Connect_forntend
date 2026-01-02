package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindashboard);

        // 1. Back button: Returns to Admin Login or previous screen
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. Notification icon logic
        View btnNotifications = findViewById(R.id.btnAdminNotifications);
        if (btnNotifications != null) {
            btnNotifications.setOnClickListener(v -> {
                startActivity(new Intent(AdminDashboardActivity.this, NotificationsActivity.class));
            });
        }

        // 3. Dashboard Connectivity
        setupDashboardActions();
    }

    private void setupDashboardActions() {
        // Tab: Events - Navigates to Events management
        LinearLayout tabEvents = findViewById(R.id.tabEvents);
        if (tabEvents != null) {
            tabEvents.setOnClickListener(v -> startActivity(new Intent(this, AdminEventsActivity.class)));
        }

        // Tab: Artworks (Current Screen)
        LinearLayout tabArtworks = findViewById(R.id.tabArtworks);
        if (tabArtworks != null) {
            tabArtworks.setOnClickListener(v -> 
                Toast.makeText(this, "Already on Artworks Tab", Toast.LENGTH_SHORT).show()
            );
        }

        // Tab: Upload - Navigates to AdminUploadActivity
        LinearLayout tabUpload = findViewById(R.id.tabUpload);
        if (tabUpload != null) {
            tabUpload.setOnClickListener(v -> {
                Intent intent = new Intent(AdminDashboardActivity.this, AdminUploadActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            });
        }

        // Add New Artwork Button - Navigates to AdminUploadActivity
        AppCompatButton btnAddNew = findViewById(R.id.btnAddNewArtwork);
        if (btnAddNew != null) {
            btnAddNew.setOnClickListener(v -> {
                Intent intent = new Intent(AdminDashboardActivity.this, AdminUploadActivity.class);
                startActivity(intent);
            });
        }

        // Setup Edit and Delete Actions
        setupItemActions();
    }

    private void setupItemActions() {
        // Artwork 1
        if (findViewById(R.id.btnEdit1) != null) {
            findViewById(R.id.btnEdit1).setOnClickListener(v -> {
                Intent intent = new Intent(this, AdminEditArtworkActivity.class);
                intent.putExtra("artworkName", "Sunset Dreams");
                startActivity(intent);
            });
        }
        if (findViewById(R.id.btnDelete1) != null) {
            findViewById(R.id.btnDelete1).setOnClickListener(v -> 
                Toast.makeText(this, "Sunset Dreams deleted", Toast.LENGTH_SHORT).show()
            );
        }

        // Artwork 2
        if (findViewById(R.id.btnEdit2) != null) {
            findViewById(R.id.btnEdit2).setOnClickListener(v -> {
                Intent intent = new Intent(this, AdminEditArtworkActivity.class);
                intent.putExtra("artworkName", "Geometric Harmony");
                startActivity(intent);
            });
        }
        if (findViewById(R.id.btnDelete2) != null) {
            findViewById(R.id.btnDelete2).setOnClickListener(v -> 
                Toast.makeText(this, "Geometric Harmony deleted", Toast.LENGTH_SHORT).show()
            );
        }

        // Artwork 3
        if (findViewById(R.id.btnEdit3) != null) {
            findViewById(R.id.btnEdit3).setOnClickListener(v -> {
                Intent intent = new Intent(this, AdminEditArtworkActivity.class);
                intent.putExtra("artworkName", "Urban Stories");
                startActivity(intent);
            });
        }
        if (findViewById(R.id.btnDelete3) != null) {
            findViewById(R.id.btnDelete3).setOnClickListener(v -> 
                Toast.makeText(this, "Urban Stories deleted", Toast.LENGTH_SHORT).show()
            );
        }

        // Artwork 4
        if (findViewById(R.id.btnEdit4) != null) {
            findViewById(R.id.btnEdit4).setOnClickListener(v -> {
                Intent intent = new Intent(this, AdminEditArtworkActivity.class);
                intent.putExtra("artworkName", "Joy in Color");
                startActivity(intent);
            });
        }
        if (findViewById(R.id.btnDelete4) != null) {
            findViewById(R.id.btnDelete4).setOnClickListener(v -> 
                Toast.makeText(this, "Joy in Color deleted", Toast.LENGTH_SHORT).show()
            );
        }
    }
}
