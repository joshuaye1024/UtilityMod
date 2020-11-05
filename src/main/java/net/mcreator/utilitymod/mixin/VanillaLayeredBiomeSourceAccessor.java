package net.mcreator.utilitymod.mixin;

import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.RegistryKey;

import java.util.List;

@Mixin(VanillaLayeredBiomeSource.class)
public interface VanillaLayeredBiomeSourceAccessor {
	@Accessor("BIOMES")
	static List<RegistryKey<Biome>> getBiomes() {
		throw new AssertionError();
	}

	@Accessor("BIOMES")
	static void setBiomes(List<RegistryKey<Biome>> biomes) {
		throw new AssertionError();
	}
}
