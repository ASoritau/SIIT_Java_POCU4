package org.HomeWork3;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import org.HomeWork3.Phones.Devices.GenericPhone;

import java.util.List;

/**
 * HomeWork 3
 *
 */
public class App_HW3
{
    public static void main( String[] args )
    {
        GenericTelephoneOperator defaultOperator = new GenericTelephoneOperator();

        GenericPhone phone1 = new GenericPhone("Nokia", "7 plus", defaultOperator);
        GenericPhone phone2 = new GenericPhone("Samsung", "Galaxy S10", defaultOperator);

        defaultOperator.addClient(phone1);
        defaultOperator.addClient(phone2);

        phone1.sendMessage(phone2.getOwnNumber(), "Salut! Ajung in 5 min.");
        phone1.sendMessage(phone2.getOwnNumber(), "Ajung in 2 min.");
        phone1.sendMessage(phone2.getOwnNumber(), "Am ajuns.");

        List<Message> conversation = phone1.getConversationWithNumber(phone2.getOwnNumber());
        for (Message message : conversation) {
            System.out.println(message.toString());
        }
    }
}
