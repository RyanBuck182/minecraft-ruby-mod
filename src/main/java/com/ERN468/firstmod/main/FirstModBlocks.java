package com.ERN468.firstmod.main;

import com.ERN468.firstmod.FirstMod;
import com.ERN468.firstmod.blocks.FirstModCakeBase;
import com.ERN468.firstmod.crops.FirstModCropBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FirstModBlocks {

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().strength(30.0f, 3.0f).sounds(BlockSoundGroup.STONE));
    public static final Block CHEESECAKE = new FirstModCakeBase(FabricBlockSettings.of(Material.CAKE).strength(0.5f, 0.5f).sounds(BlockSoundGroup.WOOL));
    public static final Block RUBY_CROP = new FirstModCropBlock(FirstModItems.RUBY_SEEDS, FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(FirstMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(FirstMod.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.BLOCK, new Identifier(FirstMod.MOD_ID, "cheesecake"), CHEESECAKE);
        Registry.register(Registry.BLOCK, new Identifier(FirstMod.MOD_ID, "ruby_crop"), RUBY_CROP);
    }
}
