package com.github.arceus6666.more_chests_mod.config;

import java.util.ArrayList;
import java.util.List;

import com.github.arceus6666.more_chests_mod.MoreChestsMod;

import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ForgeConfigSpec;

final class ServerConfig {

	final ForgeConfigSpec.BooleanValue serverBoolean;
	final ForgeConfigSpec.ConfigValue<List<String>> serverStringList;
	final ForgeConfigSpec.ConfigValue<DyeColor> serverEnumDyeColor;

	ServerConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		serverBoolean = builder
				.comment("An example boolean in the server config")
				.translation(MoreChestsMod.MODID + ".config.serverBoolean")
				.define("serverBoolean", true);
		serverStringList = builder
				.comment("An example list of Strings in the server config")
				.translation(MoreChestsMod.MODID + ".config.serverStringList")
				.define("serverStringList", new ArrayList<>());
		serverEnumDyeColor = builder
				.comment("An example enum DyeColor in the server config")
				.translation(MoreChestsMod.MODID + ".config.serverEnumDyeColor")
				.defineEnum("serverEnumDyeColor", DyeColor.WHITE);
	}

}
