package com.gridev.androidappdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateWeightFragment extends Fragment {

    private RadioButton isFemale;
    private EditText weightInput;
    private EditText heightInput;
    private EditText ageInput;
    private Button calculate;
    private ImageView resultImage;
    private TextView resultText;

    private Profile profile;

    private int min;
    private int max;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate_weight, container, false);

        // Initialize Views
        init(view);


        // Calculate
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : Validate Inputs

                // Get Inputs
               getInputsValues();

                // Calculate
                double result = getCalculatedResult();

                // set Result
                setResult(result);

            }
        });


        return view;
    }


    private void init(View view) {
        isFemale = view.findViewById(R.id.calculateWeightFemaleRadioButton);

        weightInput = view.findViewById(R.id.weightInput);
        heightInput = view.findViewById(R.id.heightInput);
        ageInput = view.findViewById(R.id.ageInput);

        calculate = view.findViewById(R.id.calculateWeightButton);

        resultImage = view.findViewById(R.id.weightImageResult);
        resultText = view.findViewById(R.id.weightResult);
    }

    private void getInputsValues () {

        double weight = Double.parseDouble(weightInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString());
        int age = Integer.parseInt(ageInput.getText().toString());
        Gender gender;
        if (isFemale.isChecked()) {
            min = 15;
            max = 30;
            gender = Gender.female;
        } else {
            min = 10;
            max = 15;
            gender = Gender.male;
        }

        profile = new Profile(weight, height, age, gender);
    }

    private double getCalculatedResult() {
        // This Formula Is not Right
        return (1.2 * (703 * profile.getWeight() / (profile.getHeight() * profile.getHeight()))) +
                0.23 * profile.getAge() - 10.83 * profile.getGender().ordinal() - 0.54;
    }

    private void setResult(double result) {

        if (result < min) {
            resultText.setText("Thin");
            resultImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_sentiment_neutral_24dp));
        }
        else if (result > max) {
            resultText.setText("Fat");
            resultImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_sentiment_dissatisfied_24dp));
        }
        else {
            resultText.setText("Normal");
            resultImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_sentiment_satisfied_24dp));
        }

    }

}
