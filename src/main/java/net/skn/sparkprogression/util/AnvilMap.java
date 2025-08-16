package net.skn.sparkprogression.util;

import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.skn.sparkprogression.components.ModDataComponentTypes;

import java.util.List;
import java.util.Map;

public class AnvilMap {
    public static final Map<Item, ComponentType> ANVIL_MAP =
            Map.of(
                    Items.DIAMOND, ModDataComponentTypes.TIPPED, // applies to pickaxes
                    Items.QUARTZ, ModDataComponentTypes.SHARPENED, // applies to weapons
                    Items.ECHO_SHARD, ModDataComponentTypes.SOULBOUND, // applies to any item?
                    Items.EMERALD_ORE, ModDataComponentTypes.EFFICIENT, // applies to tools, material not determined...
                    //TODO: determine EFFICIENT component material
                    Items.CHAINMAIL_CHESTPLATE, ModDataComponentTypes.PROTECTED // applies to armor, uses chainmail?
            );
}
