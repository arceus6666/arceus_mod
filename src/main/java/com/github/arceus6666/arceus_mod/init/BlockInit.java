package com.github.arceus6666.arceus_mod.init;

import com.github.arceus6666.arceus_mod.MoreChestsMod;
import com.github.arceus6666.arceus_mod.block.IronChestBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
// import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * ModBlocks
 */
public final class BlockInit {

  public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreChestsMod.MODID);

  public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
  
  public static final RegistryObject<Block> IRON_CHEST = BLOCKS.register("iron_chest",
      () -> new IronChestBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON)
          .hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
}
