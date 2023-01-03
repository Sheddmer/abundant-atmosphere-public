package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AABiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, AbundantAtmosphere.MODID);

}
