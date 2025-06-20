package net.origin.expandedoceans.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.custom.ModLogBlock;
import net.origin.expandedoceans.item.ModItems;
import net.origin.expandedoceans.worldgen.tree.ModTreeGrowers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExpandedOceans.MOD_ID);

    //Woods
    //Ocean Willow
    public static final Map<Block, Block> STRIPPABLES = new HashMap<>();

    public static final DeferredBlock<Block> OCEAN_WILLOW_LOG = registerBlock("ocean_willow_log",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM)));
    public static final DeferredBlock<Block> OCEAN_WILLOW_WOOD = registerBlock("ocean_willow_wood",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HYPHAE)));
    public static final DeferredBlock<Block> STRIPPED_OCEAN_WILLOW_LOG = registerBlock("stripped_ocean_willow_log",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final DeferredBlock<Block> STRIPPED_OCEAN_WILLOW_WOOD = registerBlock("stripped_ocean_willow_wood",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));

    public static final DeferredBlock<Block> OCEAN_WILLOW_PLANKS = registerBlock("ocean_willow_planks",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> OCEAN_WILLOW_LEAVES = registerBlock("ocean_willow_leaves",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));

    public static final DeferredBlock<Block> OCEAN_WILLOW_SAPLING = registerBlock("ocean_willow_sapling",
            ()-> new SaplingBlock(ModTreeGrowers.OCEAN_WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)));

    public static final DeferredBlock<StairBlock> OCEAN_WILLOW_STAIRS = registerBlock("ocean_willow_stairs",
            ()-> new StairBlock(ModBlocks.OCEAN_WILLOW_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    public static final DeferredBlock<SlabBlock> OCEAN_WILLOW_SLAB = registerBlock("ocean_willow_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));

    public static final DeferredBlock<PressurePlateBlock> OCEAN_WILLOW_PRESSURE_PLATE = registerBlock("ocean_willow_pressure_plate",
            ()-> new PressurePlateBlock(BlockSetType.WARPED,BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> OCEAN_WILLOW_BUTTON = registerBlock("ocean_willow_button",
            ()-> new ButtonBlock(BlockSetType.WARPED, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON)));

    public static final DeferredBlock<FenceBlock> OCEAN_WILLOW_FENCE = registerBlock("ocean_willow_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)));
    public static final DeferredBlock<FenceGateBlock> OCEAN_WILLOW_FENCE_GATE = registerBlock("ocean_willow_fence_gate",
            ()-> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> OCEAN_WILLOW_DOOR = registerBlock("ocean_willow_door",
            ()-> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> OCEAN_WILLOW_TRAPDOOR = registerBlock("ocean_willow_trapdoor",
            ()-> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR)));

    //Water Maple
    public static final DeferredBlock<Block> WATER_MAPLE_LOG = registerBlock("water_maple_log",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM)));
    public static final DeferredBlock<Block> WATER_MAPLE_WOOD = registerBlock("water_maple_wood",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HYPHAE)));
    public static final DeferredBlock<Block> STRIPPED_WATER_MAPLE_LOG = registerBlock("stripped_water_maple_log",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final DeferredBlock<Block> STRIPPED_WATER_MAPLE_WOOD = registerBlock("stripped_water_maple_wood",
            ()-> new ModLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));

    public static final DeferredBlock<Block> WATER_MAPLE_PLANKS = registerBlock("water_maple_planks",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> WATER_MAPLE_LEAVES = registerBlock("water_maple_leaves",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));

    public static final DeferredBlock<Block> WATER_MAPLE_SAPLING = registerBlock("water_maple_sapling",
            ()-> new SaplingBlock(ModTreeGrowers.WATER_MAPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)));

    public static final DeferredBlock<StairBlock> WATER_MAPLE_STAIRS = registerBlock("water_maple_stairs",
            ()-> new StairBlock(ModBlocks.WATER_MAPLE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    public static final DeferredBlock<SlabBlock> WATER_MAPLE_SLAB = registerBlock("ocean_willow_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));

    public static final DeferredBlock<PressurePlateBlock> WATER_MAPLE_PRESSURE_PLATE = registerBlock("water_maple_pressure_plate",
            ()-> new PressurePlateBlock(BlockSetType.WARPED,BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> WATER_MAPLE_BUTTON = registerBlock("water_maple_button",
            ()-> new ButtonBlock(BlockSetType.WARPED, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON)));

    public static final DeferredBlock<FenceBlock> WATER_MAPLE_FENCE = registerBlock("water_maple_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)));
    public static final DeferredBlock<FenceGateBlock> WATER_MAPLE_FENCE_GATE = registerBlock("water_maple_fence_gate",
            ()-> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> WATER_MAPLE_DOOR = registerBlock("water_maple_door",
            ()-> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> WATER_MAPLE_TRAPDOOR = registerBlock("water_maple_trapdoor",
            ()-> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR)));

    //Strippables Registry
    public static void registerStrippables(){
        STRIPPABLES.put(OCEAN_WILLOW_LOG.get(), STRIPPED_OCEAN_WILLOW_LOG.get());
        STRIPPABLES.put(OCEAN_WILLOW_WOOD.get(), STRIPPED_OCEAN_WILLOW_WOOD.get());
        STRIPPABLES.put(WATER_MAPLE_LOG.get(), STRIPPED_WATER_MAPLE_LOG.get());
        STRIPPABLES.put(WATER_MAPLE_WOOD.get(), STRIPPED_WATER_MAPLE_WOOD.get());
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static  <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        eventBus.addListener(ModBlocks::onBlocksRegistered);
    }

    private static void onBlocksRegistered(net.neoforged.neoforge.registries.RegisterEvent event) {
        if (event.getRegistryKey() == net.minecraft.core.registries.Registries.BLOCK) {
            registerStrippables();
        }
    }
}
