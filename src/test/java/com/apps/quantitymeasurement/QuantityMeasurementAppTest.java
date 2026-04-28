package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        // 1.0 FEET + 12.0 INCHES (Target INCHES) = 24.0 INCHES [cite: 2410, 2497]
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length sum = length1.add(length2, LengthUnit.INCHES);

        assertEquals(new Length(24.0, LengthUnit.INCHES), sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        // 1.0 FEET + 12.0 INCHES (Target YARDS) = 0.667 YARDS [cite: 2418]
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length sum = length1.add(length2, LengthUnit.YARD);

        assertEquals(new Length(0.667, LengthUnit.YARD), sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        // Commutativity: add(A, B, Target) == add(B, A, Target) [cite: 2137, 2433]
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        LengthUnit target = LengthUnit.YARD;

        assertEquals(length1.add(length2, target), length2.add(length1, target));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        // Passing null targetUnit throws IllegalArgumentException [cite: 2382, 2461]
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length1.add(length2, null));
    }

    @Test
    public void testAddition_SmallToLargeScale() {
        // 12.0 INCHES + 12.0 INCHES (Target YARDS) = 0.667 YARDS [cite: 2471, 2473]
        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(new Length(0.667, LengthUnit.YARD), l1.add(l2, LengthUnit.YARD));
    }
}