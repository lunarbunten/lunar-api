package net.bunten.lunar.impl.mixin;

import net.bunten.lunar.impl.SoundTypeModificationImpl;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class ModifyBlockSounds extends BlockBehaviour {
    public ModifyBlockSounds(Properties settings) {
        super(settings);
    }

    @Unique
    private final Block block = (Block) (Object) this;

    @Inject(at = @At("HEAD"), method = "getSoundType", cancellable = true)
    public void getSoundType(BlockState state, CallbackInfoReturnable<SoundType> info) {
        SoundType type = SoundTypeModificationImpl.getSoundType(state);
        if (type != null) info.setReturnValue(type);
    }
}