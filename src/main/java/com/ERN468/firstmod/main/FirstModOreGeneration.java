package com.ERN468.firstmod.main;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class FirstModOreGeneration {
        public static ConfiguredFeature<?, ?> ORE_RUBY_OVERWORLD = Feature.ORE
                .configure(new OreFeatureConfig(
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        FirstModBlocks.RUBY_ORE.getDefaultState(),
                        3)) // vein size
                .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                        0,
                        0,
                        20)))
                .spreadHorizontally()
                .repeat(10); // number of veins per chunk
        public static void registerOreGeneration() {
                RegistryKey<ConfiguredFeature<?, ?>> oreRubyOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                        new Identifier("firstmod", "ore_ruby_overworld"));
                Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreRubyOverworld.getValue(), FirstModOreGeneration.ORE_RUBY_OVERWORLD);
                BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreRubyOverworld);
                FabricModelPredicateProviderRegistry.register(FirstModItems.RUBY_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
                        if (livingEntity == null) {
                                return 0.0F;
                        }
                        return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
                });

                FabricModelPredicateProviderRegistry.register(FirstModItems.RUBY_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
                        if (livingEntity == null) {
                                return 0.0F;
                        }
                        return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
                });
        }
}
