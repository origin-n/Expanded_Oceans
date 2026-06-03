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
import net.origin.expandedoceans.block.ModBlocks;
import net.origin.expandedoceans.worldgen.custom_features.ModFeatures;
import net.origin.expandedoceans.worldgen.custom_features.configuration.ModSeagrassConfiguration;
import net.origin.expandedoceans.worldgen.tree.trunk.ModForkingTrunkPlacer;
import net.origin.expandedoceans.worldgen.tree.trunk.ModStraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OCEAN_WILLOW_KEY = registerKey("ocean_willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_MAPLE_KEY = registerKey("water_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SEAGRASS_PATCH_KEY = registerKey("red_seagrass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_RED_SEAGRASS_PATCH_KEY = registerKey("sparse_red_seagrass_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, OCEAN_WILLOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.OCEAN_WILLOW_LOG.get()),
                new ModStraightTrunkPlacer(3, 3, 2),

                BlockStateProvider.simple(ModBlocks.OCEAN_WILLOW_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, WATER_MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WATER_MAPLE_LOG.get()),
                new ModForkingTrunkPlacer(2, 2, 1),

                BlockStateProvider.simple(ModBlocks.WATER_MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, RED_SEAGRASS_PATCH_KEY, ModFeatures.MOD_SEAGRASS_FEATURE.get(), new ModSeagrassConfiguration(
                0.3f, 4, 40,
                BlockStateProvider.simple(ModBlocks.RED_SEAGRASS.get()),
                BlockStateProvider.simple(ModBlocks.TALL_RED_SEAGRASS.get())));

        register(context, SPARSE_RED_SEAGRASS_PATCH_KEY, ModFeatures.MOD_SEAGRASS_FEATURE.get(), new ModSeagrassConfiguration(
                0.3f, 4, 10,
                BlockStateProvider.simple(ModBlocks.RED_SEAGRASS.get()),
                BlockStateProvider.simple(ModBlocks.TALL_RED_SEAGRASS.get())));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
