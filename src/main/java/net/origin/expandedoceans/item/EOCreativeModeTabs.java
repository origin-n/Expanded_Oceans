package net.origin.expandedoceans.item;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;

import java.util.function.Supplier;

public class EOCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExpandedOceans.MOD_ID);

    public static final Supplier<CreativeModeTab> EXPANDED_OCEANS_TAB = CREATIVE_MODE_TAB.register("expanded_oceans_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(EOBlocks.OCEAN_WILLOW_SAPLING.asItem()))
                    .title(Component.translatable("creativetab.expandedoceans.expanded_oceans"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(EOBlocks.OCEAN_WILLOW_LOG.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_WOOD.get());
                        output.accept(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.get());
                        output.accept(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_PLANKS.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_LEAVES.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_SAPLING.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_STAIRS.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_SLAB.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_PRESSURE_PLATE.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_BUTTON.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_FENCE.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_FENCE_GATE.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_DOOR.get());
                        output.accept(EOBlocks.OCEAN_WILLOW_TRAPDOOR.get());


                        output.accept(EOBlocks.WATER_MAPLE_LOG.get());
                        output.accept(EOBlocks.WATER_MAPLE_WOOD.get());
                        output.accept(EOBlocks.STRIPPED_WATER_MAPLE_LOG.get());
                        output.accept(EOBlocks.STRIPPED_WATER_MAPLE_WOOD.get());
                        output.accept(EOBlocks.WATER_MAPLE_PLANKS.get());
                        output.accept(EOBlocks.WATER_MAPLE_LEAVES.get());
                        output.accept(EOBlocks.WATER_MAPLE_SAPLING.get());
                        output.accept(EOBlocks.WATER_MAPLE_STAIRS.get());
                        output.accept(EOBlocks.WATER_MAPLE_SLAB.get());
                        output.accept(EOBlocks.WATER_MAPLE_PRESSURE_PLATE.get());
                        output.accept(EOBlocks.WATER_MAPLE_BUTTON.get());
                        output.accept(EOBlocks.WATER_MAPLE_FENCE.get());
                        output.accept(EOBlocks.WATER_MAPLE_FENCE_GATE.get());
                        output.accept(EOBlocks.WATER_MAPLE_DOOR.get());
                        output.accept(EOBlocks.WATER_MAPLE_TRAPDOOR.get());

                        output.accept(EOBlocks.RED_SEAGRASS.get());
                        output.accept(EOBlocks.TALL_RED_SEAGRASS.get());
                        output.accept(EOBlocks.WHITE_SAND.get());
                        output.accept(EOBlocks.WHITE_SANDSTONE.get());
                        output.accept(EOBlocks.CUT_WHITE_SANDSTONE.get());
                        output.accept(EOBlocks.CHISELED_WHITE_SANDSTONE.get());
                        output.accept(EOBlocks.SMOOTH_WHITE_SANDSTONE.get());
                        output.accept(EOBlocks.WHITE_SANDSTONE_SLAB.get());
                        output.accept(EOBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get());
                        output.accept(EOBlocks.CUT_WHITE_SANDSTONE_SLAB.get());
                        output.accept(EOBlocks.WHITE_SANDSTONE_STAIRS.get());
                        output.accept(EOBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get());
                        output.accept(EOBlocks.WHITE_SANDSTONE_WALL.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
