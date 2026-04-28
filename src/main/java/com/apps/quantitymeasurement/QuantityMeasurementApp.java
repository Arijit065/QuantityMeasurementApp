package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp handles comparisons between different quantities.
 * UC4: Extends units to include Yards and Centimeters.
 */
public class QuantityMeasurementApp {

    /**
     * Enum updated to include Yards and Centimeters[cite: 454].
     * Base unit: Inches.
     */
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARD(36.0),        // 1 Yard = 3 Feet * 12 Inches [cite: 477]
        CENTIMETER(0.4);   // 1 cm = 0.4 inches as per UC4 requirements

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

        private double convertToBaseUnit() {
            return this.value * this.unit.getConversionFactor();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length that = (Length) obj;
            return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
        }
    }

    public static void main(String[] args) {
        // Example demonstrations
        Length threeFeet = new Length(3.0, LengthUnit.FEET);
        Length oneYard = new Length(1.0, LengthUnit.YARD);
        System.out.println("1 Yard == 3 Feet: " + oneYard.equals(threeFeet));

        Length oneInch = new Length(1.0, LengthUnit.INCHES);
        Length twoPointFiveCm = new Length(2.5, LengthUnit.CENTIMETER);
        System.out.println("1 Inch == 2.5 CM: " + oneInch.equals(twoPointFiveCm));
    }
}