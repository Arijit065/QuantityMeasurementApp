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