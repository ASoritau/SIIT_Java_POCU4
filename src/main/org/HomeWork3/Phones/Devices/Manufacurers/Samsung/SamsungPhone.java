package org.HomeWork3.Phones.Devices.Manufacurers.Samsung;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.Devices.GenericPhone;
import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public abstract class SamsungPhone extends GenericPhone {
    public SamsungPhone(Color color, Material material, String model, int batteryCapacity) {
        super(color, material, "Samsung", model, batteryCapacity);
    }

    public SamsungPhone(Color color, Material material, String model, int batteryCapacity, GenericTelephoneOperator operator) {
        super(color, material,"Nokia", model, batteryCapacity, operator);
    }
}
