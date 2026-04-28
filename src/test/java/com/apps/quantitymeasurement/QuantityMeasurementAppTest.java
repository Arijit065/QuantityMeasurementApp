package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        // 1 yard = 3 feet
        assertEquals(new Length(1.0, LengthUnit.YARD), new Length(3.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        // 1 yard = 36 inches
        assertEquals(new Length(1.0, LengthUnit.YARD), new Length(36.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_InchesToCm_EquivalentValue() {
        // 1 inch = 2.5 cm (based on 0.4 conversion factor)
        assertEquals(new Length(1.0, LengthUnit.INCHES), new Length(2.5, LengthUnit.CENTIMETER));
    }

    @Test
    public void testEquality_YardToFeet_Symmetry() {
        // 3 feet = 1 yard
        assertEquals(new Length(3.0, LengthUnit.FEET), new Length(1.0, LengthUnit.YARD));
    }

    @Test
    public void testInequality_YardToFeet_DifferentValue() {
        assertNotEquals(new Length(1.0, LengthUnit.YARD), new Length(1.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_CmToFeet() {
        // 30 cm = 12 inches = 1 foot
        assertEquals(new Length(30.0, LengthUnit.CENTIMETER), new Length(1.0, LengthUnit.FEET));
    }
}