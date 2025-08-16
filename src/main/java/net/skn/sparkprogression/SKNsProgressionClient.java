package net.skn.sparkprogression;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.skn.sparkprogression.components.ModDataComponentTypes;

import java.util.ArrayList;
import java.util.List;

public class SKNsProgressionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, tooltipContext, tooltipType, lines) -> {
            int insertIndex = 1;
            List<Text> toAdd = new ArrayList<>();
            if (stack.getComponents().contains(ModDataComponentTypes.SOULBOUND)) {
                toAdd.add(
                        net.minecraft.text.Text.translatable("tooltip.skns_progression.components.soulbound")
                                .formatted(Formatting.DARK_AQUA)
                );
            }
            if (stack.getComponents().contains(ModDataComponentTypes.TIPPED)) {
                toAdd.add(
                        Text.translatable("tooltip.skns_progression.components.tipped")
                                .formatted(Formatting.AQUA)
                );
            }
            if (stack.getComponents().contains(ModDataComponentTypes.SHARPENED)) {
                toAdd.add(
                        Text.translatable("tooltip.skns_progression.components.sharpened")
                                .formatted(Formatting.RED)
                );
            }
            if (stack.getComponents().contains(ModDataComponentTypes.EFFICIENT)) {
                toAdd.add(
                        Text.translatable("tooltip.skns_progression.components.efficient")
                                .formatted(Formatting.YELLOW)
                );
            }
            if (stack.getComponents().contains(ModDataComponentTypes.PROTECTED)) {
                toAdd.add(
                        Text.translatable("tooltip.skns_progression.components.protected")
                                .formatted(Formatting.GOLD)
                );
            }
            for (int offset = 0; offset < toAdd.size(); offset++) {
                lines.add(insertIndex + offset, toAdd.get(offset));
            }
        });
    }
}
