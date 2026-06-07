package net.origin.expandedoceans.worldgen.custom_features;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOHourglassPillarConfig;
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOSeagrassConfig;
import net.origin.expandedoceans.worldgen.custom_features.features.EOHourglassPillar;
import net.origin.expandedoceans.worldgen.custom_features.features.EOSeagrassFeature;

public class EOFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, ExpandedOceans.MOD_ID);

    public static final DeferredHolder<Feature<?>, EOSeagrassFeature> SEAGRASS_CONFIGURABLE =
            FEATURES.register("seagrass_configurable", ()-> new EOSeagrassFeature(EOSeagrassConfig.CODEC));
    public static final DeferredHolder<Feature<?>, EOHourglassPillar> HOURGLASS_PILLAR =
            FEATURES.register("hourglass_pillar", ()-> new EOHourglassPillar(EOHourglassPillarConfig.CODEC));


    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
