package net.bunten.lunar.impl.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.bunten.lunar.api.registry.SoundTypeModificationRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(Block.class)
public abstract class ModifyBlockSounds extends BlockBehaviour {
    public ModifyBlockSounds(Properties settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "getSoundType", cancellable = true)
    public void getSoundType(BlockState state, CallbackInfoReturnable<SoundType> info) {
        SoundType type = SoundTypeModificationRegistry.getSoundType((Block) (Object) this);
        if (type != null) info.setReturnValue(type);
    }
}