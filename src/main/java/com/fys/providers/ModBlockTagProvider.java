package com.fys.providers;

import com.fys.block.ModBlocks;
import com.fys.registry.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.END_BLOCK_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_BLOCK)
                .add(ModBlocks.END_BLOCK_ORE);

        valueLookupBuilder(ModBlockTags.ORE_LIST)
                .add(ModBlocks.SUN_BLOCK)
                .add(ModBlocks.SUN_BLOCK_ORE)
                .add(ModBlocks.END_BLOCK)
                .add(ModBlocks.END_BLOCK_ORE);
    }

}
