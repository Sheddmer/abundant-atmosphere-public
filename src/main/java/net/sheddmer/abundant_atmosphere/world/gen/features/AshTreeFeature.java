package net.sheddmer.abundant_atmosphere.world.gen.features;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.world.gen.features.treedecorator.FoxfireDecorator;

import java.util.List;

public class AshTreeFeature {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ASH_TREE = FeatureUtils.register("ash", Feature.TREE,
            (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(AABlocks.ASH_LOG.get()),
                    new FancyTrunkPlacer(5, 4, 4), BlockStateProvider.simple(AABlocks.ASH_LEAVES.get()),
                    new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 60),
                    new TwoLayersFeatureSize(2, 2, 4))).decorators(List.of(new FoxfireDecorator(0.5F),
                    new AttachedToLeavesDecorator(0.5F, 1, 0, BlockStateProvider.simple(AABlocks.HANGING_ASH_LEAVES.get()), 2, List.of(Direction.DOWN))
            )).ignoreVines().build());
}