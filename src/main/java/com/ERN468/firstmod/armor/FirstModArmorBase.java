package com.ERN468.firstmod.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class FirstModArmorBase extends ArmorItem {
    public FirstModArmorBase(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings());
    }
}
