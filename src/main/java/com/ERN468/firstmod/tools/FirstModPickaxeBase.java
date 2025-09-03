package com.ERN468.firstmod.tools;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class FirstModPickaxeBase extends PickaxeItem {
    public FirstModPickaxeBase(ToolMaterial material) {
        super(material, 1, -2.8f, new Item.Settings());
    }
}