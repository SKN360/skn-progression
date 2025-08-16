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

        // Upgrade
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
        offerSwordRecipe(exporter, ModItems.OBSIDIAN_SWORD, Items.OBSIDIAN);
        offerAxeRecipe(exporter, ModItems.OBSIDIAN_AXE, Items.OBSIDIAN);
        offerPickaxeRecipe(exporter, ModItems.OBSIDIAN_PICKAXE, Items.OBSIDIAN);
        offerShovelRecipe(exporter, ModItems.OBSIDIAN_SHOVEL, Items.OBSIDIAN);
        offerHoeRecipe(exporter, ModItems.OBSIDIAN_HOE, Items.OBSIDIAN);
        // Copper
        offerSwordRecipe(exporter, ModItems.COPPER_SWORD, Items.COPPER_INGOT);
        offerAxeRecipe(exporter, ModItems.COPPER_AXE, Items.COPPER_INGOT);
        offerPickaxeRecipe(exporter, ModItems.COPPER_PICKAXE, Items.COPPER_INGOT);
        offerShovelRecipe(exporter, ModItems.COPPER_SHOVEL, Items.COPPER_INGOT);
        offerHoeRecipe(exporter, ModItems.COPPER_HOE, Items.COPPER_INGOT);
        offerHelmetRecipe(exporter, ModItems.COPPER_HELMET, Items.COPPER_INGOT);
        offerChestplateRecipe(exporter, ModItems.COPPER_CHESTPLATE, Items.COPPER_INGOT);
        offerLeggingsRecipe(exporter, ModItems.COPPER_LEGGINGS, Items.COPPER_INGOT);
        offerBootsRecipe(exporter, ModItems.COPPER_BOOTS, Items.COPPER_INGOT);

        // Chainmail armor
        offerHelmetRecipe(exporter, Items.CHAINMAIL_HELMET, Items.CHAIN);
        offerChestplateRecipe(exporter, Items.CHAINMAIL_CHESTPLATE, Items.CHAIN);
        offerLeggingsRecipe(exporter, Items.CHAINMAIL_LEGGINGS, Items.CHAIN);
        offerBootsRecipe(exporter, Items.CHAINMAIL_BOOTS, Items.CHAIN);
    }

    //private functions
    private static void offerSwordRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("R")
                .pattern("R")
                .pattern("I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerPickaxeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("RRR")
                .pattern(" I ")
                .pattern(" I ")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerAxeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("RR")
                .pattern("RI")
                .pattern(" I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerShovelRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("R")
                .pattern("I")
                .pattern("I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerHoeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("RR")
                .pattern(" I")
                .pattern(" I")
                .input('I', Items.STICK).input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private static void offerHelmetRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RRR")
                .pattern("R R")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerChestplateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerLeggingsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    private static void offerBootsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("R R")
                .pattern("R R")
                .input('R', input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
}
