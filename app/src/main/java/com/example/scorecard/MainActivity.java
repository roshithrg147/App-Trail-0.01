package com.example.scorecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("State", "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("State", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("State", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("State", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("State", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("State", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("State", "onDestroy");
    }

    public void loginButtonClicked(View view){
        Intent intent = new Intent(this, AccountSelectionActivity.class);

        intent.putExtra("key", "value");
        startActivity(intent);
    }

    public void signupButtonClicked(View view){
        Intent intent = new Intent(this, SignUpActivity.class);

        intent.putExtra("key", "value");
        startActivity(intent);
    }
}





