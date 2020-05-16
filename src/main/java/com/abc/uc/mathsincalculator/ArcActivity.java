package com.abc.uc.mathsincalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class ArcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc);


        final Button buttonASin = (Button) findViewById(R.id.buttoncalcSine);
        final Button buttonACos = (Button) findViewById(R.id.buttoncalcCosine);
        final Button buttonATan = (Button) findViewById(R.id.buttoncalcTan);
        final Button buttonACotan = (Button) findViewById(R.id.buttoncalcCotan);
        final Button buttonRate = (Button) findViewById(R.id.buttonrate);
        final TextView resultText = (TextView) findViewById(R.id.textView5);
        final EditText editText = (EditText) findViewById(R.id.editText);



        buttonASin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString())) {
                    double valueEntered = Double.parseDouble(editText.getText().toString());
                    if(valueEntered >= -1 && valueEntered <= 1){
                        double resultDouble = Math.round(Math.toDegrees(Math.asin(valueEntered)));
                        resultText.setText("asin(" + valueEntered + ") = " + String.format("%1.4f", resultDouble) + " degrees");
                    }else{
                        Toast.makeText(ArcActivity.this,
                                "Arc sine can only take values between -1 and 1.", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(ArcActivity.this,
                            "Please fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonACos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString())) {
                    double valueEntered = Double.parseDouble(editText.getText().toString());
                    if(valueEntered >= -1 && valueEntered <= 1){
                        double resultDouble = Math.round(Math.toDegrees(Math.acos(valueEntered)));
                        resultText.setText("acos(" + valueEntered + ") = " + String.format("%1.4f", resultDouble) + " degrees");
                    }else{
                        Toast.makeText(ArcActivity.this,
                                "Arc cosine can only take values between -1 and 1.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(ArcActivity.this,
                            "Please fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});


        buttonATan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString())) {
                    double valueEntered = Double.parseDouble(editText.getText().toString());
                    double resultDouble = Math.round(Math.toDegrees(Math.atan(valueEntered)));
                    resultText.setText("atan(" + valueEntered + ") = " + String.format("%1.4f", resultDouble) + " degrees");
                }

                else {
                    Toast.makeText(ArcActivity.this,
                            "Please fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonACotan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString())) {
                    double valueEntered = Double.parseDouble(editText.getText().toString());
                    double resultDouble = Math.round(Math.toDegrees(Math.atan(1/valueEntered)));
                    resultText.setText("acot(" + valueEntered + ") = " + String.format("%1.4f", resultDouble) + " degrees");

                } else {
                    Toast.makeText(ArcActivity.this,
                            "Please fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.abc.uc.mathsincalculator")));
            }});

    }
}
