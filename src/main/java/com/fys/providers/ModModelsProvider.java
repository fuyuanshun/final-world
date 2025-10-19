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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_BLOCK_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARINE_AMP_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUN_BLOCK_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_END_BLOCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMON_FRUIT_SUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMON_FRUIT_MOON, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
    }
}
