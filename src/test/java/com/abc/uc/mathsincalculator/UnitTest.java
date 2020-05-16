package com.abc.uc.mathsincalculator;

import com.jjoe64.graphview.series.DataPoint;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getLeftSideOfEquationVerify(){
        assertEquals("cosx", FunHolder.getLeftSideOfEquation("cosx=sinx", ""));
        assertEquals("tanx", FunHolder.getLeftSideOfEquation(" tanx = sinx", ""));
    }
    @Test
    public void getRightSideOfEquationVerify(){
        assertEquals("sinx", FunHolder.getRightSideOfEquation("cosx=sinx", ""));
        assertEquals("sinx", FunHolder.getRightSideOfEquation(" tanx = sinx  ", ""));
    }
    @Test
    public void couldBeInfinityVerify() {
        assertTrue(FunHolder.couldBeInfinity("cot"));
        assertTrue(FunHolder.couldBeInfinity("tan"));
        assertTrue(FunHolder.couldBeInfinity("sinh"));
        assertTrue(FunHolder.couldBeInfinity("cosh"));
        assertTrue(FunHolder.couldBeInfinity("coth"));
        assertTrue(FunHolder.couldBeInfinity("csch"));
        assertFalse(FunHolder.couldBeInfinity("sin"));
        assertFalse(FunHolder.couldBeInfinity("cos"));
        assertFalse(FunHolder.couldBeInfinity(""));
        assertFalse(FunHolder.couldBeInfinity("wgrg"));
    }
    @Test
    public void isArcVerify() {
        assertTrue(FunHolder.isArc("asin"));
        assertTrue(FunHolder.isArc("acos"));
        assertFalse(FunHolder.isArc("cos"));
        assertFalse(FunHolder.isArc("  d  g"));
    }
    @Test
    public void isLogVerify() {
        assertTrue(FunHolder.isLog("log"));
        assertTrue(FunHolder.isLog("log2"));
        assertTrue(FunHolder.isLog("log10"));
        assertFalse(FunHolder.isLog("  d  g"));
        assertFalse(FunHolder.isLog(""));
        assertFalse(FunHolder.isLog("sinx"));
    }
    @Test
    public void isEmptyVerify(){
        assertTrue(FunHolder.isEmpty(""));
        assertTrue(FunHolder.isEmpty("     "));
        assertFalse(FunHolder.isEmpty("d"));
        assertFalse(FunHolder.isEmpty("sinx"));
    }
    @Test
    public void areNeighbourPointsEqualVerify(){
        DataPoint[] dataPoints1 = new DataPoint[4];
        DataPoint[] dataPoints2 = new DataPoint[4];
        dataPoints1[0] = new DataPoint(1, 2);
        dataPoints1[1] = new DataPoint(1.03, 2);
        dataPoints1[2] = new DataPoint(1.09, 3.03);
        dataPoints1[3] = new DataPoint(1.11, 3.05);
        dataPoints2[0] = new DataPoint(1, 2);
        dataPoints2[1] = new DataPoint(1.03, 2);
        dataPoints2[2] = new DataPoint(1.09, 3);
        dataPoints2[3] = new DataPoint(1.11, 3.05);
        assertTrue(FunHolder.areNeighbourPointsEqual(dataPoints1, dataPoints2, 0.05, 0.05, 0, 1));
        assertTrue(FunHolder.areNeighbourPointsEqual(dataPoints1, dataPoints2, 0.05, 0.05, 2, 3));
        assertFalse(FunHolder.areNeighbourPointsEqual(dataPoints1, dataPoints2, 0.05, 0.05, 1, 2));
        assertFalse(FunHolder.areNeighbourPointsEqual(dataPoints1, dataPoints2, 0.05, 0.05, 1, 3));
    }
}