package com.kavishkamadhushan.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class CarRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_register);
        initialize();

    }

    private void initialize() {
        AutoCompleteTextView carBrand = findViewById(R.id.carBrandAutoCompleteTextView);
        AutoCompleteTextView fuelType = findViewById(R.id.fualTypeAutoCompleteTextView);
        AutoCompleteTextView carColor = findViewById(R.id.colorTypeAutoCompleteTextView);
        Spinner transmissionType = findViewById(R.id.spinnerTransmissionType);

        ArrayAdapter<String> carBrandAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.carBrands));
        ArrayAdapter<String> fuelTypeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.fuelType));
        ArrayAdapter<String> colorTypeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.carColors));
        ArrayAdapter<CharSequence> transmissionTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.transmissionType, R.layout.spinner_item);

        transmissionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        carBrand.setThreshold(1);
        fuelType.setThreshold(1);
        carColor.setThreshold(1);

        carBrand.setAdapter(carBrandAdapter);
        carBrand.setAdapter(fuelTypeAdapter);
        carColor.setAdapter(colorTypeAdapter);
        transmissionType.setAdapter(transmissionTypeAdapter);
    }
}