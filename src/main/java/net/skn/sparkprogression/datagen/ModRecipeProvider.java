package net.skn.sparkprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.skn.sparkprogression.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        // Basic Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_UPGRADE_SMITHING_TEMPLATE)
                .pattern("RTR")
                .pattern("RBR")
                .pattern("RRR")
                .input('R', Items.COPPER_INGOT)
                .input('B', Items.COBBLED_DEEPSLATE)
                .input('T', ModItems.IRON_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
        ;
        // Chainmail armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CHAINMAIL_BOOTS)
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
        ;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CHAINMAIL_LEGGINGS)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
        ;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CHAINMAIL_BOOTS)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
        ;
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CHAINMAIL_BOOTS)
                .pattern("CCC")
                .pattern("C C")
                .input('C', Items.CHAIN)
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
        ;
    }
}
