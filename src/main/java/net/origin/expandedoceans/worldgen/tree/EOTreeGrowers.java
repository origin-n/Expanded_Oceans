package net.origin.expandedoceans.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.worldgen.EOConfiguredFeatures;

import java.util.Optional;

public class EOTreeGrowers {
    public static final TreeGrower OCEAN_WILLOW = new TreeGrower(ExpandedOceans.MOD_ID + ":ocean_willow",
            Optional.empty(), Optional.of(EOConfiguredFeatures.OCEAN_WILLOW_KEY), Optional.empty());
    public static final TreeGrower WATER_MAPLE = new TreeGrower(ExpandedOceans.MOD_ID + ":ocean_willow",
            Optional.empty(), Optional.of(EOConfiguredFeatures.WATER_MAPLE_KEY), Optional.empty());
}
