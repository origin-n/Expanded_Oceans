package net.origin.expandedoceans.worldgen;

import dev.worldgen.lithostitched.api.event.AddBiomeInjectorsEvent;
import dev.worldgen.lithostitched.api.event.AddRegionsEvent;
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.BiomeInjector;
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.ParameterBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.origin.expandedoceans.ExpandedOceans;

public class EOLithostiched {
    public static void init(){

        AddBiomeInjectorsEvent.EVENT.register((registries, consumer) -> {
            var biomeRegistry = registries.registryOrThrow(Registries.BIOME);

            consumer.accept(ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, "red_grassy_plateaus"),
                    BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                            biomeRegistry.getHolderOrThrow(Biomes.LUKEWARM_OCEAN),
                            biomeRegistry.getHolderOrThrow(ModBiomes.RED_GRASSY_PLATEAUS
                            ), ParameterBuilder.create()
                    ));
                }
        );
    }
}
