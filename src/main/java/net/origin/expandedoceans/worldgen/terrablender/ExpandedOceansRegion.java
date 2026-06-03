package net.origin.expandedoceans.worldgen.terrablender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.worldgen.ModBiomes;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class ExpandedOceansRegion extends Region {

    public ExpandedOceansRegion() {
        super(
                ResourceLocation.fromNamespaceAndPath(
                        ExpandedOceans.MOD_ID,
                        "overworld"
                ),
                RegionType.OVERWORLD,
                3
        );
    }

    public static void register() {
        ExpandedOceans.LOGGER.info("Registering TerraBlender Region");
        Regions.register(new ExpandedOceansRegion());
    }

    @Override
    public void addBiomes(
            Registry<Biome> registry,
            Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {

        VanillaParameterOverlayBuilder builder =
                new VanillaParameterOverlayBuilder();
                new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.OCEAN, Continentalness.DEEP_OCEAN)
                .erosion(Erosion.EROSION_3)
                .depth(Depth.SURFACE)
                .weirdness(
                        Weirdness.MID_SLICE_NORMAL_ASCENDING,
                        Weirdness.MID_SLICE_NORMAL_DESCENDING
                )
                .build()
                .forEach(point ->
                        builder.add(
                                point,
                                ModBiomes.RED_GRASSY_PLATEAUS
                        ));

        builder.build().forEach(mapper);
    }
}