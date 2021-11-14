package com.untitledkingdom.weatherwoman.presentation;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.untitledkingdom.weatherwoman.R;
import com.untitledkingdom.weatherwoman.use_cases.facade.WeatherForecastFacade;

import java.io.IOException;
import java.io.InputStream;

public class MinTemperatureActivity extends AppCompatActivity {

    private final WeatherForecastFacade facade = new WeatherForecastFacade();

    public MinTemperatureActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_temperature);
        Toolbar toolbar = findViewById(R.id.toolbar_min_temp);
        setSupportActionBar(toolbar);

        InputStream inputStream = getResources().openRawResource(
                getResources().getIdentifier("task",
                        "raw", getPackageName()));

        facade.decodeJson(inputStream);
        String minTemp = String.valueOf(facade.getMinTemperature());
        EditText textView = (EditText) findViewById(R.id.editTextNumberDecimal);
        textView.setText(minTemp);
    }
}