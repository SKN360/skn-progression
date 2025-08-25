package net.skn.sparkprogression;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.skn.sparkprogression.components.ModDataComponentTypes;
import net.skn.sparkprogression.item.ModItemGroups;
import net.skn.sparkprogression.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SKNsProgression implements ModInitializer {
	public static final String MOD_ID = "skns_progression";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() { //TODO: remove Sharpness, Protection, & Efficiency enchantments
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerDataComponentTypes();

		/*TODO: find some way to overwrite vanilla trades (remove/replace diamond and iron)
		 *  this will do as a placeholder */
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 12),
					new ItemStack(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE), 12, 5, 0.2f
			));
		});

		ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of("scrap"),
				FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
				"(SKN's Prog...) Nuggets to Scrap",
				ResourcePackActivationType.DEFAULT_ENABLED
		);

		LOGGER.info(MOD_ID + " did it!");
	}
}