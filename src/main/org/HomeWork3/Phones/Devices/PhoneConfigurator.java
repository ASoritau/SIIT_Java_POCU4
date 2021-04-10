package org.HomeWork3.Phones.Devices;

import org.HomeWork3.Phones.PhysicalProperties.Color;
import org.HomeWork3.Phones.PhysicalProperties.Material;

public abstract class PhoneConfigurator {
    protected Color bodyColor;

    protected final Material bodyMaterial;

    protected final String phoneBrand;

    protected final String phoneModel;

    public PhoneConfigurator(Color color, Material material, String brand, String model) {
        bodyColor = color;
        bodyMaterial = material;
        phoneBrand = brand;
        phoneModel = model;
    }

    public void changeColor(Color newColor) {
        bodyColor = newColor;
    }

    public Color getBodyColor() {
        return bodyColor;
    }

    public Material getBodyMaterial() {
        return bodyMaterial;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }
}
