package net.origin.expandedoceans.worldgen.custom_features.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.origin.expandedoceans.worldgen.custom_features.configuration.EOHourglassPillarConfig;

public class EOHourglassPillar extends Feature<EOHourglassPillarConfig> {
    public EOHourglassPillar(Codec<EOHourglassPillarConfig> codec) {super(codec);}

    @Override
    public boolean place(FeaturePlaceContext<EOHourglassPillarConfig> context) {
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        EOHourglassPillarConfig config = context.config();

        origin = origin.below(2);

        int height = config.height().sample(random);
        int baseRadius = config.baseRadius().sample(random);
        int neckRadius = config.neckRadius().sample(random);
        int capRadius = config.capRadius().sample(random);

        if (origin.getY() > level.getSeaLevel() - 12) {return false;}
        if (origin.getY() + height >= level.getSeaLevel() - 2) {return false;}

        for (int x = -baseRadius; x <= baseRadius; x++) {
            for (int z = -baseRadius; z <= baseRadius; z++) {
                if (x * x + z * z > baseRadius * baseRadius) continue;
                BlockPos checkPos = origin.offset(x, -1, z);

                if (!level.getBlockState(checkPos).isFaceSturdy(level, checkPos, Direction.UP)) {
                    return false;
                }
            }
        }

        int driftX = 0;
        int driftZ = 0;

        int bulges = random.nextFloat() < config.bulgeChance() ? 1 + random.nextInt(config.maxBulges()) : 0;

        int[] bulgeHeights = new int[bulges];
        float[] bulgeStrengths = new float[bulges];

        int minBulgeHeight = Math.max(1, height / 5);
        int maxBulgeHeight = Math.max(minBulgeHeight + 1, height - minBulgeHeight);

        float edgeFreq = 2.0f + random.nextFloat() * 3.0f;
        float edgeStrength = 0.5f + random.nextFloat();

        for (int bulgeIndex = 0; bulgeIndex < bulges; bulgeIndex++) {
            bulgeHeights[bulgeIndex] = random.nextInt(minBulgeHeight, maxBulgeHeight);
            bulgeStrengths[bulgeIndex] = 0.5f + random.nextFloat() * 1.5f;
        }

        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            float heightProgress = currentHeight / (float) height;
            float currentRadius;

            if (heightProgress < 0.5f) {
                currentRadius = Mth.lerp(heightProgress * 2f, baseRadius, neckRadius);
            }
            else {
                currentRadius = Mth.lerp((heightProgress - 0.5f) * 2f, neckRadius, capRadius);
            }

            for (int bulgeIndex = 0; bulgeIndex<bulges; bulgeIndex++) {
                float distB = Math.abs(currentHeight-bulgeHeights[bulgeIndex]);
                if (distB < 4 ){
                    currentRadius += bulgeStrengths[bulgeIndex] * (1.0f - distB / 4.0f);
                }
            }

            currentRadius += (random.nextFloat() - 0.5f);
            int layerRadius = Math.max(1, Mth.floor(currentRadius));

            if(random.nextFloat() < 0.25f) {driftX += random.nextInt(3) - 1;}
            if(random.nextFloat() < 0.25f) {driftZ += random.nextInt(3) - 1;}

            if (config.drift()) {
                driftX = Mth.clamp(driftX, -2, 2);
                driftZ = Mth.clamp(driftZ, -2, 2);
            }

            fillCircle(level, origin.above(currentHeight).offset(driftX, 0, driftZ), layerRadius, config, random, edgeFreq, edgeStrength);
        }
        return true;
    }

    private void fillCircle(
            WorldGenLevel level,
            BlockPos center,
            int radius,
            EOHourglassPillarConfig config,
            RandomSource random,
            float edgeFreq,
            float edgeStrength) {

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                double angle = Math.atan2(z, x);

                if (config.distortion()) {
                    float edgeOffset = (float) (Math.sin(angle * edgeFreq) * edgeStrength);
                    float distortedRadius = radius + edgeOffset;
                    if (x * x + z * z > distortedRadius * distortedRadius) continue;
                }
                else {
                    if (x * x + z * z > radius * radius) continue;
                }
                BlockPos pos = center.offset(x, 0, z);
                BlockState state = config.baseBlock().getState(random, pos);

                level.setBlock(pos, state, 3);
            }
        }
    }
}
