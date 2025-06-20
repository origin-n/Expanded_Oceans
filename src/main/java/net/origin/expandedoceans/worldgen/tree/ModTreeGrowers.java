package net.origin.expandedoceans.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower OCEAN_WILLOW = new TreeGrower(ExpandedOceans.MOD_ID + ":ocean_willow",
            Optional.empty(), Optional.of(ModConfiguredFeatures.OCEAN_WILLOW_KEY), Optional.empty());
    public static final TreeGrower WATER_MAPLE = new TreeGrower(ExpandedOceans.MOD_ID + ":ocean_willow",
            Optional.empty(), Optional.of(ModConfiguredFeatures.WATER_MAPLE_KEY), Optional.empty());
}
