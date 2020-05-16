package com.abc.uc.mathsincalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Hiperbolic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiperbolic);

        
        final CheckBox checkDegree = (CheckBox) findViewById(R.id.checkdegree);
        final CheckBox checkRad = (CheckBox) findViewById(R.id.checkrad);
        final CheckBox checkGrad = (CheckBox) findViewById(R.id.checkgrad);
        final Button buttonSin = (Button) findViewById(R.id.buttoncalcSine);
        final Button buttonCos = (Button) findViewById(R.id.buttoncalcCosine);
        final Button buttonTan = (Button) findViewById(R.id.buttoncalcTan);
        final Button buttonCotan = (Button) findViewById(R.id.buttoncalcCotan);
        final Button buttonSec = (Button) findViewById(R.id.buttoncalcSec);
        final Button buttonCsc = (Button) findViewById(R.id.buttoncalcCsc);
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
                        double resultDouble = Math.sinh(valueEntered);
                        if (resultDouble < 1000) {
                            resultText.setText("sinh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("sinh(" + valueEntered + ") = infinity");
                        }
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.sinh(valueEntered);
                        if (resultDouble < 1000) {
                            resultText.setText("sinh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("sinh(" + valueEntered + ") = infinity");
                        }
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.sinh(Math.toRadians(valueEntered*0.9));
                        if (resultDouble < 1000) {
                            resultText.setText("sinh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("sinh(" + valueEntered + ") = infinity");
                        }
                    }
                } else {
                    Toast.makeText(Hiperbolic.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.cosh(Math.toRadians(valueEntered));
                        if (resultDouble < 1000) {
                            resultText.setText("cosh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("cosh(" + valueEntered + ") = infinity");
                        }
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.cosh(valueEntered);
                        if (resultDouble < 1000) {
                            resultText.setText("cosh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("cosh(" + valueEntered + ") = infinity");
                        }
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.cosh(Math.toRadians(valueEntered*0.9));
                        if (resultDouble < 1000) {
                            resultText.setText("cosh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("cosh(" + valueEntered + ") = infinity");
                        }
                    }
                } else {
                    Toast.makeText(Hiperbolic.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});


        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.tanh(Math.toRadians(valueEntered));
                        resultText.setText("tanh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));


                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.tanh(valueEntered);
                            resultText.setText("tanh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = Math.tanh(Math.toRadians(valueEntered*0.9));
                            resultText.setText("tanh(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }
                } else {
                    Toast.makeText(Hiperbolic.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonCotan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.tanh(Math.toRadians(valueEntered));
                            if(valueEntered == 0){
                                Toast.makeText(Hiperbolic.this,
                                        "Coth cant take value = 0", Toast.LENGTH_LONG).show();
                            }else
                                resultText.setText("coth(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.tanh(valueEntered);
                            resultText.setText("coth(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.tanh(Math.toRadians(valueEntered*0.9));
                            resultText.setText("coth(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }
                } else {
                    Toast.makeText(Hiperbolic.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {

                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = (1/Math.cosh(Math.toRadians(valueEntered)));
                        if (resultDouble < 1000) {
                            resultText.setText("sech(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("sech(" + valueEntered + ") = infinity");
                        }
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.cosh(valueEntered);
                        if (resultDouble < 1000) {
                            resultText.setText("sech(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("sech(" + valueEntered + ") = infinity");
                        }
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.cosh(Math.toRadians(valueEntered*0.9));
                        if (resultDouble < 1000) {
                            resultText.setText("sech(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                        }else{
                            resultText.setText("sech(" + valueEntered + ") = infinity");
                        }
                    }
                } else {
                    Toast.makeText(Hiperbolic.this,
                            "Please select units and fill all the fields.", Toast.LENGTH_LONG).show();
                }
            }});

        buttonCsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FunHolder.isEmpty(editText.getText().toString()) && (checkGrad.isChecked() || checkRad.isChecked() || checkDegree.isChecked())) {
                    if(checkDegree.isChecked()) {
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.sinh(Math.toRadians(valueEntered));
                        if(valueEntered == 0){
                            Toast.makeText(Hiperbolic.this,
                                    "Csch cant take value = 0", Toast.LENGTH_LONG).show();
                        }else
                            resultText.setText("csch(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkRad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.sinh(valueEntered);
                        resultText.setText("csch(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }else if(checkGrad.isChecked()){
                        double valueEntered = Double.parseDouble(editText.getText().toString());
                        double resultDouble = 1/Math.sinh(Math.toRadians(valueEntered*0.9));
                        resultText.setText("csch(" + valueEntered + ") = " + String.format("%1.4f", resultDouble));
                    }
                } else {
                    Toast.makeText(Hiperbolic.this,
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
