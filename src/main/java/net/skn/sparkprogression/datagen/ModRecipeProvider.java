package net.skn.sparkprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
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

        // Misc Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_UPGRADE_SMITHING_TEMPLATE)
                .pattern("RTR")
                .pattern("RBR")
                .pattern("RRR")
                .input('R', Items.COPPER_INGOT)
                .input('B', Items.COBBLED_DEEPSLATE)
                .input('T', ModItems.IRON_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE))
        ;
        // Obsidian
        offerSwordRecipe(exporter, RecipeCategory.TOOLS, ModItems.OBSIDIAN_SWORD, Items.OBSIDIAN);
        offerAxeRecipe(exporter, RecipeCategory.TOOLS, ModItems.OBSIDIAN_AXE, Items.OBSIDIAN);
        offerPickaxeRecipe(exporter, RecipeCategory.TOOLS, ModItems.OBSIDIAN_PICKAXE, Items.OBSIDIAN);
        offerShovelRecipe(exporter, RecipeCategory.TOOLS, ModItems.OBSIDIAN_SHOVEL, Items.OBSIDIAN);
        offerHoeRecipe(exporter, RecipeCategory.TOOLS, ModItems.OBSIDIAN_HOE, Items.OBSIDIAN);
        // Copper
        offerSwordRecipe(exporter, RecipeCategory.TOOLS, ModItems.COPPER_SWORD, Items.COPPER_INGOT);
        offerAxeRecipe(exporter, RecipeCategory.TOOLS, ModItems.COPPER_AXE, Items.COPPER_INGOT);
        offerPickaxeRecipe(exporter, RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE, Items.COPPER_INGOT);
        offerShovelRecipe(exporter, RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL, Items.COPPER_INGOT);
        offerHoeRecipe(exporter, RecipeCategory.TOOLS, ModItems.COPPER_HOE, Items.COPPER_INGOT);

        // Chainmail armor
        offerHelmetRecipe(exporter, RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET, Items.CHAIN);
        offerChestplateRecipe(exporter, RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE, Items.CHAIN);
        offerLeggingsRecipe(exporter, RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS, Items.CHAIN);
        offerBootsRecipe(exporter, RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS, Items.CHAIN);
    }

    //private functions
    private static void offerSwordRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("R")
                .pattern("R")
                .pattern("I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerPickaxeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("RRR")
                .pattern(" I ")
                .pattern(" I ")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerAxeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("RR")
                .pattern("RI")
                .pattern(" I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerShovelRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("R")
                .pattern("I")
                .pattern("I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerHoeRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("RR")
                .pattern(" I")
                .pattern(" I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private static void offerHelmetRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("RRR")
                .pattern("R R")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerChestplateRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerLeggingsRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerBootsRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(category, output)
                .pattern("R R")
                .pattern("R R")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
}
