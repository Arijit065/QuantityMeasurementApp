package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        return new Length(value, from).convertTo(to);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {
        System.out.println("--- UC8 Refactored Application ---");

        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length i12 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Equality (1ft vs 12in): " + demonstrateLengthEquality(f1, i12));
        System.out.println("Addition (1ft + 12in): " + demonstrateLengthAddition(f1, i12));
    }
}