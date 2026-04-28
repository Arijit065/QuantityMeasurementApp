package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void addFeetAndInches() {
        // 1.0 feet + 12.0 inches = 2.0 feet [cite: 2027-2037]
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length sum = QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);

        assertEquals(new Length(2.0, LengthUnit.FEET), sum);
    }

    @Test
    public void testAddition_CrossUnit_InchesPlusFeet() {
        // 12.0 inches + 1.0 feet = 24.0 inches [cite: 1915-1916]
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length sum = inches.add(feet);

        assertEquals(new Length(24.0, LengthUnit.INCHES), sum);
    }

    @Test
    public void testAddition_Commutativity() {
        // a + b should have same numerical base value as b + a [cite: 1928-1931]
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length sum1 = length1.add(length2); // 2.0 feet
        Length sum2 = length2.add(length1); // 24.0 inches

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sum1, sum2));
    }

    @Test
    public void testAddition_WithZero() {
        // 5.0 feet + 0 inches = 5.0 feet [cite: 1885]
        Length feet = new Length(5.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.INCHES);
        assertEquals(feet, feet.add(zero));
    }

    @Test
    public void testAddition_NegativeValues() {
        // 5.0 feet + (-2.0) feet = 3.0 feet [cite: 1941]
        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(-2.0, LengthUnit.FEET);
        assertEquals(new Length(3.0, LengthUnit.FEET), l1.add(l2));
    }

    @Test
    public void testAddition_NullOperand_ThrowsException() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length.add(null)); // [cite: 1945]
    }
}