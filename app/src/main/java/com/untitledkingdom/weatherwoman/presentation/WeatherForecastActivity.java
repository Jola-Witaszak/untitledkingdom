package com.untitledkingdom.weatherwoman.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.untitledkingdom.weatherwoman.R;

public class WeatherForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()) {
            case R.id.min_button:
                intent = new Intent(WeatherForecastActivity.this, MinTemperatureActivity.class);
                startActivity(intent);
                break;
            case R.id.max_button:
               intent = new Intent(WeatherForecastActivity.this, MaxTempActivity.class);
               startActivity(intent);
               break;
            case R.id.average_daily_button:
                intent = new Intent(WeatherForecastActivity.this, LowAvgTempActivity.class);
                startActivity(intent);
                break;
            case R.id.all_cities_button:
                intent = new Intent(WeatherForecastActivity.this, AllCitiesActivity.class);
                startActivity(intent);
                break;
        }
    }
}