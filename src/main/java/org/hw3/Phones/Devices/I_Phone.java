package java.org.hw3.Phones.Devices;

import java.org.hw3.Phones.CommunicationsLogic.Message;

public interface I_Phone {
    void changeOwnNumber(int number);

    int getOwnNumber();

    void receiveMessage(Message message);
}
