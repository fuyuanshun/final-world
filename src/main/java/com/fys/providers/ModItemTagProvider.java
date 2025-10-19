package com.fys.providers;

import com.fys.block.ModBlocks;
import com.fys.item.ModItems;
import com.fys.registry.tag.ModBlockTags;
import com.fys.registry.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModItemTags.RAW_LIST)
                .add(ModItems.RAW_END_BLOCK);

        valueLookupBuilder(ModItemTags.ENDER_TOOL_MATERIALS)
                .add(ModItems.RAW_END_BLOCK)
        ;
    }

}
