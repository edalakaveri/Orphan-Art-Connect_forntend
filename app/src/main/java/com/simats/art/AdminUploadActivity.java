package com.simats.art;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AdminUploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadinadmindashboard);

        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Tabs Connectivity
        setupTabs();

        // Upload Button Logic
        AppCompatButton btnUpload = findViewById(R.id.btnUploadArtwork);
        if (btnUpload != null) {
            btnUpload.setOnClickListener(v -> {
                Toast.makeText(this, "Artwork Uploaded Successfully!", Toast.LENGTH_SHORT).show();
                finish(); // Return to dashboard
            });
        }
    }

    private void setupTabs() {
        // Tab: Artworks
        LinearLayout tabArtworks = findViewById(R.id.tabArtworks);
        if (tabArtworks != null) {
            tabArtworks.setOnClickListener(v -> {
                startActivity(new Intent(this, AdminDashboardActivity.class));
                overridePendingTransition(0, 0);
                finish();
            });
        }
    }
}
