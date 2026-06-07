package net.origin.expandedoceans.worldgen.custom_features.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record EOHourglassPillarConfig(
        IntProvider height,
        IntProvider baseRadius,
        IntProvider neckRadius,
        IntProvider capRadius,
        boolean drift,
        boolean distortion,
        float bulgeChance,
        int maxBulges,
        BlockStateProvider baseBlock,
        BlockStateProvider topBlock
) implements FeatureConfiguration {

    public static final Codec<EOHourglassPillarConfig> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            IntProvider.CODEC.fieldOf("height").forGetter(EOHourglassPillarConfig::height),
                            IntProvider.CODEC.fieldOf("base_radius").forGetter(EOHourglassPillarConfig::baseRadius),
                            IntProvider.CODEC.fieldOf("neck_radius").forGetter(EOHourglassPillarConfig::neckRadius),
                            IntProvider.CODEC.fieldOf("cap_radius").forGetter(EOHourglassPillarConfig::capRadius),
                            Codec.BOOL.fieldOf("drift").forGetter(EOHourglassPillarConfig::drift),
                            Codec.BOOL.fieldOf("distortion").forGetter(EOHourglassPillarConfig::distortion),
                            Codec.FLOAT.fieldOf("bulge_chance").forGetter(EOHourglassPillarConfig::bulgeChance),
                            Codec.INT.fieldOf("max_bulges").forGetter(EOHourglassPillarConfig::maxBulges),
                            BlockStateProvider.CODEC.fieldOf("base_block").forGetter(EOHourglassPillarConfig::baseBlock),
                            BlockStateProvider.CODEC.fieldOf("top_block").forGetter(EOHourglassPillarConfig::topBlock)
                    ).apply(instance, EOHourglassPillarConfig::new));

}
