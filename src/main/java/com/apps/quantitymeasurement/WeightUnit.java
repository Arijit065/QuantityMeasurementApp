package com.apps.quantitymeasurement;

public enum WeightUnit {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        double result = value * this.conversionFactor;
        return Math.round(result * 1000.0) / 1000.0;
    }

    public double convertFromBaseUnit(double baseValue) {
        double result = baseValue / this.conversionFactor;
        return Math.round(result * 1000.0) / 1000.0;
    }
}