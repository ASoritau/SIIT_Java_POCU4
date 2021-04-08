package java.org.hw3.Phones.CommunicationsLogic;

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

    int getReceiverNumber() {
        return receiverNumber;
    }

    int getSenderNumber() {
        return senderNumber;
    }
}
