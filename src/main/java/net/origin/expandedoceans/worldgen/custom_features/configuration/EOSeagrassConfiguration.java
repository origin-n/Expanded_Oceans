package net.origin.expandedoceans.worldgen.custom_features.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record EOSeagrassConfiguration(
        float probability,
        int patchRadius,
        int patchAttempts,
        BlockStateProvider shortSeagrass,
        BlockStateProvider tallSeagrass
) implements FeatureConfiguration {

    public static final Codec<EOSeagrassConfiguration> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codec.FLOAT.fieldOf("probability").forGetter(EOSeagrassConfiguration::probability),
                            Codec.INT.fieldOf("patch_radius").forGetter(EOSeagrassConfiguration::patchRadius),
                            Codec.INT.fieldOf("patch_attempts").forGetter(EOSeagrassConfiguration::patchAttempts),
                            BlockStateProvider.CODEC.fieldOf("short_seagrass").forGetter(EOSeagrassConfiguration::shortSeagrass),
                            BlockStateProvider.CODEC.fieldOf("tall_seagrass").forGetter(EOSeagrassConfiguration::tallSeagrass)
                    ).apply(instance, EOSeagrassConfiguration::new));
}
