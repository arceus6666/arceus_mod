package com.github.arceus6666.more_chests_mod;

import com.github.arceus6666.more_chests_mod.init.BlockInit;
import com.github.arceus6666.more_chests_mod.init.ModContainerTypes;
import com.github.arceus6666.more_chests_mod.init.ItemInit;
import com.github.arceus6666.more_chests_mod.init.ModTileEntityTypes;
import com.github.arceus6666.more_chests_mod.init.SoundInit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
// import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
// import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// @SuppressWarnings("deprecation")
@Mod(MoreChestsMod.MODID)
@Mod.EventBusSubscriber(modid = MoreChestsMod.MODID, bus = Bus.MOD)
public class MoreChestsMod {

  private static final Logger LOGGER = LogManager.getLogger();
  public static final String MODID = "more_chests_mod";

  public static MoreChestsMod instance;

  // public static final ResourceLocation EXAMPLE_DIM_TYPE = new
  // ResourceLocation(MODID, "example");

  public MoreChestsMod() {
    LOGGER.info("Hello from MoreChests!");

    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::setup);

    // ParticleInit.PARTICLE_TYPES.register(modEventBus);
    SoundInit.SOUNDS.register(modEventBus);
    // PotionInit.POTIONS.register(modEventBus);
    // PotionInit.POTION_EFFECTS.register(modEventBus);
    // EnchantmentInit.ENCHANTMENTS.register(modEventBus);
    ItemInit.ITEMS.register(modEventBus);
    // FluidInit.FLUIDS.register(modEventBus);
    BlockInit.BLOCKS.register(modEventBus);
    ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
    // ModEntityTypes.ENTITY_TYPES.register(modEventBus);
    // BiomeInit.BIOMES.register(modEventBus);
    // DimensionInit.MOD_DIMENSIONS.register(modEventBus);

    instance = this;
    MinecraftForge.EVENT_BUS.register(this);
  }

  @SubscribeEvent
  public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    final IForgeRegistry<Item> registry = event.getRegistry();

    BlockInit.BLOCKS.getEntries().stream()
    .map(RegistryObject::get).forEach(block -> {
      final Item.Properties properties = new Item.Properties().group(MoreChestsItemGroup.instance);
      final BlockItem blockItem = new BlockItem(block, properties);
      blockItem.setRegistryName(block.getRegistryName());
      registry.register(blockItem);
    });

    LOGGER.debug("Registered BlockItems!");
  }

  private void setup(final FMLCommonSetupEvent event) {// K9#8016
    // ComposterBlock.registerCompostable(0.6f, ModBlocks.JAZZ_LEAVES.get());
    // ComposterBlock.registerCompostable(0.4f, ItemInit.SEED_ITEM.get());
    // DeferredWorkQueue.runLater(TutorialOreGen::generateOre);
    /*
     * DeferredWorkQueue.runLater(() -> { for (Biome biome : ForgeRegistries.BIOMES)
     * { if (biome instanceof ExampleBiome) {
     * biome.getSpawns(EntityClassification.MONSTER) .add(new
     * Biome.SpawnListEntry(EntityType.ZOMBIE, 1000, 1, 4)); } } });
     */
  }

  public static class MoreChestsItemGroup extends ItemGroup {
    public static final ItemGroup instance = new MoreChestsItemGroup(ItemGroup.GROUPS.length, "grouptab");

    private MoreChestsItemGroup(int index, String label) {
      super(index, label);
    }

    @Override
    public ItemStack createIcon() {
      return new ItemStack(BlockInit.IRON_CHEST.get());
    }
  }

}
