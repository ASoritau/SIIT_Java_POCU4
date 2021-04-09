package org.HomeWork3.Phones.CommunicationsLogic;

public class Contact {
    private String firstName;

    private String lastName;

    private int contactNumber;

    public Contact( int contactNumber, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return contactNumber + ", " + firstName + " " + lastName;
    }
}
