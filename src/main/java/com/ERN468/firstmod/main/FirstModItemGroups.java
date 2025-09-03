package com.ERN468.firstmod.main;

import com.ERN468.firstmod.FirstMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class FirstModItemGroups {
    public static void registerItemGroups() {
        final ItemGroup GENERAL = FabricItemGroupBuilder.create(new Identifier(FirstMod.MOD_ID, "general")).icon(() -> new ItemStack(FirstModBlocks.RUBY_BLOCK)).appendItems(stacks -> {
            stacks.add(new ItemStack(FirstModItems.RUBY));
            stacks.add(new ItemStack(FirstModBlocks.RUBY_BLOCK));
            stacks.add(new ItemStack(FirstModBlocks.RUBY_ORE));
            stacks.add(new ItemStack(FirstModItems.RUBY_SWORD));
            stacks.add(new ItemStack(FirstModItems.RUBY_BOW));
            stacks.add(new ItemStack(FirstModItems.RUBY_SHOVEL));
            stacks.add(new ItemStack(FirstModItems.RUBY_PICKAXE));
            stacks.add(new ItemStack(FirstModItems.RUBY_AXE));
            stacks.add(new ItemStack(FirstModItems.RUBY_HOE));
            stacks.add(new ItemStack(FirstModItems.RUBY_MULTITOOL));
            stacks.add(new ItemStack(FirstModItems.RUBY_SHEARS));
            stacks.add(new ItemStack(FirstModItems.RUBY_HELMET));
            stacks.add(new ItemStack(FirstModItems.RUBY_CHESTPLATE));
            stacks.add(new ItemStack(FirstModItems.RUBY_LEGGINGS));
            stacks.add(new ItemStack(FirstModItems.RUBY_BOOTS));
            stacks.add(new ItemStack(FirstModItems.RUBY_HORSE_ARMOR));
            stacks.add(new ItemStack(FirstModItems.RUBY_SEEDS));
            stacks.add(new ItemStack(FirstModItems.CHEESE_WHEEL));
            stacks.add(new ItemStack(FirstModItems.CHEESECAKE));
        }).build();
    }
}
