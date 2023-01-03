package net.sheddmer.abundant_atmosphere.world.gen.features.treedecorator;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.sheddmer.abundant_atmosphere.blocks.FoxfireShelfBlock;
import net.sheddmer.abundant_atmosphere.init.AABlocks;

import java.util.List;

public class FoxfireDecorator extends TreeDecorator {
    public static final Codec<FoxfireDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(FoxfireDecorator::new, (p_69989_) -> {
        return p_69989_.probability;
    }).codec();
    private final float probability;

    public FoxfireDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected TreeDecoratorType<?> type() {
        return TreeDecoratorType.COCOA;
    }

    public void place(Context p_226028_) {
        RandomSource randomsource = p_226028_.random();
        if (!(randomsource.nextFloat() >= this.probability)) {
            List<BlockPos> list = p_226028_.logs();
            int i = list.get(0).getY();
            list.stream().filter((p_69980_) -> {
                return p_69980_.getY() - i <= 2;
            }).forEach((p_226026_) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (randomsource.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (p_226028_.isAir(blockpos)) {
                            p_226028_.setBlock(blockpos, AABlocks.FOXFIRE_SHELF.get().defaultBlockState().setValue(FoxfireShelfBlock.FACING, direction.getOpposite()));
                        }
                    }
                }

            });
        }
    }
}