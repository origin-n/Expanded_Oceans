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

        buttonItem(ModBlocks.OCEAN_WILLOW_BUTTON, ModBlocks.OCEAN_WILLOW_PLANKS);
        fenceItem(ModBlocks.OCEAN_WILLOW_FENCE, ModBlocks.OCEAN_WILLOW_PLANKS);

        basicItem(ModBlocks.OCEAN_WILLOW_DOOR.asItem());

        saplingItem(ModBlocks.WATER_MAPLE_SAPLING);

        buttonItem(ModBlocks.WATER_MAPLE_BUTTON, ModBlocks.WATER_MAPLE_PLANKS);
        fenceItem(ModBlocks.WATER_MAPLE_FENCE, ModBlocks.WATER_MAPLE_PLANKS);

        basicItem(ModBlocks.WATER_MAPLE_DOOR.asItem());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID,"block/" + item.getId().getPath()));
    }
}
