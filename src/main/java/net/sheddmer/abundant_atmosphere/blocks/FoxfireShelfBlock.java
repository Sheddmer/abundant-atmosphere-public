package net.sheddmer.abundant_atmosphere.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FoxfireShelfBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape NORTH_AABB = Block.box(1.0D, 1.0D, 8.0D, 15.0D, 15.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 1.0D, 1.0D, 8.0D, 15.0D, 15.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 8.0D);
    protected static final VoxelShape WEST_AABB = Block.box(8.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D);

    public static final BooleanProperty UNLIT = BooleanProperty.create("unlit");

    public FoxfireShelfBlock(Properties properties) {super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState p_51787_, BlockGetter p_51788_, BlockPos p_51789_, CollisionContext p_51790_) {
        switch ((Direction)p_51787_.getValue(FACING)) {
            case NORTH:
            default:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }

    private boolean canAttachTo(BlockGetter p_54349_, BlockPos p_54350_, Direction p_54351_) {
        BlockState blockstate = p_54349_.getBlockState(p_54350_);
        return blockstate.isFaceSturdy(p_54349_, p_54350_, p_54351_);
    }

    public boolean canSurvive(BlockState p_54353_, LevelReader p_54354_, BlockPos p_54355_) {
        Direction direction = p_54353_.getValue(FACING);
        return this.canAttachTo(p_54354_, p_54355_.relative(direction.getOpposite()), direction);
    }

    /* FACING */

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
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

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean currentState = pState.getValue(UNLIT);
            pLevel.setBlock(pPos, pState.setValue(UNLIT, !currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, UNLIT);
    }
}