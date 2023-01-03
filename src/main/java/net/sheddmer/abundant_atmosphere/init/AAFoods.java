package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.world.food.FoodProperties;

public class AAFoods {

    public static final FoodProperties FROG_LEG = new FoodProperties.Builder().nutrition(3).saturationMod(0.1f).build();
    public static final FoodProperties COOKED_FROG_LEG = new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).build();
    public static final FoodProperties ROASTED_MUSHROOMS = new FoodProperties.Builder().nutrition(5).saturationMod(0.3f).fast().build();

}
