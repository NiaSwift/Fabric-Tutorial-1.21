package com.niaswift.tutorialmod.datagen;

import com.niaswift.tutorialmod.block.ModBlocks;
import com.niaswift.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.RUBY_ORE,
                copperLikeOreDrops(ModBlocks.RUBY_ORE,
                        ModItems.RAW_RUBY, 2.0F, 5.0F));

        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE,
                copperLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE,
                        ModItems.RAW_RUBY, 2.0F, 5.0F));

        addDrop(ModBlocks.NETHER_RUBY_ORE,
                copperLikeOreDrops(ModBlocks.NETHER_RUBY_ORE,
                        ModItems.RAW_RUBY,2.0F, 5.0F));

        addDrop(ModBlocks.END_STONE_RUBY_ORE,
                copperLikeOreDrops(ModBlocks.END_STONE_RUBY_ORE,
                        ModItems.RAW_RUBY, 3.0F, 7.0F));

    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(drop, (LootPoolEntry.Builder<?>)
                this.applyExplosionDecay(drop, ItemEntry.builder(item)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(minDrops, maxDrops)))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

}
