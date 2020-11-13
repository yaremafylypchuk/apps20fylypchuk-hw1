package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {
    private TemperatureSeriesAnalysis emptyArr;
    private TemperatureSeriesAnalysis oneElArr;
    private TemperatureSeriesAnalysis tempArr;
    private TemperatureSeriesAnalysis badArr;
    private double tempValue;

    @Before
    public void SetUp() {
        emptyArr = new TemperatureSeriesAnalysis();
        oneElArr = new TemperatureSeriesAnalysis(new double[]{100.0});
        tempArr = new TemperatureSeriesAnalysis(new double[]{23.0, 1.0, 3.0, -43.0, 77.0});
//        badArr = new TemperatureSeriesAnalysis(new double[] {-275.0, 1.0});
        tempValue = 20.0;
    }


    @Test
    public void testAverageWithOneElementArray() {
        double expResult = 100.0;

        // call tested method
        double actualResult = oneElArr.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        emptyArr.average();
    }

    @Test
    public void testAverage() {
        double expResult = 12.2;
        double actualResult = tempArr.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double expResult = 1514.56;
        double actualResult = tempArr.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double expResult = 0.0;
        double actualResult = oneElArr.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        emptyArr.deviation();
    }

    @Test
    public void testMin() {
        double expResult = -43.0;
        double actualResult = tempArr.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        double expResult = 100.0;
        double actualResult = oneElArr.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        emptyArr.min();
    }

    @Test
    public void testMax() {
        double expResult = 77.0;
        double actualResult = tempArr.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double expResult = 100.0;
        double actualResult = oneElArr.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        emptyArr.max();
    }
    @Test
    public void testfindTempClosestToZero() {
        double expResult = 1.0;
        double actualResult = tempArr.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToZeroWithOneElementArray() {
        double expResult = 100.0;
        double actualResult = oneElArr.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testfindTempClosestToZeroWithEmptyArray() {
        emptyArr.findTempClosestToZero();
    }
    @Test
    public void testfindTempClosestToValue() {
        double expResult = 23.0;
        double actualResult = tempArr.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempClosestToValueWithOneElementArray() {
        double expResult = 100.0;
        double actualResult = oneElArr.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testfindTempClosestToValueWithEmptyArray() {
        emptyArr.findTempClosestToValue(tempValue);
    }

    @Test
    public void testfindTempsLessThan() {
        double[] expResult = {1.0, 3.0, -43.0};
        double[] actualResult = tempArr.findTempsLessThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testfindTempsLessThanWithOneElementArray() {
        double[] expResult = {};
        double[] actualResult = oneElArr.findTempsLessThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsLessThanWithEmptyArray() {
        double[] expResult = {};
        double[] actualResult = emptyArr.findTempsLessThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testfindTempsGreaterThan() {
        double[] expResult = {23.0, 77.0};
        double[] actualResult = tempArr.findTempsGreaterThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThanWithOneElementArray() {
        double[] expResult = {100.0};
        double[] actualResult = oneElArr.findTempsGreaterThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testfindTempsGreaterThanWithEmptyArray() {
        double[] expResult = {};
        double[] actualResult = emptyArr.findTempsGreaterThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testcheckInput(){
        emptyArr.checkInput();
    }
}
