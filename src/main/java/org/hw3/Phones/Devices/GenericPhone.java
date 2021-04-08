package java.org.hw3.Phones.Devices;

import java.org.hw3.Phones.CommunicationsLogic.Contact;
import java.org.hw3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import java.org.hw3.Phones.CommunicationsLogic.Message;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericPhone implements I_Phone{
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

    public GenericPhone(GenericTelephoneOperator operator) {
        this.operator = operator;
        this.ownNumber = operator.generatePhoneNumber();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void sendMessage(int receiverNumber, String messageText) {
        Message message = new Message(ownNumber, receiverNumber, messageText);

        operator.sendMessage(message);
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
