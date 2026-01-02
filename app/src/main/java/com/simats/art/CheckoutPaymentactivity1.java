package com.simats.art;

import android.content.Intent;
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

public class CheckoutPaymentactivity1 extends AppCompatActivity {

    private LinearLayout layoutPaypal, layoutApplePay, layoutCard, layoutGooglePay;
    private ImageView imgPaypal, imgApplePay, imgCard, imgGooglePay;
    private TextView txtPaypal, txtApplePay, txtCard, txtGooglePay, txtRedirectInfo;
    private Button btnPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_payment1);

        // Initialize Layouts
        layoutCard = findViewById(R.id.layoutCard);
        layoutPaypal = findViewById(R.id.layoutPaypal);
        layoutApplePay = findViewById(R.id.layoutApplePay);
        layoutGooglePay = findViewById(R.id.layoutGooglePay);

        // Initialize Icons
        imgCard = findViewById(R.id.imgCard);
        imgPaypal = findViewById(R.id.imgPaypal);
        imgApplePay = findViewById(R.id.imgApplePay);
        imgGooglePay = findViewById(R.id.imgGooglePay);

        // Initialize Texts
        txtCard = findViewById(R.id.txtCard);
        txtPaypal = findViewById(R.id.txtPaypal);
        txtApplePay = findViewById(R.id.txtApplePay);
        txtGooglePay = findViewById(R.id.txtGooglePay);
        txtRedirectInfo = findViewById(R.id.txtRedirectInfo);

        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        // Default: Select Apple Pay (matches your 2nd image)
        selectApplePay();

        // Click Listeners
        layoutCard.setOnClickListener(v -> selectCard());
        layoutPaypal.setOnClickListener(v -> selectPaypal());
        layoutApplePay.setOnClickListener(v -> selectApplePay());
        layoutGooglePay.setOnClickListener(v -> selectGooglePay());

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // Connectivity: Open Success Screen
        btnPlaceOrder.setOnClickListener(v -> {
            Toast.makeText(this, "Processing Payment...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CheckoutPaymentactivity1.this, OrderSuccessActivity.class);
            startActivity(intent);
        });
    }

    private void selectApplePay() {
        resetAllOptions();
        layoutApplePay.setBackgroundResource(R.drawable.bg_payment_selected);
        txtApplePay.setTextColor(Color.parseColor("#805AD5"));
        ImageViewCompat.setImageTintList(imgApplePay, ColorStateList.valueOf(Color.parseColor("#805AD5")));
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
        txtRedirectInfo.setText("Enter your card details to complete the payment.");
    }

    private void selectGooglePay() {
        resetAllOptions();
        layoutGooglePay.setBackgroundResource(R.drawable.bg_payment_selected);
        txtGooglePay.setTextColor(Color.parseColor("#805AD5"));
        ImageViewCompat.setImageTintList(imgGooglePay, ColorStateList.valueOf(Color.parseColor("#805AD5")));
        txtRedirectInfo.setText("Complete your payment using Google Pay on the next screen.");
    }

    private void resetAllOptions() {
        // Reset Card
        layoutCard.setBackgroundResource(R.drawable.bg_payment_normal);
        txtCard.setTextColor(Color.parseColor("#4A5568"));
        ImageViewCompat.setImageTintList(imgCard, ColorStateList.valueOf(Color.parseColor("#718096")));

        // Reset PayPal
        layoutPaypal.setBackgroundResource(R.drawable.bg_payment_normal);
        txtPaypal.setTextColor(Color.parseColor("#4A5568"));
        ImageViewCompat.setImageTintList(imgPaypal, ColorStateList.valueOf(Color.parseColor("#718096")));

        // Reset Apple Pay
        layoutApplePay.setBackgroundResource(R.drawable.bg_payment_normal);
        txtApplePay.setTextColor(Color.parseColor("#4A5568"));
        ImageViewCompat.setImageTintList(imgApplePay, ColorStateList.valueOf(Color.parseColor("#718096")));

        // Reset Google Pay
        layoutGooglePay.setBackgroundResource(R.drawable.bg_payment_normal);
        txtGooglePay.setTextColor(Color.parseColor("#4A5568"));
        ImageViewCompat.setImageTintList(imgGooglePay, ColorStateList.valueOf(Color.parseColor("#718096")));
    }
}
