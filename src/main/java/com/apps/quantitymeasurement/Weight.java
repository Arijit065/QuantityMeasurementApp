package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {
    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Category Type Safety: Ensures Weight can only be compared to Weight
        if (o == null || getClass() != o.getClass()) return false;
        Weight that = (Weight) o;
        return Double.compare(this.unit.convertToBaseUnit(this.value),
                that.unit.convertToBaseUnit(that.value)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.convertToBaseUnit(value));
    }

    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double targetValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Weight(targetValue, targetUnit);
    }

    public Weight add(Weight that, WeightUnit targetUnit) {
        if (that == null || targetUnit == null) {
            throw new IllegalArgumentException("Operand and target unit cannot be null");
        }
        double totalBase = this.unit.convertToBaseUnit(this.value) +
                that.unit.convertToBaseUnit(that.value);
        return new Weight(targetUnit.convertFromBaseUnit(totalBase), targetUnit);
    }

    public Weight add(Weight that) {
        return this.add(that, this.unit);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, unit);
    }
}