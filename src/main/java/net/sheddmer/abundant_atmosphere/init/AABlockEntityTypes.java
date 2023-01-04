package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.blocks.blockentities.AASignBlockEntity;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AABlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AbundantAtmosphere.MODID);

    public static final RegistryObject<BlockEntityType<AASignBlockEntity>> AA_SIGN = BLOCK_ENTITY_TYPES.register("sign", () -> BlockEntityType.Builder.of(AASignBlockEntity::new, AABlocks.ASH_SIGN.get(), AABlocks.ASH_WALL_SIGN.get(), AABlocks.GOURDROT_SIGN.get(), AABlocks.GOURDROT_WALL_SIGN.get()).build(null));

}
