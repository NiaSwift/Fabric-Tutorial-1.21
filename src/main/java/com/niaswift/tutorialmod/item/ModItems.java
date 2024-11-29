package com.niaswift.tutorialmod.item;

import com.niaswift.tutorialmod.TutorialMod;
import com.niaswift.tutorialmod.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));

    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoodComponents.TOMATO)));

    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(new Item.Settings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new Item.Settings().maxDamage(64)));

    public static final Item RUBY_STAFF = registerItem("ruby_staff",
            new Item(new Item.Settings().maxCount(1)));

    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY,
                    new Item.Settings().attributeModifiers(SwordItem.
                            createAttributeModifiers(ModToolMaterial.RUBY, 3, -2.4F))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY,
                    new Item.Settings().attributeModifiers(PickaxeItem.
                            createAttributeModifiers(ModToolMaterial.RUBY, 1.0F, -2.8F))));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY,
                    new Item.Settings().attributeModifiers(AxeItem.
                            createAttributeModifiers(ModToolMaterial.RUBY, 6.0F, -3.1F))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY,
                    new Item.Settings().attributeModifiers(ShovelItem.
                            createAttributeModifiers(ModToolMaterial.RUBY, 1.5F, -3.0F))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY,
                    new Item.Settings().attributeModifiers(HoeItem.
                            createAttributeModifiers(ModToolMaterial.RUBY, -2.0F, -1.0F))));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
