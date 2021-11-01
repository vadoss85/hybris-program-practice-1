package javaCode.se.collectionsFramework;

import java.util.Objects;

public class Vehicle {
    String model;
    String make;
    int price;
    boolean isFourWheels;

    public Vehicle(String model, String make, int price, boolean isFourWheels) {
        this.model = model;
        this.make = make;
        this.price = price;
        this.isFourWheels = isFourWheels;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFourWheels() {
        return isFourWheels;
    }

    public void setFourWheels(boolean fourWheels) {
        isFourWheels = fourWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", price=" + price +
                ", isFourWheels=" + isFourWheels +
                '}';
    }
}
