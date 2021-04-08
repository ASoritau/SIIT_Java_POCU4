package org.HomeWork3.Phones.Devices;

import org.HomeWork3.Phones.CommunicationsLogic.Contact;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import java.util.List;

public interface I_Phone {
    void changeOwnNumber(int number);

    int getOwnNumber();

    List<Contact> getContacts();

    void receiveMessage(Message message);

    void sendMessage(int receiverNumber, String message);

    void sendMessage(Contact contact, String message);

    List<Message> getConversationWithNumber(int number);
}
