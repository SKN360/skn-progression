package net.skn.sparkprogression.mixin;

import net.minecraft.item.ToolMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ToolMaterials.class)
public class ToolMaterialsMixin {
    /*
    * TODO: learn to use "@WrapOperation" for performance and compatibility purposes
    * WIKI: https://github.com/LlamaLad7/MixinExtras/wiki/WrapOperation
     */
    @Inject(method = "getDurability", at = @At("RETURN"), cancellable = true)
    private void getDurabilityInject(CallbackInfoReturnable<Integer> cir) {
        switch ((Object) this) {
            case ToolMaterials.GOLD: cir.setReturnValue(60);
            case ToolMaterials.IRON: cir.setReturnValue(750);
            case ToolMaterials.WOOD, ToolMaterials.DIAMOND: cir.setReturnValue(36);
            case ToolMaterials.STONE: cir.setReturnValue(108);
            case ToolMaterials.NETHERITE: cir.setReturnValue(999999);
            default:break;
        }
    }
    @Inject(method = "getMiningSpeedMultiplier", at = @At("RETURN"), cancellable = true)
    private void getMiningSpeedMultiplierInject(CallbackInfoReturnable<Float> cir) {
        switch ((Object) this) {
            case ToolMaterials.IRON: cir.setReturnValue(8F);
            case ToolMaterials.DIAMOND: cir.setReturnValue(1F);
            default:break;
        }
    }
    @Inject(method = "getAttackDamage", at = @At("RETURN"), cancellable = true)
    private void getAttackDamageInject(CallbackInfoReturnable<Float> cir) {
        switch ((Object) this) {
            case ToolMaterials.GOLD: cir.setReturnValue(2F);
            case ToolMaterials.DIAMOND: cir.setReturnValue(0F);
            default:break;
        }
    }
}
