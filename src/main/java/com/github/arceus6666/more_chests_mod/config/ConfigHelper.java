package com.github.arceus6666.more_chests_mod.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper {

	public static void bakeClient(final ModConfig config) {
		MoreChestsConfig.clientBoolean = ConfigHolder.CLIENT.clientBoolean.get();
		MoreChestsConfig.clientStringList = ConfigHolder.CLIENT.clientStringList.get();
		MoreChestsConfig.clientDyeColorEnum = ConfigHolder.CLIENT.clientDyeColorEnum.get();

		MoreChestsConfig.modelTranslucency = ConfigHolder.CLIENT.modelTranslucency.get();
		MoreChestsConfig.modelScale = ConfigHolder.CLIENT.modelScale.get().floatValue();
	}

	public static void bakeServer(final ModConfig config) {
		MoreChestsConfig.serverBoolean = ConfigHolder.SERVER.serverBoolean.get();
		MoreChestsConfig.serverStringList = ConfigHolder.SERVER.serverStringList.get();
		MoreChestsConfig.serverEnumDyeColor = ConfigHolder.SERVER.serverEnumDyeColor.get();
	}

}
