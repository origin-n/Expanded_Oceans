package net.origin.expandedoceans.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;
import net.origin.expandedoceans.worldgen.custom_features.EOFeatures;
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOSeagrassConfiguration;
import net.origin.expandedoceans.worldgen.tree.trunk.EOForkingTrunkPlacer;
import net.origin.expandedoceans.worldgen.tree.trunk.EOStraightTrunkPlacer;

public class EOConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OCEAN_WILLOW_KEY = registerKey("ocean_willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_MAPLE_KEY = registerKey("water_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SEAGRASS_PATCH_KEY = registerKey("red_seagrass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_RED_SEAGRASS_PATCH_KEY = registerKey("sparse_red_seagrass_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, OCEAN_WILLOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EOBlocks.OCEAN_WILLOW_LOG.get()),
                new EOStraightTrunkPlacer(3, 3, 2),

                BlockStateProvider.simple(EOBlocks.OCEAN_WILLOW_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, WATER_MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EOBlocks.WATER_MAPLE_LOG.get()),
                new EOForkingTrunkPlacer(2, 2, 1),

                BlockStateProvider.simple(EOBlocks.WATER_MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, RED_SEAGRASS_PATCH_KEY, EOFeatures.MOD_SEAGRASS_FEATURE.get(), new EOSeagrassConfiguration(
                0.3f, 4, 40,
                BlockStateProvider.simple(EOBlocks.RED_SEAGRASS.get()),
                BlockStateProvider.simple(EOBlocks.TALL_RED_SEAGRASS.get())));

        register(context, SPARSE_RED_SEAGRASS_PATCH_KEY, EOFeatures.MOD_SEAGRASS_FEATURE.get(), new EOSeagrassConfiguration(
                0.3f, 4, 10,
                BlockStateProvider.simple(EOBlocks.RED_SEAGRASS.get()),
                BlockStateProvider.simple(EOBlocks.TALL_RED_SEAGRASS.get())));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
