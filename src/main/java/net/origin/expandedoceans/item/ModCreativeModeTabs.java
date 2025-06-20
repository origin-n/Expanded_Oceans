package net.origin.expandedoceans.item;


import net.origin.expandedoceans.block.ModBlocks;
import net.origin.expandedoceans.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;


import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExpandedOceans.MOD_ID);

    public static final Supplier<CreativeModeTab> EXPANDED_OCEANS_TAB = CREATIVE_MODE_TAB.register("expanded_oceans_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OCEAN_WILLOW_SAPLING.asItem()))
                    .title(Component.translatable("creativetab.expandedoceans.expanded_oceans"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OCEAN_WILLOW_LOG.get());
                        output.accept(ModBlocks.OCEAN_WILLOW_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.get());
                        output.accept(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get());
                        output.accept(ModBlocks.OCEAN_WILLOW_PLANKS.get());
                        output.accept(ModBlocks.OCEAN_WILLOW_LEAVES.get());
                        output.accept(ModBlocks.OCEAN_WILLOW_SAPLING.get());

                        output.accept(ModBlocks.WATER_MAPLE_LOG.get());
                        output.accept(ModBlocks.WATER_MAPLE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_WATER_MAPLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_WATER_MAPLE_WOOD.get());
                        output.accept(ModBlocks.WATER_MAPLE_PLANKS.get());
                        output.accept(ModBlocks.WATER_MAPLE_LEAVES.get());
                        output.accept(ModBlocks.WATER_MAPLE_SAPLING.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
