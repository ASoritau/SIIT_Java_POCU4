package org.HomeWork3;

import org.HomeWork3.Phones.CommunicationsLogic.Contact;
import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import org.HomeWork3.Phones.Devices.I_Phone;
import org.HomeWork3.Phones.Devices.Manufacurers.Nokia.Nokia7plus;
import org.HomeWork3.Phones.Devices.Manufacurers.Samsung.SamsungGalaxyS20;
import org.HomeWork3.Phones.Devices.Manufacurers.Samsung.SamsungGalaxyS21Custom;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

import java.util.List;

/**
 * HomeWork 3
 *
 */
public class App_HW3
{
    public static void main( String[] args )
    {
        // Resource creation
        GenericTelephoneOperator defaultOperator = new GenericTelephoneOperator();

        I_Phone phone1 = new Nokia7plus(defaultOperator);
        I_Phone phone2 = new SamsungGalaxyS21Custom(Color.Blue, Material.Aluminium, defaultOperator);
        I_Phone phone3 = new SamsungGalaxyS20(Color.Green);

        defaultOperator.addClient(phone3);
        Contact contact = new Contact(phone2.getOwnNumber(), "Alex", "Avram");
        phone3.addContact(contact);

        // Communications
        // Messages (Phone1 to Phone2)
        phone1.sendMessage(phone2.getOwnNumber(), "Salut! Ajung in 5 min.");
        phone1.sendMessage(phone2.getOwnNumber(), "Ajung in 2 min.");
        phone1.sendMessage(phone2.getOwnNumber(), "Am ajuns.");

        // Calls (Phone1 to Phone2, and vice-versa)
        phone1.callNumber(phone2.getOwnNumber());
        phone2.callNumber(phone1.getOwnNumber());
        phone2.addContact(phone1.getOwnNumber(), "Ion", "Ionescu");

        // Messages (Phone2 and Phone3)
        phone3.callContact(contact);
        phone2.sendMessage(phone3.getOwnNumber(), "Imi cer scuze, nu pot raspunde. Revin cu un telefon.");
        phone3.sendMessage(contact, "OK, nici o problema.");
        phone2.callNumber(phone3.getOwnNumber());
        phone3.sendMessage(contact, "Imi cer scuze, tocmai am intrat intr-o sedinta. Sun eu cand pot.");

        // Invalid phone call and message (validate the program does not crash)
        phone1.sendMessage(142, "Message");
        phone3.callNumber(15);
        phone2.callNumber(3);

        // Printing results
        System.out.println("\n Phone1 message thread with Phone2");
        List<Message> conversation = phone1.getConversationWithNumber(phone2.getOwnNumber());
        for (Message message : conversation) {
            System.out.println(message.toString());
        }

        System.out.println("\n Phone2 call log (with Phone1 and Phone3)");
        List<String> phone2CallLog = phone2.getCallLog();
        for (String call : phone2CallLog) {
            System.out.println(call);
        }

        System.out.println("\n Phone2 message thread with Phone3");
        List<Message> Lphone2Messages = phone2.getConversationWithNumber(phone3.getOwnNumber());
        for (Message message : Lphone2Messages) {
            System.out.println(message.toString());
        }
    }
}
