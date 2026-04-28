package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // --- Weight Demonstration Methods ---

    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static Weight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
        return new Weight(value, from).convertTo(to);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2) {
        return w1.add(w2);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2, WeightUnit target) {
        return w1.add(w2, target);
    }

    // --- Length Methods (Existing from UC8) ---

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void main(String[] args) {
        System.out.println("--- UC9 Weight and Length App ---");

        // Example Weight: 1 kg + 1000 g = 2 kg
        Weight kg1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight g1000 = new Weight(1000.0, WeightUnit.GRAM);
        System.out.println("1kg + 1000g = " + demonstrateWeightAddition(kg1, g1000));

        // Category Incompatibility Check
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        System.out.println("Can compare 1kg to 1ft? " + kg1.equals(feet1));
    }
}