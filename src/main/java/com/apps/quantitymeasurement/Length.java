package com.apps.quantitymeasurement;

public class Length {
    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length that = (Length) o;
        return Double.compare(this.unit.convertToBaseUnit(this.value),
                that.unit.convertToBaseUnit(that.value)) == 0;
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double targetValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Length(targetValue, targetUnit);
    }

    public Length add(Length that, LengthUnit targetUnit) {
        if (that == null || targetUnit == null) {
            throw new IllegalArgumentException("Operand and target unit cannot be null");
        }
        double totalBase = this.unit.convertToBaseUnit(this.value) +
                that.unit.convertToBaseUnit(that.value);
        return new Length(targetUnit.convertFromBaseUnit(totalBase), targetUnit);
    }

    public Length add(Length that) {
        return this.add(that, this.unit);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, unit);
    }
}