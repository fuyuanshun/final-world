package com.fys.providers;

import com.fys.block.ModBlocks;
import com.fys.item.ModItems;
import com.fys.registry.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {

        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {

                //方块1->9材料  9材料->方块1
//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.RAW_END_BLOCK,
//                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_BLOCK);

                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShapeless(RecipeCategory.MISC, ModItems.RAW_END_BLOCK, 9)
                        .input(ModBlocks.END_BLOCK)
                        .criterion(hasItem(ModItems.RAW_END_BLOCK), conditionsFromItem(ModItems.RAW_END_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_BLOCK)
                        .pattern("rrr")
                        .pattern("rrr")
                        .pattern("rrr")
                        .input('r', ModItemTags.RAW_LIST)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);

                //9个太阳石合成太阳恶魔果实
                createShaped(RecipeCategory.MISC, ModItems.DEMON_FRUIT_SUN)
                        .pattern("rrr")
                        .pattern("rrr")
                        .pattern("rrr")
                        .input('r', ModBlocks.SUN_BLOCK)
                        .criterion(hasItem(ModItems.DEMON_FRUIT_SUN), conditionsFromItem(ModItems.DEMON_FRUIT_SUN))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDER_AXE)
                        .pattern("rr ")
                        .pattern("rm ")
                        .pattern(" m ")
                        .input('r', ModBlocks.END_BLOCK)
                        .input('m', Items.STICK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDER_HOE)
                        .pattern("rr ")
                        .pattern(" m ")
                        .pattern(" m ")
                        .input('r', ModBlocks.END_BLOCK)
                        .input('m', Items.STICK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDER_PICKAXE)
                        .pattern("rrr")
                        .pattern(" m ")
                        .pattern(" m ")
                        .input('r', ModBlocks.END_BLOCK)
                        .input('m', Items.STICK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDER_SHOVEL)
                        .pattern(" r ")
                        .pattern(" m ")
                        .pattern(" m ")
                        .input('r', ModBlocks.END_BLOCK)
                        .input('m', Items.STICK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDER_SWORD)
                        .pattern(" r ")
                        .pattern(" r ")
                        .pattern(" m ")
                        .input('r', ModBlocks.END_BLOCK)
                        .input('m', Items.STICK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);

                //装备
                createShaped(RecipeCategory.MISC, ModItems.ENDER_BOOTS)
                        .pattern("r r")
                        .pattern("r r")
                        .pattern("   ")
                        .input('r', ModBlocks.END_BLOCK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModItems.ENDER_CHESTPLATE)
                        .pattern("r r")
                        .pattern("rrr")
                        .pattern("rrr")
                        .input('r', ModBlocks.END_BLOCK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModItems.ENDER_HELMET)
                        .pattern("rrr")
                        .pattern("r r")
                        .pattern("   ")
                        .input('r', ModBlocks.END_BLOCK)
                        .criterion(hasItem(ModItems.ENDER_CHESTPLATE), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModItems.ENDER_LEGGINGS)
                        .pattern("rrr")
                        .pattern("r r")
                        .pattern("r r")
                        .input('r', ModBlocks.END_BLOCK)
                        .criterion(hasItem(ModBlocks.END_BLOCK), conditionsFromItem(ModBlocks.END_BLOCK))
                        .offerTo(exporter);
            }
        };
    }


    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
