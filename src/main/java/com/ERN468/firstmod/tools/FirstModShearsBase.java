package com.ERN468.firstmod.tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;

import java.util.List;

public class FirstModShearsBase extends ShearsItem {
    public float miningSpeedWool;
    public float miningSpeedOther;
    public static final DispenserBehavior DISPENSER_BEHAVIOR = new ShearsDispenserBehavior();

    public FirstModShearsBase(float woolMine, float otherMine, Settings settings) {
        super(settings);
        miningSpeedWool = woolMine;
        miningSpeedOther = otherMine;
        DispenserBlock.registerBehavior(this, DISPENSER_BEHAVIOR);
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (!state.isOf(Blocks.COBWEB) && !state.isIn(BlockTags.LEAVES)) {
            return state.isIn(BlockTags.WOOL) ? miningSpeedWool /* default is 5.0f */: super.getMiningSpeedMultiplier(stack, state);
        } else {
            return miningSpeedOther; //default is 15.0f
        }
    }
}
