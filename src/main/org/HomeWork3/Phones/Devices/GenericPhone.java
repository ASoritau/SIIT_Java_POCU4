package org.HomeWork3.Phones.Devices;

import org.HomeWork3.Phones.CommunicationsLogic.Contact;
import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import org.HomeWork3.Phones.CommunicationsLogic.PhoneCall;

import java.util.ArrayList;
import java.util.List;

public class GenericPhone implements I_Phone{
    private List<Contact> contacts = new ArrayList<>();

    private List<Message> messages = new ArrayList<>();

    private List<PhoneCall> callLog = new ArrayList<>();

    private int ownNumber;

    private String phoneBrand;

    private String phoneModel;

    GenericTelephoneOperator operator;

    public GenericPhone(String brand, String model) {
        this.phoneBrand = brand;
        this.phoneModel = model;
    }

    public GenericPhone(String brand, String model, GenericTelephoneOperator operator) {
        this.phoneBrand = brand;
        this.phoneModel = model;
        this.operator = operator;
        operator.addClient(this);
    }

    // ----------Device Logic----------
    public void changeOwnNumber(int number) {
        ownNumber = number;
    }

    public int getOwnNumber() {
        return ownNumber;
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
