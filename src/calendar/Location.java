package calendar;

/**
 * This class represents a location, which is an address with an associated name.
 * @author Markus Luethje
 */

public class Location {
    private String name;
    private Address address;

    public Location(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
