package com.hfad.starbuzz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BottleCalc extends ActionBarActivity {

    private EditText gallons;
    private EditText ouncesPerBottle;
    private TextView BottleNumber;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_calc);
    }

    public float calculateAndDisplay() {

        // get references to the widgets
        gallons = (EditText) findViewById(R.id.gallons);
        ouncesPerBottle = (EditText) findViewById(R.id.BottleSize);
        BottleNumber = (TextView) findViewById(R.id.BottleNumber);
        submit = (Button) findViewById(R.id.SubmitButton);

        // get the gallons and ounces per bottle
        String first = gallons.getText().toString();
        String second = ouncesPerBottle.getText().toString();


        float firstnum, secondnum, bottleNum;
        if (first.equals("")) {
            firstnum = 0;
        }
        else
            firstnum = Float.parseFloat(first);
        if (second.equals("")) {
            secondnum = 0;
        }
        else
            secondnum = Float.parseFloat(second);

        bottleNum=(firstnum*128)/secondnum;
        int rounded = (int)Math.ceil(bottleNum);

        BottleNumber.setText(Integer.toString(rounded));
        return rounded;

    }


    public void onClickBottleCalc(View v) {

        calculateAndDisplay();
    }
}