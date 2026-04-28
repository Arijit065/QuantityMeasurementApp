package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp handles comparisons between different quantities.
 * UC2: Accommodates Equality Check for Inches along with Feet.
 */
public class QuantityMeasurementApp {

    /**
     * Inner class to represent Feet measurement.
     */
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, this.value) == 0;
        }
    }

    /**
     * Inner class to represent Inches measurement[cite: 304].
     */
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches inches = (Inches) obj;
            return Double.compare(inches.value, this.value) == 0;
        }
    }

    /**
     * Static method to demonstrate Feet equality check[cite: 305].
     */
    public static void demonstrateFeetEquality() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        System.out.println("Feet Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + feet1.equals(feet2) + ")");
    }

    /**
     * Static method to demonstrate Inches equality check[cite: 307].
     */
    public static void demonstrateInchesEquality() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);
        System.out.println("Inches Input: 1.0 in and 1.0 in");
        System.out.println("Output: Equal (" + inch1.equals(inch2) + ")");
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}