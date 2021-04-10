package org.HomeWork3.Phones.Devices.Manufacurers.Nokia;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.Devices.I_Phone;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public class Nokia2 extends NokiaPhone implements I_Phone {
    public Nokia2() {
        super(Color.Black, Material.Plastic,"2", 55);
    }

    public Nokia2(Color color) {
        super(color, Material.Plastic,"2", 55);
    }

    public Nokia2(GenericTelephoneOperator operator) {
        super(Color.Black, Material.Plastic,"2", 55, operator);
    }

    public Nokia2(Color color, GenericTelephoneOperator operator) {
        super(color, Material.Plastic,"2", 55, operator);
    }
}
