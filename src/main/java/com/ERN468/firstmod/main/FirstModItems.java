package com.ERN468.firstmod.main;

import com.ERN468.firstmod.FirstMod;
import com.ERN468.firstmod.armor.FirstModArmorBase;
import com.ERN468.firstmod.armor.FirstModArmorMaterialRuby;
import com.ERN468.firstmod.tools.*;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FirstModItems {

    //Items
    public static final Item RUBY = new Item(new Item.Settings());
    public static final Item CHEESE_WHEEL = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(10).saturationModifier(16.0f).build()));

    //Tools
    public static final ToolMaterial RUBY_TOOL_MATERIAL = new FirstModToolMaterialRuby();
    public static final Item RUBY_PICKAXE = new FirstModPickaxeBase(RUBY_TOOL_MATERIAL);
    public static final Item RUBY_AXE = new FirstModAxeBase(RUBY_TOOL_MATERIAL);
    public static final Item RUBY_SHOVEL = new FirstModShovelBase(RUBY_TOOL_MATERIAL);
    public static final Item RUBY_HOE = new FirstModHoeBase(RUBY_TOOL_MATERIAL);
    public static final Item RUBY_SWORD = new FirstModSwordBase(RUBY_TOOL_MATERIAL);
    public static final Item RUBY_BOW = new FirstModBowBase(2.0D, new Item.Settings().maxDamage(2500)); //add zoom when aiming
    public static final Item RUBY_SHEARS = new FirstModShearsBase(10.0f, 30.0f, new Item.Settings().maxDamage(2500)); //make shears play animation when shearing snow golem
    public static final Item RUBY_MULTITOOL = new FirstModMultitoolBase(RUBY_TOOL_MATERIAL, 5, -2.4f, new Item.Settings().maxDamage(15000));

    //Armor
    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new FirstModArmorMaterialRuby();
    public static final Item RUBY_HELMET = new FirstModArmorBase(RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD);
    public static final Item RUBY_CHESTPLATE = new FirstModArmorBase(RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST);
    public static final Item RUBY_LEGGINGS = new FirstModArmorBase(RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS);
    public static final Item RUBY_BOOTS = new FirstModArmorBase(RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET);
    public static final Item RUBY_HORSE_ARMOR = new HorseArmorItem(15, "ruby", new Item.Settings().maxCount(1));

    //Block Items
    public static final BlockItem RUBY_BLOCK = new BlockItem(FirstModBlocks.RUBY_BLOCK, new Item.Settings());
    public static final BlockItem RUBY_ORE = new BlockItem(FirstModBlocks.RUBY_ORE, new Item.Settings());
    public static final BlockItem CHEESECAKE = new BlockItem(FirstModBlocks.CHEESECAKE, new Item.Settings().maxCount(1));
    public static final Item RUBY_SEEDS = new AliasedBlockItem(FirstModBlocks.RUBY_CROP, new Item.Settings());

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "cheese_wheel"), CHEESE_WHEEL);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_axe"), RUBY_AXE);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_hoe"), RUBY_HOE);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_sword"), RUBY_SWORD);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_boots"), RUBY_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_bow"), RUBY_BOW);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "cheesecake"), CHEESECAKE);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_shears"), RUBY_SHEARS);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_horse_armor"), RUBY_HORSE_ARMOR);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_seeds"), RUBY_SEEDS);
        Registry.register(Registry.ITEM, new Identifier(FirstMod.MOD_ID, "ruby_multitool"), RUBY_MULTITOOL);
    }
}
