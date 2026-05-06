package com.apps.quantitymeasurement;

public class Inches {

    private double inches;

    public Inches(double inches) {
        this.inches = inches;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Inches other = (Inches) obj;

        return Double.compare(other.inches, inches) == 0;
    }
}