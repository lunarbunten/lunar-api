package net.bunten.lunar.api.registry;

import java.util.Objects;

import net.bunten.lunar.api.loot.LootInjection;
import net.bunten.lunar.impl.LootInjectionImpl;

public class LootInjections {

    public static void register(LootInjection injection) {
        Objects.requireNonNull(injection);
        LootInjectionImpl.INJECTIONS.add(injection);
	}
}