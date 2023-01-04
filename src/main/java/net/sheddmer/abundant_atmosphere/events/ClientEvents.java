package net.sheddmer.abundant_atmosphere.events;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.client.renderer.AABoatEntityRenderer;
import net.sheddmer.abundant_atmosphere.entities.AABoatEntity;
import net.sheddmer.abundant_atmosphere.init.AABlockEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAEntityTypes;
import net.sheddmer.abundant_atmosphere.init.AAModelLayers;
import net.sheddmer.abundant_atmosphere.init.AASignTypes;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {

        event.enqueueWork(AASignTypes::init);
    }

    @SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        Arrays.stream(AABoatEntity.BoatType.values()).forEach(type -> {
            event.registerLayerDefinition(AAModelLayers.createBoat(type), () -> BoatModel.createBodyModel(false));
            event.registerLayerDefinition(AAModelLayers.createChestBoat(type), () -> BoatModel.createBodyModel(true));
        });
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AABlockEntityTypes.AA_SIGN.get(), SignRenderer::new);
        event.registerEntityRenderer(AAEntityTypes.BOAT.get(), ctx -> new AABoatEntityRenderer(ctx, false));
        event.registerEntityRenderer(AAEntityTypes.CHEST_BOAT.get(), ctx -> new AABoatEntityRenderer(ctx, true));
    }
}