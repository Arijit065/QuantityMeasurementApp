@Test
void shouldReturnTrueForLitreAndMillilitreEquality() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> milliLitre =
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

    assertEquals(litre, milliLitre);
}

@Test
void shouldConvertLitreToMillilitre() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> result =
            litre.convertTo(VolumeUnit.MILLILITRE);

    assertEquals(
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE),
            result
    );
}

@Test
void shouldConvertGallonToLitre() {

    Quantity<VolumeUnit> gallon =
            new Quantity<>(1.0, VolumeUnit.GALLON);

    Quantity<VolumeUnit> result =
            gallon.convertTo(VolumeUnit.LITRE);

    assertEquals(
            new Quantity<>(3.79,
                    VolumeUnit.LITRE),
            result
    );
}

@Test
void shouldAddLitreAndMillilitre() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> milliLitre =
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE);

    Quantity<VolumeUnit> result =
            litre.add(milliLitre);

    assertEquals(
            new Quantity<>(2.0,
                    VolumeUnit.LITRE),
            result
    );
}

@Test
void shouldAddVolumesInTargetUnit() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> milliLitre =
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE);

    Quantity<VolumeUnit> result =
            litre.add(
                    milliLitre,
                    VolumeUnit.MILLILITRE
            );

    assertEquals(
            new Quantity<>(2000.0,
                    VolumeUnit.MILLILITRE),
            result
    );
}

@Test
void shouldReturnFalseForDifferentCategories() {

    Quantity<LengthUnit> length =
            new Quantity<>(1.0,
                    LengthUnit.FEET);

    Quantity<VolumeUnit> volume =
            new Quantity<>(1.0,
                    VolumeUnit.LITRE);

    assertNotEquals(length, volume);
}