package net.sheddmer.abundant_atmosphere.world.gen.features.generator;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sheddmer.abundant_atmosphere.world.gen.features.AshTreeFeature;

public class AshTreeGenerator extends AbstractTreeGrower {
    @Nullable
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222916_, boolean p_222917_) {
        return AshTreeFeature.ASH_TREE;
    }
}