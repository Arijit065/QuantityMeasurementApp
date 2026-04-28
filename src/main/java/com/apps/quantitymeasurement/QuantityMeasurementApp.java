package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * QuantityMeasurementApp handles advanced arithmetic with target unit specification.
 * UC7: Allows adding two lengths and explicitly defining the result unit.
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

        private double convertToBaseUnit() {
            return this.value * this.unit.getConversionFactor();
        }

        private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
            double convertedValue = lengthInInches / targetUnit.getConversionFactor();
            return Math.round(convertedValue * 1000.0) / 1000.0; // Increased precision for Yards
        }

        /**
         * Private utility to sum two lengths and convert to a target unit.
         * Prevents code duplication between overloaded add methods[cite: 2315, 2317].
         */
        private Length addAndConvert(Length thatLength, LengthUnit targetUnit) {
            if (thatLength == null || targetUnit == null) {
                throw new IllegalArgumentException("Operand and target unit cannot be null");
            }
            double sumInInches = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
            double summedValue = convertFromBaseToTargetUnit(sumInInches, targetUnit);
            return new Length(summedValue, targetUnit);
        }

        /**
         * UC6: Addition defaulting to the unit of the first operand.
         */
        public Length add(Length thatLength) {
            return addAndConvert(thatLength, this.unit);
        }

        /**
         * UC7: Addition with explicit target unit specification.
         */
        public Length add(Length thatLength, LengthUnit targetUnit) {
            return addAndConvert(thatLength, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length that = (Length) obj;
            double thisBase = Math.round(this.convertToBaseUnit() * 100.0) / 100.0;
            double thatBase = Math.round(that.convertToBaseUnit() * 100.0) / 100.0;
            return Double.compare(thisBase, thatBase) == 0;
        }

        @Override
        public String toString() {
            return String.format("%.3f %s", value, unit);
        }
    }

    // --- API Demonstration Methods ---

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {
        System.out.println("UC7 Addition Demonstrations:");

        // 1.0 Foot + 12.0 Inches with Target unit YARDS -> 0.667 YARDS [cite: 2103, 2293]
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length i12 = new Length(12.0, LengthUnit.INCHES);
        System.out.println(f1 + " + " + i12 + " (Target YARDS) = " +
                demonstrateLengthAddition(f1, i12, LengthUnit.YARD));

        // 1.0 FEET + 12.0 INCHES with Target unit INCHES -> 24.0 INCHES [cite: 2292]
        System.out.println(f1 + " + " + i12 + " (Target INCHES) = " +
                f1.add(i12, LengthUnit.INCHES));
    }
}