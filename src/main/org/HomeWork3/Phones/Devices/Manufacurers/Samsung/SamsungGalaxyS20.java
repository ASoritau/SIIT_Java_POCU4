package org.HomeWork3.Phones.Devices.Manufacurers.Samsung;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public class SamsungGalaxyS20 extends SamsungPhone{
    public SamsungGalaxyS20() {
        super(Color.Grey, Material.Glass,"Galaxy S20", 70);
    }

    public SamsungGalaxyS20(Color color) {
        super(color, Material.Glass,"Galaxy S20", 70);
    }

    public SamsungGalaxyS20(GenericTelephoneOperator operator) {
        super(Color.Grey, Material.Glass,"Galaxy S20", 70, operator);
    }

    public SamsungGalaxyS20(Color color, GenericTelephoneOperator operator) {
        super(color, Material.Glass,"Galaxy S20", 70, operator);
    }
}
