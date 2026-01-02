package com.simats.art;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AdminEditArtworkActivity extends AppCompatActivity {

    private EditText etTitle, etPrice, etDescription, etMedium, etDimensions;
    private Spinner spinnerArtist, spinnerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_edit_artwork);

        initializeViews();
        setupSpinners();

        // Get data from intent (placeholder for actual data passing)
        String artworkName = getIntent().getStringExtra("artworkName");
        if (artworkName != null) {
            etTitle.setText(artworkName);
        }

        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Update Button
        AppCompatButton btnUpdate = findViewById(R.id.btnUpdateArtwork);
        if (btnUpdate != null) {
            btnUpdate.setOnClickListener(v -> {
                Toast.makeText(this, "Artwork updated successfully!", Toast.LENGTH_SHORT).show();
                finish();
            });
        }

        // Cancel Button
        AppCompatButton btnCancel = findViewById(R.id.btnCancel);
        if (btnCancel != null) {
            btnCancel.setOnClickListener(v -> finish());
        }
    }

    private void initializeViews() {
        etTitle = findViewById(R.id.etArtworkTitle);
        etPrice = findViewById(R.id.etPrice);
        etDescription = findViewById(R.id.etDescription);
        etMedium = findViewById(R.id.etMedium);
        etDimensions = findViewById(R.id.etDimensions);
        spinnerArtist = findViewById(R.id.spinnerArtist);
        spinnerCategory = findViewById(R.id.spinnerCategory);
    }

    private void setupSpinners() {
        String[] artists = {"Select an artist", "Priya Sharma", "Ahmed Hassan", "Maria Santos", "David Okonkwo"};
        ArrayAdapter<String> artistAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, artists);
        spinnerArtist.setAdapter(artistAdapter);

        String[] categories = {"Select category", "Abstract", "Portrait", "Landscape", "Modern"};
        ArrayAdapter<String> catAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinnerCategory.setAdapter(catAdapter);
    }
}
