package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

import java.util.List;

public class AAPlacedFeatures {

    public static void init() {
    }

    public static final Holder<PlacedFeature> ORE_MOSS_PATCH = registerPlacedFeature("ore_moss_patch", AAConfiguredFeatures.ORE_MOSSY_STONES, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(48))));

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        return registerPlacedFeature(id, feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        ResourceLocation resourceLocation = new ResourceLocation(AbundantAtmosphere.MODID, id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(resourceLocation))
            throw new IllegalStateException("Placed Feature ID: \"" + resourceLocation + "\" already exists in the Placed Features registry!");

        PlacedFeature placedFeature = new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers));

        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, resourceLocation, placedFeature);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier2) {
        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(count), modifier);
    }

}
