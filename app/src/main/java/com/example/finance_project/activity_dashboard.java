package com.example.finance_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_dashboard extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView tvWelcome, tvLastMonthSavings, tvIncome, tvExpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        tvWelcome = findViewById(R.id.tvWelcome);
        tvLastMonthSavings = findViewById(R.id.tvLastMonthSavings);
        tvIncome = findViewById(R.id.tvIncome);
        tvExpenses = findViewById(R.id.tvExpenses);

        if (currentUser != null) {
            String userEmail = currentUser.getEmail();
            tvWelcome.setText("שלום, " + userEmail);
        }

        loadFinancialData();
    }

    private void loadFinancialData() {
        tvLastMonthSavings.setText("כמה חסכת בחודש שעבר: ₪1,200");
        tvIncome.setText("הכנסות החודש: ₪8,500");
        tvExpenses.setText("הוצאות החודש: ₪3,400");
    }
}