package net.skn.sparkprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.skn.sparkprogression.item.ModItems;
import net.skn.sparkprogression.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //Vanilla tags
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.OBSIDIAN_SWORD)
                .add(ModItems.COPPER_SWORD)
        ;
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.OBSIDIAN_AXE)
                .add(ModItems.COPPER_AXE)
        ;
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.OBSIDIAN_PICKAXE)
                .add(ModItems.COPPER_PICKAXE)
        ;
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.OBSIDIAN_SHOVEL)
                .add(ModItems.COPPER_SHOVEL)
        ;
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.OBSIDIAN_HOE)
                .add(ModItems.COPPER_HOE)
        ;
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_BOOTS)
        ;
        //Mod Tags
        getOrCreateTagBuilder(ModTags.Items.ENHANCEMENT_MATERIAL)
                .add(Items.DIAMOND)
                .add(Items.ECHO_SHARD)
                .add(Items.QUARTZ)
                .add(Items.EMERALD_ORE)
                .add(Items.CHAINMAIL_HELMET)
                .add(Items.CHAINMAIL_CHESTPLATE)
                .add(Items.CHAINMAIL_LEGGINGS)
                .add(Items.CHAINMAIL_BOOTS)
        ;
        getOrCreateTagBuilder(ModTags.Items.NERFED_ITEMS)
                .add(Items.DIAMOND_SWORD)
                .add(Items.DIAMOND_AXE)
                .add(Items.DIAMOND_PICKAXE)
                .add(Items.DIAMOND_SHOVEL)
                .add(Items.DIAMOND_HOE)
                .add(Items.DIAMOND_HELMET)
                .add(Items.DIAMOND_CHESTPLATE)
                .add(Items.DIAMOND_LEGGINGS)
                .add(Items.DIAMOND_BOOTS)
        ;
    }
}
