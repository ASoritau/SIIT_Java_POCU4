package org.HomeWork3.Phones.Devices.Manufacurers.Nokia;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.Devices.I_Phone;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public class Nokia7plus extends NokiaPhone implements I_Phone {

    public Nokia7plus() {
        super(Color.Black, Material.Aluminium,"7 plus", 90);
    }

    public Nokia7plus(Color color) {
        super(color, Material.Aluminium,"7 plus", 90);
    }

    public Nokia7plus(GenericTelephoneOperator operator) {
        super(Color.Black, Material.Aluminium,"7 plus", 90, operator);
    }

    public Nokia7plus(Color color, GenericTelephoneOperator operator) {
        super(color, Material.Aluminium,"7 plus", 90, operator);
    }
}
