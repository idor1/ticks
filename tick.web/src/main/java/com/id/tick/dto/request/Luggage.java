package com.id.tick.dto.request;

/**
 * Created on 31.07.2015.
 */
public class Luggage {
    private byte equipment;
    private byte animal;
    private byte carryon;

    public byte getEquipment() {
        return equipment;
    }

    public void setEquipment(byte equipment) {
        this.equipment = equipment;
    }

    public byte getAnimal() {
        return animal;
    }

    public void setAnimal(byte animal) {
        this.animal = animal;
    }

    public byte getCarryon() {
        return carryon;
    }

    public void setCarryon(byte carryon) {
        this.carryon = carryon;
    }
}
