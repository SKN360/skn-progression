package net.skn.sparkprogression.mixin;

import net.minecraft.item.ToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ToolMaterials.class)
public abstract class ToolMaterialsMixin {
    @Inject(method = "getDurability", at = @At("RETURN"), cancellable = true)
    private void getDurabilityInject(CallbackInfoReturnable<Integer> cir) {
        switch ((ToolMaterials) (Object) this) {
            case WOOD, DIAMOND ->  cir.setReturnValue(48);
            case STONE -> cir.setReturnValue(108);
            case GOLD -> cir.setReturnValue(60);
            case IRON -> cir.setReturnValue(750);
            case NETHERITE -> cir.setReturnValue(999999);
        }
    }
    @Inject(method = "getMiningSpeedMultiplier", at = @At("RETURN"), cancellable = true)
    private void getMiningSpeedMultiplierInject(CallbackInfoReturnable<Float> cir) {
        switch ((ToolMaterials) (Object) this) {
            case IRON -> cir.setReturnValue(8F);
            case DIAMOND -> cir.setReturnValue(1F);
        }
    }
    @Inject(method = "getAttackDamage", at = @At("RETURN"), cancellable = true)
    private void getAttackDamageInject(CallbackInfoReturnable<Float> cir) {
        switch ((ToolMaterials) (Object) this) {
            case GOLD -> cir.setReturnValue(2F);
            case DIAMOND -> cir.setReturnValue(0F);
        }
    }
}
