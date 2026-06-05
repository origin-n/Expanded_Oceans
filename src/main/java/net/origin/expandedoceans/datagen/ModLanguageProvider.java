package net.origin.expandedoceans.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, ExpandedOceans.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("creativetab.expandedoceans.expanded_oceans", "Expanded Oceans");

        addBlock(ModBlocks.WHITE_SAND);
        addBlock(ModBlocks.WHITE_SANDSTONE);
        addBlock(ModBlocks.CUT_WHITE_SANDSTONE);
        addBlock(ModBlocks.CHISELED_WHITE_SANDSTONE);
        addBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE);
        addBlock(ModBlocks.WHITE_SANDSTONE_SLAB);
        addBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
        addBlock(ModBlocks.CUT_WHITE_SANDSTONE_SLAB);
        addBlock(ModBlocks.WHITE_SANDSTONE_STAIRS);
        addBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
        addBlock(ModBlocks.WHITE_SANDSTONE_WALL);

        addBlock(ModBlocks.RED_SEAGRASS);
        addBlock(ModBlocks.TALL_RED_SEAGRASS);

        addBlock(ModBlocks.OCEAN_WILLOW_LOG);
        addBlock(ModBlocks.OCEAN_WILLOW_PLANKS);
        addBlock(ModBlocks.OCEAN_WILLOW_WOOD);
        addBlock(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        addBlock(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD);
        addBlock(ModBlocks.OCEAN_WILLOW_LEAVES);
        addBlock(ModBlocks.OCEAN_WILLOW_SAPLING);
        addBlock(ModBlocks.OCEAN_WILLOW_STAIRS);
        addBlock(ModBlocks.OCEAN_WILLOW_SLAB);
        addBlock(ModBlocks.OCEAN_WILLOW_PRESSURE_PLATE);
        addBlock(ModBlocks.OCEAN_WILLOW_BUTTON);
        addBlock(ModBlocks.OCEAN_WILLOW_FENCE);
        addBlock(ModBlocks.OCEAN_WILLOW_FENCE_GATE);
        addBlock(ModBlocks.OCEAN_WILLOW_DOOR);
        addBlock(ModBlocks.OCEAN_WILLOW_TRAPDOOR);

        addBlock(ModBlocks.WATER_MAPLE_LOG);
        addBlock(ModBlocks.WATER_MAPLE_PLANKS);
        addBlock(ModBlocks.WATER_MAPLE_WOOD);
        addBlock(ModBlocks.STRIPPED_WATER_MAPLE_LOG);
        addBlock(ModBlocks.STRIPPED_WATER_MAPLE_WOOD);
        addBlock(ModBlocks.WATER_MAPLE_LEAVES);
        addBlock(ModBlocks.WATER_MAPLE_SAPLING);
        addBlock(ModBlocks.WATER_MAPLE_STAIRS);
        addBlock(ModBlocks.WATER_MAPLE_SLAB);
        addBlock(ModBlocks.WATER_MAPLE_PRESSURE_PLATE);
        addBlock(ModBlocks.WATER_MAPLE_BUTTON);
        addBlock(ModBlocks.WATER_MAPLE_FENCE);
        addBlock(ModBlocks.WATER_MAPLE_FENCE_GATE);
        addBlock(ModBlocks.WATER_MAPLE_DOOR);
        addBlock(ModBlocks.WATER_MAPLE_TRAPDOOR);
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
