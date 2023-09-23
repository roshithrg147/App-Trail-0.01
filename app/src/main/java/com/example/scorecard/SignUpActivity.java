package com.example.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String name = editTextName.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (isValidSignUp(username, name, phoneNumber, email, password)) {
                    // Successful sign-up, navigate to the next screen (e.g., home screen)
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the sign-up activity
                } else {
                    // Show an error message to the user
                    Toast.makeText(SignUpActivity.this, "Invalid sign-up data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidSignUp(String username, String name, String phoneNumber, String email, String password) {
        // Implement your sign-up validation logic here
        // For example, check if the fields are not empty and meet certain criteria

        return !username.isEmpty() && !name.isEmpty() && !phoneNumber.isEmpty()
                && !email.isEmpty() && password.length() >= 6;
    }
}
