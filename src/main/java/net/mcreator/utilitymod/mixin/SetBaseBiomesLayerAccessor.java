package net.mcreator.utilitymod.mixin;

import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.biome.layer.SetBaseBiomesLayer;

@Mixin(SetBaseBiomesLayer.class)
public interface SetBaseBiomesLayerAccessor {
	@Accessor("TEMPERATE_BIOMES")
	static int[] getTemperateBiomes() {
		throw new AssertionError();
	}

	@Accessor("TEMPERATE_BIOMES")
	static void setTemperateBiomes(int[] biomes) {
		throw new AssertionError();
	}
}
