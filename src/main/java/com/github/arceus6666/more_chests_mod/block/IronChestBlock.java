package com.github.arceus6666.more_chests_mod.block;

import javax.annotation.Nullable;

// import java.util.stream.Stream;

import com.github.arceus6666.more_chests_mod.init.ModTileEntityTypes;
import com.github.arceus6666.more_chests_mod.tileentity.IronChestTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
// import net.minecraft.item.Item;
// import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
// import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
// import net.minecraft.util.math.shapes.IBooleanFunction;
// import net.minecraft.util.math.shapes.ISelectionContext;
// import net.minecraft.util.math.shapes.VoxelShape;
// import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
// import net.minecraft.world.server.ServerWorld;
// import net.minecraft.world.storage.loot.LootContext;
// import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.state.StateContainer.Builder;

public class IronChestBlock extends Block {

  // private Item toDrop;

  public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  /*
   * 
   * private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(5,
   * 3, 3, 11, 4, 13), Block.makeCuboidShape(5, 4, 11, 11, 11, 12),
   * Block.makeCuboidShape(7, 0, 5, 9, 3, 11), Block.makeCuboidShape(11, 5, 5, 13,
   * 6, 12), Block.makeCuboidShape(3, 5, 5, 5, 6, 12)).reduce((v1, v2) -> { return
   * VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR); }).get();
   * private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(3,
   * 3, 5, 13, 4, 11), Block.makeCuboidShape(11, 4, 5, 12, 11, 11),
   * Block.makeCuboidShape(5, 0, 7, 11, 3, 9), Block.makeCuboidShape(5, 5, 3, 12,
   * 6, 5), Block.makeCuboidShape(5, 5, 11, 12, 6, 13)).reduce((v1, v2) -> {
   * return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR); }).get();
   * private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(5,
   * 3, 3, 11, 4, 13), Block.makeCuboidShape(5, 4, 4, 11, 11, 5),
   * Block.makeCuboidShape(7, 0, 5, 9, 3, 11), Block.makeCuboidShape(3, 5, 4, 5,
   * 6, 11), Block.makeCuboidShape(11, 5, 4, 13, 6, 11)).reduce((v1, v2) -> {
   * return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR); }).get();
   * private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(3,
   * 3, 5, 13, 4, 11), Block.makeCuboidShape(4, 4, 5, 5, 11, 11),
   * Block.makeCuboidShape(5, 0, 7, 11, 3, 9), Block.makeCuboidShape(4, 5, 11, 11,
   * 6, 13), Block.makeCuboidShape(4, 5, 3, 11, 6, 5)).reduce((v1, v2) -> { return
   * VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR); }).get();
   */
  public IronChestBlock(Properties properties) {
    super(properties);
    // this.setDefaultState(this.stateContainer.getBaseState().with(FACING,
    // Direction.NORTH));
  }

  /*
   * @Override public VoxelShape getShape(BlockState state, IBlockReader worldIn,
   * BlockPos pos, ISelectionContext context) { switch (state.get(FACING)) { case
   * NORTH: return SHAPE_N; case SOUTH: return SHAPE_S; case EAST: return SHAPE_E;
   * case WEST: return SHAPE_W; default: return SHAPE_N; } }
   */

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return ModTileEntityTypes.IRON_CHEST.get().create();
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
      Hand handIn, BlockRayTraceResult result) {
    if (!worldIn.isRemote) {
      TileEntity tile = worldIn.getTileEntity(pos);
      if (tile instanceof IronChestTileEntity) {
        NetworkHooks.openGui((ServerPlayerEntity) player, (IronChestTileEntity) tile, pos);
        return ActionResultType.SUCCESS;
      }
    }
    return ActionResultType.FAIL;
  }

  @Override
  public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
    if (state.getBlock() != newState.getBlock()) {
      TileEntity te = worldIn.getTileEntity(pos);
      if (te instanceof IronChestTileEntity) {
        InventoryHelper.dropItems(worldIn, pos, ((IronChestTileEntity) te).getItems());
      }
    }
  }

  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  public BlockState rotate(BlockState state, Rotation rot) {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }

  @Override
  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }

  @Override
  protected void fillStateContainer(Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

}
