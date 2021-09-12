package com.untitledkingdom.weatherwoman.presentation;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.untitledkingdom.weatherwoman.R;
import com.untitledkingdom.weatherwoman.use_cases.facade.WeatherForecastFacade;

import java.io.InputStream;

public class AllCitiesActivity extends AppCompatActivity {
    WeatherForecastFacade weatherForecastFacade = new WeatherForecastFacade();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cities);

        EditText editText = (EditText) findViewById(R.id.edit_text_all_cities);

        InputStream inputStream = getResources().openRawResource(
                getResources().getIdentifier("task",
                        "raw", getPackageName()));

        String txtFile = weatherForecastFacade.reedFile(inputStream);

        editText.setText(txtFile);
    }
}