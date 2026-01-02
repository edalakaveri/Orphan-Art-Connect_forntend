package com.simats.art;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AdminAddEventActivity extends AppCompatActivity {

    private EditText etTitle, etDate, etLocation, etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_event);

        initializeViews();

        // Back button
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Add Event Button
        AppCompatButton btnAdd = findViewById(R.id.btnAddEvent);
        if (btnAdd != null) {
            btnAdd.setOnClickListener(v -> {
                String title = etTitle.getText().toString().trim();
                if (title.isEmpty()) {
                    Toast.makeText(this, "Please enter event title", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Event \"" + title + "\" added successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }

        // Cancel Button
        AppCompatButton btnCancel = findViewById(R.id.btnCancel);
        if (btnCancel != null) {
            btnCancel.setOnClickListener(v -> finish());
        }
    }

    private void initializeViews() {
        etTitle = findViewById(R.id.etEventTitle);
        etDate = findViewById(R.id.etEventDate);
        etLocation = findViewById(R.id.etEventLocation);
        etDescription = findViewById(R.id.etEventDescription);
    }
}
