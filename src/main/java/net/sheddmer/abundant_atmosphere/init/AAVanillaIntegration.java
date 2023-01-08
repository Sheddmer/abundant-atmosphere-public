package net.sheddmer.abundant_atmosphere.init;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class AAVanillaIntegration {

    public static void init() {
        registerStrippables();
        registerFlammables();
        registerCompostables();
    }

    public static void registerFlammables() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(AABlocks.ASH_LOG.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.ASH_WOOD.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.STRIPPED_ASH_LOG.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.STRIPPED_ASH_WOOD.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.ASH_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASH_SLAB.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASH_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASH_FENCE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASH_FENCE_GATE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASH_DOOR.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.ASH_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(AABlocks.HANGING_ASH_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(AABlocks.GOURDROT_LOG.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.GOURDROT_WOOD.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.STRIPPED_GOURDROT_LOG.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.STRIPPED_GOURDROT_WOOD.get(), 5, 5);
        fireBlock.setFlammable(AABlocks.GOURDROT_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_SLAB.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_FENCE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_FENCE_GATE.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_DOOR.get(), 5, 20);
        fireBlock.setFlammable(AABlocks.GOURDROT_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(AABlocks.HANGING_MANGROVE_LEAVES.get(), 30, 60);

    }

    public static void registerStrippables() {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(AABlocks.ASH_LOG.get(), AABlocks.STRIPPED_ASH_LOG.get());
        AxeItem.STRIPPABLES.put(AABlocks.ASH_WOOD.get(), AABlocks.STRIPPED_ASH_WOOD.get());
        AxeItem.STRIPPABLES.put(AABlocks.GOURDROT_LOG.get(), AABlocks.STRIPPED_GOURDROT_LOG.get());
        AxeItem.STRIPPABLES.put(AABlocks.GOURDROT_WOOD.get(), AABlocks.STRIPPED_GOURDROT_WOOD.get());
    }

    public static void registerCompostables() {

        ComposterBlock.COMPOSTABLES.put(AABlocks.ASH_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.GOURDROT_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.HANGING_ASH_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.ASH_SAPLING.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.GOURDROT_SAPLING.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.PORESHROOM_SHELF.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.PORESHROOM.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.FOXFIRE_SHELF.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.FOXFIRE_MUSHROOM.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.CATSBANE.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.MOSS_CLUMP.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(AABlocks.CURVED_MANGROVE_ROOTS.get(), 0.65F);

    }
}