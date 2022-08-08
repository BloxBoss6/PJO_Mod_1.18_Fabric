package net.bloxboss6.pjomod.util;

import net.bloxboss6.pjomod.PJOMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> CELESTIAL_BRONZE = createTag("celestial_bronze");
        public static final TagKey<Block> STYGIAN_IRON = createTag("stygian_iron");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(PJOMod.MOD_ID, name));
        }

        private static TagKey<Block> createcommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }

    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(PJOMod.MOD_ID, name));
        }

        private static TagKey<Item> createcommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }

    }

}
