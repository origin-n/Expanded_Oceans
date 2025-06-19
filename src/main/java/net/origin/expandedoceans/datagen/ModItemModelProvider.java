package net.origin.expandedoceans.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExpandedOceans.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        saplingItem(ModBlocks.OCEAN_WILLOW_SAPLING);

    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID,"block/" + item.getId().getPath()));
    }
}
