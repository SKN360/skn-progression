package net.skn.sparkprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.skn.sparkprogression.SKNsProgression;

import java.util.List;

public class ModItems {

    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -2.4f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 6, -3.2f))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 1, -2.4f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER, 1.5f, -3.0f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER, 0, -3f))));

    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            new SwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 3, -2.4f))));
    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe",
            new AxeItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 6, -3.2f))));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            new PickaxeItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 1, -2.4f))));
    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel",
            new ShovelItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 1.5f, -3.0f))));
    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
            new HoeItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 0, -3f))));

    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = registerItem("iron_upgrade_smithing_template",
            createIronUpgradeSmithingTemplate());

    private static Item createIronUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(
                Text.translatable("tooltip.skns_progression.smithing_template.iron_upgrade.applies_to"),
                Text.translatable("tooltip.skns_progression.smithing_template.iron_upgrade.ingredients"),
                Text.translatable("upgrade.skns_progression.smithing_template_iron_upgrade"),
                Text.translatable("tooltip.skns_progression.smithing_template.iron_upgrade.base_slot_description"),
                Text.translatable("tooltip.skns_progression.smithing_template.iron_upgrade.additions_slot_description"),
                getEquipmentUpgradeEmptyBaseSlotTextures(),
                getIronUpgradeEmptyAdditionsSlotTextures()
        );
    }
    private static List<Identifier> getEquipmentUpgradeEmptyBaseSlotTextures() {
        return List.of(
                Identifier.of("minecraft", "item/empty_armor_slot_helmet"),
                Identifier.of("minecraft", "item/empty_armor_slot_chestplate"),
                Identifier.of("minecraft", "item/empty_armor_slot_leggings"),
                Identifier.of("minecraft", "item/empty_armor_slot_boots"),
                Identifier.of("minecraft", "item/empty_slot_sword"),
                Identifier.of("minecraft", "item/empty_slot_pickaxe"),
                Identifier.of("minecraft", "item/empty_slot_axe"),
                Identifier.of("minecraft", "item/empty_slot_shovel"),
                Identifier.of("minecraft", "item/empty_slot_hoe")
        );
    }
    private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
        return List.of(Identifier.of("minecraft", "item/empty_slot_ingot"));
    }



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SKNsProgression.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SKNsProgression.LOGGER.info("Registering Items for " + SKNsProgression.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.IRON_NUGGET, COPPER_NUGGET);
            entries.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, IRON_UPGRADE_SMITHING_TEMPLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.STONE_HOE, ModItems.OBSIDIAN_SHOVEL);
            entries.addAfter(ModItems.OBSIDIAN_SHOVEL, ModItems.OBSIDIAN_PICKAXE);
            entries.addAfter(ModItems.OBSIDIAN_PICKAXE, ModItems.OBSIDIAN_AXE);
            entries.addAfter(ModItems.OBSIDIAN_AXE, ModItems.OBSIDIAN_HOE);
            entries.addAfter(ModItems.OBSIDIAN_HOE, ModItems.COPPER_SHOVEL);
            entries.addAfter(ModItems.COPPER_SHOVEL, ModItems.COPPER_PICKAXE);
            entries.addAfter(ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE);
            entries.addAfter(ModItems.COPPER_AXE, ModItems.COPPER_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.STONE_SWORD, ModItems.OBSIDIAN_SWORD);
            entries.addAfter(Items.STONE_AXE, ModItems.OBSIDIAN_AXE);
            entries.addBefore(Items.IRON_SWORD, ModItems.COPPER_SWORD);
            entries.addBefore(Items.IRON_AXE, ModItems.COPPER_AXE);
        });
    }
}
