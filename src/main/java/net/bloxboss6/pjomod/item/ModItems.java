package net.bloxboss6.pjomod.item;

import net.bloxboss6.pjomod.PJOMod;
import net.bloxboss6.pjomod.block.ModBlocks;
import net.bloxboss6.pjomod.item.custom.RiptidePenItem;
import net.bloxboss6.pjomod.item.template.ModAxeItem;
import net.bloxboss6.pjomod.item.template.ModDrinkItem;
import net.bloxboss6.pjomod.item.template.ModHoeItem;
import net.bloxboss6.pjomod.item.template.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
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
    // Celestial Bronze
    public static final Item CB_INGOT = registerItem("celestial_bronze_ingot", ModItemGroup.PJO_BASICS);
    public static final Item CB_NUGGET = registerItem("celestial_bronze_nugget", ModItemGroup.PJO_BASICS);
    public static final Item CB_RAW = registerItem("celestial_bronze_raw", ModItemGroup.PJO_BASICS);
    public static final Item CB_ROD = registerItem("celestial_bronze_rod", ModItemGroup.PJO_BASICS);
    // Imperial Gold
    public static final Item IG_INGOT = registerItem("imperial_gold_ingot", ModItemGroup.PJO_BASICS);
    public static final Item IG_NUGGET = registerItem("imperial_gold_nugget", ModItemGroup.PJO_BASICS);
    public static final Item IG_ROD = registerItem("imperial_gold_rod", ModItemGroup.PJO_BASICS);
    // Mixed Alloy
    public static final Item MA_INGOT = registerItem("mixed_alloy_ingot", ModItemGroup.PJO_BASICS);
    public static final Item MA_RAW = registerItem("mixed_alloy_raw", ModItemGroup.PJO_BASICS);
    // Stygian Iron
    public static final Item SI_INGOT = registerItem("stygian_iron_ingot", ModItemGroup.PJO_BASICS);
    public static final Item SI_NUGGET = registerItem("stygian_iron_nugget", ModItemGroup.PJO_BASICS);
    public static final Item SI_RAW = registerItem("stygian_iron_raw", ModItemGroup.PJO_BASICS);

    // Tools
    public static final Item CB_SWORD = registerItem("celestial_bronze_sword", new SwordItem(
            ModToolMaterials.CELESTIAL_BRONZE,3,-2.4f, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_SHOVEL = registerItem("celestial_bronze_shovel", new ShovelItem(
            ModToolMaterials.CELESTIAL_BRONZE,1.5F,-3.0f, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_PICKAXE = registerItem("celestial_bronze_pickaxe", new ModPickaxeItem(
            ModToolMaterials.CELESTIAL_BRONZE,1,-2.8f, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_AXE = registerItem("celestial_bronze_axe", new ModAxeItem(
            ModToolMaterials.CELESTIAL_BRONZE,5,-3.0f, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_HOE = registerItem("celestial_bronze_hoe", new ModHoeItem(
            ModToolMaterials.CELESTIAL_BRONZE,-3,0f, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));

    // Armor
    public static final Item CB_HELMET = registerItem("celestial_bronze_helmet", new ArmorItem(
            ModArmorMaterials.CELESTIAL_BRONZE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_CHESTPLATE = registerItem("celestial_bronze_chestplate", new ArmorItem(
            ModArmorMaterials.CELESTIAL_BRONZE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_LEGGINGS = registerItem("celestial_bronze_leggings", new ArmorItem(
            ModArmorMaterials.CELESTIAL_BRONZE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item CB_BOOTS = registerItem("celestial_bronze_boots", new ArmorItem(
            ModArmorMaterials.CELESTIAL_BRONZE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));

    // Food
    public static final Item AMBROSIA = registerItem("ambrosia", new Item(
            new FabricItemSettings().group(ModItemGroup.PJO_BASICS).food(ModFoodComponents.AMBROSIA)));
    public static final Item BLUE_COOKIE = registerItem("blue_cookie", new Item(
            new FabricItemSettings().group(ModItemGroup.PJO_BASICS).food(ModFoodComponents.BLUE_COOKIE)));
    public static final Item NECTAR_BOTTLE = registerItem("nectar_bottle", new ModDrinkItem(
            new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.NECTAR_BOTTLE)
                    .group(ModItemGroup.PJO_BASICS).maxCount(16)));

    // Plants
    public static final Item DRAGON_TOOTH_SEEDS = registerItem("dragon_tooth_seeds", new AliasedBlockItem(
            ModBlocks.DRAGON_TOOTH, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));
    public static final Item LAUREL = registerItem("laurel", ModItemGroup.PJO_BASICS);
    public static final Item LAUREL_SEEDS = registerItem("laurel_seeds", new AliasedBlockItem(
            ModBlocks.LAUREL_BUSH, new FabricItemSettings().group(ModItemGroup.PJO_BASICS)));

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
