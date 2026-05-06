public Quantity<U> subtract(Quantity<U> other) {

    double baseResult =
            this.toBaseUnit() - other.toBaseUnit();

    double convertedValue =
            this.unit.convertFromBaseUnit(baseResult);

    convertedValue =
            Math.round(convertedValue * 100.0) / 100.0;

    return new Quantity<>(convertedValue, this.unit);
}

public Quantity<U> subtract(
        Quantity<U> other,
        U targetUnit) {

    double baseResult =
            this.toBaseUnit() - other.toBaseUnit();

    double convertedValue =
            targetUnit.convertFromBaseUnit(baseResult);

    convertedValue =
            Math.round(convertedValue * 100.0) / 100.0;

    return new Quantity<>(convertedValue, targetUnit);
}

public double divide(Quantity<U> other) {

    if (other.toBaseUnit() == 0)
        throw new ArithmeticException(
                "Cannot divide by zero");

    double result =
            this.toBaseUnit() / other.toBaseUnit();

    return Math.round(result * 100.0) / 100.0;
}