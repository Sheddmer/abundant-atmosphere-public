package net.sheddmer.abundant_atmosphere.util;

import net.minecraft.world.level.block.state.properties.WoodType;

public class AASignType extends WoodType {
    private final String id;

    public AASignType(String name) {
        super(name);
        this.id = name;
    }

    public String getId() {
        return this.id;
    }

}