package net.origin.expandedoceans.datagen;

import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.worldgen.*;
import net.origin.expandedoceans.worldgen.biomes.EOBiomes;
import net.origin.expandedoceans.worldgen.biomes.EOWorldgenModifiers;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EODatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()

            .add(Registries.CONFIGURED_FEATURE, EOConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, EOPlacedFeatures::bootstrap)
            .add(Registries.BIOME, EOBiomes::bootstrap)
            .add(LithostitchedRegistries.WORLDGEN_MODIFIER, EOWorldgenModifiers::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, EOBiomeModifiers::bootstrap)
            ;


    public EODatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ExpandedOceans.MOD_ID));
    }
}
