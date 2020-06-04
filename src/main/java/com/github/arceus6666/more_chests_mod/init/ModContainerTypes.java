package com.github.arceus6666.more_chests_mod.init;

import com.github.arceus6666.more_chests_mod.MoreChestsMod;
// import com.github.arceus6666.more_chests_mod.container.IronChestContainer;
import com.github.arceus6666.more_chests_mod.container.IronChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.extensions.IForgeContainerType;

public class ModContainerTypes {

  public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
      ForgeRegistries.CONTAINERS, MoreChestsMod.MODID);

  public static final RegistryObject<ContainerType<IronChestContainer>> IRON_CHEST = CONTAINER_TYPES
      .register("iron_chest", () -> IForgeContainerType.create(IronChestContainer::new));
}
