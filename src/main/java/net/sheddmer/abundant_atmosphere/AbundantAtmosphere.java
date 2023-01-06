package net.sheddmer.abundant_atmosphere;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sheddmer.abundant_atmosphere.events.MiscEvents;
import net.sheddmer.abundant_atmosphere.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AbundantAtmosphere.MODID)
public class AbundantAtmosphere {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "abundant_atmosphere";

    public AbundantAtmosphere() {
        IEventBus Bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        Bus.addListener(this::commonSetup);

        AABlocks.BLOCKS.register(Bus);
        AABlockEntityTypes.BLOCK_ENTITY_TYPES.register(Bus);
        AAEntityTypes.ENTITY_TYPES.register(Bus);
        AABiomes.BIOMES.register(Bus);
        AAFeatures.FEATURES.register(Bus);
        AAItems.ITEMS.register(Bus);

        eventBus.register(new MiscEvents());
        Bus.addListener(AbundantAtmosphere::registerBlockColors);
        Bus.addListener(AbundantAtmosphere::registerItemColors);

    }

    private static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state,  level, pos, tintindex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor(), AABlocks.HANGING_MANGROVE_LEAVES.get());
    }
    private static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((p_92696_, p_92697_) -> {return FoliageColor.getMangroveColor();}, AABlocks.HANGING_MANGROVE_LEAVES.get());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AAVanillaIntegration.init();
            AAConfiguredFeatures.init();
            AAPlacedFeatures.init();


        });
    }

}