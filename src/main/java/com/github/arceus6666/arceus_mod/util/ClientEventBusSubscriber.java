package com.github.arceus6666.arceus_mod.util;

import com.github.arceus6666.arceus_mod.MoreChestsMod;
import com.github.arceus6666.arceus_mod.client.gui.IronChestScreen;
import com.github.arceus6666.arceus_mod.init.ModContainerTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MoreChestsMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.IRON_CHEST.get(), IronChestScreen::new);

	}
}
