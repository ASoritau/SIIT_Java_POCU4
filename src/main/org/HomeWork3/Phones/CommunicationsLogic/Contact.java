package org.HomeWork3.Phones.CommunicationsLogic;

public class Contact {
    private String contactName;

    private int contactNumber;

    public Contact(String contactName, int contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getContactName() {
        return contactName;
    }
}
