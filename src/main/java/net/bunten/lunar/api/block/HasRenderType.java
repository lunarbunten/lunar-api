package net.bunten.lunar.api.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;

public interface HasRenderType {

    @Environment(EnvType.CLIENT)
    RenderType getRenderType();
}