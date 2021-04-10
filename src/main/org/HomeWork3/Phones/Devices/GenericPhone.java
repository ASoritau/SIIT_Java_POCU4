package org.HomeWork3.Phones.Devices;

import org.HomeWork3.Phones.CommunicationsLogic.Contact;
import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import org.HomeWork3.Phones.CommunicationsLogic.PhoneCall;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GenericPhone extends PhoneConfigurator implements I_Phone{
    protected List<Contact> contacts = new ArrayList<>();

    protected List<Message> messages = new ArrayList<>();

    protected List<PhoneCall> callLog = new ArrayList<>();

    protected int ownNumber;

    protected GenericTelephoneOperator operator;

    protected final int batteryCapacity;

    protected int remainingBattery;

    protected final String IMEI;

    public GenericPhone(Color color, Material material, String brand, String model, int batteryCapacity) {
        super(color, material, brand, model);
        this.batteryCapacity = batteryCapacity;
        IMEI = generateIMEI();
    }

    public GenericPhone(Color color, Material material, String brand, String model, int batteryCapacity, GenericTelephoneOperator operator) {
        super(color, material, brand, model);
        this.operator = operator;
        IMEI = generateIMEI();
        this.batteryCapacity = batteryCapacity;
        operator.addClient(this);
    }

    // ----------Device Logic----------
    public void changeOwnNumber(int number) {
        ownNumber = number;
    }

    public int getOwnNumber() {
        return ownNumber;
    }

    public int getRemainingBattery() {
        return remainingBattery;
    }

    public void chargePhone(int chargeTime) {
        updateRemainingBattery(chargeTime);
    }

    protected void updateRemainingBattery(int timeToAdd) {
        remainingBattery = remainingBattery + timeToAdd;
    }

    private String generateIMEI() {
        int length = 15;
        StringBuilder imeiBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = new Random().nextInt(10);
            imeiBuilder.append(i);
        }

        return imeiBuilder.toString();
    }

    // ----------Contacts----------
    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContactByNumber(int number) {
        for (Contact contact : contacts) {
            if (contact.getContactNumber() == number) {
                return contact;
            }
        }

        return null;
    }

    public void addContact(int number, String firstName, String lastName) {
        Contact contact = new Contact(number, firstName, lastName);

        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    // ----------Messaging----------
    public void sendMessage(Contact contact, String message) {
        sendMessage(contact.getContactNumber(), message);
    }

    public void sendMessage(int receiverNumber, String messageText) {
        Message message = new Message(ownNumber, receiverNumber, messageText);

        try {
            operator.sendMessage(message);
            messages.add(message);
            updateRemainingBattery(-1);
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<Message> getConversationWithNumber(int number) {
        List<Message> conversation = new ArrayList<>();

        for (Message message : messages) {
            if (message.getReceiverNumber() == number || message.getSenderNumber() == number) {
                conversation.add(message);
            }
        }

        return conversation;
    }

    public void receiveMessage(Message message) {
        messages.add(message);
    }

    // ----------Calls----------
    public void callNumber(int number) {
        PhoneCall call = new PhoneCall(ownNumber, number);

        try {
            operator.sendPhoneCall(call);
            callLog.add(call);
            updateRemainingBattery(-2);
        }
        catch (Exception exception) {

        }
    }

    public void callContact(Contact contact) {
        callNumber(contact.getContactNumber());
    }

    public void receivePhoneCall(PhoneCall call) {
        callLog.add(call);
    }

    public List<String> getCallLog() {
        List<String> detailedCallLog = new ArrayList<>();

        for (PhoneCall call : callLog) {
            int sender = call.getSender();
            int receiver = call.getReceiver();
            StringBuilder callEntry = new StringBuilder();
            Contact contact;

            if (sender == ownNumber) {
                contact = getContactByNumber(call.getReceiver());
                if (contact != null) {
                    callEntry.append(contact.toString());
                }
                else {
                    callEntry.append(receiver);
                }
            }

            else {
                contact = getContactByNumber(call.getSender());
                if (contact != null) {
                    callEntry.append(contact.toString());
                }
                else {
                    callEntry.append(sender);
                }
            }

            detailedCallLog.add(callEntry.toString());
        }

        return detailedCallLog;
    }
}
