package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp handles comparisons between different quantities.
 * UC3: Implements Generic Quantity Class for DRY Principle.
 */
public class QuantityMeasurementApp {

    /**
     * Enum to represent different length units and their conversion factors.
     * Base unit is Inches (1.0) [cite: 473-475].
     */
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    /**
     * Unified class to represent any length measurement.
     */
    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        /**
         * Converts the current value to the base unit (Inches)[cite: 514].
         */
        private double convertToBaseUnit() {
            return this.value * this.unit.getConversionFactor();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length that = (Length) obj;
            // Compare values after converting both to base unit (Inches) [cite: 456, 515]
            return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
        }
    }

    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        System.out.println("Feet Equality (1.0ft == 1.0ft): " + feet1.equals(feet2));
    }

    public static void demonstrateInchesEquality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);
        System.out.println("Inches Equality (1.0in == 1.0in): " + inch1.equals(inch2));
    }

    /**
     * Demonstrates cross-unit comparison[cite: 597, 602].
     */
    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Cross-Unit Equality (1.0ft == 12.0in): " + feet.equals(inches));
    }
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}