package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // --- 1. LengthUnit Enum Tests ---

    @Test
    public void testLengthUnitEnum_ConstantsAndFactors() {
        // Verifies that enum constants are accessible and have correct factors relative to inches
        assertEquals(12.0, LengthUnit.FEET.getConversionFactor());
        assertEquals(1.0, LengthUnit.INCHES.getConversionFactor());
        assertEquals(36.0, LengthUnit.YARDS.getConversionFactor());
        assertEquals(0.393701, LengthUnit.CENTIMETERS.getConversionFactor());
    }

    @Test
    public void testLengthUnit_ConvertToBaseUnit() {
        // Verifies unit-level conversion to base unit (inches)
        assertEquals(12.0, LengthUnit.FEET.convertToBaseUnit(1.0));
        assertEquals(36.0, LengthUnit.YARDS.convertToBaseUnit(1.0));
        assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(2.54)); // 2.54 * 0.393701 ≈ 1.0
    }

    @Test
    public void testLengthUnit_ConvertFromBaseUnit() {
        // Verifies unit-level conversion from base unit (inches) to target unit
        assertEquals(1.0, LengthUnit.FEET.convertFromBaseUnit(12.0));
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(36.0));
    }

    // --- 2. Length Equality Tests ---

    @Test
    public void testLengthEquality_SameUnit() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertEquals(feet1, feet2);

        Length inches1 = new Length(12.0, LengthUnit.INCHES);
        Length inches2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testLengthEquality_CrossUnit() {
        // 1 Foot = 12 Inches
        assertEquals(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES));
        // 1 Yard = 3 Feet
        assertEquals(new Length(1.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET));
        // 1 Yard = 36 Inches
        assertEquals(new Length(1.0, LengthUnit.YARDS), new Length(36.0, LengthUnit.INCHES));
    }

    @Test
    public void testLengthInequality() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), new Length(2.0, LengthUnit.FEET));
        assertNotEquals(new Length(1.0, LengthUnit.FEET), new Length(1.0, LengthUnit.INCHES));
    }

    // --- 3. Length Conversion Tests ---

    @Test
    public void testLength_ConvertTo() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length result = feet.convertTo(LengthUnit.INCHES);
        assertEquals(new Length(12.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testLength_RoundTripConversion() {
        Length original = new Length(1.0, LengthUnit.YARDS);
        Length result = original.convertTo(LengthUnit.INCHES).convertTo(LengthUnit.YARDS);
        assertEquals(original, result);
    }

    // --- 4. Length Addition Tests ---

    @Test
    public void testLengthAddition_ImplicitTargetUnit() {
        // 1.0 feet + 12.0 inches = 2.0 feet (unit of first operand)
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(new Length(2.0, LengthUnit.FEET), l1.add(l2));
    }

    @Test
    public void testLengthAddition_ExplicitTargetUnit() {
        // 1.0 feet + 12.0 inches (Target YARDS) = 0.667 yards
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(new Length(0.667, LengthUnit.YARDS), l1.add(l2, LengthUnit.YARDS));
    }

    @Test
    public void testAddition_Commutativity() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        // Resulting base values must be equal regardless of order
        assertTrue(l1.add(l2).equals(l2.add(l1)));
    }

    // --- 5. Edge Case and Exception Tests ---

    @Test
    public void testLength_NullComparison() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), null);
    }

    @Test
    public void testLength_DifferentClassComparison() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), "1.0 FEET");
    }

    @Test
    public void testLength_NonFiniteValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.POSITIVE_INFINITY, LengthUnit.FEET));
    }

    @Test
    public void testLength_NullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
    }
}