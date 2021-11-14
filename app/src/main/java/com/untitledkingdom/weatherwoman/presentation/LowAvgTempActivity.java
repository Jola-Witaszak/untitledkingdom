package com.untitledkingdom.weatherwoman.presentation;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.untitledkingdom.weatherwoman.R;
import com.untitledkingdom.weatherwoman.use_cases.facade.WeatherForecastFacade;

import java.io.InputStream;

public class LowAvgTempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_avg_temp);

        WeatherForecastFacade weatherForecastFacade = new WeatherForecastFacade();

        InputStream inputStream = getResources().openRawResource(
                getResources().getIdentifier("task",
                        "raw", getPackageName()));

        weatherForecastFacade.decodeJson(inputStream);

        EditText editText = (EditText) findViewById(R.id.degrees);
        String text = weatherForecastFacade.getSmallestAverageTemperature();
        editText.setText(text);
    }
}