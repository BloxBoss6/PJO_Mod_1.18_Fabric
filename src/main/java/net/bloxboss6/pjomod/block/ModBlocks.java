package net.bloxboss6.pjomod.block;

import net.bloxboss6.pjomod.PJOMod;
import net.bloxboss6.pjomod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import java.util.List;

public class ModBlocks {

    public static final Block CB_ORE = registerBlock("cb_ore", Material.METAL, ModItemGroup.PJO_BASICS, 6f, "tooltip.pjomod.cb_ore");
    public static final Block NSI_ORE = registerBlock("nsi_ore", Material.METAL, ModItemGroup.PJO_BASICS, 6f);
    public static final Block SI_ORE = registerBlock("si_ore", Material.METAL, ModItemGroup.PJO_BASICS, 6f);

    // Added from YouTube tutorial by Kaupenjoe
    /*
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(PJOMod.MOD_ID, name), block);
    }
    */

    // Default Method for registering blocks
    private static Block registerBlock(String name, Material mat, ItemGroup group) {
        Block block = new Block(FabricBlockSettings.of(mat));
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(PJOMod.MOD_ID, name), block);
    }

    // Method for blocks that require tools
    private static Block registerBlock(String name, Material mat, ItemGroup group, Float strength) {
        Block block = new Block(FabricBlockSettings.of(mat).strength(strength).requiresTool());
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(PJOMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    // Method that gives tooltip to block item
    private static Block registerBlock(String name, Material mat, ItemGroup group, Float strength, String tooltipKey) {
        Block block = new Block(FabricBlockSettings.of(mat).strength(strength).requiresTool());
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(PJOMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(PJOMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)){
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

    public static void registerModBlocks() {
        PJOMod.LOGGER.info("Registering ModBlocks for " + PJOMod.MOD_ID);
    }
}
