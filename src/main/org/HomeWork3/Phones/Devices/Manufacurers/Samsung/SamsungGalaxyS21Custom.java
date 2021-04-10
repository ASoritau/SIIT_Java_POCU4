package org.HomeWork3.Phones.Devices.Manufacurers.Samsung;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public class SamsungGalaxyS21Custom extends SamsungPhone{
    public SamsungGalaxyS21Custom() {
        super(Color.Gold, Material.Glass,"Galaxy S21 Custom", 95);
    }

    public SamsungGalaxyS21Custom(Color color, Material material) {
        super(color, material,"Galaxy S21 Custom", 95);
    }

    public SamsungGalaxyS21Custom(GenericTelephoneOperator operator) {
        super(Color.Gold, Material.Glass,"Galaxy S21 Custom", 95, operator);
    }

    public SamsungGalaxyS21Custom(Color color, Material material, GenericTelephoneOperator operator) {
        super(color, material,"Galaxy S21 Custom", 95, operator);
    }

}
