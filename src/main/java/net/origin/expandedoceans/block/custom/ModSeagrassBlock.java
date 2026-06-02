package net.origin.expandedoceans.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.origin.expandedoceans.block.ModBlocks;

public class ModSeagrassBlock extends SeagrassBlock {
    public ModSeagrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        Block blockClicked = blockState.getBlock();
        if(ModBlocks.BONEMEAL_RESULT.containsKey(blockClicked)) {
            BlockState blockstate = ModBlocks.BONEMEAL_RESULT.get(blockClicked).defaultBlockState();
            BlockState blockstate1 = blockstate.setValue(TallSeagrassBlock.HALF, DoubleBlockHalf.UPPER);
            BlockPos blockpos = blockPos.above();
            if (serverLevel.getBlockState(blockpos).is(Blocks.WATER)) {
                serverLevel.setBlock(blockPos, blockstate, 2);
                serverLevel.setBlock(blockpos, blockstate1, 2);
            }
        }
    }
}
