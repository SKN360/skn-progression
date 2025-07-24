package net.skn.sparkprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(Blocks.COPPER_ORE, metalOreDrops(Blocks.COPPER_ORE, Items.RAW_COPPER, 2.0F, 5.0F));
        addDrop(Blocks.DEEPSLATE_COPPER_ORE, metalOreDrops(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 3.0F, 5.0F));
        addDrop(Blocks.IRON_ORE, metalOreDrops(Blocks.IRON_ORE, Items.RAW_IRON, 2.0F, 5.0F));
        addDrop(Blocks.DEEPSLATE_IRON_ORE, metalOreDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 3.0F, 5.0F));
        addDrop(Blocks.GOLD_ORE, metalOreDrops(Blocks.GOLD_ORE, Items.RAW_GOLD, 2.0F, 5.0F));
        addDrop(Blocks.DEEPSLATE_GOLD_ORE, metalOreDrops(Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 3.0F, 5.0F));
        addDrop(Blocks.NETHER_GOLD_ORE, metalOreDrops(Blocks.NETHER_GOLD_ORE, Items.GOLD_NUGGET, 4.0F, 8.0F));
    }

    public LootTable.Builder metalOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
