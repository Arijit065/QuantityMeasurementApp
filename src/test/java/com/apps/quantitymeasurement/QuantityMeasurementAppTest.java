package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void shouldConvertFeetToInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);

        assertEquals(12.0,
                feet.convertTo(LengthUnit.INCH));
    }

    @Test
    void shouldConvertYardToFeet() {

        Length yard = new Length(1.0, LengthUnit.YARD);

        assertEquals(3.0,
                yard.convertTo(LengthUnit.FEET));
    }

    @Test
    void shouldConvertCmToInch() {

        Length cm = new Length(2.54, LengthUnit.CM);

        assertEquals(1.0,
                cm.convertTo(LengthUnit.INCH),
                0.01);
    }

    @Test
    void shouldReturnTrueForFeetAndInchEquality() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        assertEquals(feet, inch);
    }
}