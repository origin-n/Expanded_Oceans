package net.origin.expandedoceans.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;
import net.origin.expandedoceans.item.ModItems;
import net.origin.expandedoceans.util.ModTags;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        planksFromLogs(recipeOutput, ModBlocks.OCEAN_WILLOW_PLANKS, ModTags.Items.OCEAN_WILLOW_LOGS, 4);
        woodFromLogs(recipeOutput, ModBlocks.OCEAN_WILLOW_WOOD, ModBlocks.OCEAN_WILLOW_LOG);
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD, ModBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        stairBuilder(ModBlocks.OCEAN_WILLOW_STAIRS.get(), Ingredient.of(ModBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(ModBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_WILLOW_SLAB, ModBlocks.OCEAN_WILLOW_PLANKS);
        buttonBuilder(ModBlocks.OCEAN_WILLOW_BUTTON.get(), Ingredient.of(ModBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(ModBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.OCEAN_WILLOW_PRESSURE_PLATE, ModBlocks.OCEAN_WILLOW_PLANKS);
        fenceBuilder(ModBlocks.OCEAN_WILLOW_FENCE.get(), Ingredient.of(ModBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(ModBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.OCEAN_WILLOW_FENCE_GATE.get(), Ingredient.of(ModBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(ModBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.OCEAN_WILLOW_DOOR.get(), Ingredient.of(ModBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(ModBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.OCEAN_WILLOW_TRAPDOOR.get(), Ingredient.of(ModBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(ModBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);

        planksFromLogs(recipeOutput, ModBlocks.WATER_MAPLE_PLANKS, ModTags.Items.WATER_MAPLE_LOGS, 4);
        woodFromLogs(recipeOutput, ModBlocks.WATER_MAPLE_WOOD, ModBlocks.WATER_MAPLE_WOOD);
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_WATER_MAPLE_WOOD, ModBlocks.STRIPPED_WATER_MAPLE_LOG);
        stairBuilder(ModBlocks.WATER_MAPLE_STAIRS.get(), Ingredient.of(ModBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(ModBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WATER_MAPLE_SLAB, ModBlocks.WATER_MAPLE_PLANKS);
        buttonBuilder(ModBlocks.WATER_MAPLE_BUTTON.get(), Ingredient.of(ModBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(ModBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.WATER_MAPLE_PRESSURE_PLATE, ModBlocks.WATER_MAPLE_PLANKS);
        fenceBuilder(ModBlocks.WATER_MAPLE_FENCE.get(), Ingredient.of(ModBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(ModBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.WATER_MAPLE_FENCE_GATE.get(), Ingredient.of(ModBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(ModBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.WATER_MAPLE_DOOR.get(), Ingredient.of(ModBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(ModBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.WATER_MAPLE_TRAPDOOR.get(), Ingredient.of(ModBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(ModBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, ExpandedOceans.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
