package com.abc.uc.mathsincalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.lang.String;

public class EquationsActivity extends AppCompatActivity {

    
    private final static double dx = 0.05;
    private final static double dy = 0.05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
        
        final EditText eText1 = (EditText) findViewById(R.id.editText2);
        final String leftSide = "";
        final String rightSide = "";

        Button buttonSolve = (Button) findViewById(R.id.buttonSolve);
        Button buttonHelp = (Button) findViewById(R.id.buttonHelp);

        final TextView textSolution = (TextView) findViewById(R.id.textSolution);

        textSolution.setMovementMethod(new ScrollingMovementMethod());

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String leftSideOfEquation = FunHolder.getLeftSideOfEquation(eText1.getText().toString(), leftSide);
                String rightSideOfEquation = FunHolder.getRightSideOfEquation(eText1.getText().toString(), rightSide);

                leftSideOfEquation = leftSideOfEquation.replace("csch", "1/sinh");
                leftSideOfEquation = leftSideOfEquation.replace("sech", "1/cosh");
                leftSideOfEquation = leftSideOfEquation.replace("coth", "1/tanh");
                leftSideOfEquation = leftSideOfEquation.replace("cot", "1/tan");

                rightSideOfEquation = rightSideOfEquation.replace("csch", "1/sinh");
                rightSideOfEquation = rightSideOfEquation.replace("sech", "1/cosh");
                rightSideOfEquation = rightSideOfEquation.replace("coth", "1/tanh");
                rightSideOfEquation = rightSideOfEquation.replace("cot", "1/tan");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


               try{

                    DataPoint[] dataPoints = new DataPoint[360];
                    DataPoint[] dataPointsbuf = new DataPoint[360];
                    
                int j = 0;
                DataPoint[] data1 = new DataPoint[360];
                DataPoint[] data2 = new DataPoint[360];

                for(int i = 0; i < 360; i++){

                    if(!FunHolder.isArc(leftSideOfEquation)&& !FunHolder.isLog(leftSideOfEquation)) {
                        Expression leftSideExpressionSolver = new ExpressionBuilder(leftSideOfEquation)
                                .variables("x")
                                .build()
                                .setVariable("x", Math.toRadians((i) - 180));
                        try {
                            data1[i] = new DataPoint(Math.toRadians((i) - 180), leftSideExpressionSolver.evaluate());
                        } catch (ArithmeticException e) {
                            data1[i] = new DataPoint(Math.toRadians((i) - 180), 1000);
                        }
                    }else if(FunHolder.isArc(leftSideOfEquation)){
                        Expression leftSideExpressionSolver = new ExpressionBuilder(leftSideOfEquation)
                                .variables("x")
                                .build()
                                .setVariable("x", Math.toRadians((i/3.6) - 50));
                        try {
                            data1[i] = new DataPoint(Math.toRadians((i/3.6) - 50), leftSideExpressionSolver.evaluate());
                        } catch (ArithmeticException e) {
                            data1[i] = new DataPoint(Math.toRadians((i/3.6) - 50), 1000);
                        }
                    }else if(FunHolder.isLog(leftSideOfEquation)){
                        Expression leftSideExpressionSolver = new ExpressionBuilder(leftSideOfEquation)
                                .variables("x")
                                .build()
                                .setVariable("x", Math.toRadians((i) + 0.001));
                        try {
                            data1[i] = new DataPoint(Math.toRadians((i) + 0.001), leftSideExpressionSolver.evaluate());
                        } catch (ArithmeticException e) {
                            data1[i] = new DataPoint(Math.toRadians((i) + 0.001), 1000);
                        }
                    }
                    ////////////////////////
                    if(!FunHolder.isArc(rightSideOfEquation) && !FunHolder.isLog(rightSideOfEquation)) {
                        Expression rightSideExpressionSolver = new ExpressionBuilder(rightSideOfEquation)
                                .variables("x")
                                .build()
                                .setVariable("x", Math.toRadians((i) - 180));
                        try {
                            data2[i] = new DataPoint(Math.toRadians((i) - 180), rightSideExpressionSolver.evaluate());
                        } catch (ArithmeticException e) {
                            data2[i] = new DataPoint(Math.toRadians((i) - 180), 1000);
                        }
                    }else if(FunHolder.isArc(rightSideOfEquation)){
                        Expression rightSideExpressionSolver = new ExpressionBuilder(rightSideOfEquation)
                                .variables("x")
                                .build()
                                .setVariable("x", Math.toRadians((i/3.6) - 50));
                        try {
                            data2[i] = new DataPoint(Math.toRadians((i/3.6) - 50), rightSideExpressionSolver.evaluate());
                        } catch (ArithmeticException e) {
                            data2[i] = new DataPoint(Math.toRadians((i/3.6) - 50), 1000);
                        }
                    }else if(FunHolder.isLog(rightSideOfEquation) ){
                        Expression rightSideExpressionSolver = new ExpressionBuilder(rightSideOfEquation)
                                .variables("x")
                                .build()
                                .setVariable("x", Math.toRadians((i) + 0.001));
                        try {
                            data2[i] = new DataPoint(Math.toRadians((i) + 0.001), rightSideExpressionSolver.evaluate());
                        } catch (ArithmeticException e) {
                            data2[i] = new DataPoint(Math.toRadians((i) + 0.001), 1000);
                        }
                    }


                }
                    double sum = 0;
                    int howMuchPoints = 0;
                    int which = 0;
                    boolean isMultiplePointsBugOccuring = false;
                    for(int i = 0; i < 360; i++) {
                        if (FunHolder.isLog(leftSideOfEquation) && FunHolder.isLog(rightSideOfEquation)) {
                            if (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, i, i)) {
                                sum = data1[i].getY();
                                which = i;
                                howMuchPoints = 1;
                                while (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, (i + 1), (i + 1))) {
                                    isMultiplePointsBugOccuring = true;
                                    sum += data1[i + 1].getY();
                                    which += i + 1;
                                    howMuchPoints++;
                                    i = i + 1;
                                }
                                if (isMultiplePointsBugOccuring) {

                                    dataPoints[j] = new DataPoint(Math.toRadians((which / howMuchPoints)), sum / howMuchPoints);
                                    j = j + 1;
                                    isMultiplePointsBugOccuring = false;
                                } else {
                                    dataPoints[j] = data1[i];
                                    j = j + 1;
                                }

                            }
                        }else if(FunHolder.isArc(leftSideOfEquation) && FunHolder.isArc(rightSideOfEquation)) {
                            if(FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, i, i)){
                                sum = data1[i].getY();
                                which = i;
                                howMuchPoints = 1;
                                while (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, (i + 1), (i + 1))) {
                                    isMultiplePointsBugOccuring = true;
                                    sum += data1[i + 1].getY();
                                    which += i + 1;
                                    howMuchPoints++;
                                    i = i + 1;
                                }
                                if (isMultiplePointsBugOccuring) {

                                    dataPoints[j] = new DataPoint(Math.toRadians((which / howMuchPoints)/3.6 - 50), sum / howMuchPoints);
                                    j = j + 1;
                                    isMultiplePointsBugOccuring = false;
                                } else {
                                    dataPoints[j] = data1[i];
                                    j = j + 1;
                                }

                            }
                        }else if(FunHolder.isArc(leftSideOfEquation) || FunHolder.isArc(rightSideOfEquation)) {
                            for(int n = 0; n < 359; n++) {
                                if (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, i, n)) {
                                    sum = data1[i].getY();
                                    which = i;
                                    howMuchPoints = 1;
                                    while (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, (i + 1), (n + 1))) {
                                        isMultiplePointsBugOccuring = true;
                                        sum += data1[i + 1].getY();
                                        which += i + 1;
                                        howMuchPoints++;
                                        i = i + 1;
                                    }
                                    if (isMultiplePointsBugOccuring) {

                                        dataPoints[j] = new DataPoint(Math.toRadians((which / howMuchPoints)/3.6 - 50), sum / howMuchPoints);
                                        j = j + 1;
                                        isMultiplePointsBugOccuring = false;
                                    } else {
                                        dataPoints[j] = data1[i];
                                        j = j + 1;
                                    }

                                }
                            }

                        }else if(FunHolder.isLog(leftSideOfEquation) || FunHolder.isLog(rightSideOfEquation)) {
                            for(int n =0; n < 359; n++){
                                if(FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, i, n)){
                                    sum = data1[i].getY();
                                    which = i;
                                    howMuchPoints = 1;
                                    while (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, (i + 1), (n + 1))) {
                                        isMultiplePointsBugOccuring = true;
                                        sum += data1[i + 1].getY();
                                        which += i + 1;
                                        howMuchPoints++;
                                        i = i + 1;
                                    }
                                    if (isMultiplePointsBugOccuring ) {

                                        dataPoints[j] = new DataPoint(Math.toRadians((which / howMuchPoints)), sum / howMuchPoints);
                                        j = j + 1;
                                        isMultiplePointsBugOccuring = false;
                                    } else {
                                        dataPoints[j] = data1[i];
                                        j = j + 1;
                                    }

                                }
                            }
                            DataPoint[] dataPoints2 = new DataPoint[j];
                            for(int n = 0; n<j; n++){
                                dataPoints2[n] = dataPoints[n];
                            }
                        }else{

                                if(FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, i, i)){
                                    sum = data1[i].getY();
                                    which = i;
                                    howMuchPoints = 1;
                                    while (FunHolder.areNeighbourPointsEqual(data1, data2, dx, dy, (i + 1), (i + 1))) {
                                        isMultiplePointsBugOccuring = true;
                                        sum += data1[i + 1].getY();
                                        which += i + 1;
                                        howMuchPoints++;
                                        i = i + 1;
                                    }
                                    if (isMultiplePointsBugOccuring) {

                                        dataPoints[j] = new DataPoint(Math.toRadians((which / howMuchPoints) - 180), sum / howMuchPoints);
                                        j = j + 1;
                                        isMultiplePointsBugOccuring = false;
                                    } else {
                                        dataPoints[j] = data1[i];
                                        j = j + 1;
                                    }

                                }
                            }
                        }


                    DataPoint[] dataPoints2 = new DataPoint[j];
                    for(int n = 0; n < j; n++){
                        dataPoints2[n] = dataPoints[n];
                    }
                    GraphView graph = (GraphView) findViewById(R.id.graph);
                    graph.setTitle("f(x)");
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(data1);
                    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(data2);
                    if(((FunHolder.isArc(leftSideOfEquation) && FunHolder.isArc(rightSideOfEquation)) || (FunHolder.isLog(leftSideOfEquation) && FunHolder.isLog(rightSideOfEquation))) || ((!FunHolder.isArc(leftSideOfEquation) && !FunHolder.isArc(rightSideOfEquation)) || (!FunHolder.isLog(leftSideOfEquation) && !FunHolder.isLog(rightSideOfEquation)))){

                    }else{
                        dataPoints2 = dataPointsbuf;
                    }
                    PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<>(dataPoints2);
                    graph.removeAllSeries();
                    graph.getGridLabelRenderer().setHorizontalAxisTitle("radians");
                    series2.setColor(Color.YELLOW);
                    series3.setColor(Color.RED);
                    series3.setShape(PointsGraphSeries.Shape.POINT);
                    series3.setSize(7);



                leftSideOfEquation = leftSideOfEquation.replace("1/sinh", "csch");
                leftSideOfEquation = leftSideOfEquation.replace("1/cosh", "sech");
                leftSideOfEquation = leftSideOfEquation.replace("1/tanh", "coth");
                leftSideOfEquation = leftSideOfEquation.replace("1/tan", "cot");

                rightSideOfEquation = rightSideOfEquation.replace("1/sinh", "csch");
                rightSideOfEquation = rightSideOfEquation.replace("1/cosh", "sech");
                rightSideOfEquation = rightSideOfEquation.replace("1/tanh", "coth");
                rightSideOfEquation = rightSideOfEquation.replace("1/tan", "cot");
                    series1.setTitle(leftSideOfEquation);
                    series2.setTitle(rightSideOfEquation);
                    series3.setTitle("Solutions");
                    graph.getLegendRenderer().setVisible(true);
                    graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                    graph.addSeries(series1);
                    graph.addSeries(series2);
                    graph.addSeries(series3);
                    if(FunHolder.couldBeInfinity(leftSideOfEquation)|| FunHolder.couldBeInfinity(rightSideOfEquation)){
                        graph.getViewport().setMinY(-10);
                        graph.getViewport().setMaxY(10);
                    }

                    graph.getViewport().setXAxisBoundsManual(true);
                    if(FunHolder.isArc(leftSideOfEquation) && FunHolder.isArc(rightSideOfEquation)){
                        graph.getViewport().setMinX(-1);
                        graph.getViewport().setMaxX(1);
                    }else{
                        graph.getViewport().setMinX(Math.toRadians(-180));
                        graph.getViewport().setMaxX(Math.toRadians(180));
                    }
                    String nazwa = "";
                    int bufi = 1;
                    for(int i = 0; i < j; i++){
                        if(dataPoints2[i].getX()<=Math.PI && dataPoints2[i].getX()>=-Math.PI){
                        double wynikx = dataPoints2[i].getX();
                        double wyniky = dataPoints2[i].getY();
                        nazwa = nazwa + "Solution " +(bufi)+ " = (" + String.format("%1.2f", wynikx/3.14) + " pi rad, " + String.format("%1.2f", wyniky) + ") = (" + String.format("%1.2f", Math.toDegrees(wynikx)) + "  deg, " + String.format("%1.2f", wyniky) +")\n";
                        bufi++;
                    }
                    }


                    textSolution.setText(nazwa);

                }
                catch(Exception e){
                    Toast.makeText(EquationsActivity.this,
                           "Wrong entry format, press help for information", Toast.LENGTH_LONG).show();
                }

            }
        });
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(EquationsActivity.this).create();
                alertDialog.setTitle("Help");
                alertDialog.setMessage("Warning! Please do not add or substract from variable while using asin and acos as long as they can't handle values other than between -1 and 1. Don't multiply the acos or asin variable by number greater than 1 or lower than -1. Also please don't substract from variable while using log functions as long as they can't take values lower than 0. \n" +
                        "\nCommands: \n" +
                        "abs: absolute value\n" +
                        "acos: arc cosine\n" +
                        "asin: arc sine\n" +
                        "atan: arc tangent\n" +
                        "ceil: nearest upper integer\n" +
                        "cos: cosine\n" +
                        "cosh: hyperbolic cosine\n" +
                        "exp: euler's number raised to the power (e^x)\n" +
                        "floor: nearest lower integer\n" +
                        "sin: sine\n" +
                        "sinh: hyperbolic sine\n" +
                        "tan: tangent\n" +
                        "tanh: hyperbolic tangent\n" +
                        "signum: signum function\n" +
                        "coth: hyperbolic cotangent\n" +
                        "sech: hyperbolic secant\n" +
                        "csch: hyperbolic cosecant\n" +
                        "cot: cotangent\n" +
                        "log: logarithmus naturalis (base e)\n" +
                        "log10: logarithm (base 10)\n" +
                        "log2: logarithm (base 2)\n" +

                "\nExample equations=\n" +
                "sin(x) = 2cos(0.5x)\n" +
                "tan(x^2) = 0.5tanh(x-2)\n" +
                "cotan(x+3) = 1.5acos(x)\n" +
                        "log(x^2) = tanh(x-1)\n" +
                        "exp(0.5x) = 0.5atan(x-2)\n" +
                        "acos(0.5x) = asin(x^2)\n" +
                        "floor(x-3) = x^2\n");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });


    }
}
