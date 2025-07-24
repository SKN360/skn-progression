package net.skn.sparkprogression.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.skn.sparkprogression.SKNsProgression;

import java.util.List;

public class ModItems {

    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));
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
        });
    }
}
