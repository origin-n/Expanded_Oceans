package net.origin.expandedoceans.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;

import java.util.List;

public class EOPlacedFeatures {
    public static final ResourceKey<PlacedFeature> RED_SEAGRASS_PATCH_PLACED_KEY = registerKey("red_seagrass_patch");
    public static final ResourceKey<PlacedFeature> SPARSE_RED_SEAGRASS_PATCH_PLACED_KEY = registerKey("sparse_red_seagrass_patch");
    public static final ResourceKey<PlacedFeature> RED_SEAGRASS_PATCH_BONEMEAL_KEY = registerKey("red_seagrass_bonemeal");

    public static final ResourceKey<PlacedFeature> OCEAN_WILLOW_PLACED_KEY = registerKey("ocean_willow_placed");

    public static List<PlacementModifier> oceanTreePlacement(
            PlacementModifier count,
            Block sapling) {

        return List.of(
                count,
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome(),

                BlockPredicateFilter.forPredicate(
                        BlockPredicate.wouldSurvive(
                                sapling.defaultBlockState(),
                                BlockPos.ZERO
                        )
                )
        );
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> redSeagrassPatch = configuredFeatures.getOrThrow(EOConfiguredFeatures.RED_SEAGRASS_PATCH_KEY);

        register(context, RED_SEAGRASS_PATCH_PLACED_KEY, redSeagrassPatch, List.of(
                NoiseBasedCountPlacement.of(2, 80.0D, 0.25D),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome()));
        register(context, RED_SEAGRASS_PATCH_BONEMEAL_KEY, redSeagrassPatch, List.of());
        register(context, SPARSE_RED_SEAGRASS_PATCH_PLACED_KEY, configuredFeatures.getOrThrow(EOConfiguredFeatures.SPARSE_RED_SEAGRASS_PATCH_KEY), List.of(
                NoiseBasedCountPlacement.of(2, 80.0D, 0.25D),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome()));

        register(context, OCEAN_WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(EOConfiguredFeatures.OCEAN_WILLOW_KEY),
                oceanTreePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        EOBlocks.OCEAN_WILLOW_SAPLING.get()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
