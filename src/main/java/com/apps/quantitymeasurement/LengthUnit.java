package com.apps.quantitymeasurement;

public enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value from this unit to the base unit (Inches).
     */
    public double convertToBaseUnit(double value) {
        double result = value * this.conversionFactor;
        return Math.round(result * 1000.0) / 1000.0;
    }

    /**
     * Converts a base unit value (Inches) to this unit.
     */
    public double convertFromBaseUnit(double baseValue) {
        double result = baseValue / this.conversionFactor;
        return Math.round(result * 1000.0) / 1000.0;
    }
}