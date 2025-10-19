package com.fys;

import com.fys.providers.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FinalWorldDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        //语言
        pack.addProvider(ModENUSLanguageProvider::new);
        pack.addProvider(ModCHUSLanguageProvider::new);
        //配方
        pack.addProvider(ModRecipeProvider::new);
        //方块战利品
        pack.addProvider(ModBlockLootTableProvider::new);
        //箱子战利品
        pack.addProvider(ModChestLootTableProvider::new);
        //Models
        pack.addProvider(ModModelsProvider::new);
	}
}
