package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.entities.AABoatEntity;
import net.sheddmer.abundant_atmosphere.item.AABoatItem;


@Mod.EventBusSubscriber(modid = AbundantAtmosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AAItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AbundantAtmosphere.MODID);

    public static final RegistryObject<Item> HIDE = ITEMS.register("hide", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ANCIENT_AMBER = ITEMS.register("ancient_amber", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> FROG_LEG = ITEMS.register("frog_leg", () -> new Item(new Item.Properties().food(AAFoods.FROG_LEG).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> COOKED_FROG_LEG = ITEMS.register("cooked_frog_leg", () -> new Item(new Item.Properties().food(AAFoods.COOKED_FROG_LEG).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> ROASTED_MUSHROOMS = ITEMS.register("roasted_mushrooms", () -> new Item(new Item.Properties().food(AAFoods.ROASTED_MUSHROOMS).tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> ASH_SIGN = ITEMS.register("ash_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), AABlocks.ASH_SIGN.get(), AABlocks.ASH_WALL_SIGN.get()));
    public static final RegistryObject<Item> ASH_BOAT = ITEMS.register("ash_boat", () -> new AABoatItem(false, AABoatEntity.BoatType.ASH, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> ASH_CHEST_BOAT = ITEMS.register("ash_chest_boat", () -> new AABoatItem(true, AABoatEntity.BoatType.ASH, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));

    public static final RegistryObject<Item> GOURDROT_SIGN = ITEMS.register("gourdrot_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), AABlocks.GOURDROT_SIGN.get(), AABlocks.GOURDROT_WALL_SIGN.get()));
    public static final RegistryObject<Item> GOURDROT_BOAT = ITEMS.register("gourdrot_boat", () -> new AABoatItem(false, AABoatEntity.BoatType.GOURDROT, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> GOURDROT_CHEST_BOAT = ITEMS.register("gourdrot_chest_boat", () -> new AABoatItem(true, AABoatEntity.BoatType.GOURDROT, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));


    public static RegistryObject<Item> registerBaseItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

}