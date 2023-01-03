package net.sheddmer.abundant_atmosphere.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CatsbaneBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private static final VoxelShape SHAPE_NORTH = Block.box(1, 1, 8, 15, 15, 16);
    private static final VoxelShape SHAPE_EAST = Block.box(1, 1, 0, 15, 15, 8);
    private static final VoxelShape SHAPE_SOUTH = Block.box(8, 1, 1, 16, 15, 15);
    private static final VoxelShape SHAPE_WEST = Block.box(0, 1, 1, 8, 15, 15);
    private static final VoxelShape SHAPE_UP = Block.box(2, 0, 2, 14, 14, 14);
    private static final VoxelShape SHAPE_DOWN = Block.box(2, 2, 2, 14, 16, 14);

    public CatsbaneBlock(Properties properties) {super(properties);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((Direction)pState.getValue(FACING)) {
            case UP:
                return SHAPE_UP;
            case DOWN:
                return SHAPE_DOWN;
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_SOUTH;
            case EAST:
            default:
                return SHAPE_WEST;
        }
    }
    public boolean canSurvive(BlockState p_58073_, LevelReader p_58074_, BlockPos p_58075_) {
        return p_58074_.getBlockState(p_58075_.relative(p_58073_.getValue(FACING).getOpposite())).getMaterial().isSolid();
    }

    /* FACING */

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
    public BlockState updateShape(BlockState p_58083_, Direction p_58084_, BlockState p_58085_, LevelAccessor p_58086_, BlockPos p_58087_, BlockPos p_58088_) {
        return p_58084_.getOpposite() == p_58083_.getValue(FACING) && !p_58083_.canSurvive(p_58086_, p_58087_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_58083_, p_58084_, p_58085_, p_58086_, p_58087_, p_58088_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}