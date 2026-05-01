package com.realestate.models;

// 1. INHERITANCE: The 'extends' keyword means this class gets all the variables and methods from Property.
public class ResidentialProperty extends Property {
    
    // We add a variable that is unique only to residential properties.
    private int bedrooms;

    // 2. CONSTRUCTOR: I must collect all the data needed for the parent, plus the new bedrooms data.
    public ResidentialProperty(String id, String location, double price, int bedrooms) {
        // 'super' passes the id, location, and price UP to the parent Property class.
        super(id, location, price); 
        this.bedrooms = bedrooms;
    }

    // 3. POLYMORPHISM: I use @Override to write the specific rule for formatting a residential property.
    @Override
    public String toFileFormat() {
        // Notice we use the getters (getId(), getLocation()) because the variables are private in the parent class!
        return getId() + ",Residential," + getLocation() + "," + getPrice() + "," + bedrooms;
    }
}