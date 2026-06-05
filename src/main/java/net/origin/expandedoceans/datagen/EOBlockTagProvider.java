package net.origin.expandedoceans.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EOBlockTagProvider extends BlockTagsProvider {
    public EOBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExpandedOceans.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EOBlocks.WHITE_SANDSTONE.get())
                .add(EOBlocks.CUT_WHITE_SANDSTONE.get())
                .add(EOBlocks.CHISELED_WHITE_SANDSTONE.get())
                .add(EOBlocks.SMOOTH_WHITE_SANDSTONE.get())
                .add(EOBlocks.WHITE_SANDSTONE_SLAB.get())
                .add(EOBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get())
                .add(EOBlocks.CUT_WHITE_SANDSTONE_SLAB.get())
                .add(EOBlocks.WHITE_SANDSTONE_STAIRS.get())
                .add(EOBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get())
                .add(EOBlocks.WHITE_SANDSTONE_WALL.get())
        ;

        tag(BlockTags.NEEDS_STONE_TOOL)

        ;

        tag(BlockTags.NEEDS_IRON_TOOL)

        ;

        tag(BlockTags.BEACON_BASE_BLOCKS)

        ;

        tag(BlockTags.SAND).add(EOBlocks.WHITE_SAND.get());

        tag(BlockTags.FENCES)
                .add(EOBlocks.OCEAN_WILLOW_FENCE.get())
                .add(EOBlocks.WATER_MAPLE_FENCE.get())
        ;

        tag(BlockTags.FENCE_GATES)
                .add(EOBlocks.OCEAN_WILLOW_FENCE_GATE.get())
                .add(EOBlocks.WATER_MAPLE_FENCE_GATE.get())
        ;

        this.tag(BlockTags.LOGS)
                .add(EOBlocks.OCEAN_WILLOW_LOG.get())
                .add(EOBlocks.OCEAN_WILLOW_WOOD.get())
                .add(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.get())
                .add(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get())

                .add(EOBlocks.WATER_MAPLE_LOG.get())
                .add(EOBlocks.WATER_MAPLE_WOOD.get())
                .add(EOBlocks.STRIPPED_WATER_MAPLE_LOG.get())
                .add(EOBlocks.STRIPPED_WATER_MAPLE_WOOD.get());

    }
}
