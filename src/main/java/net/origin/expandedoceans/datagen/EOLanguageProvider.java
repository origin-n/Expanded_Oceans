package net.origin.expandedoceans.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;

public class EOLanguageProvider extends LanguageProvider {
    public EOLanguageProvider(PackOutput output) {
        super(output, ExpandedOceans.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("creativetab.expandedoceans.expanded_oceans", "Expanded Oceans");

        addBlock(EOBlocks.WHITE_SAND);
        addBlock(EOBlocks.WHITE_SANDSTONE);
        addBlock(EOBlocks.CUT_WHITE_SANDSTONE);
        addBlock(EOBlocks.CHISELED_WHITE_SANDSTONE);
        addBlock(EOBlocks.SMOOTH_WHITE_SANDSTONE);
        addBlock(EOBlocks.WHITE_SANDSTONE_SLAB);
        addBlock(EOBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
        addBlock(EOBlocks.CUT_WHITE_SANDSTONE_SLAB);
        addBlock(EOBlocks.WHITE_SANDSTONE_STAIRS);
        addBlock(EOBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
        addBlock(EOBlocks.WHITE_SANDSTONE_WALL);

        addBlock(EOBlocks.RED_SEAGRASS);
        addBlock(EOBlocks.TALL_RED_SEAGRASS);

        addBlock(EOBlocks.OCEAN_WILLOW_LOG);
        addBlock(EOBlocks.OCEAN_WILLOW_PLANKS);
        addBlock(EOBlocks.OCEAN_WILLOW_WOOD);
        addBlock(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        addBlock(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD);
        addBlock(EOBlocks.OCEAN_WILLOW_LEAVES);
        addBlock(EOBlocks.OCEAN_WILLOW_SAPLING);
        addBlock(EOBlocks.OCEAN_WILLOW_STAIRS);
        addBlock(EOBlocks.OCEAN_WILLOW_SLAB);
        addBlock(EOBlocks.OCEAN_WILLOW_PRESSURE_PLATE);
        addBlock(EOBlocks.OCEAN_WILLOW_BUTTON);
        addBlock(EOBlocks.OCEAN_WILLOW_FENCE);
        addBlock(EOBlocks.OCEAN_WILLOW_FENCE_GATE);
        addBlock(EOBlocks.OCEAN_WILLOW_DOOR);
        addBlock(EOBlocks.OCEAN_WILLOW_TRAPDOOR);

        addBlock(EOBlocks.WATER_MAPLE_LOG);
        addBlock(EOBlocks.WATER_MAPLE_PLANKS);
        addBlock(EOBlocks.WATER_MAPLE_WOOD);
        addBlock(EOBlocks.STRIPPED_WATER_MAPLE_LOG);
        addBlock(EOBlocks.STRIPPED_WATER_MAPLE_WOOD);
        addBlock(EOBlocks.WATER_MAPLE_LEAVES);
        addBlock(EOBlocks.WATER_MAPLE_SAPLING);
        addBlock(EOBlocks.WATER_MAPLE_STAIRS);
        addBlock(EOBlocks.WATER_MAPLE_SLAB);
        addBlock(EOBlocks.WATER_MAPLE_PRESSURE_PLATE);
        addBlock(EOBlocks.WATER_MAPLE_BUTTON);
        addBlock(EOBlocks.WATER_MAPLE_FENCE);
        addBlock(EOBlocks.WATER_MAPLE_FENCE_GATE);
        addBlock(EOBlocks.WATER_MAPLE_DOOR);
        addBlock(EOBlocks.WATER_MAPLE_TRAPDOOR);
    }

    private void addBlock(DeferredBlock<?> deferredBlock) {
        add(deferredBlock.get(), toUpper(deferredBlock.getId().getPath()));
    }

    private static String toUpper(String id) {
        StringBuilder builder = new StringBuilder();
        for (String part : id.split("_")) {
            builder.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
        }
        return builder.toString().trim();
    }
}
