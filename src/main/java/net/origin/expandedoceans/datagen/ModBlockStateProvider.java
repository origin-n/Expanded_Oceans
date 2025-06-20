package net.origin.expandedoceans.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExpandedOceans.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(((RotatedPillarBlock) ModBlocks.OCEAN_WILLOW_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.OCEAN_WILLOW_WOOD.get()), blockTexture(ModBlocks.OCEAN_WILLOW_LOG.get()), blockTexture(ModBlocks.OCEAN_WILLOW_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get()), blockTexture(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.get()), blockTexture(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.get()));

        blockItem(ModBlocks.OCEAN_WILLOW_LOG);
        blockItem(ModBlocks.OCEAN_WILLOW_WOOD);
        blockItem(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        blockItem(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD);

        blockWithItem(ModBlocks.OCEAN_WILLOW_PLANKS);

        leavesBlock(ModBlocks.OCEAN_WILLOW_LEAVES);
        saplingBlock(ModBlocks.OCEAN_WILLOW_SAPLING);


        logBlock(((RotatedPillarBlock) ModBlocks.WATER_MAPLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.WATER_MAPLE_WOOD.get()), blockTexture(ModBlocks.WATER_MAPLE_LOG.get()), blockTexture(ModBlocks.WATER_MAPLE_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WATER_MAPLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WATER_MAPLE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_WATER_MAPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_WATER_MAPLE_LOG.get()));

        blockItem(ModBlocks.WATER_MAPLE_LOG);
        blockItem(ModBlocks.WATER_MAPLE_WOOD);
        blockItem(ModBlocks.STRIPPED_WATER_MAPLE_LOG);
        blockItem(ModBlocks.STRIPPED_WATER_MAPLE_WOOD);

        blockWithItem(ModBlocks.WATER_MAPLE_PLANKS);

        leavesBlock(ModBlocks.WATER_MAPLE_LEAVES);
        saplingBlock(ModBlocks.WATER_MAPLE_SAPLING);
    }
    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("expandedoceans:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("expandedoceans:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
