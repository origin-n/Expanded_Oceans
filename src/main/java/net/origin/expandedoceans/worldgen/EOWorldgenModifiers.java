package net.origin.expandedoceans.worldgen;

import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries;
import dev.worldgen.lithostitched.api.util.InjectionType;
import dev.worldgen.lithostitched.api.worldgen.modifier.WorldgenModifier;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.origin.expandedoceans.ExpandedOceans;

public class EOWorldgenModifiers {
    public static final ResourceKey<WorldgenModifier> SURFACE_RULES = registerKey("surface_rules");

    public static void bootstrap(BootstrapContext<WorldgenModifier> context){
        context.register(SURFACE_RULES, WorldgenModifier.builder().addSurfaceRule(
                Level.OVERWORLD, InjectionType.PREPEND, EOSurfaceRuleData.makeRules()
        ));
    }

    private static ResourceKey<WorldgenModifier> registerKey(String name) {
        return ResourceKey.create(LithostitchedRegistries.WORLDGEN_MODIFIER, ResourceLocation.fromNamespaceAndPath(ExpandedOceans.MOD_ID, name));
    }
}
