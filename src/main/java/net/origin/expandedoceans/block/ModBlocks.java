package net.origin.expandedoceans.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.custom.ModLogBlock;
import net.origin.expandedoceans.item.ModItems;

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
            ()-> new SaplingBlock(, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)));

    //Strippables Registry
    public static void registerStrippables(){
        STRIPPABLES.put(OCEAN_WILLOW_LOG.get(), STRIPPED_OCEAN_WILLOW_LOG.get());
        STRIPPABLES.put(OCEAN_WILLOW_WOOD.get(), STRIPPED_OCEAN_WILLOW_WOOD.get());
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
