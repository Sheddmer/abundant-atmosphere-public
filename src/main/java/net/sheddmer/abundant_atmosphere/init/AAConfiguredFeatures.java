package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import java.util.List;

public class AAConfiguredFeatures {

    public static void init() {
    }

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_MOSSY_STONES = registerConfiguredFeature("ore_mossy_stones", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), AABlocks.MOSSY_STONE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), AABlocks.MOSSY_DEEPSLATE.get().defaultBlockState())), 9));

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String id, F feature, FC featureConfiguration) {
        ResourceLocation resourceLocation = new ResourceLocation(AbundantAtmosphere.MODID, id);

        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(resourceLocation))
            throw new IllegalStateException("Placed Feature ID: \"" + resourceLocation + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation.toString(), new ConfiguredFeature<>(feature, featureConfiguration));
    }

}
