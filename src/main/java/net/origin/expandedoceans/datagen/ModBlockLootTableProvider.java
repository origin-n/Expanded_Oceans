package net.origin.expandedoceans.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.origin.expandedoceans.ExpandedOceans;
import net.origin.expandedoceans.block.ModBlocks;
import net.origin.expandedoceans.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.OCEAN_WILLOW_LOG.get());
        this.dropSelf(ModBlocks.OCEAN_WILLOW_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get());
        this.dropSelf(ModBlocks.OCEAN_WILLOW_PLANKS.get());
        this.dropSelf(ModBlocks.OCEAN_WILLOW_SAPLING.get());

        this.add(ModBlocks.OCEAN_WILLOW_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.OCEAN_WILLOW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.OCEAN_WILLOW_STAIRS.get());
        add(ModBlocks.OCEAN_WILLOW_SLAB.get(), block -> createSlabItemTable(ModBlocks.OCEAN_WILLOW_SLAB.get()));

        dropSelf(ModBlocks.OCEAN_WILLOW_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.OCEAN_WILLOW_BUTTON.get());
        dropSelf(ModBlocks.OCEAN_WILLOW_FENCE.get());
        dropSelf(ModBlocks.OCEAN_WILLOW_FENCE_GATE.get());
        dropSelf(ModBlocks.OCEAN_WILLOW_TRAPDOOR.get());
        add(ModBlocks.OCEAN_WILLOW_DOOR.get(), block -> createDoorTable(ModBlocks.OCEAN_WILLOW_DOOR.get()));

        this.dropSelf(ModBlocks.WATER_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.WATER_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WATER_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_WATER_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.WATER_MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.WATER_MAPLE_SAPLING.get());

        this.add(ModBlocks.WATER_MAPLE_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.WATER_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.WATER_MAPLE_STAIRS.get());
        add(ModBlocks.WATER_MAPLE_SLAB.get(), block -> createSlabItemTable(ModBlocks.WATER_MAPLE_SLAB.get()));

        dropSelf(ModBlocks.WATER_MAPLE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.WATER_MAPLE_BUTTON.get());
        dropSelf(ModBlocks.WATER_MAPLE_FENCE.get());
        dropSelf(ModBlocks.WATER_MAPLE_FENCE_GATE.get());
        dropSelf(ModBlocks.WATER_MAPLE_TRAPDOOR.get());
        add(ModBlocks.WATER_MAPLE_DOOR.get(), block -> createDoorTable(ModBlocks.WATER_MAPLE_DOOR.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createNonFortuneOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
