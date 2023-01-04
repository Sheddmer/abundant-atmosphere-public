package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.entities.AABoatEntity;
import net.sheddmer.abundant_atmosphere.entities.AAChestBoatEntity;

import static net.sheddmer.abundant_atmosphere.AbundantAtmosphere.MODID;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AAEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AbundantAtmosphere.MODID);

    public static final RegistryObject<EntityType<AABoatEntity>> BOAT = ENTITY_TYPES.register("boat", () -> EntityType.Builder.<AABoatEntity>of(AABoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(AbundantAtmosphere.MODID, "boat").toString()));
    public static final RegistryObject<EntityType<AAChestBoatEntity>> CHEST_BOAT = ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.<AAChestBoatEntity>of(AAChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(AbundantAtmosphere.MODID, "chest_boat").toString()));
}
