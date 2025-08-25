package net.skn.sparkprogression.mixin;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.*;
import net.minecraft.util.Identifier;
import net.skn.sparkprogression.SKNsProgression;
import net.skn.sparkprogression.components.ModDataComponentTypes;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.BiConsumer;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {
    /*
    TODO: reduce repetition, fix using EVERY additionStack item (use 1)*/

    @Shadow Property levelCost;
    @Shadow private int repairItemUsage;
    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context){
        super(type, syncId, playerInventory, context);
    }

    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true, order = 500)
    public void InjectUpdateResult(CallbackInfo ci) {
        ItemStack inputStack = this.input.getStack(0);
        ItemStack additionStack = this.input.getStack(1);
        ItemStack outputStack = inputStack.copy();

        if(inputStack.isIn(ItemTags.PICKAXES) && additionStack.getItem() == Items.DIAMOND &&
                !Boolean.TRUE.equals(inputStack.get(ModDataComponentTypes.TIPPED))) {
            outputStack.set(ModDataComponentTypes.TIPPED, true);
            this.output.setStack(0, outputStack);
            finalizeResult(outputStack, 5, ci);
        } else if (inputStack.isIn(ItemTags.MINING_ENCHANTABLE) && additionStack.getItem() == Items.EMERALD_ORE &&
                !Boolean.TRUE.equals(inputStack.get(ModDataComponentTypes.EFFICIENT))) {
            outputStack.set(ModDataComponentTypes.EFFICIENT, true);
            //increase pickaxe efficiency code
            finalizeResult(outputStack, 3, ci);
        } else if (inputStack.isIn(ItemTags.SHARP_WEAPON_ENCHANTABLE) && additionStack.getItem() == Items.QUARTZ &&
                !Boolean.TRUE.equals(inputStack.get(ModDataComponentTypes.SHARPENED))) {
            outputStack.set(ModDataComponentTypes.SHARPENED, true);
            //increase item damage code
            finalizeResult(outputStack, 3, ci);
        } else if (
                (
                    inputStack.isIn(ItemTags.HEAD_ARMOR) && additionStack.getItem() == Items.CHAINMAIL_HELMET
                    || inputStack.isIn(ItemTags.CHEST_ARMOR) && additionStack.getItem() == Items.CHAINMAIL_CHESTPLATE
                    || inputStack.isIn(ItemTags.LEG_ARMOR) && additionStack.getItem() == Items.CHAINMAIL_LEGGINGS
                    || inputStack.isIn(ItemTags.FOOT_ARMOR) && additionStack.getItem() == Items.CHAINMAIL_BOOTS
                ) &&  !Boolean.TRUE.equals(inputStack.get(ModDataComponentTypes.PROTECTED))) {
            outputStack.set(ModDataComponentTypes.PROTECTED, true);
            //increase equipment armor code (toughness?)
            finalizeResult(outputStack, 3, ci);
        } else if (additionStack.getItem() == Items.ECHO_SHARD &&
                !Boolean.TRUE.equals(inputStack.get(ModDataComponentTypes.SOULBOUND))) {
            outputStack.set(ModDataComponentTypes.SOULBOUND, true);
            finalizeResult(outputStack, 10, ci);
        }
    }

    @Unique
    private void finalizeResult(ItemStack outputStack, int lvlCost, CallbackInfo ci) { //I didn't like the repeats
        this.output.setStack(0, outputStack);
        this.levelCost.set(lvlCost);
        this.repairItemUsage = 1;
        this.sendContentUpdates();
        ci.cancel();
    }

}
