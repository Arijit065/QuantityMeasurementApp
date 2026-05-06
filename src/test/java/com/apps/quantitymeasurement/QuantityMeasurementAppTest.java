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
    void shouldAddFeetAndInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        Length result = feet.add(inch);

        assertEquals(
                new Length(2.0, LengthUnit.FEET),
                result
        );
    }

    @Test
    void shouldAddYardAndFeet() {

        Length yard = new Length(1.0, LengthUnit.YARD);
        Length feet = new Length(3.0, LengthUnit.FEET);

        Length result = yard.add(feet);

        assertEquals(
                new Length(2.0, LengthUnit.YARD),
                result
        );
    }

    @Test
    void shouldAddCmAndInch() {

        Length cm = new Length(2.54, LengthUnit.CM);
        Length inch = new Length(1.0, LengthUnit.INCH);

        Length result = cm.add(inch);

        assertEquals(
                new Length(5.08, LengthUnit.CM),
                result
        );
    }

    @Test
    void shouldReturnTrueForFeetAndInchEquality() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCH);

        assertEquals(feet, inch);
    }
}