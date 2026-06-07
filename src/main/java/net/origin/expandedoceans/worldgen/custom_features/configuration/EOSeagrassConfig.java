package net.origin.expandedoceans.worldgen.custom_features.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record EOSeagrassConfig(
        float probability,
        int patchRadius,
        int patchAttempts,
        BlockStateProvider shortSeagrass,
        BlockStateProvider tallSeagrass
) implements FeatureConfiguration {

    public static final Codec<EOSeagrassConfig> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codec.FLOAT.fieldOf("probability").forGetter(EOSeagrassConfig::probability),
                            Codec.INT.fieldOf("patch_radius").forGetter(EOSeagrassConfig::patchRadius),
                            Codec.INT.fieldOf("patch_attempts").forGetter(EOSeagrassConfig::patchAttempts),
                            BlockStateProvider.CODEC.fieldOf("short_seagrass").forGetter(EOSeagrassConfig::shortSeagrass),
                            BlockStateProvider.CODEC.fieldOf("tall_seagrass").forGetter(EOSeagrassConfig::tallSeagrass)
                    ).apply(instance, EOSeagrassConfig::new));
}
