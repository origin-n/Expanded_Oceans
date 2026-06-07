package net.origin.expandedoceans.worldgen.custom_features.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOSeagrassConfig;

public class EOSeagrassFeature extends Feature<EOSeagrassConfig> {
    public EOSeagrassFeature(Codec<EOSeagrassConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<EOSeagrassConfig> context) {
        boolean placedAny = false;

        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        EOSeagrassConfig config = context.config();

        for (int attempt = 0; attempt < config.patchAttempts(); attempt++) {

            int xOffset =
                    random.nextInt(config.patchRadius() * 2 + 1)
                            - config.patchRadius();
            int zOffset =
                    random.nextInt(config.patchRadius() * 2 + 1)
                            - config.patchRadius();
            int floorY = level.getHeight(
                    Heightmap.Types.OCEAN_FLOOR,
                    origin.getX() + xOffset,
                    origin.getZ() + zOffset);

            BlockPos pos = new BlockPos(
                    origin.getX() + xOffset,
                    floorY,
                    origin.getZ() + zOffset);

            if (!level.getBlockState(pos).is(Blocks.WATER)) {
                continue;
            }

            boolean tall =
                    random.nextDouble() < config.probability();

            BlockState state =
                    tall
                            ? config.tallSeagrass().getState(random, pos)
                            : config.shortSeagrass().getState(random, pos);

            if (!state.canSurvive(level, pos)) {
                continue;
            }

            if (tall) {
                BlockPos upperPos = pos.above();

                if (!level.getBlockState(upperPos).is(Blocks.WATER)) {
                    continue;
                }

                BlockState upperState =
                        state.setValue(
                                TallSeagrassBlock.HALF,
                                DoubleBlockHalf.UPPER
                        );

                level.setBlock(pos, state, 2);
                level.setBlock(upperPos, upperState, 2);
            } else {
                level.setBlock(pos, state, 2);
            }

            placedAny = true;
        }

        return placedAny;
    }
}
