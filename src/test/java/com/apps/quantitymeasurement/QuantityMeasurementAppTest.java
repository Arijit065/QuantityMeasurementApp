@Test
void shouldReturnTrueForKgAndGramEquality() {

    Weight kg = new Weight(1.0, WeightUnit.KG);
    Weight gram = new Weight(1000.0, WeightUnit.G);

    assertEquals(kg, gram);
}

@Test
void shouldConvertKgToGram() {

    Weight kg = new Weight(1.0, WeightUnit.KG);

    assertEquals(
            1000.0,
            kg.convertTo(WeightUnit.G)
    );
}

@Test
void shouldConvertPoundToKg() {

    Weight pound = new Weight(1.0, WeightUnit.LB);

    assertEquals(
            0.453592,
            pound.convertTo(WeightUnit.KG),
            0.0001
    );
}

@Test
void shouldAddKgAndGram() {

    Weight kg = new Weight(1.0, WeightUnit.KG);
    Weight gram = new Weight(1000.0, WeightUnit.G);

    Weight result = kg.add(gram);

    assertEquals(
            new Weight(2.0, WeightUnit.KG),
            result
    );
}

@Test
void shouldAddWeightsInTargetUnit() {

    Weight kg = new Weight(1.0, WeightUnit.KG);
    Weight gram = new Weight(1000.0, WeightUnit.G);

    Weight result =
            kg.add(gram, WeightUnit.G);

    assertEquals(
            new Weight(2000.0, WeightUnit.G),
            result
    );
}