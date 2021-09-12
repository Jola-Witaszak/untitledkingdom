package com.untitledkingdom.weatherwoman.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.untitledkingdom.weatherwoman.R;

public class WeatherwomanActivity extends AppCompatActivity {

    public WeatherwomanActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("aktywność", "onCreate w main");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent = new Intent(WeatherwomanActivity.this, WeatherForecastActivity.class);
        startActivity(intent);
    }
}