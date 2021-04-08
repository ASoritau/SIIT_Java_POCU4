package org.HomeWork3.Phones.CommunicationsLogic;

public class Message {
    private final int senderNumber;

    private final int receiverNumber;

    private final String messageText;

    public Message(int senderNumber, int receiverNumber, String messageText) {
        if (messageText.length() > 500) {
            throw new IllegalArgumentException("The maximum message length is 500 characters!");
        }

        this.senderNumber = senderNumber;
        this.receiverNumber = receiverNumber;
        this.messageText = messageText;
    }

    public int getReceiverNumber() {
        return receiverNumber;
    }

    public int getSenderNumber() {
        return senderNumber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "senderNumber=" + senderNumber +
                ", receiverNumber=" + receiverNumber +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
