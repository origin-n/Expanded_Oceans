package net.origin.expandedoceans.worldgen.tree.trunk;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;

import java.util.function.Supplier;

public class EOTrunkPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, ExpandedOceans.MOD_ID);

    public static final Supplier<TrunkPlacerType<EOStraightTrunkPlacer>>
            MOD_STRAIGHT_TRUNK_PLACER = TRUNK_PLACERS.register(
                    "mod_straight_trunk_placer",
            ()-> new TrunkPlacerType<>(EOStraightTrunkPlacer.CODEC)
    );
    public static final Supplier<TrunkPlacerType<EOForkingTrunkPlacer>>
            MOD_FORKING_TRUNK_PLACER = TRUNK_PLACERS.register(
                    "mod_forking_trunk_placer",
            ()-> new TrunkPlacerType<>(EOForkingTrunkPlacer.CODEC)
    );

    public static void register(IEventBus eventBus){
        TRUNK_PLACERS.register(eventBus);
    }
}
