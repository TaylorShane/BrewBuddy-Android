package com.hfad.starbuzz;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ABVCalculator extends Activity {

    private EditText OG;
    private EditText FG;
    private Button submit;
    private TextView ABV_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abvcalculator);
    }

    public void calculateAndDisplay() {

        // get references to the widgets
        OG = (EditText) findViewById(R.id.OG);
        FG = (EditText) findViewById(R.id.FG);
        ABV_result = (TextView) findViewById(R.id.ABV_result);
        submit = (Button) findViewById(R.id.ABVSubmitButton);

        // get the gravities
        String og = OG.getText().toString();
        String fg = FG.getText().toString();

        float start, finish, abv, constant = 131.25f;

        start = Float.parseFloat(og);
        finish = Float.parseFloat(fg);

        abv=(start - finish) * constant;

        String s = String.format("%.2f", abv) + '%';
        ABV_result.setText(s);
    }

    public void onClickABVCalc(View v) {calculateAndDisplay();}

}
