package com.example.finance_project;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // מחבר את הקובץ לקובץ ה-XML של העיצוב

        // אתחול Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // קישור בין משתני ה-Java לשדות ולכפתור ב-XML
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // האזנה ללחיצה על כפתור ההרשמה
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // בדיקה שהשדות אינם ריקים
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("נא להכניס אימייל");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("נא להכניס סיסמה");
            return;
        }

        // שליחת הנתונים ל-Firebase ליצירת משתמש חדש
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // ההרשמה הצליחה!
                            Toast.makeText(RegisterActivity.this, "המשתמש נוצר בהצלחה!", Toast.LENGTH_SHORT).show();
                            finish(); // סוגרת את המסך הנוכחי
                        } else {
                            // ההרשמה נכשלה - הצגת הודעת השגיאה מהשרת
                            Toast.makeText(RegisterActivity.this, "שגיאה: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}