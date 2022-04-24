package com.kavishkamadhushan.cardock;

import androidx.annotation.ArrayRes;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CarRegisterActivity extends AppCompatActivity {

    private InputValidation inputValidation;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inputValidation = new InputValidation();

        Intent intent = getIntent();
        this.userName = intent.getStringExtra(Constants.userName);

        setContentView(R.layout.activity_car_register);
        initialize();

    }

    private void initialize() {

        AutoCompleteTextView carBrand, fuelType, carColor;
        Spinner transmissionType;
        EditText carModel, year, drivenKm, price, numOfOwners;
        Button carRegBtn;

        carBrand = createDropdownSuggestionList(R.id.carBrandAutoCompleteTextView, R.array.carBrands);// car brand input field
        fuelType = createDropdownSuggestionList(R.id.fualTypeAutoCompleteTextView, R.array.fuelType); // fuel type input field
        carColor = createDropdownSuggestionList(R.id.colorTypeAutoCompleteTextView, R.array.carColors );// color input field
        transmissionType = createDropdownList(R.id.spinnerTransmissionType, R.array.transmissionType); // transmission type input field
        carModel = findViewById(R.id.editTextCarModel); // car model EditText
        year = findViewById(R.id.editTextManufactured); // manufactured year
        drivenKm = findViewById(R.id.editTextDrivenKm); // number of kilometers
        price = findViewById(R.id.editTextSellPrice); // price
        numOfOwners = findViewById(R.id.editTextNumOfOwners); // number of owners
        carRegBtn = findViewById(R.id.btnCarRegister); // car registration button

        // set car registration button action
        carRegBtn.setOnClickListener(v -> registerCar(carBrand, carModel, fuelType, transmissionType,
                carColor, year, price, drivenKm, numOfOwners));
    }

    // registration action of a car
    private void registerCar(EditText carBrand, EditText carModel, EditText fuelType, Spinner transmissionType, EditText carColor, EditText year, EditText price, EditText kmDriven, EditText numOfOwners) {
        // check given inputs are valid or not and if all inputs are valid preform action
        if(inputValidation.isValidName(carBrand) && inputValidation.isValidName(carModel) &&
                inputValidation.isValidName(fuelType) && inputValidation.isValidName(carColor) &&
                inputValidation.isValidYear(year) && inputValidation.isValidFloatNumber(price) &&
                inputValidation.isValidFloatNumber(kmDriven) && inputValidation.isOnlyNumbers(numOfOwners)) {

            // store the car
            storeCar(new Car(0, getString(carBrand), getString(carModel), getString(fuelType),
                    transmissionType.getSelectedItem().toString(), getString(carColor), this.userName,
                    Integer.parseInt(getString(year)), Integer.parseInt(getString(kmDriven)),
                    Integer.parseInt(getString(numOfOwners)), Double.parseDouble(getString(price))));

            openDialog(); // show success message
            // clear text fields
            clearTextFields(carBrand, carModel, fuelType, transmissionType, carColor, year, price,
                    kmDriven, numOfOwners);

        }
    }

    // store the car in RegisteredCarList
    private void storeCar(Car car) {
        RegisteredCarList registeredCarList = RegisteredCarList.getRegisteredCarList();
        registeredCarList.addCar(car);
    }

    //this method use to extract string from given EditText
    private String getString(EditText editText) {
        return editText.getText().toString().trim();
    }

    /*
     * set AutoCompleteTextView with suggestion list
     * this accept AutoCompleteTextView Id and resources array list Id as inputs
     */
    private AutoCompleteTextView createDropdownSuggestionList(@IdRes int autoCompleteTextViewId, @ArrayRes int arrayId) {

        AutoCompleteTextView autoCompleteTextView = findViewById(autoCompleteTextViewId);
        // create adapter with resources
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(arrayId));

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);
        return autoCompleteTextView;
    }

    /*
     * set Spinner with drop down items
     * this accept spinner id and resources array list Id as inputs
     */
    private Spinner createDropdownList(@IdRes int spinnerId, @ArrayRes int arrayListId) {
        Spinner spinner = findViewById(spinnerId);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                arrayListId, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    // show success message
    private void openDialog() {
        SuccessMsgDialog successMsgDialog = new SuccessMsgDialog();
        successMsgDialog.show(getSupportFragmentManager(), "Registration success dialog");
    }

    // clear text fields
    private void clearTextFields(EditText carBrand, EditText carModel, EditText fuelType, Spinner transmissionType, EditText carColor, EditText year, EditText price, EditText kmDriven, EditText numOfOwners) {
        carBrand.setText("");
        carModel.setText("");
        fuelType.setText("");
        transmissionType.setId(0);
        carColor.setText("");
        year.setText("");
        price.setText("");
        kmDriven.setText("");
        numOfOwners.setText("");
    }
}