package com.simats.art;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

public class checkoutpaymentactivity2 extends AppCompatActivity {

    private LinearLayout layoutPaypal, layoutApplePay, layoutCard, layoutGooglePay;
    private ImageView imgPaypal, imgApplePay, imgCard, imgGooglePay;
    private TextView txtPaypal, txtApplePay, txtCard, txtGooglePay, txtRedirectInfo;
    private Button btnPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Using the layout that matches the Apple Pay/PayPal selection design
        setContentView(R.layout.activity_checkout_payment1);

        // 1. Initialize UI components
        initializeViews();

        // 2. Default selection: Apple Pay (matches the requested slide image)
        selectApplePay();

        // 3. Set Back Button
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // 4. Set Click Listeners for all payment methods
        layoutCard.setOnClickListener(v -> selectCard());
        layoutPaypal.setOnClickListener(v -> selectPaypal());
        layoutApplePay.setOnClickListener(v -> selectApplePay());
        layoutGooglePay.setOnClickListener(v -> selectGooglePay());

        // 5. Place Order Action
        btnPlaceOrder.setOnClickListener(v -> {
            Toast.makeText(this, "Processing Payment - Total: $100.00", Toast.LENGTH_SHORT).show();
        });
    }

    private void initializeViews() {
        layoutCard = findViewById(R.id.layoutCard);
        layoutPaypal = findViewById(R.id.layoutPaypal);
        layoutApplePay = findViewById(R.id.layoutApplePay);
        layoutGooglePay = findViewById(R.id.layoutGooglePay);

        imgCard = findViewById(R.id.imgCard);
        imgPaypal = findViewById(R.id.imgPaypal);
        imgApplePay = findViewById(R.id.imgApplePay);
        imgGooglePay = findViewById(R.id.imgGooglePay);

        txtCard = findViewById(R.id.txtCard);
        txtPaypal = findViewById(R.id.txtPaypal);
        txtApplePay = findViewById(R.id.txtApplePay);
        txtGooglePay = findViewById(R.id.txtGooglePay);
        txtRedirectInfo = findViewById(R.id.txtRedirectInfo);
        
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
    }

    private void selectApplePay() {
        resetAllOptions();
        // Highlight Apple Pay (Matches the image)
        layoutApplePay.setBackgroundResource(R.drawable.bg_payment_selected);
        txtApplePay.setTextColor(Color.parseColor("#805AD5"));
        ImageViewCompat.setImageTintList(imgApplePay, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        
        // Update Info Box Text
        txtRedirectInfo.setText("Complete your payment using Apple Pay on the next screen.");
    }

    private void selectPaypal() {
        resetAllOptions();
        layoutPaypal.setBackgroundResource(R.drawable.bg_payment_selected);
        txtPaypal.setTextColor(Color.parseColor("#805AD5"));
        ImageViewCompat.setImageTintList(imgPaypal, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        txtRedirectInfo.setText("You will be redirected to PayPal to complete your payment.");
    }

    private void selectCard() {
        resetAllOptions();
        layoutCard.setBackgroundResource(R.drawable.bg_payment_selected);
        txtCard.setTextColor(Color.parseColor("#805AD5"));
        ImageViewCompat.setImageTintList(imgCard, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        txtRedirectInfo.setText("Complete your payment using Credit/Debit Card on the next screen.");
    }

    private void selectGooglePay() {
        resetAllOptions();
        layoutGooglePay.setBackgroundResource(R.drawable.bg_payment_selected);
        txtGooglePay.setTextColor(Color.parseColor("#805AD5"));
        ImageViewCompat.setImageTintList(imgGooglePay, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        txtRedirectInfo.setText("Complete your payment using Google Pay on the next screen.");
    }

    private void resetAllOptions() {
        // Colors
        int inactiveIconColor = Color.parseColor("#718096");
        int inactiveTextColor = Color.parseColor("#4A5568");

        // Reset Backgrounds
        layoutCard.setBackgroundResource(R.drawable.bg_payment_normal);
        layoutPaypal.setBackgroundResource(R.drawable.bg_payment_normal);
        layoutApplePay.setBackgroundResource(R.drawable.bg_payment_normal);
        layoutGooglePay.setBackgroundResource(R.drawable.bg_payment_normal);

        // Reset Text Colors
        txtCard.setTextColor(inactiveTextColor);
        txtPaypal.setTextColor(inactiveTextColor);
        txtApplePay.setTextColor(inactiveTextColor);
        txtGooglePay.setTextColor(inactiveTextColor);

        // Reset Icon Colors
        ImageViewCompat.setImageTintList(imgCard, ColorStateList.valueOf(inactiveIconColor));
        ImageViewCompat.setImageTintList(imgPaypal, ColorStateList.valueOf(inactiveIconColor));
        ImageViewCompat.setImageTintList(imgApplePay, ColorStateList.valueOf(inactiveIconColor));
        ImageViewCompat.setImageTintList(imgGooglePay, ColorStateList.valueOf(inactiveIconColor));
    }
}
