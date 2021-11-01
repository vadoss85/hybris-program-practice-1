package javaCode.se.collectionsFramework;

import java.util.Objects;

class VehicleOverrideHashCode extends Vehicle {
    public VehicleOverrideHashCode(String model, String make, int price, boolean isFourWheels) {
        super(model, make, price, isFourWheels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return price == vehicle.price && isFourWheels == vehicle.isFourWheels && Objects.equals(model, vehicle.model) && Objects.equals(make, vehicle.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, make, price, isFourWheels);
    }
}
