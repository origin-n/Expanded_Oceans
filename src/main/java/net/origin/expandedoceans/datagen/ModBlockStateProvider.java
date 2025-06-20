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

        stairsBlock(ModBlocks.OCEAN_WILLOW_STAIRS.get(), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()));
        slabBlock(ModBlocks.OCEAN_WILLOW_SLAB.get(), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()));
        buttonBlock(ModBlocks.OCEAN_WILLOW_BUTTON.get(), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()));
        pressurePlateBlock(ModBlocks.OCEAN_WILLOW_PRESSURE_PLATE.get(), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()));
        fenceBlock(ModBlocks.OCEAN_WILLOW_FENCE.get(), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()));
        fenceGateBlock(ModBlocks.OCEAN_WILLOW_FENCE_GATE.get(), blockTexture(ModBlocks.OCEAN_WILLOW_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.OCEAN_WILLOW_DOOR.get(), modLoc("block/ocean_willow_door_bottom"), modLoc("block/ocean_willow_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.OCEAN_WILLOW_TRAPDOOR.get(), modLoc("block/ocean_willow_trapdoor"), true, "cutout");

        blockItem(ModBlocks.OCEAN_WILLOW_STAIRS);
        blockItem(ModBlocks.OCEAN_WILLOW_SLAB);
        blockItem(ModBlocks.OCEAN_WILLOW_PRESSURE_PLATE);
        blockItem(ModBlocks.OCEAN_WILLOW_FENCE_GATE);
        blockItem(ModBlocks.OCEAN_WILLOW_TRAPDOOR, "_bottom");


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

        stairsBlock(ModBlocks.WATER_MAPLE_STAIRS.get(), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()));
        slabBlock(ModBlocks.WATER_MAPLE_SLAB.get(), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()));
        buttonBlock(ModBlocks.WATER_MAPLE_BUTTON.get(), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()));
        pressurePlateBlock(ModBlocks.WATER_MAPLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()));
        fenceBlock(ModBlocks.WATER_MAPLE_FENCE.get(), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()));
        fenceGateBlock(ModBlocks.WATER_MAPLE_FENCE_GATE.get(), blockTexture(ModBlocks.WATER_MAPLE_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.WATER_MAPLE_DOOR.get(), modLoc("block/water_maple_door_bottom"), modLoc("block/water_maple_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.WATER_MAPLE_TRAPDOOR.get(), modLoc("block/water_maple_trapdoor"), true, "cutout");

        blockItem(ModBlocks.WATER_MAPLE_STAIRS);
        blockItem(ModBlocks.WATER_MAPLE_SLAB);
        blockItem(ModBlocks.WATER_MAPLE_PRESSURE_PLATE);
        blockItem(ModBlocks.WATER_MAPLE_FENCE_GATE);
        blockItem(ModBlocks.WATER_MAPLE_TRAPDOOR, "_bottom");
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
