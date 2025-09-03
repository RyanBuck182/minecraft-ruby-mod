package com.ERN468.firstmod.main;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.fabric.mixin.loot.table.LootSupplierBuilderHooks;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.AlternativeLootCondition;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

import java.util.List;

public class FirstModLootTables {
    private static final Identifier DESERT_PYRAMID_LOOT_TABLE_ID = new Identifier("minecraft", "chests/desert_pyramid");
    private static final Identifier END_CITY_TREASURE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier JUNGLE_TEMPLE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier NETHER_BRIDGE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier SIMPLE_DUNGEON_LOOT_TABLE_ID = new Identifier("minecraft", "chests/simple_dungeon");
    private static final Identifier STRONGHOLD_CORRIDOR_LOOT_TABLE_ID = new Identifier("minecraft", "chests/stronghold_corridor");
    private static final Identifier VILLAGE_WEAPONSMITH_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_weaponsmith");
    private static final Identifier ACACIA_LEAVES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/acacia_leaves");
    private static final Identifier BIRCH_LEAVES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/birch_leaves");
    private static final Identifier DARK_OAK_LEAVES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/dark_oak_leaves");
    private static final Identifier JUNGLE_LEAVES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/jungle_leaves");
    private static final Identifier OAK_LEAVES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/oak_leaves");
    private static final Identifier SPRUCE_LEAVES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/spruce_leaves");
    private static final Identifier COBWEB_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/cobweb");
    private static final Identifier DEAD_BUSH_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/dead_bush");
    private static final Identifier FERN_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/fern");
    private static final Identifier GRASS_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/grass");
    private static final Identifier LARGE_FERN_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/large_fern");
    private static final Identifier NETHER_SPROUTS_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/nether_sprouts");
    private static final Identifier SEAGRASS_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/seagrass");
    private static final Identifier TALL_GRASS_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/tall_grass");
    private static final Identifier TALL_SEAGRASS_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/tall_seagrass");
    private static final Identifier TWISTING_VINES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/twisting_vines");
    private static final Identifier TWISTING_VINES_PLANT_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/twisting_vines_plant");
    private static final Identifier VINE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/vine");
    private static final Identifier WEEPING_VINES_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/weeping_vines");
    private static final Identifier WEEPING_VINES_PLANT_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/weeping_vines_plant");
    private static final Identifier BLACK_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/black");
    private static final Identifier BLUE_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/blue");
    private static final Identifier BROWN_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/brown");
    private static final Identifier CYAN_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/cyan");
    private static final Identifier GRAY_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/gray");
    private static final Identifier GREEN_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/green");
    private static final Identifier LIGHT_BLUE_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/light_blue");
    private static final Identifier LIGHT_GRAY_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/light_gray");
    private static final Identifier LIME_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/lime");
    private static final Identifier MAGENTA_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/magenta");
    private static final Identifier ORANGE_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/orange");
    private static final Identifier PINK_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/pink");
    private static final Identifier PURPLE_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/purple");
    private static final Identifier RED_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/red");
    private static final Identifier WHITE_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/white");
    private static final Identifier YELLOW_SHEEP_LOOT_TABLE_ID = new Identifier("minecraft", "entities/sheep/yellow");

    private static final ItemPredicate.Builder FABRIC_SHEARS = ItemPredicate.Builder.create().tag(FabricToolTags.SHEARS);
    private static final ItemPredicate.Builder SHEARS = ItemPredicate.Builder.create().item(Items.SHEARS);

    public static void registerLootTables() {
        //0.026 = 2.6%

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            final LootSupplierBuilderHooks EXTENDED = (LootSupplierBuilderHooks) supplier;
            //chests
            if (DESERT_PYRAMID_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.026f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            else if (END_CITY_TREASURE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.015f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            else if (JUNGLE_TEMPLE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.014f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            else if (NETHER_BRIDGE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.065f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            else if (SIMPLE_DUNGEON_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.031f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            else if (STRONGHOLD_CORRIDOR_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.008f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            else if (VILLAGE_WEAPONSMITH_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.020f))
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(FirstModItems.RUBY_HORSE_ARMOR).build());

                supplier.withPool(poolBuilder.build());
            }
            //blocks
            else if (ACACIA_LEAVES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if(i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.ACACIA_LEAVES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (BIRCH_LEAVES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if(i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.BIRCH_LEAVES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (DARK_OAK_LEAVES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if(i == 3) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if(i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.DARK_OAK_LEAVES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (JUNGLE_LEAVES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if(i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.JUNGLE_LEAVES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (OAK_LEAVES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if(i == 3) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if(i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.OAK_LEAVES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (SPRUCE_LEAVES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if(i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS).invert());
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.SPRUCE_LEAVES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (COBWEB_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.COBWEB).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (DEAD_BUSH_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.DEAD_BUSH).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (FERN_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.FERN).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (GRASS_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.GRASS).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (LARGE_FERN_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))))
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(2, 2)).conditionally(MatchToolLootCondition.builder(SHEARS)));
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))))
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(2, 2)).conditionally(MatchToolLootCondition.builder(SHEARS)));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(2))
                            .withEntry(ItemEntry.builder(Items.FERN).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (NETHER_SPROUTS_LOOT_TABLE_ID .equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.NETHER_SPROUTS).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (SEAGRASS_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.SEAGRASS).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (TALL_GRASS_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 2) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))))
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(2, 2)).conditionally(MatchToolLootCondition.builder(SHEARS)));
                            replacement.withPool(poolBuilder.build());
                        }
                        else if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))))
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(2, 2)).conditionally(MatchToolLootCondition.builder(SHEARS)));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(2))
                            .withEntry(ItemEntry.builder(Items.GRASS).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (TALL_SEAGRASS_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(2))
                            .withEntry(ItemEntry.builder(Items.SEAGRASS).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (TWISTING_VINES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.TWISTING_VINES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (TWISTING_VINES_PLANT_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.TWISTING_VINES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (VINE_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.VINE).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (WEEPING_VINES_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.WEEPING_VINES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            else if (WEEPING_VINES_PLANT_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(0, 0)).conditionally(InvertedLootCondition.builder(AlternativeLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()).or(MatchToolLootCondition.builder(SHEARS)))));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .conditionally(MatchToolLootCondition.builder(FABRIC_SHEARS))
                            .conditionally(MatchToolLootCondition.builder(SHEARS).invert())
                            .rolls(ConstantLootTableRange.create(1))
                            .withEntry(ItemEntry.builder(Items.WEEPING_VINES).build());
                    replacement.withPool(poolBuilder.build());
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }
            //entities
            /*else if (BLACK_SHEEP_LOOT_TABLE_ID.equals(id)) {
                if (supplier != null) {
                    LootContextType contextType = supplier.build().getType();
                    List<LootPool> pools = EXTENDED.getPools();
                    List<LootFunction> functions = EXTENDED.getFunctions();
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder()
                            .type(contextType);
                    int i = 0;
                    for (LootPool pool : pools) {
                        i++;
                        if (i == 1) {
                            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.of(pool)
                                    .conditionally(InvertedLootCondition.builder(MatchToolLootCondition.builder(FABRIC_SHEARS).invert()));
                            replacement.withPool(poolBuilder.build());
                        }
                        else {
                            replacement.withPool(pool);
                        }
                    }
                    replacement.withFunctions(functions);
                    setter.set(replacement.build());
                }
            }*/
        });
    }
}
