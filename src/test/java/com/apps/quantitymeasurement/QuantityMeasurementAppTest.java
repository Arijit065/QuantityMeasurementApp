package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void shouldReturnTrueForEqualFeetValues() {

        QuantityMeasurementApp value1 =
                new QuantityMeasurementApp(5.0);

        QuantityMeasurementApp value2 =
                new QuantityMeasurementApp(5.0);

        assertEquals(value1, value2);
    }

    @Test
    void shouldReturnFalseForDifferentFeetValues() {

        QuantityMeasurementApp value1 =
                new QuantityMeasurementApp(5.0);

        QuantityMeasurementApp value2 =
                new QuantityMeasurementApp(6.0);

        assertNotEquals(value1, value2);
    }

    @Test
    void shouldReturnFalseWhenComparedWithNull() {

        QuantityMeasurementApp value =
                new QuantityMeasurementApp(5.0);

        assertNotEquals(null, value);
    }

    @Test
    void shouldReturnTrueForSameReference() {

        QuantityMeasurementApp value =
                new QuantityMeasurementApp(5.0);

        assertEquals(value, value);
    }

    @Test
    void shouldReturnTrueForEqualInchValues() {

        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);

        assertEquals(inch1, inch2);
    }

    @Test
    void shouldReturnFalseForDifferentInchValues() {

        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(2.0);

        assertNotEquals(inch1, inch2);
    }

    @Test
    void shouldReturnFalseWhenInchesComparedWithNull() {

        Inches inch = new Inches(1.0);

        assertNotEquals(null, inch);
    }

    @Test
    void shouldReturnTrueForSameInchReference() {

        Inches inch = new Inches(1.0);

        assertEquals(inch, inch);
    }
}