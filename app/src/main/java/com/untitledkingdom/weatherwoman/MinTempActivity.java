package com.untitledkingdom.weatherwoman;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.untitledkingdom.weatherwoman.weatherforecast.facade.WeatherForecastFacade;

public class MinTempActivity extends AppCompatActivity {

    private TextView textView;
    private WeatherForecastFacade weatherForecastFacade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_temp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.minTemp);
        textView.setText((int) weatherForecastFacade.getMinTemperature());
    }
}