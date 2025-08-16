package net.skn.sparkprogression.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.skn.sparkprogression.SKNsProgression;
import net.skn.sparkprogression.components.ModDataComponentTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.annotation.Target;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "isCorrectForDrops", at = @At("RETURN"), cancellable = true)
    protected void isCorrectForDropsInject(ItemStack stack, BlockState state, CallbackInfoReturnable cir) {
        boolean robert = (
                state.isIn(BlockTags.INCORRECT_FOR_IRON_TOOL) ||
                state.isIn(BlockTags.INCORRECT_FOR_GOLD_TOOL) ||
                state.isIn(BlockTags.INCORRECT_FOR_WOODEN_TOOL) ||
                state.isIn(BlockTags.INCORRECT_FOR_STONE_TOOL)
            ) && stack.getComponents().contains(ModDataComponentTypes.TIPPED);

        ToolComponent toolComponent = stack.get(DataComponentTypes.TOOL);
        cir.setReturnValue(toolComponent != null && (toolComponent.isCorrectForDrops(state) || robert));
    }
}
