package net.bunten.lunar.api.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.block.BlockColor;

public interface HasColorProvider {
    
    @Environment(value=EnvType.CLIENT)
    public BlockColor getColorProvider();
}