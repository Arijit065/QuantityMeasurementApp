package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void shouldReturnTrueForEqualFeetValues() {

        Length value1 = new Length(1.0, LengthUnit.FEET);
        Length value2 = new Length(1.0, LengthUnit.FEET);

        assertEquals(value1, value2);
    }

    @Test
    void shouldReturnTrueForEqualInchValues() {

        Length value1 = new Length(12.0, LengthUnit.INCH);
        Length value2 = new Length(12.0, LengthUnit.INCH);

        assertEquals(value1, value2);
    }

    @Test
    void shouldReturnTrueForFeetAndInchEquality() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        assertEquals(feet, inch);
    }

    @Test
    void shouldReturnFalseForDifferentValues() {

        Length value1 = new Length(1.0, LengthUnit.FEET);
        Length value2 = new Length(2.0, LengthUnit.FEET);

        assertNotEquals(value1, value2);
    }

    @Test
    void shouldReturnFalseWhenComparedWithNull() {

        Length value = new Length(1.0, LengthUnit.FEET);

        assertNotEquals(null, value);
    }

    @Test
    void shouldReturnTrueForSameReference() {

        Length value = new Length(1.0, LengthUnit.FEET);

        assertEquals(value, value);
    }
}