package net.skn.sparkprogression;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.skn.sparkprogression.datagen.ModBlockTagProvider;
import net.skn.sparkprogression.datagen.ModItemTagProvider;
import net.skn.sparkprogression.datagen.ModLootTableProvider;
import net.skn.sparkprogression.datagen.ModModelProvider;
import net.skn.sparkprogression.datagen.ModRecipeProvider;

public class SKNsProgressionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
