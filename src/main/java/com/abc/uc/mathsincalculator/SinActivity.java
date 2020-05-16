package com.abc.uc.mathsincalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SinActivity extends AppCompatActivity {
    

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin);


        final CheckBox checkDegree = (CheckBox) findViewById(R.id.checkdegree);
        final CheckBox checkRad = (CheckBox) findViewById(R.id.checkrad);
        final CheckBox checkGrad = (CheckBox) findViewById(R.id.checkgrad);
        final Button buttonSin = (Button) findViewById(R.id.buttoncalcSine);
        final Button buttonCos = (Button) findViewById(R.id.buttoncalcCosine);
        final Button buttonTan = (Button) findViewById(R.id.buttoncalcTan);
        final Button buttonCotan = (Button) findViewById(R.id.buttoncalcCotan);
        final TextView resultText = (TextView) findViewById(R.id.Result);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button buttonRate = (Button) findViewById(R.id.buttonrate);


        checkDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDegree.isChecked()){
                    checkDegree.setChecked(true);
                    checkRad.setChecked(false);
                    checkGrad.setChecked(false);
                }
            }
        });
        checkRad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkRad.isChecked()){
                    checkRad.setChecked(true);
                    checkDegree.setChecked(false);
                    checkGrad.setChecked(false);
                }
            }
        });
        checkGrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkGrad.isChecked()){
                    checkDegree.setChecked(false);
                    checkRad.setChecked(false);
                    checkGrad.setChecked(true);
                }
            }
        });

        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {

                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.sin(Math.toRadians(valueEntered));
                        if(valueEntered == 45){
                            resultText.setText(Html.fromHtml("sin(" + valueEntered + ") = " +"\u221a" +"2/2 = "+String.format("%1.4f", resultDouble)));
                        }else if(valueEntered == 60){
                            resultText.setText(Html.fromHtml("sin(" + valueEntered + ") = " +"\u221a" +"3/2 = "+String.format("%1.4f", resultDouble)));
                        }else
                        resultText.setText("sin(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.sin(valueEntered);
                        resultText.setText("sin(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.sin(Math.toRadians(valueEntered*0.9));
                        resultText.setText("sin(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }
                } else {
                    Toast.makeText(SinActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.cos(Math.toRadians(valueEntered));
                        if(valueEntered == 30){
                            resultText.setText(Html.fromHtml("cos(" + valueEntered + ") = " +"\u221a" +"3/2 = "+String.format("%1.4f", resultDouble)));
                        }else if(valueEntered == 45){
                            resultText.setText(Html.fromHtml("cos(" + valueEntered + ") = " +"\u221a" +"2/2 = "+String.format("%1.4f", resultDouble)));
                        }else
                        resultText.setText("cos(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.cos(valueEntered);
                        resultText.setText("cos(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.cos(Math.toRadians(valueEntered*0.9));
                        resultText.setText("cos(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }
                } else {
                    Toast.makeText(SinActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});


        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.tan(Math.toRadians(valueEntered));

                        if(resultDouble < 10000){
                            if(valueEntered == 30){
                                resultText.setText(Html.fromHtml("tan(" + valueEntered + ") = " + "\u221a" +"3/3 = "+String.format("%1.4f", resultDouble)));
                            }else if(valueEntered == 60){
                                resultText.setText(Html.fromHtml("tan(" + valueEntered + ") = " + "\u221a" +"3 = "+String.format("%1.4f", resultDouble)));
                            }else
                            resultText.setText("tan(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("tan(" + valueEntered + ") = infinity");
                        }

                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.tan(valueEntered);
                        if(resultDouble < 10000){
                            resultText.setText("tan(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("tan(" + valueEntered + ") = infinity");
                        }
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.tan(Math.toRadians(valueEntered*0.9));
                        if(resultDouble < 10000){
                            resultText.setText("tan(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("tan(" + valueEntered + ") = infinity");
                        }
                    }
                } else {
                    Toast.makeText(SinActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonCotan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.tan(Math.toRadians(valueEntered));
                        if(resultDouble < 10000){
                            if(valueEntered == 30){
                                resultText.setText(Html.fromHtml("cot(" + valueEntered + ") = " + "\u221a" +"3 = "+String.format("%1.4f", resultDouble)));
                            }else if(valueEntered == 60){
                                resultText.setText(Html.fromHtml("cot(" + valueEntered + ") = " + "\u221a" +"3/3 = "+String.format("%1.4f", resultDouble)));
                            }else
                            resultText.setText("cot(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("cot(" + valueEntered + ") = infinity");
                        }
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.tan(valueEntered);
                        if(resultDouble < 10000){
                            resultText.setText("cot(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("cot(" + valueEntered + ") = infinity");
                        }
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.tan(Math.toRadians(valueEntered*0.9));
                        if(resultDouble < 10000){
                            resultText.setText("cot(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("cot(" + valueEntered + ") = infinity");
                        }
                    }
                } else {
                    Toast.makeText(SinActivity.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

            buttonRate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.abc.uc.mathsincalculator")));
                }});

    }
}
