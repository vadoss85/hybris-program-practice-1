package javaCode.se.collectionsFramework;

public class VehicleComparable extends Vehicle implements Comparable<VehicleComparable> {
    public VehicleComparable(String model, String make, int price, boolean isFourWheels) {
        super(model, make, price, isFourWheels);
    }

    @Override
    public int compareTo(VehicleComparable o) {
        if (o.price == this.price) {
            return 0;
        }

        return o.price > this.price ? -1 : 1;
    }
}
