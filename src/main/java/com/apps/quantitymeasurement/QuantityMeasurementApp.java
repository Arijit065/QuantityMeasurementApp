package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * QuantityMeasurementApp handles active unit-to-unit conversions.
 * UC5: Implements explicit conversion operations between length units.
 */
public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARD(36.0),
        CENTIMETER(0.393701); // Updated to precise factor as per UC5 [cite: 1311]

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        /**
         * Private helper to normalize values to the base unit (inches) with rounding.
         * [cite: 850, 1021, 1025]
         */
        private double convertToBaseUnit() {
            double rawInches = this.value * this.unit.getConversionFactor();
            return Math.round(rawInches * 100.0) / 100.0; // Round to 2 decimal places [cite: 933]
        }

        /**
         * Converts this instance to a new unit.
         * [cite: 953, 1113]
         */
        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null"); // [cite: 1107]
            }
            double inches = this.value * this.unit.getConversionFactor();
            double convertedValue = inches / targetUnit.getConversionFactor();
            double roundedValue = Math.round(convertedValue * 100.0) / 100.0;
            return new Length(roundedValue, targetUnit); // Return new instance [cite: 1101]
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length that = (Length) obj;
            return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
        }

        @Override
        public String toString() {
            return String.format("%.2f %s", value, unit); // [cite: 1125]
        }
    }

    // --- API Demonstration Methods ---

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        boolean result = Objects.equals(l1, l2);
        System.out.println("Comparing " + l1 + " to " + l2 + " -> Equal: " + result);
        return result;
    }

    /**
     * Overloaded method for raw values [cite: 874]
     */
    public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    /**
     * Overloaded method for existing objects [cite: 880]
     */
    public static Length demonstrateLengthConversion(Length length, LengthUnit to) {
        return length.convertTo(to);
    }

    public static void main(String[] args) {
        System.out.println("UC5 Conversion Demonstrations:");

        // 1.0 Feet to Inches [cite: 1281]
        Length inches = demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        System.out.println("1.0 FEET -> " + inches);

        // 3.0 Yards to Feet [cite: 1282]
        Length feet = demonstrateLengthConversion(3.0, LengthUnit.YARD, LengthUnit.FEET);
        System.out.println("3.0 YARDS -> " + feet);

        // 1.0 Centimeter to Inches [cite: 1286]
        Length cmToInches = demonstrateLengthConversion(1.0, LengthUnit.CENTIMETER, LengthUnit.INCHES);
        System.out.println("1.0 CENTIMETER -> " + cmToInches);
    }
}