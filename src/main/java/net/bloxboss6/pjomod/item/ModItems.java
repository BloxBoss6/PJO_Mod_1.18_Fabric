package net.bloxboss6.pjomod.item;

import net.bloxboss6.pjomod.PJOMod;
import net.bloxboss6.pjomod.item.custom.RiptidePenItem;
import net.bloxboss6.pjomod.item.template.DrinkItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ModItems {

    // Basic Items
    public static final Item CB_INGOT = registerItem("cb_ingot", ModItemGroup.PJO_BASICS);
    public static final Item IG_INGOT = registerItem("ig_ingot", ModItemGroup.PJO_BASICS);
    public static final Item MA_INGOT = registerItem("ma_ingot", ModItemGroup.PJO_BASICS);
    public static final Item SI_INGOT = registerItem("si_ingot", ModItemGroup.PJO_BASICS);

    public static final Item CB_RAW = registerItem("cb_raw", ModItemGroup.PJO_BASICS);
    public static final Item MA_RAW = registerItem("ma_raw", ModItemGroup.PJO_BASICS);
    public static final Item SI_RAW = registerItem("si_raw", ModItemGroup.PJO_BASICS);

    public static final Item CB_NUGGET = registerItem("cb_nugget", ModItemGroup.PJO_BASICS);
    public static final Item IG_NUGGET = registerItem("ig_nugget", ModItemGroup.PJO_BASICS);
    public static final Item SI_NUGGET = registerItem("si_nugget", ModItemGroup.PJO_BASICS);

    public static final Item CB_ROD = registerItem("cb_rod", ModItemGroup.PJO_BASICS);
    public static final Item IG_ROD = registerItem("ig_rod", ModItemGroup.PJO_BASICS);

    public static final Item AMBROSIA = registerItem("ambrosia", new Item(
            new FabricItemSettings().group(ModItemGroup.PJO_BASICS).food(ModFoodComponents.AMBROSIA)));
    public static final Item BLUE_COOKIE = registerItem("blue_cookie", new Item(
            new FabricItemSettings().group(ModItemGroup.PJO_BASICS).food(ModFoodComponents.BLUE_COOKIE)));
    public static final Item NECTAR_BOTTLE = registerItem("nectar_bottle", new DrinkItem(
            new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.NECTAR_BOTTLE)
                    .group(ModItemGroup.PJO_BASICS).maxCount(16)));

    // Advanced Items
    public static final Item RIPTIDE_PEN = registerItem("riptide_pen", new RiptidePenItem(
            new FabricItemSettings().group(ModItemGroup.PJO_BASICS).maxCount(1)));

    private static Item registerItem(String name, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name), new Item(
                new FabricItemSettings().group(group)));
    }

    private static Item registerItem(String name, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name), new Item(
                new FabricItemSettings().group(group)){
            @Override
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(new TranslatableText(tooltipKey));
            }
        });
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PJOMod.LOGGER.info("Registering Mod Items for " + PJOMod.MOD_ID);
    }
}
