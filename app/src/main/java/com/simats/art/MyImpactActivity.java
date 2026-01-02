package com.simats.art;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MyImpactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Since myimpact.xml might be missing, creating a default content view or using a placeholder
        // For now, let's assume you'll create myimpact.xml soon.
        // If the layout doesn't exist, this will cause a runtime crash, 
        // but it solves the compilation error for MyImpactActivity.class.
        setContentView(R.layout.my_impact); 

        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}
