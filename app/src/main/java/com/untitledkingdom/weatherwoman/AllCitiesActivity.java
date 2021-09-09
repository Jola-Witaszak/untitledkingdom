package com.untitledkingdom.weatherwoman;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.untitledkingdom.weatherwoman.weatherforecast.facade.WeatherForecastFacade;

public class AllCitiesActivity extends AppCompatActivity {

    private WeatherForecastFacade weatherForecastFacade;

    public AllCitiesActivity(WeatherForecastFacade weatherForecastFacade) {
        this.weatherForecastFacade = weatherForecastFacade;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cities);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView) findViewById(R.id.printJson);
        textView.setText((CharSequence) weatherForecastFacade.getAllForecasts());
    }
}