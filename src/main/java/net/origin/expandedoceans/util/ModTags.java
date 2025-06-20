package net.origin.expandedoceans.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.origin.expandedoceans.ExpandedOceans;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> OCEAN_WILLOW_LOGS = createTag("ocean_willow_logs");
        public static final TagKey<Item> WATER_MAPLE_LOGS = createTag("water_maple_logs");
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
        }
    }
}
