package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.blocks.*;
import net.sheddmer.abundant_atmosphere.world.gen.features.generator.AshTreeGenerator;
import net.sheddmer.abundant_atmosphere.world.gen.features.generator.GourdrotTreeGenerator;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AABlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AbundantAtmosphere.MODID);

    // Natural blocks
    public static final RegistryObject<Block> MOSSY_STONE = registerBlock("mossy_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_DEEPSLATE = registerBlock("mossy_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> ASH_LOG = registerBlock("ash_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_WOOD = registerBlock("ash_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_ASH_LOG = registerBlock("stripped_ash_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_ASH_WOOD = registerBlock("stripped_ash_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_PLANKS = registerBlock("ash_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_SLAB = registerBlock("ash_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_STAIRS = registerBlock("ash_stairs", () -> new StairBlock(ASH_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ASH_DOOR= registerBlock("ash_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_FENCE = registerBlock("ash_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ASH_FENCE_GATE = registerBlock("ash_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ASH_PRESSURE_PLATE = registerBlock("ash_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F, 0.5F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_BUTTON = registerBlock("ash_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F, 0.5F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_TRAPDOOR = registerBlock("ash_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> ASH_SIGN = BLOCKS.register("ash_sign", () -> new AAStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD, ASH_LOG.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), AASignTypes.ASH));
    public static final RegistryObject<Block> ASH_WALL_SIGN = BLOCKS.register("ash_wall_sign", () -> new AAWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD, ASH_LOG.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(ASH_SIGN.get()), AASignTypes.ASH));
    public static final RegistryObject<Block> ASH_LEAVES = registerBlock("ash_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.2F, 0.2F).sound(SoundType.AZALEA_LEAVES)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> HANGING_ASH_LEAVES = registerBlock("hanging_ash_leaves", () -> new HangingLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_ORANGE).strength(0.2F, 0.2F).sound(SoundType.AZALEA_LEAVES)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ASH_SAPLING = registerBlock("ash_sapling", () -> new SaplingBlock(new AshTreeGenerator(), BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_ORANGE).instabreak().noCollission().sound(SoundType.GRASS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_ASH_SAPLING = registerBlockWithoutBlockItem("potted_ash_sapling", () -> new FlowerPotBlock(null, AABlocks.ASH_SAPLING, BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> GOURDROT_LOG = registerBlock("gourdrot_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GOURDROT_WOOD = registerBlock("gourdrot_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GOURDROT_LOG = registerBlock("stripped_gourdrot_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GOURDROT_WOOD = registerBlock("stripped_gourdrot_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 2.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GOURDROT_PLANKS = registerBlock("gourdrot_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GOURDROT_SLAB = registerBlock("gourdrot_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GOURDROT_STAIRS = registerBlock("gourdrot_stairs", () -> new StairBlock(GOURDROT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GOURDROT_DOOR= registerBlock("gourdrot_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GOURDROT_FENCE = registerBlock("gourdrot_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GOURDROT_FENCE_GATE = registerBlock("gourdrot_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GOURDROT_PRESSURE_PLATE = registerBlock("gourdrot_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F, 0.5F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GOURDROT_BUTTON = registerBlock("gourdrot_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F, 0.5F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GOURDROT_TRAPDOOR = registerBlock("gourdrot_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GOURDROT_SIGN = BLOCKS.register("gourdrot_sign", () -> new AAStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD, GOURDROT_LOG.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), AASignTypes.GOURDROT));
    public static final RegistryObject<Block> GOURDROT_WALL_SIGN = BLOCKS.register("gourdrot_wall_sign", () -> new AAWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD, GOURDROT_LOG.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(GOURDROT_SIGN.get()), AASignTypes.GOURDROT));
    public static final RegistryObject<Block> GOURDROT_LEAVES = registerBlock("gourdrot_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.2F, 0.2F).sound(SoundType.AZALEA_LEAVES)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GOURDROT_SAPLING = registerBlock("gourdrot_sapling", () -> new SaplingBlock(new GourdrotTreeGenerator(), BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_ORANGE).instabreak().noCollission().sound(SoundType.GRASS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_GOURDROT_SAPLING = registerBlockWithoutBlockItem("potted_gourdrot_sapling", () -> new FlowerPotBlock(null, AABlocks.GOURDROT_SAPLING, BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> HANGING_MANGROVE_LEAVES = registerBlock("hanging_mangrove_leaves", () -> new HangingLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.2F, 0.2F).sound(SoundType.GRASS)), CreativeModeTab.TAB_DECORATIONS);

    // Deco blocks
    public static final RegistryObject<Block> MIXED_BRICKS = registerBlock("mixed_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MIXED_BRICK_SLAB = registerBlock("mixed_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MIXED_BRICK_STAIRS = registerBlock("mixed_brick_stairs", () -> new StairBlock(MIXED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MIXED_BRICK_WALL = registerBlock("mixed_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs", () -> new StairBlock(POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs", () -> new StairBlock(CALCITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_CALCITE_BRICKS = registerBlock("chiseled_calcite_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).requiresCorrectToolForDrops().strength(0.75F, 0.75F).sound(SoundType.CALCITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs", () -> new StairBlock(POLISHED_DRIPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_WALL = registerBlock("polished_dripstone_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILES = registerBlock("dripstone_tiles", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILE_SLAB = registerBlock("dripstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DRIPSTONE_TILE_STAIRS = registerBlock("dripstone_tile_stairs", () -> new StairBlock(DRIPSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);;
    public static final RegistryObject<Block> DRIPSTONE_TILE_WALL = registerBlock("dripstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.PODZOL).requiresCorrectToolForDrops().strength(1.0F, 1.5F).sound(SoundType.DRIPSTONE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BASALT_BRICKS = registerBlock("basalt_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_BASALT_BRICKS = registerBlock("chiseled_basalt_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLACKSTONE_BASALT_TILES = registerBlock("blackstone_basalt_tiles", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).requiresCorrectToolForDrops().strength(1.5F, 4.5F).sound(SoundType.BASALT)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHISELED_MUD_BRICKS = registerBlock("chiseled_mud_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).requiresCorrectToolForDrops().strength(1.0F, 3.0F).sound(SoundType.MUD_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_PILLAR = registerBlock("deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CHISELED_DEEPSLATE_TILES = registerBlock("chiseled_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE_TILES)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MANGROVE_WEAVE = registerBlock("mangrove_weave", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.7F, 0.7F).sound(SoundType.MANGROVE_ROOTS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MUD_LANTERN = registerBlock("mud_lantern", () -> new MudLanternBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(1.0F, 3.0F).sound(SoundType.MUD_BRICKS).lightLevel(state -> 10)), CreativeModeTab.TAB_DECORATIONS);

    // Pot blocks
    public static final RegistryObject<Block> ANCIENT_POT = registerBlock("ancient_pot", () -> new DeepslatePotBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.5F, 8.0F).sound(SoundType.DEEPSLATE)), CreativeModeTab.TAB_SEARCH);
    public static final RegistryObject<Block> TALL_ANCIENT_POT = registerBlock("tall_ancient_pot", () -> new DoublePotBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.5F, 8.0F).sound(SoundType.DEEPSLATE)), CreativeModeTab.TAB_SEARCH);
    public static final RegistryObject<Block> DEEPSLATE_POT = registerBlock("deepslate_pot", () -> new DeepslatePotBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> TALL_DEEPSLATE_POT = registerBlock("tall_deepslate_pot", () -> new DoublePotBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MUD_POT = registerBlock("mud_pot", () -> new MudPotBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).requiresCorrectToolForDrops().strength(1.0F, 3.0F).sound(SoundType.MUD_BRICKS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CARVED_MUD_POT = registerBlock("carved_mud_pot", () -> new MudPotBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).requiresCorrectToolForDrops().strength(1.0F, 3.0F).sound(SoundType.MUD_BRICKS)), CreativeModeTab.TAB_DECORATIONS);

    // Nature deco blocks
    public static final RegistryObject<Block> PORESHROOM_SHELF = registerBlock("poreshroom_shelf", () -> new PoreshroomShelfBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_ORANGE).instabreak().noCollission().sound(SoundType.FUNGUS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> PORESHROOM = registerBlock("poreshroom", () -> new PoreshroomBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_MAGENTA).instabreak().noCollission().sound(SoundType.FUNGUS), () -> {return TreeFeatures.HUGE_BROWN_MUSHROOM;}), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_PORESHROOM = registerBlockWithoutBlockItem("potted_poreshroom", () -> new FlowerPotBlock(null, AABlocks.PORESHROOM, BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> FOXFIRE_SHELF = registerBlock("foxfire_shelf", () -> new FoxfireShelfBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_MAGENTA).instabreak().noCollission().lightLevel((state) -> state.getValue(FoxfireShelfBlock.UNLIT) ? 0 : 4).sound(SoundType.FUNGUS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FOXFIRE_MUSHROOM = registerBlock("foxfire_mushroom", () -> new FoxfireMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_MAGENTA).instabreak().noCollission().lightLevel((state) -> state.getValue(FoxfireShelfBlock.UNLIT) ? 0 : 5).sound(SoundType.FUNGUS), () -> {return TreeFeatures.HUGE_BROWN_MUSHROOM;}), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_FOXFIRE = registerBlockWithoutBlockItem("potted_foxfire", () -> new FlowerPotBlock(null, AABlocks.FOXFIRE_MUSHROOM, BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> CATSBANE = registerBlock("catsbane", () -> new CatsbaneBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).instabreak().noCollission().sound(SoundType.FUNGUS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_CATSBANE = registerBlockWithoutBlockItem("potted_catsbane", () -> new FlowerPotBlock(null, AABlocks.CATSBANE, BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> CURVED_MANGROVE_ROOTS = registerBlock("curved_mangrove_roots", () -> new CurvedRootsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).instabreak().noCollission().sound(SoundType.MANGROVE_ROOTS)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MOSS_CLUMP = registerBlock("moss_clump", () -> new GlowLichenBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.GRASS).instabreak().noCollission().sound(SoundType.MOSS)), CreativeModeTab.TAB_DECORATIONS);

    // Trophy blocks
    public static final RegistryObject<Block> CENTERPIECE_STATUE = registerBlock("centerpiece_statue", () -> new CenterPieceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(4.0F, 6.0F).sound(SoundType.DEEPSLATE)), CreativeModeTab.TAB_DECORATIONS);


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> block, CreativeModeTab tab) {
        RegistryObject<B> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return AAItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
}
