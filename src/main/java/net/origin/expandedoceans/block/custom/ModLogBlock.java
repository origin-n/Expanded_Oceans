package net.origin.expandedoceans.block.custom;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.origin.expandedoceans.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class ModLogBlock extends RotatedPillarBlock {
    public ModLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {

        if(context.getItemInHand().getItem() instanceof AxeItem){
            Block blockClicked = state.getBlock();
            if(ModBlocks.STRIPPABLES.containsKey(blockClicked)){
                Block strippedBlock = ModBlocks.STRIPPABLES.get(blockClicked);
                return strippedBlock.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
