package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.entities.AABoatEntity;

public class AAModelLayers {

    public static ModelLayerLocation createChestBoat(AABoatEntity.BoatType type) {
        return create("chest_boat/" + type.getName(), "main");
    }

    public static ModelLayerLocation createBoat(AABoatEntity.BoatType type) {
        return create("boat/" + type.getName(), "main");
    }

    private static ModelLayerLocation create(String id, String layer) {
        return new ModelLayerLocation(new ResourceLocation(AbundantAtmosphere.MODID, id), layer);
    }

}
