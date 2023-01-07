package net.sheddmer.abundant_atmosphere.world.gen.features;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.sheddmer.abundant_atmosphere.init.AABlocks;

public class HugeFoxfireFeature {
    public static final Holder<ConfiguredFeature<HugeMushroomFeatureConfiguration, ?>> HUGE_FOXFIRE_MUSHROOM = FeatureUtils.register("huge_foxfire_mushroom", Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(AABlocks.FOXFIRE_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 2));

}
