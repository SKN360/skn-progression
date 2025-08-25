package net.skn.sparkprogression;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.skn.sparkprogression.components.ModDataComponentTypes;
import net.skn.sparkprogression.item.ModItems;
import net.skn.sparkprogression.util.ModTags;

import java.util.ArrayList;
import java.util.List;

public class SKNsProgressionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //tooltips BEFORE enchantments
        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, lines) -> {
            int insertIndex = 1;
            List<Text> toAdd = new ArrayList<>();
            if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.SOULBOUND))) {
                toAdd.add(net.minecraft.text.Text.translatable("tooltip.skns_progression.components.soulbound").formatted(Formatting.DARK_AQUA));
                toAdd.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
            }
            if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.TIPPED))) {
                toAdd.add(Text.translatable("tooltip.skns_progression.components.tipped").formatted(Formatting.AQUA));
            }
            if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.SHARPENED))) {
                toAdd.add(Text.translatable("tooltip.skns_progression.components.sharpened").formatted(Formatting.RED));
                toAdd.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
            }
            if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.EFFICIENT))) {
                toAdd.add(Text.translatable("tooltip.skns_progression.components.efficient").formatted(Formatting.YELLOW));
                toAdd.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
            }
            if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.PROTECTED))) {
                toAdd.add(Text.translatable("tooltip.skns_progression.components.protected").formatted(Formatting.GOLD));
                toAdd.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
            }
            if (stack.isIn(ModTags.Items.NERFED_ITEMS)) {
                toAdd.add(Text.translatable("tooltip.skns_progression.item.nerfed").formatted(Formatting.RED, Formatting.BOLD));
                if(stack.getItem().getName().toString().contains("diamond")) {
                    toAdd.add(Text.translatable("tooltip.skns_progression.item.nerfed.description").formatted(Formatting.RED));
                    if(stack.getItem() == Items.DIAMOND_PICKAXE) {
                        toAdd.add(Text.translatable("tooltip.skns_progression.item.diamond.line1").formatted(Formatting.BLUE));
                        toAdd.add(Text.translatable("tooltip.skns_progression.item.diamond.line2").formatted(Formatting.BLUE));
                    }
                }
            }
            // script that puts lines in the right spot
            for (int offset = 0; offset < toAdd.size(); offset++) {
                lines.add(insertIndex + offset, toAdd.get(offset));
            }
            // tooltips below everything else
            if(stack.isIn(ModTags.Items.ENHANCEMENT_MATERIAL)) {
                if(stack.getItem() == Items.QUARTZ) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.weapons").formatted(Formatting.BLUE));
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
                } else if(stack.getItem().getName().toString().contains("chainmail")) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.armor").formatted(Formatting.BLUE));
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
                } else if(stack.getItem() == Items.DIAMOND) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.pickaxes").formatted(Formatting.BLUE));
                } else if(stack.getItem() == Items.EMERALD_ORE) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.tools").formatted(Formatting.BLUE));
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
                } else {
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.misc").formatted(Formatting.BLUE));
                    lines.add(Text.translatable("tooltip.skns_progression.item.enhancement_material.wip").formatted(Formatting.YELLOW, Formatting.ITALIC));
                }
            }
            if(!Boolean.TRUE.equals(stack.get(ModDataComponentTypes.TIPPED)) && stack.isIn(ItemTags.PICKAXES)) {
                if (stack.getItem() == Items.WOODEN_PICKAXE) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.wood_tier").formatted(Formatting.BLUE));
                } else if (stack.getItem() == Items.STONE_PICKAXE || stack.getItem() == ModItems.OBSIDIAN_PICKAXE) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.stone_tier").formatted(Formatting.BLUE));
                } else if (stack.getItem() == ModItems.COPPER_PICKAXE) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.lower_metal_tier").formatted(Formatting.BLUE));
                } else if (stack.getItem() == Items.IRON_PICKAXE || stack.getItem() == Items.GOLDEN_PICKAXE) {
                    lines.add(Text.translatable("tooltip.skns_progression.item.upper_metal_tier").formatted(Formatting.BLUE));
                }
            }
        });
    }
}
