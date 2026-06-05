package net.origin.expandedoceans.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;

public class EOBlockStateProvider extends BlockStateProvider {

    public EOBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExpandedOceans.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(EOBlocks.WHITE_SAND);
        cubeBottomTop(EOBlocks.WHITE_SANDSTONE);
        cubeBottomTop(EOBlocks.CUT_WHITE_SANDSTONE, EOBlocks.CUT_WHITE_SANDSTONE.getId().getPath(), EOBlocks.WHITE_SANDSTONE.getId().getPath() + "_top", EOBlocks.WHITE_SANDSTONE.getId().getPath() + "_top");
        cubeBottomTop(EOBlocks.CHISELED_WHITE_SANDSTONE, EOBlocks.CHISELED_WHITE_SANDSTONE.getId().getPath(), EOBlocks.WHITE_SANDSTONE.getId().getPath() + "_top", EOBlocks.WHITE_SANDSTONE.getId().getPath() + "_top");
        blockWithItem(EOBlocks.SMOOTH_WHITE_SANDSTONE, "white_sandstone_top");
        slabBlock(EOBlocks.WHITE_SANDSTONE_SLAB.get(), blockTexture(EOBlocks.WHITE_SANDSTONE.get()), blockTexture(EOBlocks.WHITE_SANDSTONE.get()), modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"));
        slabBlock(EOBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get(), blockTexture(EOBlocks.SMOOTH_WHITE_SANDSTONE.get()), modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"));
        slabBlock(EOBlocks.CUT_WHITE_SANDSTONE_SLAB.get(), blockTexture(EOBlocks.CUT_WHITE_SANDSTONE.get()), blockTexture(EOBlocks.CUT_WHITE_SANDSTONE.get()), modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"));
        stairsBlock(EOBlocks.WHITE_SANDSTONE_STAIRS.get(), blockTexture(EOBlocks.WHITE_SANDSTONE.get()), modLoc("block/white_sandstone_bottom"), modLoc("block/white_sandstone_top"));
        stairsBlock(EOBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get(), modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"));
        wallBlock(EOBlocks.WHITE_SANDSTONE_WALL.get(), blockTexture(EOBlocks.WHITE_SANDSTONE.get()));

        blockItem(EOBlocks.WHITE_SANDSTONE_SLAB);
        blockItem(EOBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
        blockItem(EOBlocks.CUT_WHITE_SANDSTONE_SLAB);
        blockItem(EOBlocks.WHITE_SANDSTONE_STAIRS);
        blockItem(EOBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
        blockItem(EOBlocks.WHITE_SANDSTONE_WALL);

        saplingBlock(EOBlocks.RED_SEAGRASS);
        tallSeagrassBlock(EOBlocks.TALL_RED_SEAGRASS);

        logBlock(((RotatedPillarBlock) EOBlocks.OCEAN_WILLOW_LOG.get()));
        axisBlock(((RotatedPillarBlock) EOBlocks.OCEAN_WILLOW_WOOD.get()), blockTexture(EOBlocks.OCEAN_WILLOW_LOG.get()), blockTexture(EOBlocks.OCEAN_WILLOW_LOG.get()));
        logBlock(((RotatedPillarBlock) EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.get()));
        axisBlock(((RotatedPillarBlock) EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get()), blockTexture(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.get()), blockTexture(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.get()));

        blockItem(EOBlocks.OCEAN_WILLOW_LOG);
        blockItem(EOBlocks.OCEAN_WILLOW_WOOD);
        blockItem(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        blockItem(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD);

        blockWithItem(EOBlocks.OCEAN_WILLOW_PLANKS);

        leavesBlock(EOBlocks.OCEAN_WILLOW_LEAVES);
        saplingBlock(EOBlocks.OCEAN_WILLOW_SAPLING);

        stairsBlock(EOBlocks.OCEAN_WILLOW_STAIRS.get(), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()));
        slabBlock(EOBlocks.OCEAN_WILLOW_SLAB.get(), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()));
        buttonBlock(EOBlocks.OCEAN_WILLOW_BUTTON.get(), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()));
        pressurePlateBlock(EOBlocks.OCEAN_WILLOW_PRESSURE_PLATE.get(), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()));
        fenceBlock(EOBlocks.OCEAN_WILLOW_FENCE.get(), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()));
        fenceGateBlock(EOBlocks.OCEAN_WILLOW_FENCE_GATE.get(), blockTexture(EOBlocks.OCEAN_WILLOW_PLANKS.get()));

        doorBlockWithRenderType(EOBlocks.OCEAN_WILLOW_DOOR.get(), modLoc("block/ocean_willow_door_bottom"), modLoc("block/ocean_willow_door_top"), "cutout");
        trapdoorBlockWithRenderType(EOBlocks.OCEAN_WILLOW_TRAPDOOR.get(), modLoc("block/ocean_willow_trapdoor"), true, "cutout");

        blockItem(EOBlocks.OCEAN_WILLOW_STAIRS);
        blockItem(EOBlocks.OCEAN_WILLOW_SLAB);
        blockItem(EOBlocks.OCEAN_WILLOW_PRESSURE_PLATE);
        blockItem(EOBlocks.OCEAN_WILLOW_FENCE_GATE);
        blockItem(EOBlocks.OCEAN_WILLOW_TRAPDOOR, "_bottom");

        logBlock(((RotatedPillarBlock) EOBlocks.WATER_MAPLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) EOBlocks.WATER_MAPLE_WOOD.get()), blockTexture(EOBlocks.WATER_MAPLE_LOG.get()), blockTexture(EOBlocks.WATER_MAPLE_LOG.get()));
        logBlock(((RotatedPillarBlock) EOBlocks.STRIPPED_WATER_MAPLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) EOBlocks.STRIPPED_WATER_MAPLE_WOOD.get()), blockTexture(EOBlocks.STRIPPED_WATER_MAPLE_LOG.get()), blockTexture(EOBlocks.STRIPPED_WATER_MAPLE_LOG.get()));

        blockItem(EOBlocks.WATER_MAPLE_LOG);
        blockItem(EOBlocks.WATER_MAPLE_WOOD);
        blockItem(EOBlocks.STRIPPED_WATER_MAPLE_LOG);
        blockItem(EOBlocks.STRIPPED_WATER_MAPLE_WOOD);

        blockWithItem(EOBlocks.WATER_MAPLE_PLANKS);

        leavesBlock(EOBlocks.WATER_MAPLE_LEAVES);
        saplingBlock(EOBlocks.WATER_MAPLE_SAPLING);

        stairsBlock(EOBlocks.WATER_MAPLE_STAIRS.get(), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()));
        slabBlock(EOBlocks.WATER_MAPLE_SLAB.get(), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()));
        buttonBlock(EOBlocks.WATER_MAPLE_BUTTON.get(), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()));
        pressurePlateBlock(EOBlocks.WATER_MAPLE_PRESSURE_PLATE.get(), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()));
        fenceBlock(EOBlocks.WATER_MAPLE_FENCE.get(), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()));
        fenceGateBlock(EOBlocks.WATER_MAPLE_FENCE_GATE.get(), blockTexture(EOBlocks.WATER_MAPLE_PLANKS.get()));

        doorBlockWithRenderType(EOBlocks.WATER_MAPLE_DOOR.get(), modLoc("block/water_maple_door_bottom"), modLoc("block/water_maple_door_top"), "cutout");
        trapdoorBlockWithRenderType(EOBlocks.WATER_MAPLE_TRAPDOOR.get(), modLoc("block/water_maple_trapdoor"), true, "cutout");

        blockItem(EOBlocks.WATER_MAPLE_STAIRS);
        blockItem(EOBlocks.WATER_MAPLE_SLAB);
        blockItem(EOBlocks.WATER_MAPLE_PRESSURE_PLATE);
        blockItem(EOBlocks.WATER_MAPLE_FENCE_GATE);
        blockItem(EOBlocks.WATER_MAPLE_TRAPDOOR, "_bottom");
    }

    private void tallSeagrassBlock(DeferredBlock<TallSeagrassBlock> deferredBlock) {
        ModelFile bottom = models().cross(deferredBlock.getId().getPath() + "_bottom", modLoc("block/" + deferredBlock.getId().getPath() + "_bottom")).renderType("cutout");
        ModelFile top = models().cross(deferredBlock.getId().getPath() + "_top", modLoc("block/" + deferredBlock.getId().getPath() + "_top")).renderType("cutout");
        getVariantBuilder(deferredBlock.get())
                .partialState().with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)
                .modelForState().modelFile(bottom).addModel()
                .partialState().with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER)
                .modelForState().modelFile(top).addModel();
        simpleBlockItem(deferredBlock.get(), bottom);
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

    private void blockWithItem(DeferredBlock<?> deferredBlock, String name) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(deferredBlock.getId().getPath(), modLoc("block/" + name)));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("expandedoceans:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("expandedoceans:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void cubeBottomTop(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeBottomTop(deferredBlock.getId().getPath(), modLoc("block/" + deferredBlock.getId().getPath()),
                modLoc("block/" + deferredBlock.getId().getPath() + "_bottom"), modLoc("block/" + deferredBlock.getId().getPath() + "_top")));
    }
    private void cubeBottomTop(DeferredBlock<?> deferredBlock, String side, String bottom, String top) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeBottomTop(deferredBlock.getId().getPath(), modLoc("block/" + side),
                modLoc("block/" + bottom), modLoc("block/" + top)));
    }
}
