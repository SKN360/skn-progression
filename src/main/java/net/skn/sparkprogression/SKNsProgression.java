package net.skn.sparkprogression;

import net.fabricmc.api.ModInitializer;
import net.skn.sparkprogression.components.ModDataComponentTypes;
import net.skn.sparkprogression.item.ModItemGroups;
import net.skn.sparkprogression.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SKNsProgression implements ModInitializer {
	public static final String MOD_ID = "skns_progression";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerDataComponentTypes();

		LOGGER.info(MOD_ID + " did it!");
	}
}