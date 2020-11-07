
package net.mcreator.utilitymod.world;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Identifier;
import net.minecraft.block.Blocks;

import net.mcreator.utilitymod.mixin.VanillaLayeredBiomeSourceAccessor;
import net.mcreator.utilitymod.mixin.SetBaseBiomesLayerAccessor;
import net.mcreator.utilitymod.mixin.BuiltinBiomesAccessor;
import net.mcreator.utilitymod.UtilitymodMod;

import java.util.List;
import java.util.ArrayList;

public class TestBiomeBiome {
	private static Biome theBiome;
	private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> SURFACE_BUILDER = SurfaceBuilder.DEFAULT
			.method_30478(new TernarySurfaceConfig(Blocks.DIAMOND_ORE.getDefaultState(), UtilitymodMod.TestPortalBlock_BLOCK.getDefaultState(),
					UtilitymodMod.TestPortalBlock_BLOCK.getDefaultState()));
	public static final RegistryKey<Biome> BIOME_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("utilitymod", "test_biome"));
	public static void init() {
		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, BIOME_KEY.getValue(), SURFACE_BUILDER);
		BiomeEffects.Builder effectsBuilder = new BiomeEffects.Builder();
		effectsBuilder.waterColor(-16724788).waterFogColor(-16724788);
		effectsBuilder.skyColor(-13382401).fogColor(-13382401);
		effectsBuilder.grassColor(-6723841).foliageColor(-6723841);
		GenerationSettings.Builder genSettingsBuilder = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addDefaultOres(genSettingsBuilder);
		DefaultBiomeFeatures.addLandCarvers(genSettingsBuilder);
		DefaultBiomeFeatures.addDungeons(genSettingsBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundStructures(genSettingsBuilder);
		DefaultBiomeFeatures.addDefaultLakes(genSettingsBuilder);
		DefaultBiomeFeatures.addDefaultFlowers(genSettingsBuilder);
		DefaultBiomeFeatures.addDefaultGrass(genSettingsBuilder);
		genSettingsBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PLAIN_VEGETATION);
		genSettingsBuilder.surfaceBuilder(SURFACE_BUILDER);
		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		Biome.Builder biomeBuilder = new Biome.Builder();
		biomeBuilder.effects(effectsBuilder.build());
		biomeBuilder.generationSettings(genSettingsBuilder.build());
		biomeBuilder.spawnSettings(spawnBuilder.build());
		biomeBuilder.temperatureModifier(Biome.TemperatureModifier.NONE);
		biomeBuilder.temperature(0.5F);
		biomeBuilder.downfall(0.5F);
		biomeBuilder.depth(0.3F);
		biomeBuilder.scale(1.5F);
		biomeBuilder.category(Biome.Category.NONE);
		biomeBuilder.precipitation(Biome.Precipitation.RAIN);
		theBiome = biomeBuilder.build();
		Registry.register(BuiltinRegistries.BIOME, BIOME_KEY.getValue(), theBiome);
		BuiltinBiomesAccessor.getRawIdMap().put(BuiltinRegistries.BIOME.getRawId(theBiome), BIOME_KEY);
		List<RegistryKey<Biome>> biomes = new ArrayList<>(VanillaLayeredBiomeSourceAccessor.getBiomes());
		biomes.add(BIOME_KEY);
		VanillaLayeredBiomeSourceAccessor.setBiomes(biomes);
		SetBaseBiomesLayerAccessor
				.setTemperateBiomes(ArrayUtils.add(SetBaseBiomesLayerAccessor.getTemperateBiomes(), BuiltinRegistries.BIOME.getRawId(theBiome)));
	}

	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}
}
