package com.apps.quantitymeasurement;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public double convertTo(WeightUnit targetUnit) {

        double baseValue = this.toBaseUnit();

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Weight add(Weight other) {

        double totalBaseValue =
                this.toBaseUnit() + other.toBaseUnit();

        double convertedValue =
                this.unit.convertFromBaseUnit(totalBaseValue);

        return new Weight(convertedValue, this.unit);
    }

    public Weight add(Weight other,
                      WeightUnit targetUnit) {

        double totalBaseValue =
                this.toBaseUnit() + other.toBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(totalBaseValue);

        return new Weight(convertedValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Weight other = (Weight) obj;

        return Double.compare(
                this.toBaseUnit(),
                other.toBaseUnit()
        ) == 0;
    }
}