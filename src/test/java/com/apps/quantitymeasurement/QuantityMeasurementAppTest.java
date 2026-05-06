@Test
void shouldSubtractLengthQuantities() {

    Quantity<LengthUnit> feet =
            new Quantity<>(10.0,
                    LengthUnit.FEET);

    Quantity<LengthUnit> inch =
            new Quantity<>(6.0,
                    LengthUnit.INCH);

    Quantity<LengthUnit> result =
            feet.subtract(inch);

    assertEquals(
            new Quantity<>(9.5,
                    LengthUnit.FEET),
            result
    );
}

@Test
void shouldSubtractWeightsInTargetUnit() {

    Quantity<WeightUnit> kg =
            new Quantity<>(5.0,
                    WeightUnit.KG);

    Quantity<WeightUnit> gram =
            new Quantity<>(1000.0,
                    WeightUnit.G);

    Quantity<WeightUnit> result =
            kg.subtract(
                    gram,
                    WeightUnit.G
            );

    assertEquals(
            new Quantity<>(4000.0,
                    WeightUnit.G),
            result
    );
}

@Test
void shouldSubtractVolumes() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(5.0,
                    VolumeUnit.LITRE);

    Quantity<VolumeUnit> milliLitre =
            new Quantity<>(2000.0,
                    VolumeUnit.MILLILITRE);

    Quantity<VolumeUnit> result =
            litre.subtract(milliLitre);

    assertEquals(
            new Quantity<>(3.0,
                    VolumeUnit.LITRE),
            result
    );
}

@Test
void shouldDivideWeights() {

    Quantity<WeightUnit> tenKg =
            new Quantity<>(10.0,
                    WeightUnit.KG);

    Quantity<WeightUnit> fiveKg =
            new Quantity<>(5.0,
                    WeightUnit.KG);

    assertEquals(
            2.0,
            tenKg.divide(fiveKg)
    );
}

@Test
void shouldDivideDifferentLengthUnits() {

    Quantity<LengthUnit> feet =
            new Quantity<>(24.0,
                    LengthUnit.INCH);

    Quantity<LengthUnit> inch =
            new Quantity<>(12.0,
                    LengthUnit.INCH);

    assertEquals(
            2.0,
            feet.divide(inch)
    );
}

@Test
void shouldThrowExceptionForDivisionByZero() {

    Quantity<WeightUnit> kg =
            new Quantity<>(10.0,
                    WeightUnit.KG);

    Quantity<WeightUnit> zero =
            new Quantity<>(0.0,
                    WeightUnit.KG);

    assertThrows(
            ArithmeticException.class,
            () -> kg.divide(zero)
    );
}