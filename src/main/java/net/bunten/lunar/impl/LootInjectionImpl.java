package net.bunten.lunar.impl;

import java.util.ArrayList;
import java.util.List;

import net.bunten.lunar.api.loot.LootInjection;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;

public class LootInjectionImpl {
    
    public static final List<LootInjection> INJECTIONS = new ArrayList<>();

    private static void addInjection(LootTable.Builder builder, ResourceLocation location) {
        builder.pool(LootPool.lootPool().add(LootTableReference.lootTableReference(location).setWeight(1).setQuality(0)).build());
    }

    static {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, location, builder, source) -> {
            INJECTIONS.stream().filter((injection) -> injection.applies(location)).forEach((injection) -> addInjection(builder, injection.injectedTable()));
        });
    }
}