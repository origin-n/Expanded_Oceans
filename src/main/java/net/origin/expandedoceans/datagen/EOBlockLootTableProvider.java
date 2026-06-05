package net.origin.expandedoceans.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.origin.expandedoceans.block.EOBlocks;

import java.util.Set;

public class EOBlockLootTableProvider extends BlockLootSubProvider {
    protected EOBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(EOBlocks.WHITE_SAND.get());
        this.dropSelf(EOBlocks.WHITE_SANDSTONE.get());
        this.dropSelf(EOBlocks.CUT_WHITE_SANDSTONE.get());
        this.dropSelf(EOBlocks.CHISELED_WHITE_SANDSTONE.get());
        this.dropSelf(EOBlocks.SMOOTH_WHITE_SANDSTONE.get());
        this.dropSelf(EOBlocks.WHITE_SANDSTONE_SLAB.get());
        this.dropSelf(EOBlocks.WHITE_SANDSTONE_STAIRS.get());
        this.dropSelf(EOBlocks.WHITE_SANDSTONE_WALL.get());
        this.dropSelf(EOBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get());
        this.dropSelf(EOBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get());
        this.dropSelf(EOBlocks.CUT_WHITE_SANDSTONE_SLAB.get());

        this.add(EOBlocks.RED_SEAGRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.add(EOBlocks.TALL_RED_SEAGRASS.get(), this.createDoublePlantShearsDrop(EOBlocks.TALL_RED_SEAGRASS.get()));

        this.dropSelf(EOBlocks.OCEAN_WILLOW_LOG.get());
        this.dropSelf(EOBlocks.OCEAN_WILLOW_WOOD.get());
        this.dropSelf(EOBlocks.STRIPPED_OCEAN_WILLOW_LOG.get());
        this.dropSelf(EOBlocks.STRIPPED_OCEAN_WILLOW_WOOD.get());
        this.dropSelf(EOBlocks.OCEAN_WILLOW_PLANKS.get());
        this.dropSelf(EOBlocks.OCEAN_WILLOW_SAPLING.get());

        this.add(EOBlocks.OCEAN_WILLOW_LEAVES.get(), block -> createLeavesDrops(block, EOBlocks.OCEAN_WILLOW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(EOBlocks.OCEAN_WILLOW_STAIRS.get());
        add(EOBlocks.OCEAN_WILLOW_SLAB.get(), block -> createSlabItemTable(EOBlocks.OCEAN_WILLOW_SLAB.get()));

        dropSelf(EOBlocks.OCEAN_WILLOW_PRESSURE_PLATE.get());
        dropSelf(EOBlocks.OCEAN_WILLOW_BUTTON.get());
        dropSelf(EOBlocks.OCEAN_WILLOW_FENCE.get());
        dropSelf(EOBlocks.OCEAN_WILLOW_FENCE_GATE.get());
        dropSelf(EOBlocks.OCEAN_WILLOW_TRAPDOOR.get());
        add(EOBlocks.OCEAN_WILLOW_DOOR.get(), block -> createDoorTable(EOBlocks.OCEAN_WILLOW_DOOR.get()));

        this.dropSelf(EOBlocks.WATER_MAPLE_LOG.get());
        this.dropSelf(EOBlocks.WATER_MAPLE_WOOD.get());
        this.dropSelf(EOBlocks.STRIPPED_WATER_MAPLE_LOG.get());
        this.dropSelf(EOBlocks.STRIPPED_WATER_MAPLE_WOOD.get());
        this.dropSelf(EOBlocks.WATER_MAPLE_PLANKS.get());
        this.dropSelf(EOBlocks.WATER_MAPLE_SAPLING.get());

        this.add(EOBlocks.WATER_MAPLE_LEAVES.get(), block -> createLeavesDrops(block, EOBlocks.WATER_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(EOBlocks.WATER_MAPLE_STAIRS.get());
        add(EOBlocks.WATER_MAPLE_SLAB.get(), block -> createSlabItemTable(EOBlocks.WATER_MAPLE_SLAB.get()));

        dropSelf(EOBlocks.WATER_MAPLE_PRESSURE_PLATE.get());
        dropSelf(EOBlocks.WATER_MAPLE_BUTTON.get());
        dropSelf(EOBlocks.WATER_MAPLE_FENCE.get());
        dropSelf(EOBlocks.WATER_MAPLE_FENCE_GATE.get());
        dropSelf(EOBlocks.WATER_MAPLE_TRAPDOOR.get());
        add(EOBlocks.WATER_MAPLE_DOOR.get(), block -> createDoorTable(EOBlocks.WATER_MAPLE_DOOR.get()));
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
        return EOBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
