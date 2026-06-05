package net.origin.expandedoceans.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;
import net.origin.expandedoceans.util.EOTags;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class EOItemTagProvider extends ItemTagsProvider {
    public EOItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ExpandedOceans.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.PLANKS)
                .add(EOBlocks.OCEAN_WILLOW_PLANKS.asItem())
                .add(EOBlocks.WATER_MAPLE_PLANKS.asItem());

        this.tag(ItemTags.LOGS)
                .add(EOBlocks.OCEAN_WILLOW_LOG.asItem())
                .add(EOBlocks.OCEAN_WILLOW_WOOD.asItem())
                .add(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.asItem())
                .add(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD.asItem())

                .add(EOBlocks.WATER_MAPLE_LOG.asItem())
                .add(EOBlocks.WATER_MAPLE_WOOD.asItem())
                .add(EOBlocks.STRIPPED_WATER_MAPLE_LOG.asItem())
                .add(EOBlocks.STRIPPED_WATER_MAPLE_WOOD.asItem());

        this.tag(EOTags.Items.OCEAN_WILLOW_LOGS)
                .add(EOBlocks.OCEAN_WILLOW_LOG.asItem())
                .add(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.asItem())
                .add(EOBlocks.OCEAN_WILLOW_WOOD.asItem())
                .add(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD.asItem())
            ;

        this.tag(EOTags.Items.WATER_MAPLE_LOGS)
                .add(EOBlocks.WATER_MAPLE_LOG.asItem())
                .add(EOBlocks.WATER_MAPLE_WOOD.asItem())
                .add(EOBlocks.STRIPPED_WATER_MAPLE_LOG.asItem())
                .add(EOBlocks.STRIPPED_WATER_MAPLE_WOOD.asItem())
            ;


    }
}
