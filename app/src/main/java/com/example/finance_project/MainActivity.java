package com.example.finance_project;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. הצהרה על המשתנים ברמת המחלקה
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. קישור בין המשתנים ב-Java לרכיבי ה-XML לפי ה-ID שלהם
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        // 3. הגדרת מאזין ללחיצה (OnClickListener) עבור כפתור התחברות
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "מתחבר עם אימייל: " + email, Toast.LENGTH_SHORT).show();
                    // כאן בהמשך תוסיף בדיקה מול בסיס נתונים (כמו Firebase או SQLite)
                }
            }
        });

        // 4. הגדרת מאזין ללחיצה עבור כפתור הרשמה
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "מעבר למסך הרשמה...", Toast.LENGTH_SHORT).show();
                // כאן בהמשך תוסיף מעבר אקטיביטי לרישום (Intent)
            }
        });
    }
}