package net.bunten.lunar.api.registry;

import java.util.Objects;

import net.bunten.lunar.api.block.SoundTypeModification;
import net.bunten.lunar.impl.SoundTypeModificationImpl;

public class SoundTypeModifications {

	public static void register(SoundTypeModification modification) {
		Objects.requireNonNull(modification);
		SoundTypeModificationImpl.MODIFICATIONS.add(modification);
	}
}