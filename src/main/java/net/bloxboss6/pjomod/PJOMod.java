package net.bloxboss6.pjomod;

import net.bloxboss6.pjomod.block.ModBlocks;
import net.bloxboss6.pjomod.item.ModItems;
import net.bloxboss6.pjomod.util.ModRegistries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PJOMod implements ModInitializer {
	public static final String MOD_ID = "pjomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(PJOMod.MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
	}
}
