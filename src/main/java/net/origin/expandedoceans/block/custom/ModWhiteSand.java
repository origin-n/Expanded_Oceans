package net.origin.expandedoceans.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluids;
import net.origin.expandedoceans.worldgen.ModPlacedFeatures;

public class ModWhiteSand extends Block implements BonemealableBlock {
    public ModWhiteSand(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        Holder<PlacedFeature> feature = level.registryAccess()
                .registryOrThrow(Registries.PLACED_FEATURE)
                .getHolderOrThrow(ModPlacedFeatures.RED_SEAGRASS_PATCH_BONEMEAL_KEY);

        if (level.getBlockState(pos.above()).getFluidState().is(Fluids.WATER)) {
            feature.value().place(level, level.getChunkSource().getGenerator(), random, pos.above());
            System.out.println("Spawned red seagrass patch via bonemeal at " + pos);
        }
    }
}

//    @Override
//    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
//        if (level.getFluidState(pos.above()).is(Fluids.WATER) && level.getBlockState(pos.above()).getBlock() == Blocks.WATER) {
//            level.setBlock(pos.above(), ModBlocks.RED_SEAGRASS.get().defaultBlockState(), 3);
//        }
//    }

