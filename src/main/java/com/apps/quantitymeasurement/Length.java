package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public double convertTo(LengthUnit targetUnit) {

        double baseValue = this.toBaseUnit();

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Length add(Length other) {

        double totalBaseValue =
                this.toBaseUnit() + other.toBaseUnit();

        double convertedValue =
                this.unit.convertFromBaseUnit(totalBaseValue);

        return new Length(convertedValue, this.unit);
    }

    public Length add(Length other,
                      LengthUnit targetUnit) {

        double totalBaseValue =
                this.toBaseUnit() + other.toBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(totalBaseValue);

        return new Length(convertedValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return Double.compare(
                this.toBaseUnit(),
                other.toBaseUnit()
        ) == 0;
    }
}