package com.fys.providers;

import com.fys.block.ModBlocks;
import com.fys.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

/**
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class ModModelsProvider extends FabricModelProvider {

    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_AMP_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUN_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_END_BLOCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMON_FRUIT_SUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMON_FRUIT_MOON, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        //工具
        itemModelGenerator.register(ModItems.ENDER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_SHOVEL, Models.HANDHELD);

        //盔甲
        itemModelGenerator.register(ModItems.ENDER_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_BOOTS, Models.GENERATED);

    }
}
