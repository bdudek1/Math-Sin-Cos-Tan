package com.abc.uc.mathsincalculator;

import android.widget.EditText;

import com.jjoe64.graphview.series.DataPoint;

public abstract class FunHolder {

    public static String getLeftSideOfEquation(String equation, String left) throws NullPointerException{
        String eqBuf = equation.trim();
        left = "";

        for(int i = 0; i<eqBuf.length(); i++){
            if(eqBuf.charAt(i) == '='){
                break;
            }
            left = left + eqBuf.charAt(i);

        }
        left = left.trim();
        return left;
    }

    public static String getRightSideOfEquation(String equation, String right) throws NullPointerException{
        String eqBuf = equation.trim();
        right = "";
        boolean equalSignSpotted = false;
        for(int i = 0; i<eqBuf.length(); i++){
            if(eqBuf.charAt(i) == '='){
                equalSignSpotted = true;
                i = i+1;
            }
            if(equalSignSpotted ){
                right = right + eqBuf.charAt(i);
            }


        }
        right = right.trim();
        return right;
    }

    public static boolean couldBeInfinity (String string) throws NullPointerException{
        if(string.contains("cot") || string.contains("tan") || string.contains("sinh") || string.contains("cosh") || string.contains("coth") || string.contains("csch")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isArc (String string) throws NullPointerException{
        if(string.contains("asin") || string.contains("acos")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isLog (String string) throws NullPointerException{
        if(string.contains("log") || string.contains("log2") || string.contains("log10")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean areNeighbourPointsEqual(DataPoint[] d1, DataPoint[] d2, double dx, double dy, int i1, int i2) throws ArrayIndexOutOfBoundsException ,NullPointerException{
        if ((d1[i1].getY() >= d2[i2].getY() - dx && d1[i1].getY() <= d2[i2].getY() + dx && d1[i1].getX() >= d2[i2].getX() - dy && d1[i1].getX() <= d2[i2].getX() + dy) && i1 < d1.length && i2 < d2.length) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(String str) throws NullPointerException {
        if (str.trim().length() > 0)
            return false;

        return true;
    }
}
