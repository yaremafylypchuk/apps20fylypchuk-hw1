package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private final static int MINTEMP = -273;
    private double[] temperaturesArray;
    private int currentTempnum;
    private int currentCapacity;

    public TemperatureSeriesAnalysis() {
        temperaturesArray = new double[1];
        currentCapacity = 1;
        currentTempnum = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this();
        addTemps(temperatureSeries);
    }

    public double average() {
        checkInput();
        double avarage = 0;
        for (int i = 0; i < currentTempnum; i++) {
            avarage += temperaturesArray[i];
        }
        avarage = avarage / currentTempnum;
        return avarage;
    }

    public double deviation() {
        checkInput();
        double deviation = 0;
        double average = average();
        for (int i = 0; i < currentTempnum; i++) {
            deviation += Math.pow(Math.abs(temperaturesArray[i] - average), 2);
        }

        deviation /= currentTempnum;
        return deviation;
    }

    public double min() {
        checkInput();
        double min = temperaturesArray[0];
        for (int i = 0; i < currentTempnum; i++) {
            if (min > temperaturesArray[i]) {
                min = temperaturesArray[i];
            }
        }
        return min;
    }

    public double max() {
        checkInput();
        double max = temperaturesArray[0];
        for (int i = 0; i < currentTempnum; i++) {
            if (max < temperaturesArray[i]) {
                max = temperaturesArray[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkInput();
        double curClosest = temperaturesArray[0];
        double distance = Math.abs(curClosest - tempValue);
        for (int i = 0; i < currentTempnum; i++) {
            if (distance > Math.abs(temperaturesArray[i] - tempValue)) {
                curClosest = temperaturesArray[i];
                distance = Math.abs(curClosest - tempValue);
            }
        }
        return curClosest;
    }

    public double[] findTempsLessThen(double tempValue) {
        TemperatureSeriesAnalysis res = new TemperatureSeriesAnalysis();
        for (int i = 0; i < currentTempnum; i++) {
            if (temperaturesArray[i] < tempValue) {
                res.addTemps(temperaturesArray[i]);
            }
        }
        double[] result = new double[res.currentTempnum];
        System.arraycopy(res.temperaturesArray,
                0, result,
                0,
                res.currentTempnum);
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        TemperatureSeriesAnalysis res = new TemperatureSeriesAnalysis();
        for (int i = 0; i < currentTempnum; i++) {
            if (temperaturesArray[i] > tempValue) {
                res.addTemps(temperaturesArray[i]);
            }
        }
        double[] result = new double[res.currentTempnum];
        System.arraycopy(res.temperaturesArray,
                0, result,
                0,
                res.currentTempnum);
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        checkInput();
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public void checkInput() {
        if (currentTempnum == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < MINTEMP) {
                throw new InputMismatchException();
            }
            if (currentTempnum < currentCapacity) {
                temperaturesArray[currentTempnum] = temp;
                currentTempnum++;
            } else {
                double[] newArray = new double[currentCapacity * 2];
                System.arraycopy(temperaturesArray,
                        0, newArray,
                        0,
                        currentCapacity);
                currentCapacity *= 2;
                temperaturesArray = newArray;
                temperaturesArray[currentTempnum] = temp;
                currentTempnum++;
            }
        }
        return currentTempnum;
    }
}
