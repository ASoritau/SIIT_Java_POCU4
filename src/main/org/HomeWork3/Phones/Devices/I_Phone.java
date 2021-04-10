package org.HomeWork3.Phones.Devices;

import org.HomeWork3.Phones.CommunicationsLogic.Contact;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import org.HomeWork3.Phones.CommunicationsLogic.PhoneCall;

import java.util.List;

public interface I_Phone {
    // ----------Device Logic----------
    void changeOwnNumber(int number);

    int getOwnNumber();

    int getRemainingBattery();

    // ----------Contacts----------
    List<Contact> getContacts();

    void addContact(int number, String firstName, String lastName);

    // ----------Messaging----------
    void receiveMessage(Message message);

    void sendMessage(int receiverNumber, String message);

    void sendMessage(Contact contact, String message);

    List<Message> getConversationWithNumber(int number);

    // ----------Calls----------
    void callNumber(int number);

    void callContact(Contact contact);

    void receivePhoneCall(PhoneCall call);

    List<String> getCallLog();
}
