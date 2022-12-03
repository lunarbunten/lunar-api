package net.bunten.lunar.api.loot;

import java.util.function.Predicate;

import net.minecraft.resources.ResourceLocation;

public record LootInjection(ResourceLocation injectedTable, Predicate<ResourceLocation> canModify) {

    public boolean applies(ResourceLocation replaced) {
        return canModify.test(replaced);
    }
}