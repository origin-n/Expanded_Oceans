package net.origin.expandedoceans.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.EOBlocks;
import net.origin.expandedoceans.util.EOTags;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EORecipeProvider extends RecipeProvider implements IConditionBuilder {
    public EORecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        planksFromLogs(recipeOutput, EOBlocks.OCEAN_WILLOW_PLANKS, EOTags.Items.OCEAN_WILLOW_LOGS, 4);
        woodFromLogs(recipeOutput, EOBlocks.OCEAN_WILLOW_WOOD, EOBlocks.OCEAN_WILLOW_LOG);
        woodFromLogs(recipeOutput, EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD, EOBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        stairBuilder(EOBlocks.OCEAN_WILLOW_STAIRS.get(), Ingredient.of(EOBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(EOBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, EOBlocks.OCEAN_WILLOW_SLAB, EOBlocks.OCEAN_WILLOW_PLANKS);
        buttonBuilder(EOBlocks.OCEAN_WILLOW_BUTTON.get(), Ingredient.of(EOBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(EOBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, EOBlocks.OCEAN_WILLOW_PRESSURE_PLATE, EOBlocks.OCEAN_WILLOW_PLANKS);
        fenceBuilder(EOBlocks.OCEAN_WILLOW_FENCE.get(), Ingredient.of(EOBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(EOBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        fenceGateBuilder(EOBlocks.OCEAN_WILLOW_FENCE_GATE.get(), Ingredient.of(EOBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(EOBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        doorBuilder(EOBlocks.OCEAN_WILLOW_DOOR.get(), Ingredient.of(EOBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(EOBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);
        trapdoorBuilder(EOBlocks.OCEAN_WILLOW_TRAPDOOR.get(), Ingredient.of(EOBlocks.OCEAN_WILLOW_PLANKS)).group("ocean_willow")
                .unlockedBy("has_ocean_willow_planks", has(EOBlocks.OCEAN_WILLOW_PLANKS)).save(recipeOutput);

        planksFromLogs(recipeOutput, EOBlocks.WATER_MAPLE_PLANKS, EOTags.Items.WATER_MAPLE_LOGS, 4);
        woodFromLogs(recipeOutput, EOBlocks.WATER_MAPLE_WOOD, EOBlocks.WATER_MAPLE_WOOD);
        woodFromLogs(recipeOutput, EOBlocks.STRIPPED_WATER_MAPLE_WOOD, EOBlocks.STRIPPED_WATER_MAPLE_LOG);
        stairBuilder(EOBlocks.WATER_MAPLE_STAIRS.get(), Ingredient.of(EOBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(EOBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, EOBlocks.WATER_MAPLE_SLAB, EOBlocks.WATER_MAPLE_PLANKS);
        buttonBuilder(EOBlocks.WATER_MAPLE_BUTTON.get(), Ingredient.of(EOBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(EOBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, EOBlocks.WATER_MAPLE_PRESSURE_PLATE, EOBlocks.WATER_MAPLE_PLANKS);
        fenceBuilder(EOBlocks.WATER_MAPLE_FENCE.get(), Ingredient.of(EOBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(EOBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        fenceGateBuilder(EOBlocks.WATER_MAPLE_FENCE_GATE.get(), Ingredient.of(EOBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(EOBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        doorBuilder(EOBlocks.WATER_MAPLE_DOOR.get(), Ingredient.of(EOBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(EOBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);
        trapdoorBuilder(EOBlocks.WATER_MAPLE_TRAPDOOR.get(), Ingredient.of(EOBlocks.WATER_MAPLE_PLANKS)).group("water_maple")
                .unlockedBy("has_water_maple_planks", has(EOBlocks.WATER_MAPLE_PLANKS)).save(recipeOutput);

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
