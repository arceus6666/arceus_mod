package com.github.arceus6666.more_chests_mod.init;

import com.github.arceus6666.more_chests_mod.MoreChestsMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

  public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
      MoreChestsMod.MODID);

  public static final RegistryObject<SoundEvent> AMBIENT = SOUNDS.register("entity.example_entity.ambient",
      () -> new SoundEvent(new ResourceLocation(MoreChestsMod.MODID, "entity.example_entity.ambient")));
}
