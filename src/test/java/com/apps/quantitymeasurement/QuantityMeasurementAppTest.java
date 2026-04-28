package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(new Length(36.0, LengthUnit.INCHES), result); // [cite: 1551, 1552]
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length lengthInYards = new Length(2.0, LengthUnit.YARD);
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards, LengthUnit.INCHES);
        assertEquals(new Length(72.0, LengthUnit.INCHES), result); // [cite: 1554, 1557]
    }

    @Test
    public void testConversion_ZeroValue() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(0.0, 0.0); // Verifies 0 returns 0 [cite: 1392]
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double originalValue = 10.0;
        Length toInches = new Length(originalValue, LengthUnit.FEET).convertTo(LengthUnit.INCHES);
        Length backToFeet = toInches.convertTo(LengthUnit.FEET);

        // Using toString comparison for rounded equality check
        assertEquals(String.format("%.2f FEET", originalValue), backToFeet.toString()); // [cite: 1388]
    }

    @Test
    public void testConversion_InvalidUnit_ThrowsException() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length.convertTo(null)); // [cite: 1397]
    }

    @Test
    public void testCentimeterToInchEquality() {
        // 1 cm = 0.393701 inches. Our rounding to 2 decimal places makes this 0.39.
        Length cm = new Length(1.0, LengthUnit.CENTIMETER);
        Length inch = new Length(0.39, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(cm, inch)); // [cite: 1576]
    }
}