package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        // 1.0 FEET + 12.0 INCHES (Target YARDS) = 0.667 YARDS [cite: 3118-3119]
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length i12 = new Length(12.0, LengthUnit.INCHES);

        Length sum = f1.add(i12, LengthUnit.YARDS);
        Length expected = new Length(0.667, LengthUnit.YARDS);

        // This will now use Length.equals() instead of getValueForTest()
        assertEquals(expected, sum);
    }

    @Test
    public void testFeetToInchesConversion() {
        // 1.0 FEET converted to INCHES should be 12.0 INCHES [cite: 3105-3107]
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length result = feet.convertTo(LengthUnit.INCHES);
        Length expected = new Length(12.0, LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testInchesToFeetConversion() {
        // 12.0 INCHES converted to FEET should be 1.0 FEET [cite: 3045-3048]
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = inches.convertTo(LengthUnit.FEET);
        Length expected = new Length(1.0, LengthUnit.FEET);

        assertEquals(expected, result);
    }
}