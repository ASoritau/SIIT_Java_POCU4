package org.HomeWork3.Phones.Devices.Manufacurers.Nokia;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.Devices.GenericPhone;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public abstract class NokiaPhone extends GenericPhone {
    public NokiaPhone(Color color, Material material, String model, int batteryCapacity) {
        super(color, material,"Nokia", model, batteryCapacity);
    }

    public NokiaPhone(Color color, Material material, String model, int batteryCapacity, GenericTelephoneOperator operator) {
        super(color, material,"Nokia", model, batteryCapacity, operator);
    }
}