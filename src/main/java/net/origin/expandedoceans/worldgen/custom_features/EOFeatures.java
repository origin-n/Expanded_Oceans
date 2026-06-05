package net.origin.expandedoceans.worldgen.custom_features;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOSeagrassConfiguration;

public class EOFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, ExpandedOceans.MOD_ID);

    public static final DeferredHolder<Feature<?>, EOSeagrassFeature> MOD_SEAGRASS_FEATURE =
            FEATURES.register("mod_seagrass", ()-> new EOSeagrassFeature(
                    EOSeagrassConfiguration.CODEC
            ));

    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
