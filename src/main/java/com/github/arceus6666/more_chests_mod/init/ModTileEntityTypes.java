package com.github.arceus6666.more_chests_mod.init;

import com.github.arceus6666.more_chests_mod.MoreChestsMod;
import com.github.arceus6666.more_chests_mod.tileentity.IronChestTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * ModTileEntityTypes
 */
public final class ModTileEntityTypes {

  public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
      ForgeRegistries.TILE_ENTITIES, MoreChestsMod.MODID);

  public static final RegistryObject<TileEntityType<IronChestTileEntity>> IRON_CHEST = TILE_ENTITY_TYPES.register(
      "iron_chest",
      () -> TileEntityType.Builder.create(IronChestTileEntity::new, BlockInit.IRON_CHEST.get()).build(null));

}
