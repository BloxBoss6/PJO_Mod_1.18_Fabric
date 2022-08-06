package net.bloxboss6.pjomod.item;

import net.bloxboss6.pjomod.PJOMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    // Items
    public static final Item CB_INGOT = registerItem("cb_ingot", ItemGroup.MISC);
    public static final Item IG_INGOT = registerItem("ig_ingot", ItemGroup.MISC);
    public static final Item MA_INGOT = registerItem("ma_ingot", ItemGroup.MISC);
    public static final Item SI_INGOT = registerItem("si_ingot", ItemGroup.MISC);

    public static final Item CB_ROD = registerItem("cb_rod", ItemGroup.MISC);
    public static final Item IG_ROD = registerItem("ig_rod", ItemGroup.MISC);

    // Pulled from YouTube Tutorial by Kaupenjoe
    /*
    private static Item youtubeRegisterItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name), item);
    }
    */

    private static Item registerItem(String name, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name), new Item(new FabricItemSettings().group(group)));
    }
    public static void registerModItems() {
        PJOMod.LOGGER.info("Registering Mod Items for " + PJOMod.MOD_ID);
    }
}
