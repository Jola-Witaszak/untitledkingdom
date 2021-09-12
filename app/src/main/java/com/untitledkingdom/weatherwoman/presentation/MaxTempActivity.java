package com.untitledkingdom.weatherwoman.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.untitledkingdom.weatherwoman.R;
import com.untitledkingdom.weatherwoman.databinding.ActivityMaxTempBinding;
import com.untitledkingdom.weatherwoman.use_cases.facade.WeatherForecastFacade;

import java.io.InputStream;

public class MaxTempActivity extends AppCompatActivity {

    private ActivityMaxTempBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_temp);

        WeatherForecastFacade weatherForecastFacade = new WeatherForecastFacade();

        InputStream inputStream = getResources().openRawResource(
                getResources().getIdentifier("task",
                        "raw", getPackageName()));

        weatherForecastFacade.decodeJson(inputStream);

        TextView textView = (TextView) findViewById(R.id.textViewCityMax);
        String text = weatherForecastFacade.getMaxTempAndCity();
        textView.setText(text);
    }
}