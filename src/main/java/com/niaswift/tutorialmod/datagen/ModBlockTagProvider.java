package com.niaswift.tutorialmod.datagen;

import com.niaswift.tutorialmod.block.ModBlocks;
import com.niaswift.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.RUBY_ORE)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.NETHER_RUBY_ORE)
                .add(ModBlocks.END_STONE_RUBY_ORE)
                .add(ModBlocks.SOUND_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_RUBY_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_RUBY_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .add(ModBlocks.SOUND_BLOCK);


        List<TagKey<Block>> needsTool = new ArrayList<>();
        needsTool.add(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
        needsTool.add(ModTags.Blocks.NEEDS_RUBY_TOOL);
        for (TagKey<Block> x : needsTool) {
            getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL).forceAddTag(x);
            getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL).forceAddTag(x);
            getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL).forceAddTag(x);
            getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL).forceAddTag(x);
            getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).forceAddTag(x);
        }
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).forceAddTag(ModTags.Blocks.NEEDS_RUBY_TOOL);


        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.RUBY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.RUBY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.RUBY_WALL);

    }

}
