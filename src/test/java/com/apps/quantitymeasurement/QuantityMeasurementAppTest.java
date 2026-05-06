package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void shouldAddFeetAndInchesInFeet() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        Length result = feet.add(inch);

        assertEquals(
                new Length(2.0, LengthUnit.FEET),
                result
        );
    }

    @Test
    void shouldAddFeetAndInchesInYards() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        Length result =
                feet.add(inch, LengthUnit.YARD);

        assertEquals(
                new Length(0.6666666667,
                        LengthUnit.YARD),
                result
        );
    }

    @Test
    void shouldAddYardAndFeetInInches() {

        Length yard = new Length(1.0, LengthUnit.YARD);
        Length feet = new Length(3.0, LengthUnit.FEET);

        Length result =
                yard.add(feet, LengthUnit.INCH);

        assertEquals(
                new Length(72.0,
                        LengthUnit.INCH),
                result
        );
    }

    @Test
    void shouldConvertFeetToInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);

        assertEquals(
                12.0,
                feet.convertTo(LengthUnit.INCH)
        );
    }

    @Test
    void shouldReturnTrueForFeetAndInchEquality() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        assertEquals(feet, inch);
    }
}