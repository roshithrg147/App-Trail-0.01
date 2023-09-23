package com.example.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class AccountSelectionActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private static final int PERSONAL_RADIO_BUTTON_ID = R.id.personalRadioButton;
    private static final int BUSINESS_RADIO_BUTTON_ID = R.id.businessRadioButton;
    private static final int SAVINGS_RADIO_BUTTON_ID = R.id.savingsRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_selection);

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                if (checkedId == PERSONAL_RADIO_BUTTON_ID) {
                    showToast("Personal Account selected");
                } else if (checkedId == BUSINESS_RADIO_BUTTON_ID) {
                    showToast("Business Account selected");
                } else if (checkedId == SAVINGS_RADIO_BUTTON_ID) {
                    showToast("Savings Account selected");
                }
            }
        });
        // Retrieve the selected account from the Intent.
        Intent intent = getIntent();
        final String selectedAccount = intent.getStringExtra("selectedAccount");

        // Display the selected account as a label or title.
        setTitle("Selected Account: " + selectedAccount);

        // Define buttons for user interaction.
        Button confirmButton = findViewById(R.id.confirmButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        // Set a click listener for the confirm button.
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to send the selected account back to MainActivity.
                Intent resultIntent = new Intent();
                resultIntent.putExtra("selectedAccount", selectedAccount);

                // Set the result code and data to be returned to MainActivity.
                setResult(RESULT_OK, resultIntent);

                // Finish this Activity to return to MainActivity.
                finish();
            }
        });

        // Set a click listener for the cancel button.
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // No account selected, so return to MainActivity without passing data.
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void showToast (String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
