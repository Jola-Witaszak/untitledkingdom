package com.untitledkingdom.weatherwoman;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherwomanActivity extends AppCompatActivity {

    public WeatherwomanActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("aktywność", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent = new Intent(WeatherwomanActivity.this, WeatherForecastActivity.class);
        startActivity(intent);
    }
}