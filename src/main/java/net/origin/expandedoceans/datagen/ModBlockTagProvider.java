package net.origin.expandedoceans.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;
import net.origin.expandedoceans.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExpandedOceans.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)

        ;

        tag(BlockTags.NEEDS_STONE_TOOL)

        ;

        tag(BlockTags.NEEDS_IRON_TOOL)

        ;

        tag(BlockTags.BEACON_BASE_BLOCKS)

        ;

        tag(BlockTags.FENCES)
                .add(ModBlocks.OCEAN_WILLOW_FENCE.get())
        ;

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.OCEAN_WILLOW_FENCE_GATE.get())
        ;

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.OCEAN_WILLOW_LOG.get())
                .add(ModBlocks.OCEAN_WILLOW_WOOD.get())
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.get())
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get())

                .add(ModBlocks.WATER_MAPLE_LOG.get())
                .add(ModBlocks.WATER_MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_WOOD.get());

    }
}
