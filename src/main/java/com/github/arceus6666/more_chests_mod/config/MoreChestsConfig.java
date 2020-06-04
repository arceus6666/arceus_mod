package com.github.arceus6666.more_chests_mod.config;

import java.util.List;

import net.minecraft.item.DyeColor;

public final class MoreChestsConfig {

  // Client
  public static boolean clientBoolean;
  public static List<String> clientStringList;
  public static DyeColor clientDyeColorEnum;

  public static boolean modelTranslucency;
  public static float modelScale;

  // Server
  public static boolean serverBoolean;
  public static List<String> serverStringList;
  public static DyeColor serverEnumDyeColor;

  public static int electricFurnaceEnergySmeltCostPerTick = 100;
  public static int heatCollectorTransferAmountPerTick = 100;

}
