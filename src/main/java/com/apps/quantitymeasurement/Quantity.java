public class Quantity<U extends IMeasurable> {

    private enum ArithmeticOperation {
        ADD,
        SUBTRACT,
        DIVIDE
    }

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double performArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Quantity cannot be null");

        if (this.unit.getClass() != other.unit.getClass())
            throw new IllegalArgumentException(
                    "Different quantity categories");

        if (!Double.isFinite(this.value)
                || !Double.isFinite(other.value))
            throw new IllegalArgumentException(
                    "Invalid numeric value");

        double thisBaseValue =
                this.toBaseUnit();

        double otherBaseValue =
                other.toBaseUnit();

        return switch (operation) {

            case ADD ->
                    thisBaseValue + otherBaseValue;

            case SUBTRACT ->
                    thisBaseValue - otherBaseValue;

            case DIVIDE -> {

                if (otherBaseValue == 0)
                    throw new ArithmeticException(
                            "Cannot divide by zero");

                yield thisBaseValue / otherBaseValue;
            }
        };
    }

    public Quantity<U> add(Quantity<U> other) {

        double baseResult =
                performArithmetic(
                        other,
                        ArithmeticOperation.ADD
                );

        double convertedValue =
                this.unit.convertFromBaseUnit(
                        baseResult);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(
                convertedValue,
                this.unit
        );
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        double baseResult =
                performArithmetic(
                        other,
                        ArithmeticOperation.ADD
                );

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseResult);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    public Quantity<U> subtract(
            Quantity<U> other) {

        double baseResult =
                performArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT
                );

        double convertedValue =
                this.unit.convertFromBaseUnit(
                        baseResult);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(
                convertedValue,
                this.unit
        );
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        double baseResult =
                performArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT
                );

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseResult);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    public double divide(
            Quantity<U> other) {

        double result =
                performArithmetic(
                        other,
                        ArithmeticOperation.DIVIDE
                );

        return Math.round(result * 100.0) / 100.0;
    }

    public Quantity<U> convertTo(U targetUnit) {

        double baseValue = this.toBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        return Math.abs(
                this.toBaseUnit()
                        - other.toBaseUnit()
        ) < 0.01;
    }
}