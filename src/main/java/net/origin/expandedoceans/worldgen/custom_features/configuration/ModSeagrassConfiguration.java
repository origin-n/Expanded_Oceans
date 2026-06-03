package net.origin.expandedoceans.worldgen.custom_features.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record ModSeagrassConfiguration(
        float probability,
        int patchRadius,
        int patchAttempts,
        BlockStateProvider shortSeagrass,
        BlockStateProvider tallSeagrass
) implements FeatureConfiguration {

    public static final Codec<ModSeagrassConfiguration> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codec.FLOAT.fieldOf("probability").forGetter(ModSeagrassConfiguration::probability),
                            Codec.INT.fieldOf("patch_radius").forGetter(ModSeagrassConfiguration::patchRadius),
                            Codec.INT.fieldOf("patch_attempts").forGetter(ModSeagrassConfiguration::patchAttempts),
                            BlockStateProvider.CODEC.fieldOf("short_seagrass").forGetter(ModSeagrassConfiguration::shortSeagrass),
                            BlockStateProvider.CODEC.fieldOf("tall_seagrass").forGetter(ModSeagrassConfiguration::tallSeagrass)
                    ).apply(instance, ModSeagrassConfiguration::new));
}
