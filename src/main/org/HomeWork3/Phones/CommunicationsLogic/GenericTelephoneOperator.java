package org.HomeWork3.Phones.CommunicationsLogic;

import org.HomeWork3.Phones.Devices.I_Phone;

import java.util.ArrayList;
import java.util.List;

public class GenericTelephoneOperator {
    private List<I_Phone> clients = new ArrayList<>();
    private int nextNumber = 0;

    public int generatePhoneNumber() {
        int number = nextNumber;
        nextNumber++;
        return number;
    }

    public void addClient(I_Phone clientPhone) {
        clientPhone.changeOwnNumber(generatePhoneNumber(), this);
        clients.add(clientPhone);
    }

    public void sendMessage(Message message) throws IllegalArgumentException {
        I_Phone receiver;

        try {
            receiver = getClientByNumber(message.getReceiverNumber());
            receiver.receiveMessage(message);
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void sendPhoneCall(PhoneCall call) throws IllegalArgumentException {
        I_Phone receiver;

        try {
            receiver = getClientByNumber(call.getReceiver());
            receiver.receivePhoneCall(call);
        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private I_Phone getClientByNumber(int number) throws IllegalArgumentException {
        for (I_Phone client : clients) {
            if (client.getOwnNumber() == number) {
                return client;
            }
        }

        throw new IllegalArgumentException("The number: \"" + number + "\" is not registered to this Telephone Operator!" );
    }
}
