package com.niaswift.tutorialmod.datagen;

import com.niaswift.tutorialmod.block.ModBlocks;
import com.niaswift.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(
            ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE,
            ModBlocks.NETHER_RUBY_ORE,
            ModBlocks.END_STONE_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC,
                ModItems.RUBY, 0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC,
                ModItems.RUBY, 0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.METAL_DETECTOR, 1)
                .pattern("IRI")
                .pattern(" T ")
                .pattern(" S ")
                .input('I', Items.IRON_NUGGET)
                .input('R', ModItems.RUBY)
                .input('T', Items.REDSTONE_TORCH)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .criterion(hasItem(Items.REDSTONE_TORCH), conditionsFromItem(Items.REDSTONE_TORCH))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.METAL_DETECTOR)));



        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.RUBY_BUTTON, 1)
                .input(Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_BUTTON)));

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB, ModItems.RUBY);
        offerPressurePlateRecipe(exporter, ModBlocks.RUBY_PRESSURE_PLATE, ModItems.RUBY);
        offerWallRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_WALL, ModItems.RUBY);

        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_STAIRS)));

        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_FENCE)));

        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_FENCE_GATE)));

        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_DOOR)));

        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_TRAPDOOR)));

    }

}
