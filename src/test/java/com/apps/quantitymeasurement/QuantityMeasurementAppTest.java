package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        assertEquals(new Length(1.0, LengthUnit.FEET), new Length(1.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        assertEquals(new Length(1.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        // Verifies 1 foot = 12 inches
        assertEquals(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        // Verifies symmetry: 12 inches = 1 foot
        assertEquals(new Length(12.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), new Length(2.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        assertNotEquals(new Length(1.0, LengthUnit.INCHES), new Length(2.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_NullComparison() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), null);
    }

    @Test
    public void testEquality_SameReference() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertEquals(length, length);
    }

    @Test
    public void testCrossUnitInequality() {
        // Verifies 1 foot is not 1 inch [cite: 778]
        assertNotEquals(new Length(1.0, LengthUnit.FEET), new Length(1.0, LengthUnit.INCHES));
    }
}