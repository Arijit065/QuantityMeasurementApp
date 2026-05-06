package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    private double feet;

    public QuantityMeasurementApp(double feet) {
        this.feet = feet;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityMeasurementApp other =
                (QuantityMeasurementApp) obj;

        return Double.compare(other.feet, feet) == 0;
    }
}