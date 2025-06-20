package net.origin.expandedoceans.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ExpandedOceans.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.OCEAN_WILLOW_PLANKS.asItem())
                .add(ModBlocks.WATER_MAPLE_PLANKS.asItem());

        this.tag(ItemTags.LOGS)
                .add(ModBlocks.OCEAN_WILLOW_LOG.asItem())
                .add(ModBlocks.OCEAN_WILLOW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.asItem())
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD.asItem())

                .add(ModBlocks.WATER_MAPLE_LOG.asItem())
                .add(ModBlocks.WATER_MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_WOOD.asItem());


    }
}
