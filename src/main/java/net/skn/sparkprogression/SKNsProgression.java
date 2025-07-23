package net.skn.sparkprogression;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SKNsProgression implements ModInitializer {
	public static final String MOD_ID = "skns-progression";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {



		LOGGER.info("We did it!");
	}
}