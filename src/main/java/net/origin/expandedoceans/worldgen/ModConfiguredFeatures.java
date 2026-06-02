package net.origin.expandedoceans.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SeagrassFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OCEAN_WILLOW_KEY = registerKey("ocean_willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_MAPLE_KEY = registerKey("water_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SEAGRASS_PATCH_KEY = registerKey("red_seagrass_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, OCEAN_WILLOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.OCEAN_WILLOW_LOG.get()),
                new StraightTrunkPlacer(3, 3, 2),

                BlockStateProvider.simple(ModBlocks.OCEAN_WILLOW_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, WATER_MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WATER_MAPLE_LOG.get()),
                new ForkingTrunkPlacer(2, 2, 1),

                BlockStateProvider.simple(ModBlocks.WATER_MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, RED_SEAGRASS_PATCH_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(96, 6, 2,
                        Holder.direct(new PlacedFeature(Holder.direct(new ConfiguredFeature<>(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(
                                                SimpleWeightedRandomList.<BlockState>builder()
                                                        .add(ModBlocks.RED_SEAGRASS.get().defaultBlockState(), 4)
                                                        .add(ModBlocks.TALL_RED_SEAGRASS.get().defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 1)
                                                        .build()
                                        )))), List.of()))));

//        register(context, RED_SEAGRASS_PATCH_KEY, Feature.RANDOM_PATCH,
//                FeatureUtils.simpleRandomPatchConfiguration(96, PlacementUtils.onlyWhenEmpty(new ConfiguredFeature<>(
//                                Feature.SIMPLE_BLOCK,
//                                new SimpleBlockConfiguration(
//                                        new WeightedStateProvider(
//                                                SimpleWeightedRandomList.<BlockState>builder()
//                                                        .add(ModBlocks.RED_SEAGRASS.get().defaultBlockState(), 4)
//                                                        .add(ModBlocks.TALL_RED_SEAGRASS.get().defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 1)
//                                                        .build()
//                                        ))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
