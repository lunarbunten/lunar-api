package net.bunten.lunar.impl;

import net.bunten.lunar.api.block.HasColorProvider;
import net.bunten.lunar.api.block.HasRenderType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.core.Registry;

public class LunarClientEntry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Registry.BLOCK.stream().filter(block -> block instanceof HasRenderType).forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, HasRenderType.class.cast(block).getRenderType()));
        Registry.BLOCK.stream().filter(block -> block instanceof HasColorProvider).forEach(block -> ColorProviderRegistry.BLOCK.register(HasColorProvider.class.cast(block).getColorProvider(), block));
    }
}