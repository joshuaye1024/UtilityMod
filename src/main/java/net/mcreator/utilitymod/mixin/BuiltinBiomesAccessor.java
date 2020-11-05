package net.mcreator.utilitymod.mixin;

import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.RegistryKey;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mixin(BuiltinBiomes.class)
public interface BuiltinBiomesAccessor {
	@Accessor("BY_RAW_ID")
	static Int2ObjectMap<RegistryKey<Biome>> getRawIdMap() {
		throw new AssertionError();
	}
}
