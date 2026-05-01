// 1. Base Class (Property.java)
package com.realestate.models;

public abstract class Property {
    private String id;
    private String location;
    private double price;

    public Property(String id, String location, double price) {
        this.id = id;
        this.location = location;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public String getId() { return id; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }

    // Polymorphic method to be overridden
    public abstract String toFileFormat();
}