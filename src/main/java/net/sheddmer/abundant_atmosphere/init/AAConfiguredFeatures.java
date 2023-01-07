package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import java.util.List;

public class AAConfiguredFeatures {

    public static void init() {
    }

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_MOSSY_STONES = registerConfiguredFeature("ore_mossy_stones", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), AABlocks.MOSSY_STONE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), AABlocks.MOSSY_DEEPSLATE.get().defaultBlockState())), 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_CAVE_SOIL = registerConfiguredFeature("ore_cave_soil", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), AABlocks.CAVE_SOIL.get().defaultBlockState())), 24));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CAVE_SPROUT_VEGETATION = registerConfiguredFeature("cave_sprout_vegetation", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(AABlocks.CAVE_SPROUTS.get().defaultBlockState(), 80).add(Blocks.AIR.defaultBlockState(), 15))));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> PORESHROOM_VEGETATION = registerConfiguredFeature("poreshoom_vegetation", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(AABlocks.PORESHROOM.get().defaultBlockState(), 50).add(Blocks.AIR.defaultBlockState(), 10))));

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String id, F feature, FC featureConfiguration) {
        ResourceLocation resourceLocation = new ResourceLocation(AbundantAtmosphere.MODID, id);

        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(resourceLocation))
            throw new IllegalStateException("Placed Feature ID: \"" + resourceLocation + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation.toString(), new ConfiguredFeature<>(feature, featureConfiguration));
    }

}
