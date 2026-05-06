@Test
void shouldReturnTrueForFeetAndInchEquality() {

    Quantity<LengthUnit> feet =
            new Quantity<>(1.0, LengthUnit.FEET);

    Quantity<LengthUnit> inch =
            new Quantity<>(12.0, LengthUnit.INCH);

    assertEquals(feet, inch);
}

@Test
void shouldConvertKgToGram() {

    Quantity<WeightUnit> kg =
            new Quantity<>(1.0, WeightUnit.KG);

    Quantity<WeightUnit> result =
            kg.convertTo(WeightUnit.G);

    assertEquals(
            new Quantity<>(1000.0, WeightUnit.G),
            result
    );
}

@Test
void shouldAddWeights() {

    Quantity<WeightUnit> kg =
            new Quantity<>(1.0, WeightUnit.KG);

    Quantity<WeightUnit> gram =
            new Quantity<>(1000.0, WeightUnit.G);

    Quantity<WeightUnit> result =
            kg.add(gram);

    assertEquals(
            new Quantity<>(2.0, WeightUnit.KG),
            result
    );
}