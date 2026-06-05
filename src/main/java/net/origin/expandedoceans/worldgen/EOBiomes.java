package net.origin.expandedoceans.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.origin.expandedoceans.ExpandedOceans;

public class EOBiomes {
    public static final ResourceKey<Biome> RED_GRASSY_PLATEAUS = registerKey("red_grassy_plateaus");

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(RED_GRASSY_PLATEAUS, redGrassyPlateaus(context));
    }

    private static Biome redGrassyPlateaus(BootstrapContext<Biome> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 5, 4, 6));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 1, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 2, 2, 3));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, context.lookup(Registries.CONFIGURED_CARVER));

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                placedFeatures.getOrThrow(EOPlacedFeatures.RED_SEAGRASS_PATCH_PLACED_KEY));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                placedFeatures.getOrThrow(EOPlacedFeatures.SPARSE_RED_SEAGRASS_PATCH_PLACED_KEY));


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.8F)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(0x43D5EE)
                                .waterFogColor(0x041F33)
                                .fogColor(0xC0D8FF)
                                .skyColor(0x7BA4FF)
                                .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static ResourceKey<Biome> registerKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
    }
}
