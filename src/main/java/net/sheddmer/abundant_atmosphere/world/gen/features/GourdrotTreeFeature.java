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
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.world.gen.features.treedecorator.FoxfireDecorator;
import net.sheddmer.abundant_atmosphere.world.gen.features.treedecorator.PoreshroomDecorator;

import java.util.List;

public class GourdrotTreeFeature {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GOURDROT_TREE = FeatureUtils.register("gourdrot", Feature.TREE,
            (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(AABlocks.GOURDROT_LOG.get()),
                    new ForkingTrunkPlacer(5, 4, 4), BlockStateProvider.simple(AABlocks.GOURDROT_LEAVES.get()),
                    new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 60),
                    new TwoLayersFeatureSize(2, 2, 4))).decorators(List.of(new PoreshroomDecorator(0.5F)
            )).ignoreVines().build());
}