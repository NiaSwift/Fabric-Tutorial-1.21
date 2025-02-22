package com.niaswift.tutorialmod.util;

import com.niaswift.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
                createTag("metal_detector_detectable_blocks");

        public static final TagKey<Block> NEEDS_NETHERITE_TOOL =
                createTag("needs_netherite_tool");

        public static final TagKey<Block> NEEDS_RUBY_TOOL =
                createTag("needs_ruby_tool");

        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL =
                createTag("incorrect_for_ruby_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }

    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        }

    }


}
