package net.skn.sparkprogression.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.*;
import net.skn.sparkprogression.components.ModDataComponentTypes;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {
    @Shadow Property levelCost;
    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context){
        super(type, syncId, playerInventory, context);
    }


    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
    public void InjectUpdateResult(CallbackInfo ci) {
        ItemStack inputStack = this.input.getStack(0); //formerly itemStack
        ItemStack addStack = this.input.getStack(1); //formerly itemStack2
        ItemStack outputStack = inputStack.copy(); //formerly itemStack3

        if(inputStack.isIn(ItemTags.PICKAXES) && addStack.getItem() == Items.DIAMOND &&
                !inputStack.getComponents().contains(ModDataComponentTypes.TIPPED)) {

            outputStack.set(ModDataComponentTypes.TIPPED, true);
            this.output.setStack(0, outputStack);
            this.levelCost.set(5);
            this.sendContentUpdates();
            ci.cancel();

        } else if (inputStack.isIn(ItemTags.MINING_ENCHANTABLE) && addStack.getItem() == Items.EMERALD_ORE && //TODO: Confirm component:Efficient material
        !inputStack.getComponents().contains(ModDataComponentTypes.EFFICIENT)) {
            outputStack.set(ModDataComponentTypes.EFFICIENT, true);
            this.output.setStack(0, outputStack);
            this.levelCost.set(3);
            ci.cancel();

        } else if (inputStack.isIn(ItemTags.SHARP_WEAPON_ENCHANTABLE) && addStack.getItem() == Items.QUARTZ &&
        !inputStack.getComponents().contains(ModDataComponentTypes.SHARPENED)) {
            outputStack.set(ModDataComponentTypes.SHARPENED, true);
            this.output.setStack(0, outputStack);
            this.levelCost.set(3);
            ci.cancel();

        } else if (
                (
                    inputStack.isIn(ItemTags.HEAD_ARMOR) && addStack.getItem() == Items.CHAINMAIL_HELMET
                    || inputStack.isIn(ItemTags.CHEST_ARMOR) && addStack.getItem() == Items.CHAINMAIL_CHESTPLATE
                    || inputStack.isIn(ItemTags.LEG_ARMOR) && addStack.getItem() == Items.CHAINMAIL_LEGGINGS
                    || inputStack.isIn(ItemTags.FOOT_ARMOR) && addStack.getItem() == Items.CHAINMAIL_BOOTS
                ) && !inputStack.getComponents().contains(ModDataComponentTypes.PROTECTED)) {
            outputStack.set(ModDataComponentTypes.PROTECTED, true);
            this.output.setStack(0, outputStack);
            this.levelCost.set(3);
            ci.cancel();

        } else if (addStack.getItem() == Items.ECHO_SHARD &&
        !inputStack.getComponents().contains(ModDataComponentTypes.SOULBOUND)) {
            outputStack.set(ModDataComponentTypes.SOULBOUND, true);
            this.output.setStack(0, outputStack);
            this.levelCost.set(10);
            ci.cancel();

        }

    }

}
