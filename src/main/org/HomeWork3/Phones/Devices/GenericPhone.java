package org.HomeWork3.Phones.Devices;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.CommunicationsLogic.Contact;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import java.util.ArrayList;
import java.util.List;

public class GenericPhone implements I_Phone{
    private List<Contact> contacts = new ArrayList<>();

    private List<Message> messages = new ArrayList<>();

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
        this.ownNumber = operator.generatePhoneNumber();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void sendMessage(Contact contact, String message) {
        sendMessage(contact.getContactNumber(), message);
    }

    public void sendMessage(int receiverNumber, String messageText) {
        Message message = new Message(ownNumber, receiverNumber, messageText);

        try {
            operator.sendMessage(message);
            messages.add(message);
        }
        catch (Exception exception) {
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

    public void changeOwnNumber(int number) {
        ownNumber = number;
    }

    public int getOwnNumber() {
        return ownNumber;
    }
}
