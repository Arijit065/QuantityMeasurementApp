package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * QuantityMeasurementApp handles arithmetic operations between quantities.
 * UC6: Enables adding two lengths and returning the result in the first unit.
 */
public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARD(36.0),
        CENTIMETER(0.393701);

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
         * Private helper to normalize values to the base unit (inches). [cite: 1704]
         */
        private double convertToBaseUnit() {
            return this.value * this.unit.getConversionFactor();
        }

        /**
         * Private helper to convert from the base unit (inches) to a target unit.
         * Centralizes rounding logic to two decimal places. [cite: 1761]
         */
        private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
            double convertedValue = lengthInInches / targetUnit.getConversionFactor();
            return Math.round(convertedValue * 100.0) / 100.0;
        }

        /**
         * Converts this instance to a new unit. [cite: 1704]
         */
        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            double inches = convertToBaseUnit();
            double roundedValue = convertFromBaseToTargetUnit(inches, targetUnit);
            return new Length(roundedValue, targetUnit);
        }

        /**
         * Adds another length to the current length.
         * The result is returned in the unit of this instance. [cite: 1714-1723]
         */
        public Length add(Length thatLength) {
            if (thatLength == null) throw new IllegalArgumentException("Operand cannot be null");

            // 1. Convert both to base unit (inches)
            double sumInInches = this.convertToBaseUnit() + thatLength.convertToBaseUnit();

            // 2. Convert sum back to the unit of the first operand (this instance)
            double summedValue = convertFromBaseToTargetUnit(sumInInches, this.unit);

            // 3. Return new immutable Length instance
            return new Length(summedValue, this.unit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length that = (Length) obj;
            // Round base values for deterministic comparison [cite: 1704]
            double thisBase = Math.round(this.convertToBaseUnit() * 100.0) / 100.0;
            double thatBase = Math.round(that.convertToBaseUnit() * 100.0) / 100.0;
            return Double.compare(thisBase, thatBase) == 0;
        }

        @Override
        public String toString() {
            return String.format("%.2f %s", value, unit);
        }
    }

    // --- API Demonstration Methods ---

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return Objects.equals(l1, l2);
    }

    /**
     * Demonstrates addition of two QuantityLength instances. [cite: 1835]
     */
    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static void main(String[] args) {
        System.out.println("UC6 Addition Demonstrations:");

        // 1.0 Foot + 12.0 Inches = 2.0 Feet [cite: 1848-1849]
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length i12 = new Length(12.0, LengthUnit.INCHES);
        System.out.println(f1 + " + " + i12 + " = " + demonstrateLengthAddition(f1, i12));

        // 12.0 Inches + 1.0 Foot = 24.0 Inches [cite: 1850-1851]
        System.out.println(i12 + " + " + f1 + " = " + demonstrateLengthAddition(i12, f1));
    }
}