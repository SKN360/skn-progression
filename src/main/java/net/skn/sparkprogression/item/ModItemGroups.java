package net.skn.sparkprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.skn.sparkprogression.SKNsProgression;

public class ModItemGroups {
    public static final ItemGroup SKNS_INVOLVED_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SKNsProgression.MOD_ID, "involved_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
                    .displayName(Text.translatable("itemgroup.skns_progression.involved_items"))

                    .entries((displayContext, entries) -> {
                        entries.add(Items.OAK_PLANKS);
                        entries.add(Items.BIRCH_PLANKS);
                        entries.add(Items.SPRUCE_PLANKS);
                        entries.add(Items.DARK_OAK_PLANKS);
                        entries.add(Items.JUNGLE_PLANKS);
                        entries.add(Items.ACACIA_PLANKS);
                        entries.add(Items.CHERRY_PLANKS);
                        entries.add(Items.BAMBOO_PLANKS);
                        entries.add(Items.MANGROVE_PLANKS);
                        entries.add(Items.CRIMSON_PLANKS);
                        entries.add(Items.WARPED_PLANKS);

                        entries.add(Items.CRAFTING_TABLE);

                        entries.add(Items.WOODEN_AXE);
                        entries.add(Items.WOODEN_SWORD);
                        entries.add(Items.WOODEN_PICKAXE);
                        entries.add(Items.WOODEN_SHOVEL);
                        entries.add(Items.WOODEN_HOE);

                        entries.add(Items.LEATHER_HELMET);
                        entries.add(Items.LEATHER_CHESTPLATE);
                        entries.add(Items.LEATHER_LEGGINGS);
                        entries.add(Items.LEATHER_BOOTS);

                        entries.add(Items.COBBLESTONE);
                        entries.add(Items.COBBLED_DEEPSLATE);
                        entries.add(Items.BLACKSTONE);

                        entries.add(Items.STONE_AXE);
                        entries.add(Items.STONE_SWORD);
                        entries.add(Items.STONE_PICKAXE);
                        entries.add(Items.STONE_SHOVEL);
                        entries.add(Items.STONE_HOE);

                        entries.add(Items.OBSIDIAN);

//                        entries.add(ModItems.OBSIDIAN_AXE);
//                        entries.add(ModItems.OBSIDIAN_SWORD);
//                        entries.add(ModItems.OBSIDIAN_PICKAXE);
//                        entries.add(ModItems.OBSIDIAN_SHOVEL);
//                        entries.add(ModItems.OBSIDIAN_HOE);

                        entries.add(Items.FURNACE);

                        entries.add(ModItems.COPPER_NUGGET);
                        entries.add(Items.COPPER_INGOT);
                        entries.add(Items.COPPER_BLOCK);

//                        entries.add(ModItems.COPPER_AXE);
//                        entries.add(ModItems.COPPER_SWORD);
//                        entries.add(ModItems.COPPER_PICKAXE);
//                        entries.add(ModItems.COPPER_SHOVEL);
//                        entries.add(ModItems.COPPER_HOE);

//                        entries.add(ModItems.COPPER_HELMET);
//                        entries.add(ModItems.COPPER_CHESTPLATE);
//                        entries.add(ModItems.COPPER_LEGGINGS);
//                        entries.add(ModItems.COPPER_BOOTS);

                        entries.add(Items.GOLD_NUGGET);
                        entries.add(Items.GOLD_INGOT);
                        entries.add(Items.GOLD_BLOCK);

                        entries.add(Items.GOLDEN_AXE);
                        entries.add(Items.GOLDEN_SWORD);
                        entries.add(Items.GOLDEN_PICKAXE);
                        entries.add(Items.GOLDEN_SHOVEL);
                        entries.add(Items.GOLDEN_HOE);

                        entries.add(Items.GOLDEN_HELMET);
                        entries.add(Items.GOLDEN_CHESTPLATE);
                        entries.add(Items.GOLDEN_LEGGINGS);
                        entries.add(Items.GOLDEN_BOOTS);

                        entries.add(Items.IRON_NUGGET);
                        entries.add(Items.IRON_INGOT);
                        entries.add(Items.IRON_BLOCK);

                        entries.add(Items.CHAIN);

                        entries.add(Items.CHAINMAIL_HELMET);
                        entries.add(Items.CHAINMAIL_CHESTPLATE);
                        entries.add(Items.CHAINMAIL_LEGGINGS);
                        entries.add(Items.CHAINMAIL_BOOTS);

                        entries.add(Items.SMITHING_TABLE);

                        entries.add(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE);

                        entries.add(Items.IRON_AXE);
                        entries.add(Items.IRON_SWORD);
                        entries.add(Items.IRON_PICKAXE);
                        entries.add(Items.IRON_SHOVEL);
                        entries.add(Items.IRON_HOE);

                        entries.add(Items.IRON_HELMET);
                        entries.add(Items.IRON_CHESTPLATE);
                        entries.add(Items.IRON_LEGGINGS);
                        entries.add(Items.IRON_BOOTS);

                        entries.add(Items.ANVIL);

                        entries.add(Items.DIAMOND);
                        entries.add(Items.ECHO_SHARD);

                        entries.add(Items.ANCIENT_DEBRIS);
                        entries.add(Items.NETHERITE_SCRAP);
                        entries.add(Items.NETHERITE_INGOT);
                        entries.add(Items.NETHERITE_BLOCK);

                        entries.add(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);

                        entries.add(Items.NETHERITE_AXE);
                        entries.add(Items.NETHERITE_SWORD);
                        entries.add(Items.NETHERITE_PICKAXE);
                        entries.add(Items.NETHERITE_SHOVEL);
                        entries.add(Items.NETHERITE_HOE);

                        entries.add(Items.NETHERITE_HELMET);
                        entries.add(Items.NETHERITE_CHESTPLATE);
                        entries.add(Items.NETHERITE_LEGGINGS);
                        entries.add(Items.NETHERITE_BOOTS);

                        entries.add(Items.ENCHANTING_TABLE);
                    })
                    .build());



    public static void registerItemGroups() {
        SKNsProgression.LOGGER.info("registering Item Groups for " + SKNsProgression.MOD_ID);
    }
}
