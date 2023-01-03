package net.sheddmer.abundant_atmosphere.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MudPotBlock extends Block implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE =  Block.box(2, 0, 2, 14, 14, 14);

    public MudPotBlock(Properties properties) {super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    public FluidState getFluidState(BlockState p_153311_) {
        return p_153311_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153311_);
    }
    public PushReaction getPistonPushReaction(BlockState p_52814_) {
        return PushReaction.DESTROY;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153309_) {
        super.createBlockStateDefinition(p_153309_);
        p_153309_.add(WATERLOGGED);
    }
}