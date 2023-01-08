package net.sheddmer.abundant_atmosphere.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.sheddmer.abundant_atmosphere.init.AABlocks;
import net.sheddmer.abundant_atmosphere.init.AAConfiguredFeatures;

public class CaveSoilBlock extends Block implements BonemealableBlock {
    public CaveSoilBlock(BlockBehaviour.Properties p_55057_) {
        super(p_55057_);
    }

    public boolean isValidBonemealTarget(BlockGetter p_55064_, BlockPos p_55065_, BlockState p_55066_, boolean p_55067_) {
        return p_55064_.getBlockState(p_55065_.above()).isAir();
    }

    public boolean isBonemealSuccess(Level p_221830_, RandomSource p_221831_, BlockPos p_221832_, BlockState p_221833_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_221825_, RandomSource p_221826_, BlockPos p_221827_, BlockState p_221828_) {
        BlockState blockstate = p_221825_.getBlockState(p_221827_);
        BlockPos blockpos = p_221827_.above();
        ChunkGenerator chunkgenerator = p_221825_.getChunkSource().getGenerator();
        if (blockstate.is(AABlocks.CAVE_SOIL.get())) {
            AAConfiguredFeatures.CAVE_SPROUT_VEGETATION.value().place(p_221825_, chunkgenerator, p_221826_, blockpos);
        }

    }
}