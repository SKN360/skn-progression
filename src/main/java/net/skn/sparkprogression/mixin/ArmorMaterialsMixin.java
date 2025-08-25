package net.skn.sparkprogression.mixin;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.EnumMap;

@Mixin(ArmorMaterials.class)
public class ArmorMaterialsMixin {
    @ModifyVariable(method = "register", at = @At(value = "HEAD", ordinal = 0), argsOnly = true)
    private static EnumMap<ArmorItem.Type, Integer> modifyArmorDefense(EnumMap<ArmorItem.Type, Integer> defense, String id) {
        if ("diamond".equals(id)) {
            defense.put(ArmorItem.Type.HELMET, 1);
            defense.put(ArmorItem.Type.CHESTPLATE, 2);
            defense.put(ArmorItem.Type.LEGGINGS, 1);
            defense.put(ArmorItem.Type.BOOTS, 0);
        } else if ("gold".equals(id)) {
            defense.put(ArmorItem.Type.HELMET, 2);
            defense.put(ArmorItem.Type.CHESTPLATE, 6);
            defense.put(ArmorItem.Type.LEGGINGS, 5);
            defense.put(ArmorItem.Type.BOOTS, 2);
        } else if ("iron".equals(id)) {
            defense.put(ArmorItem.Type.HELMET, 3);
            defense.put(ArmorItem.Type.CHESTPLATE, 8);
            defense.put(ArmorItem.Type.LEGGINGS, 6);
            defense.put(ArmorItem.Type.BOOTS, 3);
        }
        return defense;
    }
}
