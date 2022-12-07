package net.bunten.lunar.impl.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.bunten.lunar.api.block.HasColorProvider;
import net.bunten.lunar.api.block.HasRenderType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.core.registries.BuiltInRegistries;

@Environment(EnvType.CLIENT)
@Mixin(ItemBlockRenderTypes.class)
public class ItemBlockRenderTypesMixin {

	@Inject(method = "<clinit>*", at = @At("HEAD"))
	private static void onInitialize(CallbackInfo info) {
        BuiltInRegistries.BLOCK.stream().filter(block -> block instanceof HasRenderType).forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, HasRenderType.class.cast(block).getRenderType()));
        BuiltInRegistries.BLOCK.stream().filter(block -> block instanceof HasColorProvider).forEach(block -> ColorProviderRegistry.BLOCK.register(HasColorProvider.class.cast(block).getColorProvider(), block));
	}
}