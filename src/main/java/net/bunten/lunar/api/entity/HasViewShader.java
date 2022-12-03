package net.bunten.lunar.api.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;

public interface HasViewShader {

    @Environment(value=EnvType.CLIENT)
    public ResourceLocation getViewShaderLocation();
}