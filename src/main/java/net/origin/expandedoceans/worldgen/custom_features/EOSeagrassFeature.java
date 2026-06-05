package net.origin.expandedoceans.worldgen.custom_features;

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
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOSeagrassConfiguration;

public class EOSeagrassFeature extends Feature<EOSeagrassConfiguration> {
    public EOSeagrassFeature(Codec<EOSeagrassConfiguration> p_66768_) {
        super(p_66768_);
    }

    @Override
    public boolean place(FeaturePlaceContext<EOSeagrassConfiguration> context) {
        boolean placedAny = false;

        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        EOSeagrassConfiguration config = context.config();

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
                    origin.getZ() + zOffset
            );

            BlockPos pos = new BlockPos(
                    origin.getX() + xOffset,
                    floorY,
                    origin.getZ() + zOffset
            );

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
//        boolean flag = false;
//        RandomSource randomsource = p_160318_.random();
//        WorldGenLevel worldgenlevel = p_160318_.level();
//        BlockPos blockpos = p_160318_.origin();
//        EOSeagrassConfiguration seagrassfeatureconfiguration = p_160318_.config();
////        int i = randomsource.nextInt(8) - randomsource.nextInt(8);
////        int j = randomsource.nextInt(8) - randomsource.nextInt(8);
////        int k = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR, blockpos.getX() + i, blockpos.getZ() + j);
////        BlockPos blockpos1 = new BlockPos(blockpos.getX() + i, k, blockpos.getZ() + j);
//        BlockPos blockpos1 = blockpos;
//        if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER)) {
//            boolean flag1 = randomsource.nextDouble() < (double)seagrassfeatureconfiguration.probability();
//            BlockState blockstate = flag1 ? seagrassfeatureconfiguration.tallSeagrass().getState(randomsource, blockpos1)
//                    : seagrassfeatureconfiguration.shortSeagrass().getState(randomsource, blockpos1);
//            if (blockstate.canSurvive(worldgenlevel, blockpos1)) {
//                if (flag1) {
//                    BlockState blockstate1 = blockstate.setValue(TallSeagrassBlock.HALF, DoubleBlockHalf.UPPER);
//                    BlockPos blockpos2 = blockpos1.above();
//                    if (worldgenlevel.getBlockState(blockpos2).is(Blocks.WATER)) {
//                        worldgenlevel.setBlock(blockpos1, blockstate, 2);
//                        worldgenlevel.setBlock(blockpos2, blockstate1, 2);
//                    }
//                } else {
//                    worldgenlevel.setBlock(blockpos1, blockstate, 2);
//                }
//
//                flag = true;
//            }
//        }
//
//        return flag;


}
