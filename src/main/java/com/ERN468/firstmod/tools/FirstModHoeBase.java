package com.ERN468.firstmod.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class FirstModHoeBase extends HoeItem {
    public FirstModHoeBase(ToolMaterial material) {
        super(material, -5, 1.0f, new Settings());
    }
}
