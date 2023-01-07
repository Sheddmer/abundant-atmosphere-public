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

public class HugePoreshroomFeature {
    public static final Holder<ConfiguredFeature<HugeMushroomFeatureConfiguration, ?>> HUGE_PORESHROOM = FeatureUtils.register("huge_poreshroom", Feature.HUGE_BROWN_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(AABlocks.PORESHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(true)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 2));

}
