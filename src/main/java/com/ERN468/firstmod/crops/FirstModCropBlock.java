package com.ERN468.firstmod.crops;

import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

public class FirstModCropBlock extends CropBlock {
    public Item seedItem;

    public FirstModCropBlock(Item seed, Settings settings) {
        super(settings);
        seedItem = seed;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return seedItem;
    }
}
