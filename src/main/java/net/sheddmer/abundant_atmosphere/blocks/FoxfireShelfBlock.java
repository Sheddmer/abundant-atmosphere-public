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
import org.jetbrains.annotations.Nullable;

public class FoxfireShelfBlock extends HorizontalDirectionalBlock {
    protected static final VoxelShape NORTH_SHAPE = box(2, 2, 10, 14, 14, 16);
    protected static final VoxelShape SOUTH_SHAPE = box(2, 2, 0, 14, 14, 6);
    protected static final VoxelShape WEST_SHAPE = box(10, 2, 2, 16, 14, 14);
    protected static final VoxelShape EAST_SHAPE = box(0, 2, 2, 6, 14, 14);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static final BooleanProperty UNLIT = BooleanProperty.create("unlit");

    public FoxfireShelfBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(((this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> EAST_SHAPE;
        };
    }

    private boolean canAttachTo(BlockGetter p_54349_, BlockPos p_54350_, Direction p_54351_) {
        BlockState blockstate = p_54349_.getBlockState(p_54350_);
        return blockstate.isFaceSturdy(p_54349_, p_54350_, p_54351_);
    }

    public boolean canSurvive(BlockState p_54353_, LevelReader p_54354_, BlockPos p_54355_) {
        Direction direction = p_54353_.getValue(FACING);
        return this.canAttachTo(p_54354_, p_54355_.relative(direction.getOpposite()), direction);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = this.defaultBlockState();
        Level worldView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        for (Direction direction : ctx.getNearestLookingDirections()) {
            if (!direction.getAxis().isHorizontal() || !(blockState = blockState.setValue(FACING, direction)).canSurvive(worldView, blockPos)) continue;
            return blockState;
        }
        return null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction == state.getValue(FACING) && !state.canSurvive(world, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, UNLIT);
    }

}
