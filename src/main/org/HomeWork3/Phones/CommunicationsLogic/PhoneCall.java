package org.HomeWork3.Phones.CommunicationsLogic;

public class PhoneCall {
    private final int sender;
    private final int receiver;

    public PhoneCall(int sender, int receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getReceiver() {
        return receiver;
    }

    public int getSender() {
        return sender;
    }
}
