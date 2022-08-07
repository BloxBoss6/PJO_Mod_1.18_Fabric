package net.bloxboss6.pjomod.item;

import net.bloxboss6.pjomod.PJOMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup PJO_BASICS = FabricItemGroupBuilder.build(new Identifier(PJOMod.MOD_ID, "pjo_basics"), () -> new ItemStack(ModItems.CB_INGOT));

    // No icon when using this method. Will do more research later
    /*
    public static final ItemGroup PJO_BASICS = createItemGroup("pjo_basics", ModItems.CB_INGOT);

    private static ItemGroup createItemGroup(String name, Item icon) {
        return FabricItemGroupBuilder.build(new Identifier(PJOMod.MOD_ID, name), () -> new ItemStack(icon));
    }
    */

}
