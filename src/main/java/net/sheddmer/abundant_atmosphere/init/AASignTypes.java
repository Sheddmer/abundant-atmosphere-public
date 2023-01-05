package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

public class AASignTypes {

    public static final WoodType ASH = WoodType.register(new WoodType(AbundantAtmosphere.MODID + ":ash"));
    public static final WoodType GOURDROT = WoodType.register(new WoodType(AbundantAtmosphere.MODID + ":gourdrot"));

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        Sheets.addWoodType(ASH);
        Sheets.addWoodType(GOURDROT);
    }

}